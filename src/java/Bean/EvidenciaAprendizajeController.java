package Bean;

import Model.EvidenciaAprendizaje;
import Model.JuicioEvalutivo;
import java.util.Collection;
import DAO.EvidenciaAprendizajeFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "evidenciaAprendizajeController")
@ViewScoped
public class EvidenciaAprendizajeController extends AbstractController<EvidenciaAprendizaje> {

    @Inject
    private ResultadoAprendizajeController idResultadoAprendizajeController;

    // Flags to indicate if child collections are empty
    private boolean isJuicioEvalutivoCollectionEmpty;

    public EvidenciaAprendizajeController() {
        // Inform the Abstract parent controller of the concrete EvidenciaAprendizaje Entity
        super(EvidenciaAprendizaje.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idResultadoAprendizajeController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsJuicioEvalutivoCollectionEmpty();
    }

    public boolean getIsJuicioEvalutivoCollectionEmpty() {
        return this.isJuicioEvalutivoCollectionEmpty;
    }

    private void setIsJuicioEvalutivoCollectionEmpty() {
        EvidenciaAprendizaje selected = this.getSelected();
        if (selected != null) {
            EvidenciaAprendizajeFacade ejbFacade = (EvidenciaAprendizajeFacade) this.getFacade();
            this.isJuicioEvalutivoCollectionEmpty = ejbFacade.isJuicioEvalutivoCollectionEmpty(selected);
        } else {
            this.isJuicioEvalutivoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of JuicioEvalutivo entities
     * that are retrieved from EvidenciaAprendizaje and returns the navigation
     * outcome.
     *
     * @return navigation outcome for JuicioEvalutivo page
     */
    public String navigateJuicioEvalutivoCollection() {
        EvidenciaAprendizaje selected = this.getSelected();
        if (selected != null) {
            EvidenciaAprendizajeFacade ejbFacade = (EvidenciaAprendizajeFacade) this.getFacade();
            Collection<JuicioEvalutivo> selectedJuicioEvalutivoCollection = ejbFacade.findJuicioEvalutivoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("JuicioEvalutivo_items", selectedJuicioEvalutivoCollection);
        }
        return "/app/juicioEvalutivo/index";
    }

    /**
     * Sets the "selected" attribute of the ResultadoAprendizaje controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdResultadoAprendizaje(ActionEvent event) {
        EvidenciaAprendizaje selected = this.getSelected();
        if (selected != null && idResultadoAprendizajeController.getSelected() == null) {
            idResultadoAprendizajeController.setSelected(selected.getIdResultadoAprendizaje());
        }
    }

}
