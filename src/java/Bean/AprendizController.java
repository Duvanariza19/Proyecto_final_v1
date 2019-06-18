package Bean;

import Model.Aprendiz;
import Model.AprendizFicha;
import java.util.Collection;
import DAO.AprendizFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "aprendizController")
@ViewScoped
public class AprendizController extends AbstractController<Aprendiz> {

    @Inject
    private UsuarioController idUsuarioController;

    // Flags to indicate if child collections are empty
    private boolean isAprendizFichaCollectionEmpty;

    public AprendizController() {
        // Inform the Abstract parent controller of the concrete Aprendiz Entity
        super(Aprendiz.class);
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
        this.setIsAprendizFichaCollectionEmpty();
    }

    public boolean getIsAprendizFichaCollectionEmpty() {
        return this.isAprendizFichaCollectionEmpty;
    }

    private void setIsAprendizFichaCollectionEmpty() {
        Aprendiz selected = this.getSelected();
        if (selected != null) {
            AprendizFacade ejbFacade = (AprendizFacade) this.getFacade();
            this.isAprendizFichaCollectionEmpty = ejbFacade.isAprendizFichaCollectionEmpty(selected);
        } else {
            this.isAprendizFichaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of AprendizFicha entities
     * that are retrieved from Aprendiz and returns the navigation outcome.
     *
     * @return navigation outcome for AprendizFicha page
     */
    public String navigateAprendizFichaCollection() {
        Aprendiz selected = this.getSelected();
        if (selected != null) {
            AprendizFacade ejbFacade = (AprendizFacade) this.getFacade();
            Collection<AprendizFicha> selectedAprendizFichaCollection = ejbFacade.findAprendizFichaCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AprendizFicha_items", selectedAprendizFichaCollection);
        }
        return "/app/aprendizFicha/index";
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        Aprendiz selected = this.getSelected();
        if (selected != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(selected.getIdUsuario());
        }
    }

}
