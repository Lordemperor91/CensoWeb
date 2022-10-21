/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Usuario;
import co.edu.sena.censoweb.persistense.IUsuarioDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JART
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {
@EJB
    private IUsuarioDAO usuarioDAO;
    public void validate(Usuario usuario) throws Exception{
        if(usuario == null){
            throw new Exception("Los campos son obligatorios");
        }
        if(usuario.getNombre() == null){
            throw new Exception("El usuario es obligatorio");
        }
        if(usuario.getContrasena() == null){
            throw new Exception("La contraseña es obligatoria");
        }
    } 
    @Override
    public Usuario findById(String nombre) throws Exception {
        if(nombre == null){
            throw new Exception("El nombre es obligatoria");
        }
        return usuarioDAO.findById(nombre);
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return usuarioDAO.findAll();
    }

}
