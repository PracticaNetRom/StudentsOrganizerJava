/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.boundary;

import java.util.List;
import javax.ejb.Stateless;
import ro.netrom.practica.business.entity.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oana
 */


@Stateless
public class DataQuery {

    @PersistenceContext(name = "practicaPU")
    EntityManager em;

    public boolean loginControl() {
        try {
            List<Login> l = em
                    .createQuery("Select a from Login a", Login.class)
                    .getResultList();
            if (l != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
//    EntityManagerFactory emf;
//    EntityManager em;
//
//    public DataQuery() {
//        emf = Persistence.createEntityManagerFactory("PracticaPU");
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//    }
//    
//    public boolean loginControl(String username, String password){
//        try{
//            List<Login> l = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getResultList();
//            if(l != null){
//                return true;
//            }
//            return false;
//        }catch(Exception e){
//            return false;
//        }
//    }
}
