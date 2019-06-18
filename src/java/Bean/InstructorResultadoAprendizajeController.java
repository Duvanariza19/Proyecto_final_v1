package Bean;

import Model.InstructorResultadoAprendizaje;
import DAO.InstructorResultadoAprendizajeFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "instructorResultadoAprendizajeController")
@ViewScoped
public class InstructorResultadoAprendizajeController extends AbstractController<InstructorResultadoAprendizaje> {

    @Inject
    private InstructorController idInstructorController;
    @Inject
    private ResultadoAprendizajeController idResultadoAprendizajeController;

    public InstructorResultadoAprendizajeController() {
        // Inform the Abstract parent controller of the concrete InstructorResultadoAprendizaje Entity
        super(InstructorResultadoAprendizaje.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idInstructorController.setSelected(null);
        idResultadoAprendizajeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Instructor controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInstructor(ActionEvent event) {
        InstructorResultadoAprendizaje selected = this.getSelected();
        if (selected != null && idInstructorController.getSelected() == null) {
            idInstructorController.setSelected(selected.getIdInstructor());
        }
    }

    /**
     * Sets the "selected" attribute of the ResultadoAprendizaje controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdResultadoAprendizaje(ActionEvent event) {
        InstructorResultadoAprendizaje selected = this.getSelected();
        if (selected != null && idResultadoAprendizajeController.getSelected() == null) {
            idResultadoAprendizajeController.setSelected(selected.getIdResultadoAprendizaje());
        }
    }

}
