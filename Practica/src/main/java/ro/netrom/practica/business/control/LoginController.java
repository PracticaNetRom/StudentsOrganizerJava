/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.control;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import ro.netrom.practica.business.boundary.DataQuery;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
//@ManagedBean(name = "login")
//@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private final DataQuery query = new DataQuery();
    
    public String loginControl() {
        if(query.loginControl()){    //if(query.loginControl(userName, password))
            return "index?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username or Password invalid!!"));
        return " ";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
