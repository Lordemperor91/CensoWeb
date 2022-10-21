/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class UsuarioDAO implements IUsuarioDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Usuario findById(String nombre) throws Exception {
        try {
            return entityManager.find(Usuario.class, nombre);
        } catch (Exception e) {
            
            throw e;
        }
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Usuario.findAll");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
            
        }
    
    }
}