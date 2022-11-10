/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.EncuestaBeanLocal;
import co.edu.sena.censoweb.business.EncuestadorBeanLocal;
import co.edu.sena.censoweb.business.PredioBeanLocal;
import co.edu.sena.censoweb.business.ServicioBeanLocal;
import co.edu.sena.censoweb.business.SuscriptorBeanLocal;
import co.edu.sena.censoweb.model.Encuesta;
import co.edu.sena.censoweb.model.Encuestador;
import co.edu.sena.censoweb.model.Predio;
import co.edu.sena.censoweb.model.Servicio;
import co.edu.sena.censoweb.model.Suscriptor;
import co.edu.sena.censoweb.utils.MessageUtils;
import java.util.ArrayList;
import java.util.Date;
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
public class EncuestaView {

    private InputText txtNumeroFormulario;
    private Date fecha;
    private SelectOneMenu selectEncuestador;
    private SelectOneMenu selectPredio;
    private SelectOneMenu selectSuscriptor;
    private SelectOneMenu selectServicio;
    private CommandButton btnModificar;
    private CommandButton btnCrear;
    private CommandButton btnEliminar;
    private List<Encuesta> ListEncuesta = null;
    private List<SelectItem> itemsEncuestador;
    private List<SelectItem> itemsPredio;
    private List<SelectItem> itemsSuscriptor;
    private List<SelectItem> itemsServicio;

    @EJB
    private EncuestaBeanLocal encuestaBean;
    @EJB
    private EncuestadorBeanLocal encuestadorBean;
    @EJB
    private PredioBeanLocal predioBean;
    @EJB
    private SuscriptorBeanLocal suscriptorBean;
    @EJB
    private ServicioBeanLocal servicioBean;

    /**
     * Creates a new instance of EncuestaView
     */
    public EncuestaView() {
    }

    public InputText getTxtNumeroFormulario() {
        return txtNumeroFormulario;
    }

