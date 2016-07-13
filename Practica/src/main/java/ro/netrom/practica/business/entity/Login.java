/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oana
 */
@Entity
//@Table(name = "login")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Login.control", query = "SELECT l FROM Login l WHERE l.username = :username and l.password = :password"),
//    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
//    @NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.id = :id"),
//    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l WHERE l.username = :username"),
//    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l WHERE l.password = :password")})
public class Login implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max =50)
    private String username;
    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
