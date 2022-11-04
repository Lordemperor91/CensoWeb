/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Servicio;
import co.edu.sena.censoweb.persistense.IServicioDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class ServicioBean implements ServicioBeanLocal {

    
  @EJB
  private IServicioDAO servicioDAO;
  private void validate(Servicio servicio) throws Exception{
  if(servicio==null)
    {
        throw new Exception("el servicio es nulo");
    
    }
     if(servicio.getAcueducto().isEmpty())
     {
        throw new Exception("el acueducto es obligatorio");
     
     }
     
        if(servicio.getAlcantarillado().isEmpty())
     {
        throw new Exception("el alcatarillado es obligatorio");
     
     }
      if(servicio.getSerieMedidor().isEmpty())
     {
        throw new Exception("la serie medidor es obligatorio");
     
     }
    if(servicio.getMarcaMedidor().isEmpty())
     {
        throw new Exception("el marca medidor es obligatorio");
     
     }
    if(servicio.getLectura()== BigDecimal.ZERO)
     {
        throw new Exception("la lectura es obligatoria");
     
     }
  }

    @Override
    public void insert(Servicio servicio) throws Exception {
         validate(servicio);
        //no se valida existencia de servicio porque este es aunto incremental
        servicioDAO.insert(servicio);
   
    
    }

    @Override
    public void update(Servicio servicio) throws Exception {
      validate(servicio);
       if(servicio.getIdServicio()==0)
       {
         throw new Exception("el numero f es obligatorio");      
       
       }
       Servicio oldServicio = servicioDAO.findById(servicio.getIdServicio());
       if(oldServicio==null)
       {
       
       throw new Exception("no existe servicio con ese id");
       }
       
       oldServicio.setAcueducto(servicio.getAcueducto());
       oldServicio.setAlcantarillado(servicio.getAlcantarillado());       
       oldServicio.setLectura(servicio.getLectura());
       oldServicio.setMarcaMedidor(servicio.getMarcaMedidor());
       oldServicio.setSerieMedidor(servicio.getSerieMedidor());
     
       servicioDAO.update(oldServicio);
    }

    @Override
    public void delete(Servicio servicio) throws Exception {
       if(servicio.getIdServicio()==0)
       {
         throw new Exception("el id servicio es obligatorio");      
       
       }
       Servicio oldServicio = servicioDAO.findById(servicio.getIdServicio());
       if(oldServicio==null)
       {
       
       throw new Exception("no existe servicio con ese id");
       }
       servicioDAO.delete(oldServicio);
    }

    @Override
    public Servicio findById(Integer IdServicio) throws Exception {
           if(IdServicio==0)
        {
        throw new Exception("el numero del formulario es obligatorio");
        
        }
        return servicioDAO.findById(IdServicio);
    }


    @Override
    public List<Servicio> findAll() throws Exception {
        return servicioDAO.findAll();
    }
   
}


