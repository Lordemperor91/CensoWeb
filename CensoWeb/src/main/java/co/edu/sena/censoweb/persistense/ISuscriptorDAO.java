/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Suscriptor;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ISuscriptorDAO {
     public void insert(Suscriptor suscriptor) throws Exception;
    public void update(Suscriptor suscriptor) throws Exception;
    public void delete(Suscriptor suscriptor) throws Exception;
    public Suscriptor findById(Long documento) throws Exception;    
    public List<Suscriptor> findAll()throws Exception;
}

