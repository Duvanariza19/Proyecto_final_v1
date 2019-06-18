package Bean;

import Model.ResultadoAprendizaje;
import Model.InstructorResultadoAprendizaje;
import Model.EvidenciaAprendizaje;
import java.util.Collection;
import DAO.ResultadoAprendizajeFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "resultadoAprendizajeController")
@ViewScoped
public class ResultadoAprendizajeController extends AbstractController<ResultadoAprendizaje> {

    @Inject
    private CompetenciaController idCompetenciaController;

    // Flags to indicate if child collections are empty
    private boolean isInstructorResultadoAprendizajeCollectionEmpty;
    private boolean isEvidenciaAprendizajeCollectionEmpty;

    public ResultadoAprendizajeController() {
        // Inform the Abstract parent controller of the concrete ResultadoAprendizaje Entity
        super(ResultadoAprendizaje.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCompetenciaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsInstructorResultadoAprendizajeCollectionEmpty();
        this.setIsEvidenciaAprendizajeCollectionEmpty();
    }

    public boolean getIsInstructorResultadoAprendizajeCollectionEmpty() {
        return this.isInstructorResultadoAprendizajeCollectionEmpty;
    }

    private void setIsInstructorResultadoAprendizajeCollectionEmpty() {
        ResultadoAprendizaje selected = this.getSelected();
        if (selected != null) {
            ResultadoAprendizajeFacade ejbFacade = (ResultadoAprendizajeFacade) this.getFacade();
            this.isInstructorResultadoAprendizajeCollectionEmpty = ejbFacade.isInstructorResultadoAprendizajeCollectionEmpty(selected);
        } else {
            this.isInstructorResultadoAprendizajeCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of
     * InstructorResultadoAprendizaje entities that are retrieved from
     * ResultadoAprendizaje and returns the navigation outcome.
     *
     * @return navigation outcome for InstructorResultadoAprendizaje page
     */
    public String navigateInstructorResultadoAprendizajeCollection() {
        ResultadoAprendizaje selected = this.getSelected();
        if (selected != null) {
            ResultadoAprendizajeFacade ejbFacade = (ResultadoAprendizajeFacade) this.getFacade();
            Collection<InstructorResultadoAprendizaje> selectedInstructorResultadoAprendizajeCollection = ejbFacade.findInstructorResultadoAprendizajeCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InstructorResultadoAprendizaje_items", selectedInstructorResultadoAprendizajeCollection);
        }
        return "/app/instructorResultadoAprendizaje/index";
    }

    public boolean getIsEvidenciaAprendizajeCollectionEmpty() {
        return this.isEvidenciaAprendizajeCollectionEmpty;
    }

    private void setIsEvidenciaAprendizajeCollectionEmpty() {
        ResultadoAprendizaje selected = this.getSelected();
        if (selected != null) {
            ResultadoAprendizajeFacade ejbFacade = (ResultadoAprendizajeFacade) this.getFacade();
            this.isEvidenciaAprendizajeCollectionEmpty = ejbFacade.isEvidenciaAprendizajeCollectionEmpty(selected);
        } else {
            this.isEvidenciaAprendizajeCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of EvidenciaAprendizaje
     * entities that are retrieved from ResultadoAprendizaje and returns the
     * navigation outcome.
     *
     * @return navigation outcome for EvidenciaAprendizaje page
     */
    public String navigateEvidenciaAprendizajeCollection() {
        ResultadoAprendizaje selected = this.getSelected();
        if (selected != null) {
            ResultadoAprendizajeFacade ejbFacade = (ResultadoAprendizajeFacade) this.getFacade();
            Collection<EvidenciaAprendizaje> selectedEvidenciaAprendizajeCollection = ejbFacade.findEvidenciaAprendizajeCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EvidenciaAprendizaje_items", selectedEvidenciaAprendizajeCollection);
        }
        return "/app/evidenciaAprendizaje/index";
    }

    /**
     * Sets the "selected" attribute of the Competencia controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompetencia(ActionEvent event) {
        ResultadoAprendizaje selected = this.getSelected();
        if (selected != null && idCompetenciaController.getSelected() == null) {
            idCompetenciaController.setSelected(selected.getIdCompetencia());
        }
    }

}
