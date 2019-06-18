/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AprendizFicha;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.AprendizFicha_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Aprendiz;
import Model.Ficha;

/**
 *
 * @author camel
 */
@Stateless
public class AprendizFichaFacade extends AbstractFacade<AprendizFicha> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AprendizFichaFacade() {
        super(AprendizFicha.class);
    }

    public boolean isIdAprendizEmpty(AprendizFicha entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AprendizFicha> aprendizFicha = cq.from(AprendizFicha.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aprendizFicha, entity), cb.isNotNull(aprendizFicha.get(AprendizFicha_.idAprendiz)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Aprendiz findIdAprendiz(AprendizFicha entity) {
        return this.getMergedEntity(entity).getIdAprendiz();
    }

    public boolean isIdFichaEmpty(AprendizFicha entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AprendizFicha> aprendizFicha = cq.from(AprendizFicha.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aprendizFicha, entity), cb.isNotNull(aprendizFicha.get(AprendizFicha_.idFicha)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ficha findIdFicha(AprendizFicha entity) {
        return this.getMergedEntity(entity).getIdFicha();
    }
    
}
