/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Encuesta;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IEncuestaDAO {
       public void insert(Encuesta encuesta) throws Exception;
    public void update(Encuesta encuesta) throws Exception;
    public void delete(Encuesta encuesta) throws Exception;
    public Encuesta findById(Integer numeroFormulario) throws Exception;    
    public List<Encuesta> findAll()throws Exception;
}
