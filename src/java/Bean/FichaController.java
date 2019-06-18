package Bean;

import Model.Ficha;
import Model.Trimestre;
import Model.AprendizFicha;
import java.util.Collection;
import DAO.FichaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "fichaController")
@ViewScoped
public class FichaController extends AbstractController<Ficha> {

    @Inject
    private ProgramaDeFormacionController idProgramaController;

    // Flags to indicate if child collections are empty
    private boolean isTrimestreCollectionEmpty;
    private boolean isAprendizFichaCollectionEmpty;

    public FichaController() {
        // Inform the Abstract parent controller of the concrete Ficha Entity
        super(Ficha.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProgramaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTrimestreCollectionEmpty();
        this.setIsAprendizFichaCollectionEmpty();
    }

    public boolean getIsTrimestreCollectionEmpty() {
        return this.isTrimestreCollectionEmpty;
    }

    private void setIsTrimestreCollectionEmpty() {
        Ficha selected = this.getSelected();
        if (selected != null) {
            FichaFacade ejbFacade = (FichaFacade) this.getFacade();
            this.isTrimestreCollectionEmpty = ejbFacade.isTrimestreCollectionEmpty(selected);
        } else {
            this.isTrimestreCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Trimestre entities that
     * are retrieved from Ficha and returns the navigation outcome.
     *
     * @return navigation outcome for Trimestre page
     */
    public String navigateTrimestreCollection() {
        Ficha selected = this.getSelected();
        if (selected != null) {
            FichaFacade ejbFacade = (FichaFacade) this.getFacade();
            Collection<Trimestre> selectedTrimestreCollection = ejbFacade.findTrimestreCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Trimestre_items", selectedTrimestreCollection);
        }
        return "/app/trimestre/index";
    }

    /**
     * Sets the "selected" attribute of the ProgramaDeFormacion controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPrograma(ActionEvent event) {
        Ficha selected = this.getSelected();
        if (selected != null && idProgramaController.getSelected() == null) {
            idProgramaController.setSelected(selected.getIdPrograma());
        }
    }

    public boolean getIsAprendizFichaCollectionEmpty() {
        return this.isAprendizFichaCollectionEmpty;
    }

    private void setIsAprendizFichaCollectionEmpty() {
        Ficha selected = this.getSelected();
        if (selected != null) {
            FichaFacade ejbFacade = (FichaFacade) this.getFacade();
            this.isAprendizFichaCollectionEmpty = ejbFacade.isAprendizFichaCollectionEmpty(selected);
        } else {
            this.isAprendizFichaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of AprendizFicha entities
     * that are retrieved from Ficha and returns the navigation outcome.
     *
     * @return navigation outcome for AprendizFicha page
     */
    public String navigateAprendizFichaCollection() {
        Ficha selected = this.getSelected();
        if (selected != null) {
            FichaFacade ejbFacade = (FichaFacade) this.getFacade();
            Collection<AprendizFicha> selectedAprendizFichaCollection = ejbFacade.findAprendizFichaCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AprendizFicha_items", selectedAprendizFichaCollection);
        }
        return "/app/aprendizFicha/index";
    }

}
