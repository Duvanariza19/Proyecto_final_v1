package Bean;

import Model.JuicioEvalutivo;
import DAO.JuicioEvalutivoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "juicioEvalutivoController")
@ViewScoped
public class JuicioEvalutivoController extends AbstractController<JuicioEvalutivo> {

    @Inject
    private EvidenciaAprendizajeController idEvidenciaController;

    public JuicioEvalutivoController() {
        // Inform the Abstract parent controller of the concrete JuicioEvalutivo Entity
        super(JuicioEvalutivo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEvidenciaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the EvidenciaAprendizaje controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEvidencia(ActionEvent event) {
        JuicioEvalutivo selected = this.getSelected();
        if (selected != null && idEvidenciaController.getSelected() == null) {
            idEvidenciaController.setSelected(selected.getIdEvidencia());
        }
    }

}
