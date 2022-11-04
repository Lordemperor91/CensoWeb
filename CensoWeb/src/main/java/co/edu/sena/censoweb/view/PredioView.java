/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.PredioBeanLocal;
import co.edu.sena.censoweb.business.UsoComercialBeanLocal;
import co.edu.sena.censoweb.model.Predio;
import co.edu.sena.censoweb.model.UsoComercial;
import co.edu.sena.censoweb.utils.MessageUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Aprendiz
 */
public class PredioView {   
private InputText txtId;
private InputText txtPrimerNumero;
private InputText txtSegundoNumero;
private InputText txtTercerNumero;
private InputText txtComplemento;
private InputText txtNumerodePisos;
private InputText txtNumeroOcupantes;
private SelectOneMenu selectBarrio;
private SelectOneMenu selectAbreviatura;
private SelectOneMenu selectUsoComercial;
private List<Predio> listPredios = null;
private List<SelectItem> itemsUsoComecial;
private CommandButton btnCrear;
private CommandButton btnModificar;
private CommandButton btnEliminar;

@EJB

private PredioBeanLocal predioBean;
@EJB

private UsoComercialBeanLocal usoComercialBean;





    /**
     * Creates a new instance of PredioView
     */
    public PredioView() {
    }

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
    }

    public InputText getTxtPrimerNumero() {
        return txtPrimerNumero;
    }

    public void setTxtPrimerNumero(InputText txtPrimerNumero) {
        this.txtPrimerNumero = txtPrimerNumero;
    }

    public InputText getTxtSegundoNumero() {
        return txtSegundoNumero;
    }

    public void setTxtSegundoNumero(InputText txtSegundoNumero) {
        this.txtSegundoNumero = txtSegundoNumero;
    }

    public InputText getTxtTercerNumero() {
        return txtTercerNumero;
    }

    public void setTxtTercerNumero(InputText txtTercerNumero) {
        this.txtTercerNumero = txtTercerNumero;
    }

    public InputText getTxtComplemento() {
        return txtComplemento;
    }

    public void setTxtComplemento(InputText txtComplemento) {
        this.txtComplemento = txtComplemento;
    }

    public InputText getTxtNumerodePisos() {
        return txtNumerodePisos;
    }

    public void setTxtNumerodePisos(InputText txtNumerodePisos) {
        this.txtNumerodePisos = txtNumerodePisos;
    }

    public InputText getTxtNumeroOcupantes() {
        return txtNumeroOcupantes;
    }

    public void setTxtNumeroOcupantes(InputText txtNumeroOcupantes) {
        this.txtNumeroOcupantes = txtNumeroOcupantes;
    }

    public SelectOneMenu getSelectBarrio() {
        return selectBarrio;
    }

    public void setSelectBarrio(SelectOneMenu selectBarrio) {
        this.selectBarrio = selectBarrio;
    }

    public SelectOneMenu getSelectAbreviatura() {
        return selectAbreviatura;
    }

    public void setSelectAbreviatura(SelectOneMenu selectAbreviatura) {
        this.selectAbreviatura = selectAbreviatura;
    }

    public SelectOneMenu getSelectUsoComercial() {
        return selectUsoComercial;
    }

    public void setSelectUsoComercial(SelectOneMenu selectUsoComercial) {
        this.selectUsoComercial = selectUsoComercial;
    }

    public List<Predio> getListPredios() {
        
        
        try {
            if (listPredios == null) {
                
                listPredios = predioBean.findAll();
                
            }
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        return listPredios;
    }

    public void setListPredios(List<Predio> listPredios) {
        this.listPredios = listPredios;
    }

    public List<SelectItem> getItemsUsoComecial() {
        
        try {
            List<UsoComercial> listUsoComercial = usoComercialBean.findAll();
            itemsUsoComecial = new ArrayList<>();
            for (UsoComercial usoComercial : listUsoComercial) {
                itemsUsoComecial.add(
                        new SelectItem(usoComercial.getIdUso(), usoComercial.getDescripcion()));
                
            }
            
        } catch (Exception e) {
            
            MessageUtils.addErrorMessage(e.getMessage());
        }
        return itemsUsoComecial;
    }

    public void setItemsUsoComecial(List<SelectItem> itemsUsoComecial) {
        this.itemsUsoComecial = itemsUsoComecial;
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
    txtId.setValue("");
    txtComplemento.setValue("");
    txtNumeroOcupantes.setValue("");
    txtNumerodePisos.setValue("");
    txtPrimerNumero.setValue("");
    txtSegundoNumero.setValue("");
    txtTercerNumero.setValue("");
    selectAbreviatura.setValue("");
    selectBarrio.setValue("");
    selectUsoComercial.setValue("");
    listPredios = null; 
    btnCrear.setDisabled(false);
    btnEliminar.setDisabled(true);
    btnModificar.setDisabled(true);
    
    }
    
    public void insert(){
        try {
            Predio predio = new Predio();
            predio.setAbreviatura(selectAbreviatura.getValue().toString());
            predio.setBarrio(selectBarrio.getValue().toString());
            predio.setComplemento(txtComplemento.getValue().toString());
            predio.setNumeroPisos(Integer.parseInt(txtNumerodePisos.getValue().toString()));
            predio.setPrimerNumero(Integer.parseInt(txtPrimerNumero.getValue().toString()));
            predio.setSegundoNumero(Integer.parseInt(txtSegundoNumero.getValue().toString()));
            predio.setTercerNumero(Integer.parseInt(txtTercerNumero.getValue().toString()));
            // fk uso  comercial
            UsoComercial usoComercial = usoComercialBean.findById(Integer.parseInt(selectUsoComercial.getValue().toString()));
            predio.setIdUso(usoComercial);
            predioBean.insert(predio);
            MessageUtils.addErrorMessage("predio creado exitoxamente");
            clear();
        } catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
    
    
    }
     public void update(){
        try {
            Predio predio = new Predio();
            predio.setIdPredio(Integer.parseInt(txtId.getValue().toString()));
            predio.setAbreviatura(selectAbreviatura.getValue().toString());
            predio.setBarrio(selectBarrio.getValue().toString());
            predio.setComplemento(txtComplemento.getValue().toString());
            predio.setNumeroPisos(Integer.parseInt(txtNumerodePisos.getValue().toString()));
            predio.setPrimerNumero(Integer.parseInt(txtPrimerNumero.getValue().toString()));
            predio.setSegundoNumero(Integer.parseInt(txtSegundoNumero.getValue().toString()));
            predio.setTercerNumero(Integer.parseInt(txtTercerNumero.getValue().toString()));
            // fk uso  comercial
            UsoComercial usoComercial = usoComercialBean.findById(Integer.parseInt(selectUsoComercial.getValue().toString()));
            predio.setIdUso(usoComercial);
            predioBean.update(predio);
            MessageUtils.addErrorMessage("predio actualizado exitoxamente");
            clear();
        } catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
    
    
    }
        public void delete(){
        try {
            Predio predio = new Predio();
            predio.setIdPredio(Integer.parseInt(txtId.getValue().toString()));
            
            predioBean.delete(predio);
            MessageUtils.addErrorMessage("predio eliminado exitoxamente");
            clear();
        } catch (Exception e) {
             MessageUtils.addErrorMessage(e.getMessage());
        }
    
    
        }
      public void rowSelect (SelectEvent event)
      {
        Predio predio =(Predio) event.getObject();
    txtId.setValue(predio.getIdPredio());
    txtComplemento.setValue(predio.getComplemento());
    txtNumeroOcupantes.setValue(predio.getNumeroOcupantes());
    txtNumerodePisos.setValue(predio.getNumeroPisos());
    txtPrimerNumero.setValue(predio.getPrimerNumero());
    txtSegundoNumero.setValue(predio.getSegundoNumero());
    txtTercerNumero.setValue(predio.getTercerNumero());
    selectAbreviatura.setValue(predio.getAbreviatura());
    selectBarrio.setValue(predio.getBarrio());
    selectUsoComercial.setValue(predio.getIdUso().getIdUso());
    listPredios = null; 
    btnCrear.setDisabled(false);
    btnEliminar.setDisabled(true);
    btnModificar.setDisabled(true);
      
      }
}
