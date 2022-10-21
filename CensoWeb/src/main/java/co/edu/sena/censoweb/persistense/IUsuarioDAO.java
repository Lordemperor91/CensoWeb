/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Usuario;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IUsuarioDAO {
     
    public Usuario findById(String nombre) throws Exception;    
    public List<Usuario> findAll()throws Exception;
}
