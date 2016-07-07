/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.practica.busnies.boundary.Events;
import ro.netrom.practica.busnies.entity.Event;

/**
 *
 * @author practice10
 */
@Named
@ViewScoped
public class Eventview implements Serializable {

    @Inject
    private Events events;
    private Event event;
    private List<Event> allEvents;

    @PostConstruct
    public void init() {
        event = new Event();
        allEvents = events.getAll();
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Integer> getYears() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 2010; i < 2030; i++) {
            lista.add(i);
        }
        return lista;
    }

    public void saveEvent() {
        if (event.getId() == null) {
            events.eventSave(event);
            allEvents.add(event);
            
        }
               else{
                 events.eventEdit(event);
                }
         event = new Event();
    }



    public void deleteEvent() {
        
        events.eventDelete(event);
        allEvents.remove(event);
        event = new Event();
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(List<Event> allEvents) {
        this.allEvents = allEvents;
    }
public class GrowlView {
     
    private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    
}
}
