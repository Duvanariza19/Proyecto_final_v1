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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camel
 */
@Entity
@Table(name = "aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")
    , @NamedQuery(name = "Aprendiz.findByIdAprendiz", query = "SELECT a FROM Aprendiz a WHERE a.idAprendiz = :idAprendiz")})
public class Aprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aprendiz")
    private Integer idAprendiz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAprendiz")
    private Collection<AprendizFicha> aprendizFichaCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Aprendiz() {
    }

    public Aprendiz(Integer idAprendiz) {
        this.idAprendiz = idAprendiz;
    }

    public Integer getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(Integer idAprendiz) {
        this.idAprendiz = idAprendiz;
    }

    @XmlTransient
    public Collection<AprendizFicha> getAprendizFichaCollection() {
        return aprendizFichaCollection;
    }

    public void setAprendizFichaCollection(Collection<AprendizFicha> aprendizFichaCollection) {
        this.aprendizFichaCollection = aprendizFichaCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAprendiz != null ? idAprendiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.idAprendiz == null && other.idAprendiz != null) || (this.idAprendiz != null && !this.idAprendiz.equals(other.idAprendiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Aprendiz[ idAprendiz=" + idAprendiz + " ]";
    }
    
}
