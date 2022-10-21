/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.Predio;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IPredioDAO {
     public void insert(Predio predio) throws Exception;
    public void update(Predio predio) throws Exception;
    public void delete(Predio predio) throws Exception;
    public Predio findById(Integer idPredio) throws Exception;    
    public List<Predio> findAll()throws Exception;
}
