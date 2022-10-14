/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e"),
    @NamedQuery(name = "Encuesta.findByNumeroFormulario", query = "SELECT e FROM Encuesta e WHERE e.numeroFormulario = :numeroFormulario"),
    @NamedQuery(name = "Encuesta.findByFecha", query = "SELECT e FROM Encuesta e WHERE e.fecha = :fecha")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_formulario")
    private Integer numeroFormulario;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_encuestador", referencedColumnName = "cedula")
    @ManyToOne
    private Encuestador idEncuestador;
    @JoinColumn(name = "id_predio", referencedColumnName = "id_predio")
    @ManyToOne
    private Predio idPredio;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne
    private Servicio idServicio;
    @JoinColumn(name = "id_suscriptor", referencedColumnName = "documento")
    @ManyToOne
    private Suscriptor idSuscriptor;

    public Encuesta() {
    }

    public Encuesta(Integer numeroFormulario) {
        this.numeroFormulario = numeroFormulario;
    }

    public Integer getNumeroFormulario() {
        return numeroFormulario;
    }

    public void setNumeroFormulario(Integer numeroFormulario) {
        this.numeroFormulario = numeroFormulario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Encuestador getIdEncuestador() {
        return idEncuestador;
    }

    public void setIdEncuestador(Encuestador idEncuestador) {
        this.idEncuestador = idEncuestador;
    }

    public Predio getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(Predio idPredio) {
        this.idPredio = idPredio;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Suscriptor getIdSuscriptor() {
        return idSuscriptor;
    }

    public void setIdSuscriptor(Suscriptor idSuscriptor) {
        this.idSuscriptor = idSuscriptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFormulario != null ? numeroFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.numeroFormulario == null && other.numeroFormulario != null) || (this.numeroFormulario != null && !this.numeroFormulario.equals(other.numeroFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.censoweb.model.Encuesta[ numeroFormulario=" + numeroFormulario + " ]";
    }
    
}
