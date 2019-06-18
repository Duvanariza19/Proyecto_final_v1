/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camel
 */
@Entity
@Table(name = "competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c")
    , @NamedQuery(name = "Competencia.findByIdCompetencia", query = "SELECT c FROM Competencia c WHERE c.idCompetencia = :idCompetencia")
    , @NamedQuery(name = "Competencia.findByNombreCompetencia", query = "SELECT c FROM Competencia c WHERE c.nombreCompetencia = :nombreCompetencia")
    , @NamedQuery(name = "Competencia.findByEstado", query = "SELECT c FROM Competencia c WHERE c.estado = :estado")
    , @NamedQuery(name = "Competencia.findByFechaRegistro", query = "SELECT c FROM Competencia c WHERE c.fechaRegistro = :fechaRegistro")})
public class Competencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_competencia")
    private Integer idCompetencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre_competencia")
    private String nombreCompetencia;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
    @ManyToOne(optional = false)
    private ProgramaDeFormacion idPrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetencia")
    private Collection<ResultadoAprendizaje> resultadoAprendizajeCollection;

    public Competencia() {
    }

    public Competencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Competencia(Integer idCompetencia, String nombreCompetencia, String estado) {
        this.idCompetencia = idCompetencia;
        this.nombreCompetencia = nombreCompetencia;
        this.estado = estado;
    }

    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ProgramaDeFormacion getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(ProgramaDeFormacion idPrograma) {
        this.idPrograma = idPrograma;
    }

    @XmlTransient
    public Collection<ResultadoAprendizaje> getResultadoAprendizajeCollection() {
        return resultadoAprendizajeCollection;
    }

    public void setResultadoAprendizajeCollection(Collection<ResultadoAprendizaje> resultadoAprendizajeCollection) {
        this.resultadoAprendizajeCollection = resultadoAprendizajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetencia != null ? idCompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.idCompetencia == null && other.idCompetencia != null) || (this.idCompetencia != null && !this.idCompetencia.equals(other.idCompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Competencia[ idCompetencia=" + idCompetencia + " ]";
    }
    
}
