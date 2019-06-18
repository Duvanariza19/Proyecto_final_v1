/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.EvidenciaAprendizaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.EvidenciaAprendizaje_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.JuicioEvalutivo;
import Model.ResultadoAprendizaje;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class EvidenciaAprendizajeFacade extends AbstractFacade<EvidenciaAprendizaje> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvidenciaAprendizajeFacade() {
        super(EvidenciaAprendizaje.class);
    }

    public boolean isJuicioEvalutivoCollectionEmpty(EvidenciaAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<EvidenciaAprendizaje> evidenciaAprendizaje = cq.from(EvidenciaAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(evidenciaAprendizaje, entity), cb.isNotEmpty(evidenciaAprendizaje.get(EvidenciaAprendizaje_.juicioEvalutivoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<JuicioEvalutivo> findJuicioEvalutivoCollection(EvidenciaAprendizaje entity) {
        EvidenciaAprendizaje mergedEntity = this.getMergedEntity(entity);
        Collection<JuicioEvalutivo> juicioEvalutivoCollection = mergedEntity.getJuicioEvalutivoCollection();
        juicioEvalutivoCollection.size();
        return juicioEvalutivoCollection;
    }

    public boolean isIdResultadoAprendizajeEmpty(EvidenciaAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<EvidenciaAprendizaje> evidenciaAprendizaje = cq.from(EvidenciaAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(evidenciaAprendizaje, entity), cb.isNotNull(evidenciaAprendizaje.get(EvidenciaAprendizaje_.idResultadoAprendizaje)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ResultadoAprendizaje findIdResultadoAprendizaje(EvidenciaAprendizaje entity) {
        return this.getMergedEntity(entity).getIdResultadoAprendizaje();
    }
    
}
