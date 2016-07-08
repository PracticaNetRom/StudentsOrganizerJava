/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.practica_2016.business.entity.Event;

/**
 *
 * @author Andreea Mateiasi
 */
@Stateless

public class Events implements Serializable {

    @PersistenceContext(name = "practica_2016PU")
    private EntityManager emEv;

    public List<Event> getEvents() {
        List<Event> listOfEvents = emEv
                .createQuery("Select s from Event s", Event.class)
                .getResultList();
        return listOfEvents;
    }

    public void saveEvent(Event event) {
        emEv.persist(event);

    }

    public void updateEvent(Event event) {
        emEv.merge(event);

    }

    public void deleteEvent(Event event) {
        emEv.remove(emEv.merge(event));

    }

}
