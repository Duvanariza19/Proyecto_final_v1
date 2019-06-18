package Bean;

import Model.Usuario;
import Model.Perfil;
import Model.Instructor;
import Model.Aprendiz;
import java.util.Collection;
import DAO.UsuarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private PersonaController numeroDocumentoController;

    // Flags to indicate if child collections are empty
    private boolean isPerfilCollectionEmpty;
    private boolean isInstructorCollectionEmpty;
    private boolean isAprendizCollectionEmpty;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        numeroDocumentoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPerfilCollectionEmpty();
        this.setIsInstructorCollectionEmpty();
        this.setIsAprendizCollectionEmpty();
    }

    public boolean getIsPerfilCollectionEmpty() {
        return this.isPerfilCollectionEmpty;
    }

    private void setIsPerfilCollectionEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isPerfilCollectionEmpty = ejbFacade.isPerfilCollectionEmpty(selected);
        } else {
            this.isPerfilCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Perfil entities that are
     * retrieved from Usuario and returns the navigation outcome.
     *
     * @return navigation outcome for Perfil page
     */
    public String navigatePerfilCollection() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            Collection<Perfil> selectedPerfilCollection = ejbFacade.findPerfilCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Perfil_items", selectedPerfilCollection);
        }
        return "/app/perfil/index";
    }

    public boolean getIsInstructorCollectionEmpty() {
        return this.isInstructorCollectionEmpty;
    }

    private void setIsInstructorCollectionEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isInstructorCollectionEmpty = ejbFacade.isInstructorCollectionEmpty(selected);
        } else {
            this.isInstructorCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Instructor entities that
     * are retrieved from Usuario and returns the navigation outcome.
     *
     * @return navigation outcome for Instructor page
     */
    public String navigateInstructorCollection() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            Collection<Instructor> selectedInstructorCollection = ejbFacade.findInstructorCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Instructor_items", selectedInstructorCollection);
        }
        return "/app/instructor/index";
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNumeroDocumento(ActionEvent event) {
        Usuario selected = this.getSelected();
        if (selected != null && numeroDocumentoController.getSelected() == null) {
            numeroDocumentoController.setSelected(selected.getNumeroDocumento());
        }
    }

    public boolean getIsAprendizCollectionEmpty() {
        return this.isAprendizCollectionEmpty;
    }

    private void setIsAprendizCollectionEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isAprendizCollectionEmpty = ejbFacade.isAprendizCollectionEmpty(selected);
        } else {
            this.isAprendizCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Aprendiz entities that
     * are retrieved from Usuario and returns the navigation outcome.
     *
     * @return navigation outcome for Aprendiz page
     */
    public String navigateAprendizCollection() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            Collection<Aprendiz> selectedAprendizCollection = ejbFacade.findAprendizCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Aprendiz_items", selectedAprendizCollection);
        }
        return "/app/aprendiz/index";
    }

}
