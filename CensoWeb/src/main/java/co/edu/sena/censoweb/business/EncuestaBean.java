/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Encuesta;
import co.edu.sena.censoweb.persistense.IEncuestaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class EncuestaBean implements EncuestaBeanLocal {

  @EJB
  private IEncuestaDAO encuestaDAO;
  private void validate(Encuesta encuesta) throws Exception{
  if(encuesta==null)
    {
        throw new Exception("el encuesta es nulo");
    
    }
     if(encuesta.getIdEncuestador()==null)
     {
        throw new Exception("el id encuestador es obligatorio");
     
     }
     
        if(encuesta.getIdPredio()== null)
     {
        throw new Exception("el id predio es obligatorio");
     
     }
      if(encuesta.getIdServicio()== null)
     {
        throw new Exception("el id servicio es obligatorio");
     
     }
    if(encuesta.getIdSuscriptor()== null)
     {
        throw new Exception("el id suscriptor es obligatorio");
     
     }
  }

    @Override
    public void insert(Encuesta encuesta) throws Exception {
         validate(encuesta);
        //no se valida existencia de encuesta porque este es aunto incremental
        encuestaDAO.insert(encuesta);
   
    
    }

    @Override
    public void update(Encuesta encuesta) throws Exception {
      validate(encuesta);
       if(encuesta.getNumeroFormulario()==0)
       {
         throw new Exception("el numero f es obligatorio");      
       
       }
       Encuesta oldEncuesta = encuestaDAO.findById(encuesta.getNumeroFormulario());
       if(oldEncuesta==null)
       {
       
       throw new Exception("no existe encuesta con ese id");
       }
       
       oldEncuesta.setFecha(encuesta.getFecha());
       oldEncuesta.setIdEncuestador(encuesta.getIdEncuestador());
       oldEncuesta.setIdPredio(encuesta.getIdPredio());
       oldEncuesta.setIdServicio(encuesta.getIdServicio());
       oldEncuesta.setIdSuscriptor(encuesta.getIdSuscriptor());
     
       encuestaDAO.update(oldEncuesta);
    }

    @Override
    public void delete(Encuesta encuesta) throws Exception {
       if(encuesta.getNumeroFormulario()==0)
       {
         throw new Exception("el numero f es obligatorio");      
       
       }
       Encuesta oldEncuesta = encuestaDAO.findById(encuesta.getNumeroFormulario());
       if(oldEncuesta==null)
       {
       
       throw new Exception("no existe encuesta con ese id");
       }
    }

    @Override
    public Encuesta findById(Integer numeroFormulario) throws Exception {
           if(numeroFormulario==0)
        {
        throw new Exception("el numero del formulario es obligatorio");
        
        }
        return encuestaDAO.findById(numeroFormulario);
    }


    @Override
    public List<Encuesta> findAll() throws Exception {
        return encuestaDAO.findAll();
    }
   
}
