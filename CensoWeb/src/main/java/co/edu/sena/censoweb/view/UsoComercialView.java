/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.UsoComercialBeanLocal;
import co.edu.sena.censoweb.model.UsoComercial;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aprendiz
 */
public class UsoComercialView {
    private List<UsoComercial> listUsosComerciales = null;
    @EJB
    private UsoComercialBeanLocal usoComercialBean;
    
    
    /**
     * 
     * Creates a new instance of UsoComercialView
     */
    public UsoComercialView() {
    }

    public List<UsoComercial> getListUsosComerciales() {
           try {
            if(listUsosComerciales==null)
            {
                listUsosComerciales = usoComercialBean.findAll();
            
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return listUsosComerciales;
    }

    public void setListUsosComerciales(List<UsoComercial> listUsosComerciales) {
     
        this.listUsosComerciales = listUsosComerciales;
    }
    
}
