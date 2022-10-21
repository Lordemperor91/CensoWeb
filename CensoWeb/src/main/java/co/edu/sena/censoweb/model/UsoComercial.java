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
@Table(name = "uso_comercial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsoComercial.findAll", query = "SELECT u FROM UsoComercial u"),
    @NamedQuery(name = "UsoComercial.findByIdUso", query = "SELECT u FROM UsoComercial u WHERE u.idUso = :idUso"),
    @NamedQuery(name = "UsoComercial.findByDescripcion", query = "SELECT u FROM UsoComercial u WHERE u.descripcion = :descripcion")})
public class UsoComercial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "id_uso",nullable=false)
    private Integer idUso;    
    @Column(name = "descripcion",length = 50)
    private String descripcion;
    @OneToMany(mappedBy = "idUso")
    private Collection<Predio> predioCollection;

    public UsoComercial() {
    }

    public UsoComercial(Integer idUso) {
        this.idUso = idUso;
    }

    public Integer getIdUso() {
        return idUso;
    }

    public void setIdUso(Integer idUso) {
        this.idUso = idUso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Predio> getPredioCollection() {
        return predioCollection;
    }

    public void setPredioCollection(Collection<Predio> predioCollection) {
        this.predioCollection = predioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUso != null ? idUso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoComercial)) {
            return false;
        }
        UsoComercial other = (UsoComercial) object;
        if ((this.idUso == null && other.idUso != null) || (this.idUso != null && !this.idUso.equals(other.idUso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.censoweb.model.UsoComercial[ idUso=" + idUso + " ]";
    }
    
}
