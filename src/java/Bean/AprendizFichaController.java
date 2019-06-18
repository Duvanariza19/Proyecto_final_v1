package Bean;

import Model.AprendizFicha;
import DAO.AprendizFichaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "aprendizFichaController")
@ViewScoped
public class AprendizFichaController extends AbstractController<AprendizFicha> {

    @Inject
    private AprendizController idAprendizController;
    @Inject
    private FichaController idFichaController;

    public AprendizFichaController() {
        // Inform the Abstract parent controller of the concrete AprendizFicha Entity
        super(AprendizFicha.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAprendizController.setSelected(null);
        idFichaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Aprendiz controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAprendiz(ActionEvent event) {
        AprendizFicha selected = this.getSelected();
        if (selected != null && idAprendizController.getSelected() == null) {
            idAprendizController.setSelected(selected.getIdAprendiz());
        }
    }

    /**
     * Sets the "selected" attribute of the Ficha controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFicha(ActionEvent event) {
        AprendizFicha selected = this.getSelected();
        if (selected != null && idFichaController.getSelected() == null) {
            idFichaController.setSelected(selected.getIdFicha());
        }
    }

}
