/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Rol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Rol_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Perfil;
import Model.Permiso;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    public boolean isPerfilCollectionEmpty(Rol entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Rol> rol = cq.from(Rol.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(rol, entity), cb.isNotEmpty(rol.get(Rol_.perfilCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Perfil> findPerfilCollection(Rol entity) {
        Rol mergedEntity = this.getMergedEntity(entity);
        Collection<Perfil> perfilCollection = mergedEntity.getPerfilCollection();
        perfilCollection.size();
        return perfilCollection;
    }

    public boolean isPermisoCollectionEmpty(Rol entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Rol> rol = cq.from(Rol.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(rol, entity), cb.isNotEmpty(rol.get(Rol_.permisoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Permiso> findPermisoCollection(Rol entity) {
        Rol mergedEntity = this.getMergedEntity(entity);
        Collection<Permiso> permisoCollection = mergedEntity.getPermisoCollection();
        permisoCollection.size();
        return permisoCollection;
    }
    
}
