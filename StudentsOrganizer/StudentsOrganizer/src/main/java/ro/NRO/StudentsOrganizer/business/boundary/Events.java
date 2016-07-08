/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.NRO.StudentsOrganizer.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ro.NRO.StudentsOrganizer.business.entity.Event;

/**
 *
 * @author Balaci
 */
@Stateless
public class Events implements Serializable{
    
    @PersistenceContext(name = "EventsOrganizerPU")
    private EntityManager em;
    
    public void saveEvent(Event event) {

        em.persist(event);
    }
    
     public List<Event> getAll() {
        TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e", Event.class);
        return query.getResultList();
    }
    
}
