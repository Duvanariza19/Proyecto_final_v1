/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Aprendiz;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Aprendiz_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.AprendizFicha;
import Model.Usuario;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class AprendizFacade extends AbstractFacade<Aprendiz> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AprendizFacade() {
        super(Aprendiz.class);
    }

    public boolean isAprendizFichaCollectionEmpty(Aprendiz entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Aprendiz> aprendiz = cq.from(Aprendiz.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aprendiz, entity), cb.isNotEmpty(aprendiz.get(Aprendiz_.aprendizFichaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<AprendizFicha> findAprendizFichaCollection(Aprendiz entity) {
        Aprendiz mergedEntity = this.getMergedEntity(entity);
        Collection<AprendizFicha> aprendizFichaCollection = mergedEntity.getAprendizFichaCollection();
        aprendizFichaCollection.size();
        return aprendizFichaCollection;
    }

    public boolean isIdUsuarioEmpty(Aprendiz entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Aprendiz> aprendiz = cq.from(Aprendiz.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aprendiz, entity), cb.isNotNull(aprendiz.get(Aprendiz_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Aprendiz entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }
    
}
