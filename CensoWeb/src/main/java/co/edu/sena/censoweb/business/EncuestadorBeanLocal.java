/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Encuestador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface EncuestadorBeanLocal {
    public void insert(Encuestador encuestador) throws Exception;
    public void update(Encuestador encuestador) throws Exception;
    public void delete(Encuestador encuestador) throws Exception;
    public Encuestador findById(Long cedula) throws Exception;    
    public List<Encuestador> findAll()throws Exception;
}
