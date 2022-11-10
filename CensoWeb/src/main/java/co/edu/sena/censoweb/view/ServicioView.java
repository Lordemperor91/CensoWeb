/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.ServicioBeanLocal;
import co.edu.sena.censoweb.model.Servicio;
import co.edu.sena.censoweb.utils.MessageUtils;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Aprendiz
 */
public class ServicioView {
    private InputText txtIdServicio;
    private InputText txtSerieMedidor;
    private InputText txtLectura;
    private SelectOneMenu selectAcueducto;
    private SelectOneMenu selectAlcantarillado;
    private SelectOneMenu selectMarcaMedidor;
    private List<Servicio> listServicios = null;
    private CommandButton btnCrear;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    /**
     * Creates a new instance of ServicioView
     */
    @EJB

private ServicioBeanLocal servicioBean;
    
    public ServicioView() {
    }

    public InputText getTxtIdServicio() {
        return txtIdServicio;
    }

    public void setTxtIdServicio(InputText txtIdServicio) {
        this.txtIdServicio = txtIdServicio;
    }

    public InputText getTxtSerieMedidor() {
        return txtSerieMedidor;
    }

    public void setTxtSerieMedidor(InputText txtSerieMedidor) {
        this.txtSerieMedidor = txtSerieMedidor;
    }

    public InputText getTxtLectura() {
        return txtLectura;
    }

    public void setTxtLectura(InputText txtLectura) {
        this.txtLectura = txtLectura;
    }

    public SelectOneMenu getSelectAcueducto() {
        return selectAcueducto;
    }

    public void setSelectAcueducto(SelectOneMenu selectAcueducto) {
        this.selectAcueducto = selectAcueducto;
    }

    public SelectOneMenu getSelectAlcantarillado() {
        return selectAlcantarillado;
    }

    public void setSelectAlcantarillado(SelectOneMenu selectAlcantarillado) {
        this.selectAlcantarillado = selectAlcantarillado;
    }

    public SelectOneMenu getSelectMarcaMedidor() {
        return selectMarcaMedidor;
    }

    public void setSelectMarcaMedidor(SelectOneMenu selectMarcaMedidor) {
        this.selectMarcaMedidor = selectMarcaMedidor;
    }

    
    public List<Servicio> getListServicios() {
        try {
            if(listServicios==null)
            {
            
            listServicios = servicioBean.findAll();
            }
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        return listServicios;
    }

    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
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

   
    public void clear()
    {
    
    txtIdServicio.setValue("");
    txtSerieMedidor.setValue("");
    txtLectura.setValue("");
    selectAcueducto.setValue("");
    selectAlcantarillado.setValue("");
    selectMarcaMedidor.setValue("");
    btnCrear.setDisabled(false);
    btnEliminar.setDisabled(true);
    btnModificar.setDisabled(true);  
    listServicios = null;     
    
    }
    
    public void insert(){
    
        try {
            Servicio servicio = new Servicio();          
            
            servicio.setAcueducto(selectAcueducto.getValue().toString());
            servicio.setAlcantarillado(selectAlcantarillado.getValue().toString());
            servicio.setMarcaMedidor(selectMarcaMedidor.getValue().toString());
            servicio.setLectura(new BigDecimal(txtLectura.getValue().toString()));            
            servicio.setSerieMedidor(txtSerieMedidor.getValue().toString());            
            servicioBean.insert(servicio);
            MessageUtils.addinfoMessage("servicio creado exitoxamente");
             clear();      
            
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
       
    
    
    }
    public void update(){
    
        try {
            Servicio servicio = new Servicio();          
            
            servicio.setAcueducto(selectAcueducto.getValue().toString());
            servicio.setAlcantarillado(selectAlcantarillado.getValue().toString());
            servicio.setMarcaMedidor(selectMarcaMedidor.getValue().toString());
            servicio.setLectura(new BigDecimal(txtLectura.getValue().toString()));            
            servicio.setSerieMedidor(txtSerieMedidor.getValue().toString());            
            servicioBean.update(servicio);
            MessageUtils.addinfoMessage("servicio actualizado exitosamente");
             clear();      
            
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        
    }
       public void delete(){
       
        try {
            Servicio servicio = new Servicio();          
            
            servicio.setIdServicio(Integer.parseInt(txtIdServicio.getValue().toString()));
                  
            servicioBean.delete(servicio);
            MessageUtils.addinfoMessage("servicio eliminado exitosamente");
            clear();      
            
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
       
    
    
    }
      public void rowSelect (SelectEvent event)
      {
        Servicio servicio =(Servicio) event.getObject();
    txtIdServicio.setValue(servicio.getIdServicio());
    txtLectura.setValue(servicio.getLectura());
    txtSerieMedidor.setValue(servicio.getSerieMedidor());    
    
    selectAcueducto.setValue(servicio.getAcueducto());
    selectAlcantarillado.setValue(servicio.getAlcantarillado());
    selectMarcaMedidor.setValue(servicio.getMarcaMedidor());
    listServicios = null; 
    btnCrear.setDisabled(true);
    btnEliminar.setDisabled(false);
    btnModificar.setDisabled(false);
      
      }
    
    }
    

