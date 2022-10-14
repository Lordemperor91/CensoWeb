/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "suscriptor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscriptor.findAll", query = "SELECT s FROM Suscriptor s"),
    @NamedQuery(name = "Suscriptor.findByDocumento", query = "SELECT s FROM Suscriptor s WHERE s.documento = :documento"),
    @NamedQuery(name = "Suscriptor.findByTipoDocumento", query = "SELECT s FROM Suscriptor s WHERE s.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Suscriptor.findByPrimerNombre", query = "SELECT s FROM Suscriptor s WHERE s.primerNombre = :primerNombre"),
    @NamedQuery(name = "Suscriptor.findBySegundoNombre", query = "SELECT s FROM Suscriptor s WHERE s.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Suscriptor.findByPrimerApellido", query = "SELECT s FROM Suscriptor s WHERE s.primerApellido = :primerApellido"),
    @NamedQuery(name = "Suscriptor.findBySegundoApellido", query = "SELECT s FROM Suscriptor s WHERE s.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Suscriptor.findByTelefono", query = "SELECT s FROM Suscriptor s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Suscriptor.findByEmail", query = "SELECT s FROM Suscriptor s WHERE s.email = :email")})
public class Suscriptor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "documento",nullable=false)
    private Long documento;
    @Basic(optional = false)    
    @Column(name = "tipo_documento",nullable=false, length = 20)
    private String tipoDocumento;
    @Basic(optional = false)  
    @Column(name = "primer_nombre",nullable=false, length = 50)
    private String primerNombre;   
    @Column(name = "segundo_nombre",length = 50)
    private String segundoNombre;
    @Basic(optional = false)    
    @Column(name = "primer_apellido",nullable=false, length = 50)
    private String primerApellido;    
    @Column(name = "segundo_apellido",length = 50)
    private String segundoApellido;   
    @Column(name = "telefono",length = 30)
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    @Column(name = "email",length = 50)
    private String email;
    @OneToMany(mappedBy = "idSuscriptor")
    private Collection<Encuesta> encuestaCollection;

    public Suscriptor() {
    }

    public Suscriptor(Long documento) {
        this.documento = documento;
    }

    public Suscriptor(Long documento, String tipoDocumento, String primerNombre, String primerApellido) {
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Encuesta> getEncuestaCollection() {
        return encuestaCollection;
    }

    public void setEncuestaCollection(Collection<Encuesta> encuestaCollection) {
        this.encuestaCollection = encuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscriptor)) {
            return false;
        }
        Suscriptor other = (Suscriptor) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.censoweb.model.Suscriptor[ documento=" + documento + " ]";
    }
    
}
