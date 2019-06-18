/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ficha;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Ficha_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Trimestre;
import Model.ProgramaDeFormacion;
import Model.AprendizFicha;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class FichaFacade extends AbstractFacade<Ficha> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichaFacade() {
        super(Ficha.class);
    }

    public boolean isTrimestreCollectionEmpty(Ficha entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ficha> ficha = cq.from(Ficha.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ficha, entity), cb.isNotEmpty(ficha.get(Ficha_.trimestreCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Trimestre> findTrimestreCollection(Ficha entity) {
        Ficha mergedEntity = this.getMergedEntity(entity);
        Collection<Trimestre> trimestreCollection = mergedEntity.getTrimestreCollection();
        trimestreCollection.size();
        return trimestreCollection;
    }

    public boolean isIdProgramaEmpty(Ficha entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ficha> ficha = cq.from(Ficha.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ficha, entity), cb.isNotNull(ficha.get(Ficha_.idPrograma)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ProgramaDeFormacion findIdPrograma(Ficha entity) {
        return this.getMergedEntity(entity).getIdPrograma();
    }

    public boolean isAprendizFichaCollectionEmpty(Ficha entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ficha> ficha = cq.from(Ficha.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ficha, entity), cb.isNotEmpty(ficha.get(Ficha_.aprendizFichaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<AprendizFicha> findAprendizFichaCollection(Ficha entity) {
        Ficha mergedEntity = this.getMergedEntity(entity);
        Collection<AprendizFicha> aprendizFichaCollection = mergedEntity.getAprendizFichaCollection();
        aprendizFichaCollection.size();
        return aprendizFichaCollection;
    }
    
}
