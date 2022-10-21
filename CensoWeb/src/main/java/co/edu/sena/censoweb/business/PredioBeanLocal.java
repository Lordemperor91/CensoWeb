/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Predio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface PredioBeanLocal {
    public void insert(Predio predio) throws Exception;
    public void update(Predio predio) throws Exception;
    public void delete(Predio predio) throws Exception;
    public Predio findById(Integer idPredio) throws Exception;    
    public List<Predio> findAll()throws Exception;
}
