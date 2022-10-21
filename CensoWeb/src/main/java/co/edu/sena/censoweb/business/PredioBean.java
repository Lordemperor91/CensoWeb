/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package co.edu.sena.censoweb.business;

import co.edu.sena.censoweb.model.Predio;
import co.edu.sena.censoweb.persistense.IPredioDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class PredioBean implements PredioBeanLocal {

@EJB
private IPredioDAO predioDAO;
private void validate(Predio predio) throws Exception
{
    if(predio==null)
    {
        throw new Exception("el predio es nulo");
    
    }
     if(predio.getAbreviatura().isEmpty())
     {
        throw new Exception("la abreviatura es obligatoria");
     
     }
     
    if(predio.getPrimerNumero()==0)
     {
        throw new Exception("la primer numero es obligatorio");
     
     }
      if(predio.getSegundoNumero()==0)
     {
        throw new Exception("la segundo numero es obligatorio");
     
     }
    if(predio.getTercerNumero()==0)
     {
        throw new Exception("la tercer numero es obligatorio");
     
     }
    if(predio.getBarrio().isEmpty())
     {
        throw new Exception("el barrio es obligatorio");
     
     }
    //validar las pk
    if(predio.getIdUso()== null)
     {
        throw new Exception("el uso comercial es obligatorio");
     
     }
        

}

    @Override
    public void insert(Predio predio) throws Exception {
        validate(predio);
        //no se valida existencia de predio porque este es aunto incremental
        predioDAO.insert(predio);
    }

    @Override
    public void update(Predio predio) throws Exception {
       validate(predio);
       if(predio.getIdPredio()==0)
       {
         throw new Exception("el id es es obligatorio");      
       
       }
       Predio oldPredio = predioDAO.findById(predio.getIdPredio());
       if(oldPredio==null)
       {
       
       throw new Exception("no existe predio con ese id");
       }
       
       oldPredio.setAbreviatura(predio.getAbreviatura());
       oldPredio.setBarrio(predio.getBarrio());
       oldPredio.setComplemento(predio.getComplemento());
       oldPredio.setIdUso(predio.getIdUso());
       oldPredio.setNumeroOcupantes(predio.getNumeroOcupantes());
       oldPredio.setNumeroPisos(predio.getNumeroPisos());
       oldPredio.setPrimerNumero(predio.getPrimerNumero());
       oldPredio.setSegundoNumero(predio.getSegundoNumero());
       oldPredio.setTercerNumero(predio.getTercerNumero());
       predioDAO.update(oldPredio);
       
       
    }

    @Override
    public void delete(Predio predio) throws Exception {
  
       if(predio.getIdPredio()==0)
       {
         throw new Exception("el id es es obligatorio");      
       
       }
       Predio oldPredio = predioDAO.findById(predio.getIdPredio());
       if(oldPredio==null)
       {
       
       throw new Exception("no existe predio con ese id");
       }
    }

    @Override
    public Predio findById(Integer idPredio) throws Exception {
        if(idPredio==0)
        {
        throw new Exception("el id es obligatorio");
        
        }
        return predioDAO.findById(idPredio);
    }

    @Override
    public List<Predio> findAll() throws Exception {
        return predioDAO.findAll();
    }
}
