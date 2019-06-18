package Bean;

import Model.Permiso;
import DAO.PermisoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "permisoController")
@ViewScoped
public class PermisoController extends AbstractController<Permiso> {

    @Inject
    private RolController idRolController;

    public PermisoController() {
        // Inform the Abstract parent controller of the concrete Permiso Entity
        super(Permiso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idRolController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRol(ActionEvent event) {
        Permiso selected = this.getSelected();
        if (selected != null && idRolController.getSelected() == null) {
            idRolController.setSelected(selected.getIdRol());
        }
    }

}
