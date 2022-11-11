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
import org.apache.commons.codec.digest.DigestUtils;

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
        if(usuario.getContrasena().isEmpty()){
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
    public String encryptPassword(String password)
    {
    
        String encryptMD5 = DigestUtils.md5Hex(password);
        return encryptMD5;
    }

    @Override
    public void login(Usuario usuario) throws Exception {
        if(usuario == null)
        {
         throw new Exception("el usurio es nulo");
            
        }
        if (usuario.getNombre().isEmpty())
        {
        throw new Exception("el nombre de usuario es obligatorio");
        
        }
        //busca si existe un usuario por el nombre
        Usuario oldUsuario = usuarioDAO.findById(usuario.getNombre());
        if(oldUsuario == null)
        {
        
            throw new Exception("usuario incorrecto");
        
        }
        //encriptar contraseña digitada en el login para  comparar con la bd
        
        String passwordEncrypted = encryptPassword(usuario.getContrasena());
        if(!oldUsuario.getContrasena().equals(passwordEncrypted))
        {
            throw new Exception("usuario incorrecto");
        }
    }
}
