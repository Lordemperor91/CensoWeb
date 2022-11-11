/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.edu.sena.censoweb.view;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/**
 *
 * @author Aprendiz
 */
public class ErrorView implements Serializable{

    /**
     * Creates a new instance of ErrorView
     */
    public ErrorView() {
    }
    
    public String printStackTrace (Throwable exception)
    {
        StringWriter strinWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(strinWriter, true));
        return strinWriter.toString();
    }
    
}
