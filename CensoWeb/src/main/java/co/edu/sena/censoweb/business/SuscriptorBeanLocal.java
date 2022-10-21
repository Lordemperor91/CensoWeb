/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Suscriptor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JART
 */
@Local
public interface SuscriptorBeanLocal {
    public void insert(Suscriptor suscriptor) throws Exception;
    public void update(Suscriptor suscriptor) throws Exception;
    public void delete(Suscriptor suscriptor) throws Exception;
    public Suscriptor findById (Long documento) throws Exception;
    public List<Suscriptor> findAll () throws Exception;
}
