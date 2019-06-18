package Bean;

import Model.Perfil;
import DAO.PerfilFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "perfilController")
@ViewScoped
public class PerfilController extends AbstractController<Perfil> {

    @Inject
    private UsuarioController idUsuarioController;
    @Inject
    private RolController idRolController;

    public PerfilController() {
        // Inform the Abstract parent controller of the concrete Perfil Entity
        super(Perfil.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUsuarioController.setSelected(null);
        idRolController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        Perfil selected = this.getSelected();
        if (selected != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(selected.getIdUsuario());
        }
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRol(ActionEvent event) {
        Perfil selected = this.getSelected();
        if (selected != null && idRolController.getSelected() == null) {
            idRolController.setSelected(selected.getIdRol());
        }
    }

}
