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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camel
 */
@Entity
@Table(name = "trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t")
    , @NamedQuery(name = "Trimestre.findByIdTrimestre", query = "SELECT t FROM Trimestre t WHERE t.idTrimestre = :idTrimestre")
    , @NamedQuery(name = "Trimestre.findByFechaInicio", query = "SELECT t FROM Trimestre t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Trimestre.findByFechaFin", query = "SELECT t FROM Trimestre t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Trimestre.findByNumeroTrimestre", query = "SELECT t FROM Trimestre t WHERE t.numeroTrimestre = :numeroTrimestre")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trimestre")
    private Integer idTrimestre;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_trimestre")
    private short numeroTrimestre;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    @ManyToOne(optional = false)
    private Ficha idFicha;

    public Trimestre() {
    }

    public Trimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Trimestre(Integer idTrimestre, short numeroTrimestre) {
        this.idTrimestre = idTrimestre;
        this.numeroTrimestre = numeroTrimestre;
    }

    public Integer getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
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

    public short getNumeroTrimestre() {
        return numeroTrimestre;
    }

    public void setNumeroTrimestre(short numeroTrimestre) {
        this.numeroTrimestre = numeroTrimestre;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Trimestre[ idTrimestre=" + idTrimestre + " ]";
    }
    
}
