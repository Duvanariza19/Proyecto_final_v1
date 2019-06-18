package Bean;

import Model.Trimestre;
import DAO.TrimestreFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "trimestreController")
@ViewScoped
public class TrimestreController extends AbstractController<Trimestre> {

    @Inject
    private FichaController idFichaController;

    public TrimestreController() {
        // Inform the Abstract parent controller of the concrete Trimestre Entity
        super(Trimestre.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idFichaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ficha controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFicha(ActionEvent event) {
        Trimestre selected = this.getSelected();
        if (selected != null && idFichaController.getSelected() == null) {
            idFichaController.setSelected(selected.getIdFicha());
        }
    }

}
