package co.edu.sena.censoweb.persistense;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import co.edu.sena.censoweb.model.Encuesta;
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
public class EncuestaDAO implements IEncuestaDAO {
    
  @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public void insert(Encuesta encuesta) throws Exception {
        try {
            entityManager.persist(encuesta);
        } catch (Exception e) {
        }
  
    }
    @Override
    public void update(Encuesta encuesta) throws Exception {
        try {
            entityManager.merge(encuesta);
        } catch (Exception e) {
        }
        
    }
    @Override
    public void delete(Encuesta encuesta) throws Exception {
        try {
            entityManager.remove(encuesta);
        } catch (Exception e) {
        }
    }

    @Override
    public Encuesta findById(Integer numeroFormulario) throws Exception {
        try {
            return entityManager.find(Encuesta.class, numeroFormulario);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<Encuesta> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Encuesta.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
    
}
