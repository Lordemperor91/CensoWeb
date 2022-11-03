/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.SuscriptorBeanLocal;
import co.edu.sena.censoweb.model.Suscriptor;
import co.edu.sena.censoweb.utils.MessageUtils;
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
public class SuscriptorView {

    private InputText txtDocument;
    private SelectOneMenu selectTypeDoc;
    private InputText txtFirstName;
    private InputText txtSecondName;
    private InputText txtLastName;
    private InputText txtSecondLastName;
    private InputText txtPhone;
    private InputText txtEmail;
    private CommandButton btnModificar;
    private CommandButton btnCrear;
    private CommandButton btnEliminar;
    private List<Suscriptor> listSuscriptores = null;
    
    /**
     * Creates a new instance of SuscriptorView
     */
    
    @EJB
    private SuscriptorBeanLocal suscriptorBean;
    public SuscriptorView() {
    }

    public InputText getTxtDocument() {
        return txtDocument;
    }

    public void setTxtDocument(InputText txtDocument) {
        this.txtDocument = txtDocument;
    }

    public SelectOneMenu getSelectTypeDoc() {
        return selectTypeDoc;
    }

    public void setSelectTypeDoc(SelectOneMenu selectTypeDoc) {
        this.selectTypeDoc = selectTypeDoc;
    }

    public InputText getTxtFirstName() {
        return txtFirstName;
    }

    public void setTxtFirstName(InputText txtFirstName) {
        this.txtFirstName = txtFirstName;
    }

    public InputText getTxtSecondName() {
        return txtSecondName;
    }

    public void setTxtSecondName(InputText txtSecondName) {
        this.txtSecondName = txtSecondName;
    }

    public InputText getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(InputText txtLastName) {
        this.txtLastName = txtLastName;
    }

    public InputText getTxtSecondLastName() {
        return txtSecondLastName;
    }

    public void setTxtSecondLastName(InputText txtSecondLastName) {
        this.txtSecondLastName = txtSecondLastName;
    }

    public InputText getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(InputText txtPhone) {
        this.txtPhone = txtPhone;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(CommandButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public List<Suscriptor> getListSuscriptores() {
        try {
            if(listSuscriptores == null){
                listSuscriptores = suscriptorBean.findAll();
            }
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        
        return listSuscriptores;
    }

    public void setListSuscriptores(List<Suscriptor> listSuscriptores) {
        this.listSuscriptores = listSuscriptores;
    }
    
     public void clear(){
        txtDocument.setValue("");
        selectTypeDoc.setValue("");
        txtFirstName.setValue("");
        txtSecondName.setValue("");
        txtLastName.setValue("");
        txtSecondLastName.setValue("");
        txtPhone.setValue("");
        txtEmail.setValue("");
        btnCrear.setDisabled(false);
        btnEliminar.setDisabled(true);
        btnModificar.setDisabled(true);
        listSuscriptores = null;
    }
    
    public void insert(){
        try {
            Suscriptor suscriptor = new Suscriptor();
            suscriptor.setDocumento(Long.parseLong(txtDocument.getValue().toString()));
            suscriptor.setTipoDocumento(selectTypeDoc.getValue().toString());
            suscriptor.setPrimerNombre(txtFirstName.getValue().toString());
            suscriptor.setSegundoNombre(txtSecondName.getValue().toString());
            suscriptor.setPrimerApellido(txtLastName.getValue().toString());
            suscriptor.setSegundoApellido(txtSecondLastName.getValue().toString());
            suscriptor.setTelefono(txtPhone.getValue().toString());
            suscriptor.setEmail(txtEmail.getValue().toString());
            suscriptorBean.insert(suscriptor);
            clear();
            MessageUtils.addinfoMessage("Suscriptor creado exitosamente");
        }catch(NumberFormatException e){
            MessageUtils.addErrorMessage("La cédula debe ser un número");
        } 
        catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
    }
    
    public void update(){
        try {
            Suscriptor suscriptor = new Suscriptor();
            suscriptor.setDocumento(Long.parseLong(txtDocument.getValue().toString()));
            suscriptor.setTipoDocumento(selectTypeDoc.getValue().toString());
            suscriptor.setPrimerNombre(txtFirstName.getValue().toString());
            suscriptor.setSegundoNombre(txtSecondName.getValue().toString());
            suscriptor.setPrimerApellido(txtLastName.getValue().toString());
            suscriptor.setSegundoApellido(txtSecondLastName.getValue().toString());
            suscriptor.setTelefono(txtPhone.getValue().toString());
            suscriptor.setEmail(txtEmail.getValue().toString());
            suscriptorBean.update(suscriptor);
            clear();
            MessageUtils.addinfoMessage("Suscriptor modificado exitosamente");
        }catch(NumberFormatException e){
            MessageUtils.addErrorMessage("La cédula debe ser un número");
        }
        catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
    }
    
    public void delete(){
       try {
            Suscriptor suscriptor = new Suscriptor();
            suscriptor.setDocumento(Long.parseLong(txtDocument.getValue().toString()));
            suscriptorBean.delete(suscriptor);
            clear();
            MessageUtils.addinfoMessage("Suscriptor eliminado exitosamente");
        }catch(NumberFormatException e){
            MessageUtils.addErrorMessage("La cédula debe ser un número");
        }
        catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
    }
    
    public void rowSelect (SelectEvent event){
        Suscriptor suscriptor = (Suscriptor) event.getObject();
        txtDocument.setValue(suscriptor.getDocumento());
        selectTypeDoc.setValue(suscriptor.getTipoDocumento());
        txtFirstName.setValue(suscriptor.getPrimerNombre());
        txtSecondName.setValue(suscriptor.getSegundoNombre());
        txtLastName.setValue(suscriptor.getPrimerApellido());
        txtSecondLastName.setValue(suscriptor.getSegundoApellido());
        txtPhone.setValue(suscriptor.getTelefono());
        txtEmail.setValue(suscriptor.getEmail());
        btnCrear.setDisabled(true);
        btnEliminar.setDisabled(false);
        btnModificar.setDisabled(false);
    }
    
}
