/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Predio;
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
public class PredioDAO implements IPredioDAO{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
   public void insert(Predio predio) throws Exception {
        try {
            entityManager.persist(predio);
        } catch (Exception e) {
        }
  
    }
    @Override
    public void update(Predio predio) throws Exception {
        try {
            entityManager.merge(predio);
        } catch (Exception e) {
        }
        
    }
    @Override
    public void delete(Predio predio) throws Exception {
        try {
            entityManager.remove(predio);
        } catch (Exception e) {
        }
    }

    @Override
    public Predio findById(Integer idPredio) throws Exception {
        try {
            return entityManager.find(Predio.class, idPredio);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<Predio> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Predio.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
    
}

    

