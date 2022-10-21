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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "predio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predio.findAll", query = "SELECT p FROM Predio p"),
    @NamedQuery(name = "Predio.findByIdPredio", query = "SELECT p FROM Predio p WHERE p.idPredio = :idPredio"),
    @NamedQuery(name = "Predio.findByAbreviatura", query = "SELECT p FROM Predio p WHERE p.abreviatura = :abreviatura"),
    @NamedQuery(name = "Predio.findByPrimerNumero", query = "SELECT p FROM Predio p WHERE p.primerNumero = :primerNumero"),
    @NamedQuery(name = "Predio.findBySegundoNumero", query = "SELECT p FROM Predio p WHERE p.segundoNumero = :segundoNumero"),
    @NamedQuery(name = "Predio.findByTercerNumero", query = "SELECT p FROM Predio p WHERE p.tercerNumero = :tercerNumero"),
    @NamedQuery(name = "Predio.findByComplemento", query = "SELECT p FROM Predio p WHERE p.complemento = :complemento"),
    @NamedQuery(name = "Predio.findByBarrio", query = "SELECT p FROM Predio p WHERE p.barrio = :barrio"),
    @NamedQuery(name = "Predio.findByNumeroPisos", query = "SELECT p FROM Predio p WHERE p.numeroPisos = :numeroPisos"),
    @NamedQuery(name = "Predio.findByNumeroOcupantes", query = "SELECT p FROM Predio p WHERE p.numeroOcupantes = :numeroOcupantes")})
public class Predio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_predio")
    private Integer idPredio;    
    @Column(name = "abreviatura",length = 20)
    private String abreviatura;
    @Column(name = "primer_numero")
    private Integer primerNumero;
    @Column(name = "segundo_numero")
    private Integer segundoNumero;
    @Column(name = "tercer_numero")
    private Integer tercerNumero;   
    @Column(name = "complemento",length = 20)
    private String complemento;    
    @Column(name = "barrio",length = 20)
    private String barrio;
    @Column(name = "numero_pisos")
    private Integer numeroPisos;
    @Column(name = "numero_ocupantes")
    private Integer numeroOcupantes;
    @OneToMany(mappedBy = "idPredio")
    private Collection<Encuesta> encuestaCollection;
    @JoinColumn(name = "id_uso", referencedColumnName = "id_uso")
    @ManyToOne
    private UsoComercial idUso;

    public Predio() {
    }

    public Predio(Integer idPredio) {
        this.idPredio = idPredio;
    }

    public Integer getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(Integer idPredio) {
        this.idPredio = idPredio;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getPrimerNumero() {
        return primerNumero;
    }

    public void setPrimerNumero(Integer primerNumero) {
        this.primerNumero = primerNumero;
    }

    public Integer getSegundoNumero() {
        return segundoNumero;
    }

    public void setSegundoNumero(Integer segundoNumero) {
        this.segundoNumero = segundoNumero;
    }

    public Integer getTercerNumero() {
        return tercerNumero;
    }

    public void setTercerNumero(Integer tercerNumero) {
        this.tercerNumero = tercerNumero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(Integer numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public Integer getNumeroOcupantes() {
        return numeroOcupantes;
    }

    public void setNumeroOcupantes(Integer numeroOcupantes) {
        this.numeroOcupantes = numeroOcupantes;
    }

    @XmlTransient
    public Collection<Encuesta> getEncuestaCollection() {
        return encuestaCollection;
    }

    public void setEncuestaCollection(Collection<Encuesta> encuestaCollection) {
        this.encuestaCollection = encuestaCollection;
    }

    public UsoComercial getIdUso() {
        return idUso;
    }

    public void setIdUso(UsoComercial idUso) {
        this.idUso = idUso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPredio != null ? idPredio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predio)) {
            return false;
        }
        Predio other = (Predio) object;
        if ((this.idPredio == null && other.idPredio != null) || (this.idPredio != null && !this.idPredio.equals(other.idPredio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.censoweb.model.Predio[ idPredio=" + idPredio + " ]";
    }
    
}
