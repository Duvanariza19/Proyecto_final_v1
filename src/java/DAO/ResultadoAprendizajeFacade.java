/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ResultadoAprendizaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.ResultadoAprendizaje_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.InstructorResultadoAprendizaje;
import Model.EvidenciaAprendizaje;
import Model.Competencia;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class ResultadoAprendizajeFacade extends AbstractFacade<ResultadoAprendizaje> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadoAprendizajeFacade() {
        super(ResultadoAprendizaje.class);
    }

    public boolean isInstructorResultadoAprendizajeCollectionEmpty(ResultadoAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ResultadoAprendizaje> resultadoAprendizaje = cq.from(ResultadoAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(resultadoAprendizaje, entity), cb.isNotEmpty(resultadoAprendizaje.get(ResultadoAprendizaje_.instructorResultadoAprendizajeCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<InstructorResultadoAprendizaje> findInstructorResultadoAprendizajeCollection(ResultadoAprendizaje entity) {
        ResultadoAprendizaje mergedEntity = this.getMergedEntity(entity);
        Collection<InstructorResultadoAprendizaje> instructorResultadoAprendizajeCollection = mergedEntity.getInstructorResultadoAprendizajeCollection();
        instructorResultadoAprendizajeCollection.size();
        return instructorResultadoAprendizajeCollection;
    }

    public boolean isEvidenciaAprendizajeCollectionEmpty(ResultadoAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ResultadoAprendizaje> resultadoAprendizaje = cq.from(ResultadoAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(resultadoAprendizaje, entity), cb.isNotEmpty(resultadoAprendizaje.get(ResultadoAprendizaje_.evidenciaAprendizajeCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<EvidenciaAprendizaje> findEvidenciaAprendizajeCollection(ResultadoAprendizaje entity) {
        ResultadoAprendizaje mergedEntity = this.getMergedEntity(entity);
        Collection<EvidenciaAprendizaje> evidenciaAprendizajeCollection = mergedEntity.getEvidenciaAprendizajeCollection();
        evidenciaAprendizajeCollection.size();
        return evidenciaAprendizajeCollection;
    }

    public boolean isIdCompetenciaEmpty(ResultadoAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ResultadoAprendizaje> resultadoAprendizaje = cq.from(ResultadoAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(resultadoAprendizaje, entity), cb.isNotNull(resultadoAprendizaje.get(ResultadoAprendizaje_.idCompetencia)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Competencia findIdCompetencia(ResultadoAprendizaje entity) {
        return this.getMergedEntity(entity).getIdCompetencia();
    }
    
}
