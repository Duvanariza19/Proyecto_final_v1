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
@Table(name = "evidencia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvidenciaAprendizaje.findAll", query = "SELECT e FROM EvidenciaAprendizaje e")
    , @NamedQuery(name = "EvidenciaAprendizaje.findByIdEvidencia", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.idEvidencia = :idEvidencia")
    , @NamedQuery(name = "EvidenciaAprendizaje.findByNombreEvidencia", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.nombreEvidencia = :nombreEvidencia")
    , @NamedQuery(name = "EvidenciaAprendizaje.findByFechaInicio", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "EvidenciaAprendizaje.findByFechaFin", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.fechaFin = :fechaFin")
    , @NamedQuery(name = "EvidenciaAprendizaje.findByFechaRegistro", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.fechaRegistro = :fechaRegistro")})
public class EvidenciaAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evidencia")
    private Integer idEvidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre_evidencia")
    private String nombreEvidencia;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion_evidencia")
    private String descripcionEvidencia;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvidencia")
    private Collection<JuicioEvalutivo> juicioEvalutivoCollection;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;

    public EvidenciaAprendizaje() {
    }

    public EvidenciaAprendizaje(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public EvidenciaAprendizaje(Integer idEvidencia, String nombreEvidencia) {
        this.idEvidencia = idEvidencia;
        this.nombreEvidencia = nombreEvidencia;
    }

    public Integer getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public String getNombreEvidencia() {
        return nombreEvidencia;
    }

    public void setNombreEvidencia(String nombreEvidencia) {
        this.nombreEvidencia = nombreEvidencia;
    }

    public String getDescripcionEvidencia() {
        return descripcionEvidencia;
    }

    public void setDescripcionEvidencia(String descripcionEvidencia) {
        this.descripcionEvidencia = descripcionEvidencia;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<JuicioEvalutivo> getJuicioEvalutivoCollection() {
        return juicioEvalutivoCollection;
    }

    public void setJuicioEvalutivoCollection(Collection<JuicioEvalutivo> juicioEvalutivoCollection) {
        this.juicioEvalutivoCollection = juicioEvalutivoCollection;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvidencia != null ? idEvidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvidenciaAprendizaje)) {
            return false;
        }
        EvidenciaAprendizaje other = (EvidenciaAprendizaje) object;
        if ((this.idEvidencia == null && other.idEvidencia != null) || (this.idEvidencia != null && !this.idEvidencia.equals(other.idEvidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.EvidenciaAprendizaje[ idEvidencia=" + idEvidencia + " ]";
    }
    
}
