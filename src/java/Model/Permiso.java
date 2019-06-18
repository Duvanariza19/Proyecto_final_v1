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
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByIdPermiso", query = "SELECT p FROM Permiso p WHERE p.idPermiso = :idPermiso")
    , @NamedQuery(name = "Permiso.findByNombrePermiso", query = "SELECT p FROM Permiso p WHERE p.nombrePermiso = :nombrePermiso")
    , @NamedQuery(name = "Permiso.findByModulo", query = "SELECT p FROM Permiso p WHERE p.modulo = :modulo")
    , @NamedQuery(name = "Permiso.findByEstado", query = "SELECT p FROM Permiso p WHERE p.estado = :estado")
    , @NamedQuery(name = "Permiso.findByCrar", query = "SELECT p FROM Permiso p WHERE p.crar = :crar")
    , @NamedQuery(name = "Permiso.findByConsultar", query = "SELECT p FROM Permiso p WHERE p.consultar = :consultar")
    , @NamedQuery(name = "Permiso.findByModificar", query = "SELECT p FROM Permiso p WHERE p.modificar = :modificar")
    , @NamedQuery(name = "Permiso.findByEliminar", query = "SELECT p FROM Permiso p WHERE p.eliminar = :eliminar")
    , @NamedQuery(name = "Permiso.findByFechaModificacio", query = "SELECT p FROM Permiso p WHERE p.fechaModificacio = :fechaModificacio")
    , @NamedQuery(name = "Permiso.findByIdUsuarioModifica", query = "SELECT p FROM Permiso p WHERE p.idUsuarioModifica = :idUsuarioModifica")
    , @NamedQuery(name = "Permiso.findByNombreUsuarioModifica", query = "SELECT p FROM Permiso p WHERE p.nombreUsuarioModifica = :nombreUsuarioModifica")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso")
    private Integer idPermiso;
    @Size(max = 255)
    @Column(name = "nombre_permiso")
    private String nombrePermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "modulo")
    private String modulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crar")
    private boolean crar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consultar")
    private boolean consultar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificar")
    private boolean modificar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminar")
    private boolean eliminar;
    @Column(name = "fecha_modificacio")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacio;
    @Column(name = "id_usuario_modifica")
    private Integer idUsuarioModifica;
    @Size(max = 300)
    @Column(name = "nombre_usuario_modifica")
    private String nombreUsuarioModifica;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idRol;

    public Permiso() {
    }

    public Permiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Permiso(Integer idPermiso, String modulo, String estado, boolean crar, boolean consultar, boolean modificar, boolean eliminar) {
        this.idPermiso = idPermiso;
        this.modulo = modulo;
        this.estado = estado;
        this.crar = crar;
        this.consultar = consultar;
        this.modificar = modificar;
        this.eliminar = eliminar;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getCrar() {
        return crar;
    }

    public void setCrar(boolean crar) {
        this.crar = crar;
    }

    public boolean getConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public boolean getModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
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

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Permiso[ idPermiso=" + idPermiso + " ]";
    }
    
}
