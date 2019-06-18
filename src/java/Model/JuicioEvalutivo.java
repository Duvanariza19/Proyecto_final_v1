/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camel
 */
@Entity
@Table(name = "juicio_evalutivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuicioEvalutivo.findAll", query = "SELECT j FROM JuicioEvalutivo j")
    , @NamedQuery(name = "JuicioEvalutivo.findByIdJuicio", query = "SELECT j FROM JuicioEvalutivo j WHERE j.idJuicio = :idJuicio")
    , @NamedQuery(name = "JuicioEvalutivo.findByIdUsuarioAprendizaje", query = "SELECT j FROM JuicioEvalutivo j WHERE j.idUsuarioAprendizaje = :idUsuarioAprendizaje")
    , @NamedQuery(name = "JuicioEvalutivo.findByValorJuicio", query = "SELECT j FROM JuicioEvalutivo j WHERE j.valorJuicio = :valorJuicio")
    , @NamedQuery(name = "JuicioEvalutivo.findByFechaJuicioEvaluativo", query = "SELECT j FROM JuicioEvalutivo j WHERE j.fechaJuicioEvaluativo = :fechaJuicioEvaluativo")})
public class JuicioEvalutivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_juicio")
    private Integer idJuicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_aprendizaje")
    private int idUsuarioAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "valor_juicio")
    private String valorJuicio;
    @Column(name = "fecha_juicio_evaluativo")
    @Temporal(TemporalType.DATE)
    private Date fechaJuicioEvaluativo;
    @JoinColumn(name = "id_evidencia", referencedColumnName = "id_evidencia")
    @ManyToOne(optional = false)
    private EvidenciaAprendizaje idEvidencia;

    public JuicioEvalutivo() {
    }

    public JuicioEvalutivo(Integer idJuicio) {
        this.idJuicio = idJuicio;
    }

    public JuicioEvalutivo(Integer idJuicio, int idUsuarioAprendizaje, String valorJuicio) {
        this.idJuicio = idJuicio;
        this.idUsuarioAprendizaje = idUsuarioAprendizaje;
        this.valorJuicio = valorJuicio;
    }

    public Integer getIdJuicio() {
        return idJuicio;
    }

    public void setIdJuicio(Integer idJuicio) {
        this.idJuicio = idJuicio;
    }

    public int getIdUsuarioAprendizaje() {
        return idUsuarioAprendizaje;
    }

    public void setIdUsuarioAprendizaje(int idUsuarioAprendizaje) {
        this.idUsuarioAprendizaje = idUsuarioAprendizaje;
    }

    public String getValorJuicio() {
        return valorJuicio;
    }

    public void setValorJuicio(String valorJuicio) {
        this.valorJuicio = valorJuicio;
    }

    public Date getFechaJuicioEvaluativo() {
        return fechaJuicioEvaluativo;
    }

    public void setFechaJuicioEvaluativo(Date fechaJuicioEvaluativo) {
        this.fechaJuicioEvaluativo = fechaJuicioEvaluativo;
    }

    public EvidenciaAprendizaje getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(EvidenciaAprendizaje idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuicio != null ? idJuicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuicioEvalutivo)) {
            return false;
        }
        JuicioEvalutivo other = (JuicioEvalutivo) object;
        if ((this.idJuicio == null && other.idJuicio != null) || (this.idJuicio != null && !this.idJuicio.equals(other.idJuicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.JuicioEvalutivo[ idJuicio=" + idJuicio + " ]";
    }
    
}
