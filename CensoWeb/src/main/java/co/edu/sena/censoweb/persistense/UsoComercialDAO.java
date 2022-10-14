/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.UsoComercial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class UsoComercialDAO implements IUsoComerciaDAO{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
   public void insert(UsoComercial usoComercial) throws Exception {
        try {
            entityManager.persist(usoComercial);
        } catch (Exception e) {
        }
  
    }
    @Override
    public void update(UsoComercial usoComercial) throws Exception {
        try {
            entityManager.merge(usoComercial);
        } catch (Exception e) {
        }
        
    }
    @Override
    public void delete(UsoComercial usoComercial) throws Exception {
        try {
            entityManager.remove(usoComercial);
        } catch (Exception e) {
        }
    }

    @Override
    public UsoComercial findById(Integer idUso) throws Exception {
        try {
            return entityManager.find(UsoComercial.class, idUso);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<UsoComercial> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("UsoComercial.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
    
}


