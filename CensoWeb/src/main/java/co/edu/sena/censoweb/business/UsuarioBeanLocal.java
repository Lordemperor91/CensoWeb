/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JART
 */
@Local
public interface UsuarioBeanLocal {
    public Usuario findById (String nombre) throws Exception;
    public List<Usuario> findAll() throws Exception;
    public void login(Usuario usuario)throws Exception;
    
}
