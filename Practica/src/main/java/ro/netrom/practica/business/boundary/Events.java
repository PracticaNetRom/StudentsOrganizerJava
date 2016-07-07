/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.practica.business.entity.Event;

/**
 *
 * @author Oana
 */
@Stateless
public class Events implements Serializable {

    @PersistenceContext(name = "practicaPU")
    private EntityManager em;

    public void saveEvent(Event event) {
        em.persist(event);
    }

    public void deleteEvent(Event event) {
        em.remove(em.merge(event));

    }

    public void editEvent(Event event) {
        em.merge(event);

    }

    public List<Event> getEventsList() {
        List<Event> rezulte = em
                .createQuery("Select a from Event a", Event.class)
                .getResultList();
        return rezulte;
    }
}
