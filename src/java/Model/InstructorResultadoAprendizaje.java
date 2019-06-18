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
@Table(name = "instructor_resultado_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstructorResultadoAprendizaje.findAll", query = "SELECT i FROM InstructorResultadoAprendizaje i")
    , @NamedQuery(name = "InstructorResultadoAprendizaje.findByIdInstructorResultadoAprendizaje", query = "SELECT i FROM InstructorResultadoAprendizaje i WHERE i.idInstructorResultadoAprendizaje = :idInstructorResultadoAprendizaje")
    , @NamedQuery(name = "InstructorResultadoAprendizaje.findByFechaRegistro", query = "SELECT i FROM InstructorResultadoAprendizaje i WHERE i.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "InstructorResultadoAprendizaje.findByFechaModificacio", query = "SELECT i FROM InstructorResultadoAprendizaje i WHERE i.fechaModificacio = :fechaModificacio")
    , @NamedQuery(name = "InstructorResultadoAprendizaje.findByIdUsuarioModifica", query = "SELECT i FROM InstructorResultadoAprendizaje i WHERE i.idUsuarioModifica = :idUsuarioModifica")
    , @NamedQuery(name = "InstructorResultadoAprendizaje.findByNombreUsuarioModifica", query = "SELECT i FROM InstructorResultadoAprendizaje i WHERE i.nombreUsuarioModifica = :nombreUsuarioModifica")})
public class InstructorResultadoAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instructor_resultado_aprendizaje")
    private Integer idInstructorResultadoAprendizaje;
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
    @JoinColumn(name = "id_instructor", referencedColumnName = "id_instructor")
    @ManyToOne(optional = false)
    private Instructor idInstructor;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;

    public InstructorResultadoAprendizaje() {
    }

    public InstructorResultadoAprendizaje(Integer idInstructorResultadoAprendizaje) {
        this.idInstructorResultadoAprendizaje = idInstructorResultadoAprendizaje;
    }

    public Integer getIdInstructorResultadoAprendizaje() {
        return idInstructorResultadoAprendizaje;
    }

    public void setIdInstructorResultadoAprendizaje(Integer idInstructorResultadoAprendizaje) {
        this.idInstructorResultadoAprendizaje = idInstructorResultadoAprendizaje;
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

    public Instructor getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Instructor idInstructor) {
        this.idInstructor = idInstructor;
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
        hash += (idInstructorResultadoAprendizaje != null ? idInstructorResultadoAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorResultadoAprendizaje)) {
            return false;
        }
        InstructorResultadoAprendizaje other = (InstructorResultadoAprendizaje) object;
        if ((this.idInstructorResultadoAprendizaje == null && other.idInstructorResultadoAprendizaje != null) || (this.idInstructorResultadoAprendizaje != null && !this.idInstructorResultadoAprendizaje.equals(other.idInstructorResultadoAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.InstructorResultadoAprendizaje[ idInstructorResultadoAprendizaje=" + idInstructorResultadoAprendizaje + " ]";
    }
    
}
