/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import co.edu.sena.censoweb.business.UsuarioBeanLocal;
import co.edu.sena.censoweb.model.Usuario;
import co.edu.sena.censoweb.utils.MessageUtils;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author Aprendiz
 */
public class LoginView implements Serializable{
    private InputText txtNombre;
    private Password password;
    private Usuario usuarioLogeado;
    
    @EJB
    private UsuarioBeanLocal usuarioBean;
    
    @Inject
    private HttpServletRequest request;
    /**
     * Creates a new instance of UsuarioView
     */
    public LoginView() {
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    public void login()
    
    {
        try {
            usuarioLogeado = new Usuario();
            usuarioLogeado.setNombre(txtNombre.getValue().toString());
            usuarioLogeado.setContrasena(password.getValue().toString());
            
            usuarioBean.login(usuarioLogeado);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                                                    .put("usuarioLogeado", usuarioLogeado);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        
    }
    public void signOut()
    {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            String path = ((ServletContext) context.getContext()).getContextPath();
            context.redirect(path+ "?faces-redirect=true");
        } catch (IOException e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
    
    
    
    }
    public void validateSession()
    {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            usuarioLogeado = (Usuario)context.getSessionMap().get("usuarioLogeado");
            String url = request.getRequestURL().toString();
            String path = ((ServletContext) context.getContext()).getContextPath();
            
            //si la pagina actual es el login 
            if(url.endsWith(path + "/" )|| url.endsWith("/login.xhtml"))
            {
            
            if(usuarioLogeado != null)
            
            {
                context.redirect("index.xhtml");
            
            
            }
            }
            else if (usuarioLogeado==null)
            {
            
                context.redirect(path + "/unauthorized.xhtml");
            }
            
        } catch (IOException e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
    
    
    }
}
