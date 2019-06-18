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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByEstadoUsuario", query = "SELECT u FROM Usuario u WHERE u.estadoUsuario = :estadoUsuario")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByFechaContrasena", query = "SELECT u FROM Usuario u WHERE u.fechaContrasena = :fechaContrasena")
    , @NamedQuery(name = "Usuario.findByContrasenaAnterior", query = "SELECT u FROM Usuario u WHERE u.contrasenaAnterior = :contrasenaAnterior")
    , @NamedQuery(name = "Usuario.findByIntentosLogin", query = "SELECT u FROM Usuario u WHERE u.intentosLogin = :intentosLogin")
    , @NamedQuery(name = "Usuario.findByFechaRegistro", query = "SELECT u FROM Usuario u WHERE u.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Usuario.findByCorreoSena", query = "SELECT u FROM Usuario u WHERE u.correoSena = :correoSena")
    , @NamedQuery(name = "Usuario.findByFechaModificacio", query = "SELECT u FROM Usuario u WHERE u.fechaModificacio = :fechaModificacio")
    , @NamedQuery(name = "Usuario.findByIdUsuarioModifica", query = "SELECT u FROM Usuario u WHERE u.idUsuarioModifica = :idUsuarioModifica")
    , @NamedQuery(name = "Usuario.findByNombreUsuarioModifica", query = "SELECT u FROM Usuario u WHERE u.nombreUsuarioModifica = :nombreUsuarioModifica")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado_usuario")
    private String estadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "fecha_contrasena")
    @Temporal(TemporalType.DATE)
    private Date fechaContrasena;
    @Size(max = 500)
    @Column(name = "contrasena_anterior")
    private String contrasenaAnterior;
    @Column(name = "intentos_login")
    private Integer intentosLogin;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Size(max = 150)
    @Column(name = "correo_sena")
    private String correoSena;
    @Column(name = "fecha_modificacio")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacio;
    @Column(name = "id_usuario_modifica")
    private Integer idUsuarioModifica;
    @Size(max = 300)
    @Column(name = "nombre_usuario_modifica")
    private String nombreUsuarioModifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Perfil> perfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Instructor> instructorCollection;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(optional = false)
    private Persona numeroDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Aprendiz> aprendizCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String estadoUsuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.estadoUsuario = estadoUsuario;
        this.contrasena = contrasena;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaContrasena() {
        return fechaContrasena;
    }

    public void setFechaContrasena(Date fechaContrasena) {
        this.fechaContrasena = fechaContrasena;
    }

    public String getContrasenaAnterior() {
        return contrasenaAnterior;
    }

    public void setContrasenaAnterior(String contrasenaAnterior) {
        this.contrasenaAnterior = contrasenaAnterior;
    }

    public Integer getIntentosLogin() {
        return intentosLogin;
    }

    public void setIntentosLogin(Integer intentosLogin) {
        this.intentosLogin = intentosLogin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCorreoSena() {
        return correoSena;
    }

    public void setCorreoSena(String correoSena) {
        this.correoSena = correoSena;
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

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    @XmlTransient
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    public Persona getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Persona numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlTransient
    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
