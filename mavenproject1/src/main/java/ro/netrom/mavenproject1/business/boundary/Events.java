/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.mavenproject1.business.entity.Event;

/**
 *
 * @author practice7
 */
@Stateless

public class Events implements Serializable {
    
    @PersistenceContext(name = "practicaPu")
    private EntityManager em;
    
    public void saveEvent(Event event) {
        em.persist(event);
    }
    
    public void editEvent(Event event) {
        em.merge(event);
    }
    
    public void deleteEvent(Event event) {
        Event aux = em.find(Event.class, event.getId());
        if (aux != null) {
            em.remove(aux);
        }
    }
    
    public List<Event> getEvents() {
        List<Event> eventsList = em.createQuery("Select e from Event e", Event.class).getResultList();
        return eventsList;
    }
    
    public Event findById(Long id) {
        return em.find(Event.class, id);
    }
}
