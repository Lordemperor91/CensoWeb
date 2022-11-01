/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Encuestador;
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
public class EncuestadorDAO implements IEncuestadorDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public void insert(Encuestador encuestador) throws Exception {
        try {
            entityManager.persist(encuestador);
        } catch (Exception e) {
        }
  
    }
    @Override
    public void update(Encuestador encuestador) throws Exception {
        try {
            entityManager.merge(encuestador);
        } catch (Exception e) {
        }
        
    }
    @Override
    public void delete(Encuestador encuestador) throws Exception {
        try {
            entityManager.remove(encuestador);
        } catch (Exception e) {
        }
    }

    @Override
    public Encuestador findById(Long cedula) throws Exception {
        try {
            return entityManager.find(Encuestador.class, cedula);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<Encuestador> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Encuestador.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
    
}
