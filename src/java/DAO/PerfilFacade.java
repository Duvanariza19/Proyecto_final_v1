/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Perfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Perfil_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Usuario;
import Model.Rol;

/**
 *
 * @author camel
 */
@Stateless
public class PerfilFacade extends AbstractFacade<Perfil> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilFacade() {
        super(Perfil.class);
    }

    public boolean isIdUsuarioEmpty(Perfil entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Perfil> perfil = cq.from(Perfil.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(perfil, entity), cb.isNotNull(perfil.get(Perfil_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Perfil entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isIdRolEmpty(Perfil entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Perfil> perfil = cq.from(Perfil.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(perfil, entity), cb.isNotNull(perfil.get(Perfil_.idRol)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Rol findIdRol(Perfil entity) {
        return this.getMergedEntity(entity).getIdRol();
    }
    
}
