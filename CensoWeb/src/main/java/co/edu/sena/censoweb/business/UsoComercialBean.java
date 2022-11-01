/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.UsoComercial;
import co.edu.sena.censoweb.persistense.IUsoComerciaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JART
 */
@Stateless
public class UsoComercialBean implements UsoComercialBeanLocal {
@EJB
     private IUsoComerciaDAO usoComercialDAO;

    public void validate(UsoComercial usoComercial) throws Exception{
        if(usoComercial == null){
            throw new Exception("El uso comercial es obligatorio");
        }
        if(usoComercial.getIdUso() == 0){
            throw new Exception("El Id debe ser obligatorio");
        }
        if(usoComercial.getDescripcion().isEmpty()){
            throw new Exception("La descripción es obligatoria");
        }
    }
    @Override
    public void insert(UsoComercial usoComercial) throws Exception {
        validate(usoComercial);
        UsoComercial oldUsoComercial = usoComercialDAO.findById(usoComercial.getIdUso());
        if(oldUsoComercial != null){
            throw new Exception("Ya existe un usoComercial");
        }
        usoComercialDAO.insert(usoComercial);
    }

    @Override
    public void update(UsoComercial usoComercial) throws Exception {
        validate(usoComercial);
        UsoComercial oldUsoComercial = usoComercialDAO.findById(usoComercial.getIdUso());
        if(oldUsoComercial == null){
            throw new Exception("No existe un usoComercial con esta descripción");
        }
        //merge
        oldUsoComercial.setIdUso(usoComercial.getIdUso());
        oldUsoComercial.setDescripcion(usoComercial.getDescripcion());
        usoComercialDAO.update(oldUsoComercial);
    }

    @Override
    public void delete(UsoComercial usoComercial) throws Exception {
        if(usoComercial.getIdUso() == 0){
            throw new Exception("El Id es obligatoria");
        }
        UsoComercial oldUsoComercial = usoComercialDAO.findById(usoComercial.getIdUso());
        if(oldUsoComercial == null){
            throw new Exception("Ya existe un usoComercial con esta cédula");
        }
        usoComercialDAO.delete(oldUsoComercial);
    }

    @Override
    public UsoComercial findById(Integer idUso) throws Exception {
        if(idUso == 0){
            throw new Exception("el id es obligatoria");
        }
        return usoComercialDAO.findById(idUso);
    }

    @Override
    public List<UsoComercial> findAll() throws Exception {
        return usoComercialDAO.findAll();
    }
}
