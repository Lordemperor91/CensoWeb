/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Servicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface IServicioDAO {
     public void insert(Servicio servicio) throws Exception;
    public void update(Servicio servicio) throws Exception;
    public void delete(Servicio servicio) throws Exception;
    public Servicio findById(Integer idServicio) throws Exception;    
    public List<Servicio> findAll()throws Exception;
}

