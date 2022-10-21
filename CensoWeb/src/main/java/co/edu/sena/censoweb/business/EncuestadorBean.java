/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Encuestador;
import co.edu.sena.censoweb.persistense.IEncuestadorDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class EncuestadorBean implements EncuestadorBeanLocal {
    @EJB
    private IEncuestadorDAO encuestadorDAO;
    public void validate(Encuestador encuestador) throws Exception
    {
        if(encuestador==null)
        {
            throw new Exception ("el encuestador es nulo");

        }
        if(encuestador.getCedula()==0)
        {
            throw new Exception( "la cedula es obligatoria");

        }
        if(encuestador.getNombre().isEmpty())
        {
            throw new Exception( "el nombre es obligatoria");

        }
    
    }
    
    @Override
    public void insert(Encuestador encuestador) throws Exception {
        validate(encuestador);
        Encuestador oldEncuestador = encuestadorDAO.findById(encuestador.getCedula());
        if(oldEncuestador != null)
        {
            throw new Exception("ya existe un encuestador con la misma cedula");
        
        }
        encuestadorDAO.insert(encuestador);
    }

    @Override
    public void update(Encuestador encuestador) throws Exception {
        validate(encuestador);
        Encuestador oldEncuestador = encuestadorDAO.findById(encuestador.getCedula());
        if(oldEncuestador == null)
        {
            throw new Exception("no existe un encuestador con la misma cedula");
        
        }
        oldEncuestador.setNombre(encuestador.getNombre());
        oldEncuestador.setTelefono(encuestador.getTelefono());
        encuestadorDAO.update(encuestador);
    }
    

    @Override
    public void delete(Encuestador encuestador) throws Exception {
        if(encuestador.getCedula()==0)
        {
            throw new Exception( "la cedula es obligatoria");

        }
        Encuestador oldEncuestador = encuestadorDAO.findById(encuestador.getCedula());
        if(oldEncuestador == null)
        {
            throw new Exception("no existe un encuestador con la misma cedula");
        
        }
        
        encuestadorDAO.delete(encuestador);
    }

    @Override
    public Encuestador findById(Long cedula) throws Exception {
        if(cedula==0)
        {
            throw new Exception( "la cedula es obligatoria");
        }
        return encuestadorDAO.findById(cedula);
    }

    @Override
    public List<Encuestador> findAll() throws Exception {
        return encuestadorDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
