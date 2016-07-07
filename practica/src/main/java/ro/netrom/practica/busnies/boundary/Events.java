/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.busnies.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.practica.busnies.entity.Event;

/**
 *
 * @author practice10
 */
@Stateless
public class Events implements Serializable {

    @PersistenceContext(name = "practicaPU")
    private EntityManager em;

    public void eventSave(Events event) {
        em.persist(event);
    }

    public void eventEdit(Event event) {
        em.merge(event);
           }

    public void eventDelete(Event event) {
        em.remove(em.merge(event));
    }

    public List<Event> getAll() {
        List<Event> results = em
                .createQuery("Select a from Event a", Event.class)
                .getResultList();
        return results;
    }


    public void eventSave(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
