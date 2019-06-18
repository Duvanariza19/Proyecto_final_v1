package Bean;

import Model.Rol;
import Model.Perfil;
import Model.Permiso;
import java.util.Collection;
import DAO.RolFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "rolController")
@ViewScoped
public class RolController extends AbstractController<Rol> {

    // Flags to indicate if child collections are empty
    private boolean isPerfilCollectionEmpty;
    private boolean isPermisoCollectionEmpty;

    public RolController() {
        // Inform the Abstract parent controller of the concrete Rol Entity
        super(Rol.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPerfilCollectionEmpty();
        this.setIsPermisoCollectionEmpty();
    }

    public boolean getIsPerfilCollectionEmpty() {
        return this.isPerfilCollectionEmpty;
    }

    private void setIsPerfilCollectionEmpty() {
        Rol selected = this.getSelected();
        if (selected != null) {
            RolFacade ejbFacade = (RolFacade) this.getFacade();
            this.isPerfilCollectionEmpty = ejbFacade.isPerfilCollectionEmpty(selected);
        } else {
            this.isPerfilCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Perfil entities that are
     * retrieved from Rol and returns the navigation outcome.
     *
     * @return navigation outcome for Perfil page
     */
    public String navigatePerfilCollection() {
        Rol selected = this.getSelected();
        if (selected != null) {
            RolFacade ejbFacade = (RolFacade) this.getFacade();
            Collection<Perfil> selectedPerfilCollection = ejbFacade.findPerfilCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Perfil_items", selectedPerfilCollection);
        }
        return "/app/perfil/index";
    }

    public boolean getIsPermisoCollectionEmpty() {
        return this.isPermisoCollectionEmpty;
    }

    private void setIsPermisoCollectionEmpty() {
        Rol selected = this.getSelected();
        if (selected != null) {
            RolFacade ejbFacade = (RolFacade) this.getFacade();
            this.isPermisoCollectionEmpty = ejbFacade.isPermisoCollectionEmpty(selected);
        } else {
            this.isPermisoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Permiso entities that are
     * retrieved from Rol and returns the navigation outcome.
     *
     * @return navigation outcome for Permiso page
     */
    public String navigatePermisoCollection() {
        Rol selected = this.getSelected();
        if (selected != null) {
            RolFacade ejbFacade = (RolFacade) this.getFacade();
            Collection<Permiso> selectedPermisoCollection = ejbFacade.findPermisoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Permiso_items", selectedPermisoCollection);
        }
        return "/app/permiso/index";
    }

}
