package Bean;

import Model.Instructor;
import Model.InstructorResultadoAprendizaje;
import java.util.Collection;
import DAO.InstructorFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "instructorController")
@ViewScoped
public class InstructorController extends AbstractController<Instructor> {

    @Inject
    private UsuarioController idUsuarioController;

    // Flags to indicate if child collections are empty
    private boolean isInstructorResultadoAprendizajeCollectionEmpty;

    public InstructorController() {
        // Inform the Abstract parent controller of the concrete Instructor Entity
        super(Instructor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUsuarioController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsInstructorResultadoAprendizajeCollectionEmpty();
    }

    public boolean getIsInstructorResultadoAprendizajeCollectionEmpty() {
        return this.isInstructorResultadoAprendizajeCollectionEmpty;
    }

    private void setIsInstructorResultadoAprendizajeCollectionEmpty() {
        Instructor selected = this.getSelected();
        if (selected != null) {
            InstructorFacade ejbFacade = (InstructorFacade) this.getFacade();
            this.isInstructorResultadoAprendizajeCollectionEmpty = ejbFacade.isInstructorResultadoAprendizajeCollectionEmpty(selected);
        } else {
            this.isInstructorResultadoAprendizajeCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of
     * InstructorResultadoAprendizaje entities that are retrieved from
     * Instructor and returns the navigation outcome.
     *
     * @return navigation outcome for InstructorResultadoAprendizaje page
     */
    public String navigateInstructorResultadoAprendizajeCollection() {
        Instructor selected = this.getSelected();
        if (selected != null) {
            InstructorFacade ejbFacade = (InstructorFacade) this.getFacade();
            Collection<InstructorResultadoAprendizaje> selectedInstructorResultadoAprendizajeCollection = ejbFacade.findInstructorResultadoAprendizajeCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InstructorResultadoAprendizaje_items", selectedInstructorResultadoAprendizajeCollection);
        }
        return "/app/instructorResultadoAprendizaje/index";
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        Instructor selected = this.getSelected();
        if (selected != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(selected.getIdUsuario());
        }
    }

}
