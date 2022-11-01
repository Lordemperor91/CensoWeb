/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.EncuestadorBeanLocal;
import co.edu.sena.censoweb.model.Encuestador;
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
public class EncuestadorView {
    private InputText txtCedula;
    private InputText txtNombre;
    private InputText txtTelefono;
    private CommandButton btnCrear;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private List<Encuestador> listEncuestadores = null;
    
    @EJB
    private EncuestadorBeanLocal encuestadorBean;
    /**
     * Creates a new instance of EncuestadorView
     */
    public EncuestadorView() {
    }

    public InputText getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(InputText txtCedula) {
        this.txtCedula = txtCedula;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
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

    public List<Encuestador> getListEncuestadores() {
        try {
            if(listEncuestadores == null)
                  
            {
                   listEncuestadores = encuestadorBean.findAll();
                    
            }
            
        } catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
        return listEncuestadores;
    }

    public void setListEncuestadores(List<Encuestador> listEncuestadores) {
        this.listEncuestadores = listEncuestadores;
    }
    
    public void clear()
    {
        txtCedula.setValue("");
        txtNombre.setValue("");
        txtTelefono.setValue("");
        btnCrear.setDisabled(false);
        btnEliminar.setDisabled(true);
        btnModificar.setDisabled(true);
        listEncuestadores = null;
    }
    public void insert()
    {
        try {
            Encuestador encuestador = new Encuestador();
            encuestador.setCedula(Long.parseLong(txtCedula.getValue().toString()));
            encuestador.setNombre(txtNombre.getValue().toString());
            encuestador.setTelefono(txtTelefono.getValue().toString());
            encuestadorBean.insert(encuestador);
            clear();
            MessageUtils.addinfoMessage("encuestador creado exitosamente");
        } catch (NumberFormatException e) {
             MessageUtils.addErrorMessage("el id debe ser un numero");
        }
         catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
    }
    public void update()
    {
         try {
            Encuestador encuestador = new Encuestador();
            encuestador.setCedula(Long.parseLong(txtCedula.getValue().toString()));
            encuestador.setNombre(txtNombre.getValue().toString());
            encuestador.setTelefono(txtTelefono.getValue().toString());
            encuestadorBean.update(encuestador);
            clear();
            MessageUtils.addinfoMessage("encuestador modificado exitosamente");
        } catch (NumberFormatException e) {
             MessageUtils.addErrorMessage("el id debe ser un numero");
        }
         catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
    }
    public void delete()
    {
         try {
            Encuestador encuestador = new Encuestador();
            encuestador.setCedula(Long.parseLong(txtCedula.getValue().toString()));
           
            encuestadorBean.delete(encuestador);
            clear();
            MessageUtils.addinfoMessage("encuestador eliminado exitosamente");
        } catch (NumberFormatException e) {
             MessageUtils.addErrorMessage("el id debe ser un numero");
        }
         catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
    }
    public void rowSelect(SelectEvent event)
    {
        Encuestador encuestador = (Encuestador) event.getObject();
        txtCedula.setValue(encuestador.getCedula());
        txtNombre.setValue(encuestador.getNombre());
        txtTelefono.setValue(encuestador.getTelefono());
        btnCrear.setDisabled(true);
        btnEliminar.setDisabled(false);
        btnModificar.setDisabled(false);
        
        
    
        
    }
    
    
}
