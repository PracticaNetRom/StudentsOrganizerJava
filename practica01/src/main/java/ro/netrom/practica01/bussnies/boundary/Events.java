/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica01.bussnies.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ro.netrom.practica01.bussnies.entity.Event;

/**
 *
 * @author practica01
 */
@Stateless
public class Events implements Serializable {
    
    @PersistenceContext (name = "practicapu")
    private EntityManager em;
    
    public void eventSave(Event event) {
        em.persist(event);
    }
    
    public void eventEdit(Event event) {
        em.merge(event);
    }
    
    public void eventDelete(Event event) {
        em.remove(em.merge(event));
    }
    
    public List<Event> getAllEvents() {
        final String query = "SELECT e from Event e";
        TypedQuery<Event> query1 = em.createQuery(query, Event.class);
        final List<Event> events = query1.getResultList();
        return events;
    }
    
}
