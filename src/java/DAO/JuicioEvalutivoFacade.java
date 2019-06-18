/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.JuicioEvalutivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.JuicioEvalutivo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.EvidenciaAprendizaje;

/**
 *
 * @author camel
 */
@Stateless
public class JuicioEvalutivoFacade extends AbstractFacade<JuicioEvalutivo> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuicioEvalutivoFacade() {
        super(JuicioEvalutivo.class);
    }

    public boolean isIdEvidenciaEmpty(JuicioEvalutivo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<JuicioEvalutivo> juicioEvalutivo = cq.from(JuicioEvalutivo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(juicioEvalutivo, entity), cb.isNotNull(juicioEvalutivo.get(JuicioEvalutivo_.idEvidencia)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public EvidenciaAprendizaje findIdEvidencia(JuicioEvalutivo entity) {
        return this.getMergedEntity(entity).getIdEvidencia();
    }
    
}
