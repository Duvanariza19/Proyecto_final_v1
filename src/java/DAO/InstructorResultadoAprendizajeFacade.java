/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.InstructorResultadoAprendizaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.InstructorResultadoAprendizaje_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Instructor;
import Model.ResultadoAprendizaje;

/**
 *
 * @author camel
 */
@Stateless
public class InstructorResultadoAprendizajeFacade extends AbstractFacade<InstructorResultadoAprendizaje> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstructorResultadoAprendizajeFacade() {
        super(InstructorResultadoAprendizaje.class);
    }

    public boolean isIdInstructorEmpty(InstructorResultadoAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InstructorResultadoAprendizaje> instructorResultadoAprendizaje = cq.from(InstructorResultadoAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instructorResultadoAprendizaje, entity), cb.isNotNull(instructorResultadoAprendizaje.get(InstructorResultadoAprendizaje_.idInstructor)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Instructor findIdInstructor(InstructorResultadoAprendizaje entity) {
        return this.getMergedEntity(entity).getIdInstructor();
    }

    public boolean isIdResultadoAprendizajeEmpty(InstructorResultadoAprendizaje entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InstructorResultadoAprendizaje> instructorResultadoAprendizaje = cq.from(InstructorResultadoAprendizaje.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instructorResultadoAprendizaje, entity), cb.isNotNull(instructorResultadoAprendizaje.get(InstructorResultadoAprendizaje_.idResultadoAprendizaje)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ResultadoAprendizaje findIdResultadoAprendizaje(InstructorResultadoAprendizaje entity) {
        return this.getMergedEntity(entity).getIdResultadoAprendizaje();
    }
    
}
