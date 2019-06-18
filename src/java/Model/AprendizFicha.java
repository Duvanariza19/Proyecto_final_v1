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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camel
 */
@Entity
@Table(name = "aprendiz_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AprendizFicha.findAll", query = "SELECT a FROM AprendizFicha a")
    , @NamedQuery(name = "AprendizFicha.findByIdAprendizFicha", query = "SELECT a FROM AprendizFicha a WHERE a.idAprendizFicha = :idAprendizFicha")
    , @NamedQuery(name = "AprendizFicha.findByFechaRegistro", query = "SELECT a FROM AprendizFicha a WHERE a.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "AprendizFicha.findByFechaModificacio", query = "SELECT a FROM AprendizFicha a WHERE a.fechaModificacio = :fechaModificacio")
    , @NamedQuery(name = "AprendizFicha.findByIdUsuarioModifica", query = "SELECT a FROM AprendizFicha a WHERE a.idUsuarioModifica = :idUsuarioModifica")
    , @NamedQuery(name = "AprendizFicha.findByNombreUsuarioModifica", query = "SELECT a FROM AprendizFicha a WHERE a.nombreUsuarioModifica = :nombreUsuarioModifica")})
public class AprendizFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aprendiz_ficha")
    private Integer idAprendizFicha;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fecha_modificacio")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacio;
    @Column(name = "id_usuario_modifica")
    private Integer idUsuarioModifica;
    @Size(max = 300)
    @Column(name = "nombre_usuario_modifica")
    private String nombreUsuarioModifica;
    @JoinColumn(name = "id_aprendiz", referencedColumnName = "id_aprendiz")
    @ManyToOne(optional = false)
    private Aprendiz idAprendiz;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    @ManyToOne(optional = false)
    private Ficha idFicha;

    public AprendizFicha() {
    }

    public AprendizFicha(Integer idAprendizFicha) {
        this.idAprendizFicha = idAprendizFicha;
    }

    public Integer getIdAprendizFicha() {
        return idAprendizFicha;
    }

    public void setIdAprendizFicha(Integer idAprendizFicha) {
        this.idAprendizFicha = idAprendizFicha;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacio() {
        return fechaModificacio;
    }

    public void setFechaModificacio(Date fechaModificacio) {
        this.fechaModificacio = fechaModificacio;
    }

    public Integer getIdUsuarioModifica() {
        return idUsuarioModifica;
    }

    public void setIdUsuarioModifica(Integer idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }

    public String getNombreUsuarioModifica() {
        return nombreUsuarioModifica;
    }

    public void setNombreUsuarioModifica(String nombreUsuarioModifica) {
        this.nombreUsuarioModifica = nombreUsuarioModifica;
    }

    public Aprendiz getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(Aprendiz idAprendiz) {
        this.idAprendiz = idAprendiz;
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
        hash += (idAprendizFicha != null ? idAprendizFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AprendizFicha)) {
            return false;
        }
        AprendizFicha other = (AprendizFicha) object;
        if ((this.idAprendizFicha == null && other.idAprendizFicha != null) || (this.idAprendizFicha != null && !this.idAprendizFicha.equals(other.idAprendizFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.AprendizFicha[ idAprendizFicha=" + idAprendizFicha + " ]";
    }
    
}
