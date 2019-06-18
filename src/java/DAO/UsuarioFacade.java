/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Usuario_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Perfil;
import Model.Instructor;
import Model.Persona;
import Model.Aprendiz;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public boolean isPerfilCollectionEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.perfilCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Perfil> findPerfilCollection(Usuario entity) {
        Usuario mergedEntity = this.getMergedEntity(entity);
        Collection<Perfil> perfilCollection = mergedEntity.getPerfilCollection();
        perfilCollection.size();
        return perfilCollection;
    }

    public boolean isInstructorCollectionEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.instructorCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Instructor> findInstructorCollection(Usuario entity) {
        Usuario mergedEntity = this.getMergedEntity(entity);
        Collection<Instructor> instructorCollection = mergedEntity.getInstructorCollection();
        instructorCollection.size();
        return instructorCollection;
    }

    public boolean isNumeroDocumentoEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotNull(usuario.get(Usuario_.numeroDocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Persona findNumeroDocumento(Usuario entity) {
        return this.getMergedEntity(entity).getNumeroDocumento();
    }

    public boolean isAprendizCollectionEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.aprendizCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Aprendiz> findAprendizCollection(Usuario entity) {
        Usuario mergedEntity = this.getMergedEntity(entity);
        Collection<Aprendiz> aprendizCollection = mergedEntity.getAprendizCollection();
        aprendizCollection.size();
        return aprendizCollection;
    }
    
}
