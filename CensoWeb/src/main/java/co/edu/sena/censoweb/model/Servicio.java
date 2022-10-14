/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicio.findByAcueducto", query = "SELECT s FROM Servicio s WHERE s.acueducto = :acueducto"),
    @NamedQuery(name = "Servicio.findByAlcantarillado", query = "SELECT s FROM Servicio s WHERE s.alcantarillado = :alcantarillado"),
    @NamedQuery(name = "Servicio.findBySerieMedidor", query = "SELECT s FROM Servicio s WHERE s.serieMedidor = :serieMedidor"),
    @NamedQuery(name = "Servicio.findByMarcaMedidor", query = "SELECT s FROM Servicio s WHERE s.marcaMedidor = :marcaMedidor"),
    @NamedQuery(name = "Servicio.findByLectura", query = "SELECT s FROM Servicio s WHERE s.lectura = :lectura")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;    
    @Column(name = "acueducto",length = 2)
    private String acueducto;    
    @Column(name = "alcantarillado",length = 2)
    private String alcantarillado;    
    @Column(name = "serie_medidor",length = 50)
    private String serieMedidor;    
    @Column(name = "marca_medidor",length = 50)
    private String marcaMedidor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lectura")
    private BigDecimal lectura;
    @OneToMany(mappedBy = "idServicio")
    private Collection<Encuesta> encuestaCollection;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getAcueducto() {
        return acueducto;
    }

    public void setAcueducto(String acueducto) {
        this.acueducto = acueducto;
    }

    public String getAlcantarillado() {
        return alcantarillado;
    }

    public void setAlcantarillado(String alcantarillado) {
        this.alcantarillado = alcantarillado;
    }

    public String getSerieMedidor() {
        return serieMedidor;
    }

    public void setSerieMedidor(String serieMedidor) {
        this.serieMedidor = serieMedidor;
    }

    public String getMarcaMedidor() {
        return marcaMedidor;
    }

    public void setMarcaMedidor(String marcaMedidor) {
        this.marcaMedidor = marcaMedidor;
    }

    public BigDecimal getLectura() {
        return lectura;
    }

    public void setLectura(BigDecimal lectura) {
        this.lectura = lectura;
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
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.censoweb.model.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}
