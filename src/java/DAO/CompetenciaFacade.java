/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Competencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Competencia_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.ProgramaDeFormacion;
import Model.ResultadoAprendizaje;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class CompetenciaFacade extends AbstractFacade<Competencia> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompetenciaFacade() {
        super(Competencia.class);
    }

    public boolean isIdProgramaEmpty(Competencia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Competencia> competencia = cq.from(Competencia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(competencia, entity), cb.isNotNull(competencia.get(Competencia_.idPrograma)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ProgramaDeFormacion findIdPrograma(Competencia entity) {
        return this.getMergedEntity(entity).getIdPrograma();
    }

    public boolean isResultadoAprendizajeCollectionEmpty(Competencia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Competencia> competencia = cq.from(Competencia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(competencia, entity), cb.isNotEmpty(competencia.get(Competencia_.resultadoAprendizajeCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<ResultadoAprendizaje> findResultadoAprendizajeCollection(Competencia entity) {
        Competencia mergedEntity = this.getMergedEntity(entity);
        Collection<ResultadoAprendizaje> resultadoAprendizajeCollection = mergedEntity.getResultadoAprendizajeCollection();
        resultadoAprendizajeCollection.size();
        return resultadoAprendizajeCollection;
    }
    
}
