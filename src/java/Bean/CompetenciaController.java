package Bean;

import Model.Competencia;
import Model.ResultadoAprendizaje;
import java.util.Collection;
import DAO.CompetenciaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "competenciaController")
@ViewScoped
public class CompetenciaController extends AbstractController<Competencia> {

    @Inject
    private ProgramaDeFormacionController idProgramaController;

    // Flags to indicate if child collections are empty
    private boolean isResultadoAprendizajeCollectionEmpty;

    public CompetenciaController() {
        // Inform the Abstract parent controller of the concrete Competencia Entity
        super(Competencia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProgramaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsResultadoAprendizajeCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the ProgramaDeFormacion controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPrograma(ActionEvent event) {
        Competencia selected = this.getSelected();
        if (selected != null && idProgramaController.getSelected() == null) {
            idProgramaController.setSelected(selected.getIdPrograma());
        }
    }

    public boolean getIsResultadoAprendizajeCollectionEmpty() {
        return this.isResultadoAprendizajeCollectionEmpty;
    }

    private void setIsResultadoAprendizajeCollectionEmpty() {
        Competencia selected = this.getSelected();
        if (selected != null) {
            CompetenciaFacade ejbFacade = (CompetenciaFacade) this.getFacade();
            this.isResultadoAprendizajeCollectionEmpty = ejbFacade.isResultadoAprendizajeCollectionEmpty(selected);
        } else {
            this.isResultadoAprendizajeCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of ResultadoAprendizaje
     * entities that are retrieved from Competencia and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ResultadoAprendizaje page
     */
    public String navigateResultadoAprendizajeCollection() {
        Competencia selected = this.getSelected();
        if (selected != null) {
            CompetenciaFacade ejbFacade = (CompetenciaFacade) this.getFacade();
            Collection<ResultadoAprendizaje> selectedResultadoAprendizajeCollection = ejbFacade.findResultadoAprendizajeCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ResultadoAprendizaje_items", selectedResultadoAprendizajeCollection);
        }
        return "/app/resultadoAprendizaje/index";
    }

}
