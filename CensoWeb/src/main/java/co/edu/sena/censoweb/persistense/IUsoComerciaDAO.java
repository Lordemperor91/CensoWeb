/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.censoweb.persistense;

import co.edu.sena.censoweb.model.UsoComercial;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IUsoComerciaDAO {
      public void insert(UsoComercial usoComercial) throws Exception;
    public void update(UsoComercial usoComercial) throws Exception;
    public void delete(UsoComercial usoComercial) throws Exception;
    public UsoComercial findById(Integer idUso) throws Exception;    
    public List<UsoComercial> findAll()throws Exception;
}
