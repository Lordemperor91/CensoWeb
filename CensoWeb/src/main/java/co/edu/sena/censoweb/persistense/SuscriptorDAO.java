/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Suscriptor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class SuscriptorDAO implements ISuscriptorDAO {
  @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public void insert(Suscriptor suscriptor) throws Exception {
        try {
            entityManager.persist(suscriptor);
        } catch (Exception e) {
        }
  
    }
    @Override
    public void update(Suscriptor suscriptor) throws Exception {
        try {
            entityManager.merge(suscriptor);
        } catch (Exception e) {
        }
        
    }
    @Override
    public void delete(Suscriptor suscriptor) throws Exception {
        try {
            entityManager.remove(suscriptor);
        } catch (Exception e) {
        }
    }

    @Override
    public Suscriptor findById(Long documento) throws Exception {
        try {
            return entityManager.find(Suscriptor.class,documento);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<Suscriptor> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Suscriptor.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
    
}
