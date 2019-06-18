package Bean;

import Model.ProgramaDeFormacion;
import Model.Competencia;
import Model.Ficha;
import java.util.Collection;
import DAO.ProgramaDeFormacionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "programaDeFormacionController")
@ViewScoped
public class ProgramaDeFormacionController extends AbstractController<ProgramaDeFormacion> {

    // Flags to indicate if child collections are empty
    private boolean isCompetenciaCollectionEmpty;
    private boolean isFichaCollectionEmpty;

    public ProgramaDeFormacionController() {
        // Inform the Abstract parent controller of the concrete ProgramaDeFormacion Entity
        super(ProgramaDeFormacion.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCompetenciaCollectionEmpty();
        this.setIsFichaCollectionEmpty();
    }

    public boolean getIsCompetenciaCollectionEmpty() {
        return this.isCompetenciaCollectionEmpty;
    }

    private void setIsCompetenciaCollectionEmpty() {
        ProgramaDeFormacion selected = this.getSelected();
        if (selected != null) {
            ProgramaDeFormacionFacade ejbFacade = (ProgramaDeFormacionFacade) this.getFacade();
            this.isCompetenciaCollectionEmpty = ejbFacade.isCompetenciaCollectionEmpty(selected);
        } else {
            this.isCompetenciaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Competencia entities that
     * are retrieved from ProgramaDeFormacion and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Competencia page
     */
    public String navigateCompetenciaCollection() {
        ProgramaDeFormacion selected = this.getSelected();
        if (selected != null) {
            ProgramaDeFormacionFacade ejbFacade = (ProgramaDeFormacionFacade) this.getFacade();
            Collection<Competencia> selectedCompetenciaCollection = ejbFacade.findCompetenciaCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Competencia_items", selectedCompetenciaCollection);
        }
        return "/app/competencia/index";
    }

    public boolean getIsFichaCollectionEmpty() {
        return this.isFichaCollectionEmpty;
    }

    private void setIsFichaCollectionEmpty() {
        ProgramaDeFormacion selected = this.getSelected();
        if (selected != null) {
            ProgramaDeFormacionFacade ejbFacade = (ProgramaDeFormacionFacade) this.getFacade();
            this.isFichaCollectionEmpty = ejbFacade.isFichaCollectionEmpty(selected);
        } else {
            this.isFichaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ficha entities that are
     * retrieved from ProgramaDeFormacion and returns the navigation outcome.
     *
     * @return navigation outcome for Ficha page
     */
    public String navigateFichaCollection() {
        ProgramaDeFormacion selected = this.getSelected();
        if (selected != null) {
            ProgramaDeFormacionFacade ejbFacade = (ProgramaDeFormacionFacade) this.getFacade();
            Collection<Ficha> selectedFichaCollection = ejbFacade.findFichaCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ficha_items", selectedFichaCollection);
        }
        return "/app/ficha/index";
    }

}
