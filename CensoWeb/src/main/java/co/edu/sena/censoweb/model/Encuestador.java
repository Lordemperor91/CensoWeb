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
@Table(name = "encuestador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuestador.findAll", query = "SELECT e FROM Encuestador e"),
    @NamedQuery(name = "Encuestador.findByCedula", query = "SELECT e FROM Encuestador e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Encuestador.findByNombre", query = "SELECT e FROM Encuestador e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Encuestador.findByTelefono", query = "SELECT e FROM Encuestador e WHERE e.telefono = :telefono")})
public class Encuestador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "cedula", nullable=false)
    private Long cedula;
    @Basic(optional = false)   

    @Column(name = "nombre", nullable=false, length = 50)
    private String nombre;
  
    @Column(name = "telefono",length = 30)
    private String telefono;
    @OneToMany(mappedBy = "idEncuestador")
    private Collection<Encuesta> encuestaCollection;

    public Encuestador() {
    }

    public Encuestador(Long cedula) {
        this.cedula = cedula;
    }

    public Encuestador(Long cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuestador)) {
            return false;
        }
        Encuestador other = (Encuestador) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.censoweb.model.Encuestador[ cedula=" + cedula + " ]";
    }
    
}
