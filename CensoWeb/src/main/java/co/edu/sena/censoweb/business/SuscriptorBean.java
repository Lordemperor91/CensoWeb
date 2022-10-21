/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Suscriptor;
import co.edu.sena.censoweb.persistense.ISuscriptorDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JART
 */
@Stateless
public class SuscriptorBean implements SuscriptorBeanLocal {
@EJB
    private ISuscriptorDAO suscriptorDAO;
    
    public void validate(Suscriptor suscriptor) throws Exception{
        if(suscriptor == null){
            throw new Exception("El suscriptor es obligatorio");
        }
        if(suscriptor.getDocumento() == 0){
            throw new Exception("El documento es obligatorio");
        }
        if(suscriptor.getTipoDocumento() == null){
            throw new Exception("El tipo de documento es obligatorio");
        }
        if(suscriptor.getPrimerNombre() == null){
            throw new Exception("El nombre es obligatorio");
        }
        if(suscriptor.getPrimerApellido() == null){
            throw new Exception("El apellido es obligatorio");
        }
    }

    @Override
    public void insert(Suscriptor suscriptor) throws Exception {
        validate(suscriptor);
        Suscriptor oldSuscriptor = suscriptorDAO.findById(suscriptor.getDocumento());
        if(oldSuscriptor != null){
            throw new Exception("Ya existe un suscriptor");
        }
        suscriptorDAO.insert(suscriptor);
    }

    @Override
    public void update(Suscriptor suscriptor) throws Exception {
        validate(suscriptor);
        Suscriptor oldSuscriptor = suscriptorDAO.findById(suscriptor.getDocumento());
        if(oldSuscriptor == null){
            throw new Exception("No existe el suscriptor");
        }
        //merge
        oldSuscriptor.setDocumento(suscriptor.getDocumento());
        oldSuscriptor.setTipoDocumento(suscriptor.getTipoDocumento());
        oldSuscriptor.setPrimerNombre(suscriptor.getPrimerNombre());
        oldSuscriptor.setSegundoNombre(suscriptor.getSegundoNombre());
        oldSuscriptor.setPrimerApellido(suscriptor.getPrimerApellido());
        oldSuscriptor.setSegundoApellido(suscriptor.getSegundoApellido());
        oldSuscriptor.setTelefono(suscriptor.getTelefono());
        oldSuscriptor.setEmail(suscriptor.getEmail());
        suscriptorDAO.update(suscriptor);
    }

    @Override
    public void delete(Suscriptor suscriptor) throws Exception {
        if(suscriptor.getDocumento() == 0){
            throw new Exception("El documento es obligatorio");
        }
        Suscriptor oldSuscriptor = suscriptorDAO.findById(suscriptor.getDocumento());
        if(oldSuscriptor == null){
            throw new Exception("Ya existe el suscriptor");
        }
        suscriptorDAO.delete(oldSuscriptor);
    }

    @Override
    public Suscriptor findById(Long documento) throws Exception {
        if(documento == 0){
            throw new Exception("El documento es obligatorio");
        }
        return suscriptorDAO.findById(documento);
    }

    @Override
    public List<Suscriptor> findAll() throws Exception {
        return suscriptorDAO.findAll();
    }
}
