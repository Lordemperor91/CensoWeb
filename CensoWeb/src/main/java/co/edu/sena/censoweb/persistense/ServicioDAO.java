/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Servicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class ServicioDAO implements IServicioDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
   public void insert(Servicio servicio) throws Exception {
        try {
            entityManager.persist(servicio);
        } catch (Exception e) {
        }
  
    }
    @Override
    public void update(Servicio servicio) throws Exception {
        try {
            entityManager.merge(servicio);
        } catch (Exception e) {
        }
        
    }
    @Override
    public void delete(Servicio servicio) throws Exception {
        try {
            entityManager.remove(servicio);
        } catch (Exception e) {
        }
    }

    @Override
    public Servicio findById(Integer idServicio) throws Exception {
        try {
            return entityManager.find(Servicio.class, idServicio);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<Servicio> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Servicio.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
    
}

    



