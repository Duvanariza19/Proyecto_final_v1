/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camel
 */
@Entity
@Table(name = "programa_de_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaDeFormacion.findAll", query = "SELECT p FROM ProgramaDeFormacion p")
    , @NamedQuery(name = "ProgramaDeFormacion.findByIdPrograma", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.idPrograma = :idPrograma")
    , @NamedQuery(name = "ProgramaDeFormacion.findByNombrePrograma", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.nombrePrograma = :nombrePrograma")
    , @NamedQuery(name = "ProgramaDeFormacion.findByDuracionMeses", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.duracionMeses = :duracionMeses")
    , @NamedQuery(name = "ProgramaDeFormacion.findByTipoPrograma", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.tipoPrograma = :tipoPrograma")
    , @NamedQuery(name = "ProgramaDeFormacion.findByEstado", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.estado = :estado")
    , @NamedQuery(name = "ProgramaDeFormacion.findByIdUsuarioModifica", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.idUsuarioModifica = :idUsuarioModifica")
    , @NamedQuery(name = "ProgramaDeFormacion.findByNombreUsuarioModifica", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.nombreUsuarioModifica = :nombreUsuarioModifica")})
public class ProgramaDeFormacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_programa")
    private Integer idPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_programa")
    private String nombrePrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_meses")
    private int duracionMeses;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion_programa")
    private String descripcionPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_programa")
    private String tipoPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_modifica")
    private int idUsuarioModifica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre_usuario_modifica")
    private String nombreUsuarioModifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private Collection<Competencia> competenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private Collection<Ficha> fichaCollection;

    public ProgramaDeFormacion() {
    }

    public ProgramaDeFormacion(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public ProgramaDeFormacion(Integer idPrograma, String nombrePrograma, int duracionMeses, String tipoPrograma, String estado, int idUsuarioModifica, String nombreUsuarioModifica) {
        this.idPrograma = idPrograma;
        this.nombrePrograma = nombrePrograma;
        this.duracionMeses = duracionMeses;
        this.tipoPrograma = tipoPrograma;
        this.estado = estado;
        this.idUsuarioModifica = idUsuarioModifica;
        this.nombreUsuarioModifica = nombreUsuarioModifica;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public String getDescripcionPrograma() {
        return descripcionPrograma;
    }

    public void setDescripcionPrograma(String descripcionPrograma) {
        this.descripcionPrograma = descripcionPrograma;
    }

    public String getTipoPrograma() {
        return tipoPrograma;
    }

    public void setTipoPrograma(String tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuarioModifica() {
        return idUsuarioModifica;
    }

    public void setIdUsuarioModifica(int idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }

    public String getNombreUsuarioModifica() {
        return nombreUsuarioModifica;
    }

    public void setNombreUsuarioModifica(String nombreUsuarioModifica) {
        this.nombreUsuarioModifica = nombreUsuarioModifica;
    }

    @XmlTransient
    public Collection<Competencia> getCompetenciaCollection() {
        return competenciaCollection;
    }

    public void setCompetenciaCollection(Collection<Competencia> competenciaCollection) {
        this.competenciaCollection = competenciaCollection;
    }

    @XmlTransient
    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrograma != null ? idPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaDeFormacion)) {
            return false;
        }
        ProgramaDeFormacion other = (ProgramaDeFormacion) object;
        if ((this.idPrograma == null && other.idPrograma != null) || (this.idPrograma != null && !this.idPrograma.equals(other.idPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProgramaDeFormacion[ idPrograma=" + idPrograma + " ]";
    }
    
}
