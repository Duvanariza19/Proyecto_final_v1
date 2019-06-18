/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Instructor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Instructor_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.InstructorResultadoAprendizaje;
import Model.Usuario;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class InstructorFacade extends AbstractFacade<Instructor> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstructorFacade() {
        super(Instructor.class);
    }

    public boolean isInstructorResultadoAprendizajeCollectionEmpty(Instructor entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Instructor> instructor = cq.from(Instructor.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instructor, entity), cb.isNotEmpty(instructor.get(Instructor_.instructorResultadoAprendizajeCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<InstructorResultadoAprendizaje> findInstructorResultadoAprendizajeCollection(Instructor entity) {
        Instructor mergedEntity = this.getMergedEntity(entity);
        Collection<InstructorResultadoAprendizaje> instructorResultadoAprendizajeCollection = mergedEntity.getInstructorResultadoAprendizajeCollection();
        instructorResultadoAprendizajeCollection.size();
        return instructorResultadoAprendizajeCollection;
    }

    public boolean isIdUsuarioEmpty(Instructor entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Instructor> instructor = cq.from(Instructor.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instructor, entity), cb.isNotNull(instructor.get(Instructor_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Instructor entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }
    
}
