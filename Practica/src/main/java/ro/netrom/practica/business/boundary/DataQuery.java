/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.boundary;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import ro.netrom.practica.business.entity.Login;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oana
 */
@Stateless
public class DataQuery {

    @PersistenceContext(name = "practicaPU")
    EntityManager em;

    public boolean loginControl(String username, String password) {
        try {
            Login l = em
                    .createQuery("SELECT l FROM Login l WHERE l.username = :username and l.password = :password", Login.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            Logger.getLogger("DataQuery").log(Level.SEVERE, e.getMessage());
            return false;
        }
    }
}
