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
@Table(name = "resultado_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoAprendizaje.findAll", query = "SELECT r FROM ResultadoAprendizaje r")
    , @NamedQuery(name = "ResultadoAprendizaje.findByIdResultadoAprendizaje", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.idResultadoAprendizaje = :idResultadoAprendizaje")
    , @NamedQuery(name = "ResultadoAprendizaje.findByFechaRegistro", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.fechaRegistro = :fechaRegistro")})
public class ResultadoAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resultado_aprendizaje")
    private Integer idResultadoAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Nombre_resultado")
    private String nombreresultado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje")
    private Collection<InstructorResultadoAprendizaje> instructorResultadoAprendizajeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje")
    private Collection<EvidenciaAprendizaje> evidenciaAprendizajeCollection;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;

    public ResultadoAprendizaje() {
    }

    public ResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public ResultadoAprendizaje(Integer idResultadoAprendizaje, String nombreresultado, String descripcion) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
        this.nombreresultado = nombreresultado;
        this.descripcion = descripcion;
    }

    public Integer getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public String getNombreresultado() {
        return nombreresultado;
    }

    public void setNombreresultado(String nombreresultado) {
        this.nombreresultado = nombreresultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<InstructorResultadoAprendizaje> getInstructorResultadoAprendizajeCollection() {
        return instructorResultadoAprendizajeCollection;
    }

    public void setInstructorResultadoAprendizajeCollection(Collection<InstructorResultadoAprendizaje> instructorResultadoAprendizajeCollection) {
        this.instructorResultadoAprendizajeCollection = instructorResultadoAprendizajeCollection;
    }

    @XmlTransient
    public Collection<EvidenciaAprendizaje> getEvidenciaAprendizajeCollection() {
        return evidenciaAprendizajeCollection;
    }

    public void setEvidenciaAprendizajeCollection(Collection<EvidenciaAprendizaje> evidenciaAprendizajeCollection) {
        this.evidenciaAprendizajeCollection = evidenciaAprendizajeCollection;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoAprendizaje != null ? idResultadoAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoAprendizaje)) {
            return false;
        }
        ResultadoAprendizaje other = (ResultadoAprendizaje) object;
        if ((this.idResultadoAprendizaje == null && other.idResultadoAprendizaje != null) || (this.idResultadoAprendizaje != null && !this.idResultadoAprendizaje.equals(other.idResultadoAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ResultadoAprendizaje[ idResultadoAprendizaje=" + idResultadoAprendizaje + " ]";
    }
    
}