    public void setTxtNumeroFormulario(InputText txtNumeroFormulario) {
        this.txtNumeroFormulario = txtNumeroFormulario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public SelectOneMenu getSelectEncuestador() {
        return selectEncuestador;
    }

    public void setSelectEncuestador(SelectOneMenu selectEncuestador) {
        this.selectEncuestador = selectEncuestador;
    }

    public SelectOneMenu getSelectPredio() {
        return selectPredio;
    }

    public void setSelectPredio(SelectOneMenu selectPredio) {
        this.selectPredio = selectPredio;
    }

    public SelectOneMenu getSelectSuscriptor() {
        return selectSuscriptor;
    }

    public void setSelectSuscriptor(SelectOneMenu selectSuscriptor) {
        this.selectSuscriptor = selectSuscriptor;
    }

    public SelectOneMenu getSelectServicio() {
        return selectServicio;
    }

    public void setSelectServicio(SelectOneMenu selectServicio) {
        this.selectServicio = selectServicio;
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

    public List<Encuesta> getListEncuesta() {
        try {

            ListEncuesta = encuestaBean.findAll();

        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        return ListEncuesta;
    }

    public void setListEncuesta(List<Encuesta> ListEncuestas) {
        this.ListEncuesta = ListEncuestas;
    }

    public List<SelectItem> getItemsEncuestador() {
        try {
            List<Encuestador> listEncuestador = encuestadorBean.findAll();
            itemsEncuestador = new ArrayList<>();
            for (Encuestador encuestador : listEncuestador) {
                itemsEncuestador.add(new SelectItem(encuestador.getCedula(), encuestador.getNombre()));
            }

        } catch (Exception e) {

            MessageUtils.addErrorMessage(e.getMessage());
        }
        return itemsEncuestador;
    }

    public void setItemsEncuestador(List<SelectItem> itemsEncuestador) {
        this.itemsEncuestador = itemsEncuestador;
    }

    public List<SelectItem> getItemsPredio() {
        try {
            List<Predio> listPredio = predioBean.findAll();
            itemsPredio = new ArrayList<>();
            for (Predio predio : listPredio) {
                String direccion = predio.getAbreviatura() + "  " + predio.getPrimerNumero()
                        + "  " + predio.getSegundoNumero() + "  " + predio.getTercerNumero();

                itemsPredio.add(
                        new SelectItem(predio.getIdPredio(), direccion));

            }

        } catch (Exception e) {

            MessageUtils.addErrorMessage(e.getMessage());
        }
        return itemsPredio;
    }

    public void setItemsPredio(List<SelectItem> itemsPredio) {
        this.itemsPredio = itemsPredio;
    }

    public List<SelectItem> getItemsSuscriptor() {
        try {
            List<Suscriptor> listSuscriptor = suscriptorBean.findAll();
            itemsSuscriptor = new ArrayList<>();
            for (Suscriptor suscriptor : listSuscriptor) {
                String nombreCompleto = suscriptor.getPrimerNombre() + "  " + suscriptor.getSegundoNombre()
                        + "  " + suscriptor.getPrimerApellido() + "  " + suscriptor.getSegundoApellido();

                itemsSuscriptor.add(
                        new SelectItem(suscriptor.getDocumento(), nombreCompleto));

            }

        } catch (Exception e) {

            MessageUtils.addErrorMessage(e.getMessage());
        }
        return itemsSuscriptor;
    }

    public void setItemsSuscriptor(List<SelectItem> itemsSuscriptor) {
        this.itemsSuscriptor = itemsSuscriptor;
    }

    public List<SelectItem> getItemsServicio() {
        try {
            List<Servicio> listServicio = servicioBean.findAll();
            itemsServicio = new ArrayList<>();
            for (Servicio servicio : listServicio) {

                itemsServicio.add(new SelectItem(servicio.getIdServicio(), servicio.getSerieMedidor()));

            }

        } catch (Exception e) {

            MessageUtils.addErrorMessage(e.getMessage());
        }
        return itemsServicio;
    }

    public void setItemsServicio(List<SelectItem> itemsServicio) {
        this.itemsServicio = itemsServicio;
    }

    public void clear() {
        txtNumeroFormulario.setValue("");
        selectEncuestador.setValue("");
        selectPredio.setValue("");
        selectSuscriptor.setValue("");
        selectServicio.setValue("");
        fecha = null;
        ListEncuesta = null;
        btnCrear.setDisabled(false);
        btnEliminar.setDisabled(true);
        btnModificar.setDisabled(true);

    }

    public void insert() {

        try {
            Encuesta encuesta = new Encuesta();
            encuesta.setFecha(fecha);
            //fk
            Encuestador encuestador = encuestadorBean.findById(Long.parseLong(selectEncuestador.getValue().toString()));
            encuesta.setIdEncuestador(encuestador);

            Predio predio = predioBean.findById(Integer.parseInt(selectPredio.getValue().toString()));
            encuesta.setIdPredio(predio);

            Servicio servicio = servicioBean.findById(Integer.parseInt(selectServicio.getValue().toString()));
            encuesta.setIdServicio(servicio);

            Suscriptor suscriptor = suscriptorBean.findById(Long.parseLong((selectSuscriptor.getValue().toString())));
            encuesta.setIdSuscriptor(suscriptor);

            encuestaBean.insert(encuesta);

            MessageUtils.addinfoMessage("encuesta creada exitosamente");
            clear();

        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }

    }

    public void update() {
        try {
            Encuesta encuesta = new Encuesta();
            encuesta.setNumeroFormulario(Integer.parseInt(txtNumeroFormulario.getValue().toString()));
            encuesta.setFecha(fecha);
            //fk
            Encuestador encuestador = encuestadorBean.findById(Long.parseLong(selectEncuestador.getValue().toString()));
            encuesta.setIdEncuestador(encuestador);

            Predio predio = predioBean.findById(Integer.parseInt(selectPredio.getValue().toString()));
            encuesta.setIdPredio(predio);

            Servicio servicio = servicioBean.findById(Integer.parseInt(selectServicio.getValue().toString()));
            encuesta.setIdServicio(servicio);

            Suscriptor suscriptor = suscriptorBean.findById(Long.parseLong((selectSuscriptor.getValue().toString())));
            encuesta.setIdSuscriptor(suscriptor);

            encuestaBean.update(encuesta);

            MessageUtils.addinfoMessage("encuesta modificada exitosamente");
            clear();

        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }

    }

    public void delete() {

        try {
            Encuesta encuesta = new Encuesta();
            encuesta.setNumeroFormulario(Integer.parseInt(txtNumeroFormulario.getValue().toString()));
            encuesta.setFecha(fecha);

            encuestaBean.delete(encuesta);

            MessageUtils.addinfoMessage("encuesta eliminada exitosamente");
            clear();

        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }

    }

    public void rowSelect(SelectEvent event) {
        Encuesta encuesta = (Encuesta) event.getObject();
        txtNumeroFormulario.setValue(encuesta.getNumeroFormulario());
        selectEncuestador.setValue(encuesta.getIdEncuestador().getCedula());
        selectPredio.setValue(encuesta.getIdPredio().getIdPredio());
        selectSuscriptor.setValue(encuesta.getIdSuscriptor().getDocumento());
        selectServicio.setValue(encuesta.getIdServicio().getIdServicio());
        fecha = encuesta.getFecha();
        ListEncuesta = null;
        btnCrear.setDisabled(true);
        btnEliminar.setDisabled(false);
        btnModificar.setDisabled(false);

    }

}
