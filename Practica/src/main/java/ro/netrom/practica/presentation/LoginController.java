/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.presentation;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import ro.netrom.practica.business.boundary.DataQuery;

/**
 *
 * @author Oana
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    @Inject
    private DataQuery query;

    public String loginControl() {
        if (query.loginControl(username, password)) {
            return "index?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username or Password invalid!!"));
        return null;
    }

    public String logoutControl() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request
                = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            HttpSession session = request.getSession();
            session.invalidate();
            request.logout();
        } catch (ServletException e) {
            Logger.getLogger("LoginController").log(Level.SEVERE, e.getMessage());
            return "/index?faces-redirect=true";
        }
        return "login?faces-redirect=true";
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
