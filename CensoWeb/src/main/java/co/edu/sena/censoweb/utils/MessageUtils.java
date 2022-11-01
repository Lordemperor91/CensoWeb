/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.censoweb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aprendiz
 */
public class MessageUtils {
   public static void addErrorMessage(String message)
   {
       FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
   } 
    public static void addWarningMessage(String message)
   {
   FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_WARN, "advertencia", message));
   } 
   public static void addinfoMessage(String message)
   {
   FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_INFO, "mensaje", message));
   } 
}
