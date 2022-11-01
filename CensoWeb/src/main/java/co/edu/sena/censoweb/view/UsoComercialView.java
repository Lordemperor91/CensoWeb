/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.UsoComercialBeanLocal;
import co.edu.sena.censoweb.model.UsoComercial;
import co.edu.sena.censoweb.utils.MessageUtils;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Aprendiz
 */
public class UsoComercialView {
    
    private InputText txtId;
    private InputText txtDescripcion;
    private CommandButton btnCrear;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private List<UsoComercial> listUsosComerciales = null;
    @EJB
    private UsoComercialBeanLocal usoComercialBean;

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txId) {
        this.txtId = txId;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public CommandButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(CommandButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }
    
    public void clear(){
    txtId.setValue("");
    txtDescripcion.setValue("");
    btnCrear.setDisabled(false);
    btnEliminar.setDisabled(true);
    btnModificar.setDisabled(true);
    listUsosComerciales = null;
    
    
    }
      public void insert()
      {
          try {
              UsoComercial usoComercial = new UsoComercial();
              usoComercial.setIdUso(Integer.parseInt(txtId.getValue().toString()));
              usoComercial.setDescripcion(txtDescripcion.getValue().toString());
              
              usoComercialBean.insert(usoComercial);
              clear();
              MessageUtils.addinfoMessage("uso comercial creado exitosamente");
          } catch (Exception e) {
              MessageUtils.addErrorMessage(e.getMessage());
          }
      
      
      }
      
      
      public void update()
      {
          try {
              UsoComercial usoComercial = new UsoComercial();
              usoComercial.setIdUso(Integer.parseInt(txtId.getValue().toString()));
              usoComercial.setDescripcion(txtDescripcion.getValue().toString());
              
              usoComercialBean.update(usoComercial);
              clear();
              MessageUtils.addinfoMessage("uso comercial modificado exitosamente");
          } catch (Exception e) {
              MessageUtils.addErrorMessage(e.getMessage());
          }
      
      
      }
      
       public void delete()
      {
          try {
              UsoComercial usoComercial = new UsoComercial();
              usoComercial.setIdUso(Integer.parseInt(txtId.getValue().toString()));
              
              
              usoComercialBean.delete(usoComercial);
              clear();
              MessageUtils.addinfoMessage("uso comercial eliminado exitosamente");
          } catch (Exception e) {
              MessageUtils.addErrorMessage(e.getMessage());
          }
      
      
      }
       public void rowSelect(SelectEvent event)       
       {
        UsoComercial usoComercial = (UsoComercial) event.getObject();
        txtId.setValue(usoComercial.getIdUso());
        txtDescripcion.setValue(usoComercial.getDescripcion());       
        btnCrear.setDisabled(true);
        btnEliminar.setDisabled(false);
        btnModificar.setDisabled(false);
       
       }
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
             MessageUtils.addErrorMessage(e.getMessage());
        }
        return listUsosComerciales;
    }

    public void setListUsosComerciales(List<UsoComercial> listUsosComerciales) {
     
        this.listUsosComerciales = listUsosComerciales;
    }
    
}
