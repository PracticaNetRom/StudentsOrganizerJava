/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.business.entity;

import java.io.Serializable;

/**
 *
 * @author practice9
 */
public class Register implements  Serializable{
    
    private String user;
    private String firstName;
    private String lastName;
    private String password1;
    private String password2;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    
}
