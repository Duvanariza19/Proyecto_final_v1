/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Trimestre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Trimestre_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Ficha;

/**
 *
 * @author camel
 */
@Stateless
public class TrimestreFacade extends AbstractFacade<Trimestre> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrimestreFacade() {
        super(Trimestre.class);
    }

    public boolean isIdFichaEmpty(Trimestre entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Trimestre> trimestre = cq.from(Trimestre.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(trimestre, entity), cb.isNotNull(trimestre.get(Trimestre_.idFicha)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ficha findIdFicha(Trimestre entity) {
        return this.getMergedEntity(entity).getIdFicha();
    }
    
}
