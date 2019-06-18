/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProgramaDeFormacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.ProgramaDeFormacion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Competencia;
import Model.Ficha;
import java.util.Collection;

/**
 *
 * @author camel
 */
@Stateless
public class ProgramaDeFormacionFacade extends AbstractFacade<ProgramaDeFormacion> {

    @PersistenceContext(unitName = "prueba_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaDeFormacionFacade() {
        super(ProgramaDeFormacion.class);
    }

    public boolean isCompetenciaCollectionEmpty(ProgramaDeFormacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ProgramaDeFormacion> programaDeFormacion = cq.from(ProgramaDeFormacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(programaDeFormacion, entity), cb.isNotEmpty(programaDeFormacion.get(ProgramaDeFormacion_.competenciaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Competencia> findCompetenciaCollection(ProgramaDeFormacion entity) {
        ProgramaDeFormacion mergedEntity = this.getMergedEntity(entity);
        Collection<Competencia> competenciaCollection = mergedEntity.getCompetenciaCollection();
        competenciaCollection.size();
        return competenciaCollection;
    }

    public boolean isFichaCollectionEmpty(ProgramaDeFormacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ProgramaDeFormacion> programaDeFormacion = cq.from(ProgramaDeFormacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(programaDeFormacion, entity), cb.isNotEmpty(programaDeFormacion.get(ProgramaDeFormacion_.fichaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Ficha> findFichaCollection(ProgramaDeFormacion entity) {
        ProgramaDeFormacion mergedEntity = this.getMergedEntity(entity);
        Collection<Ficha> fichaCollection = mergedEntity.getFichaCollection();
        fichaCollection.size();
        return fichaCollection;
    }
    
}
