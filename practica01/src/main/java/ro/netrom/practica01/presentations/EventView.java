/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica01.presentations;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.practica01.bussnies.boundary.Events;
import ro.netrom.practica01.bussnies.entity.Event;

/**
 *
 * @author practica01
 */
@Named
@ViewScoped
public class EventView implements Serializable {
    
    @Inject
    private Events eventBoundary;
    private Event event;
    private List<Event> allEvents; 

    @PostConstruct
    public void init() {
        event = new Event();
        allEvents = eventBoundary.getAllEvents();
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void saveEvent() {
        if(event.getId() == null) {
        eventBoundary.eventSave(event);
        allEvents.add(event);
        } 
        else {
            eventBoundary.eventEdit(event);
        }
        event = new Event();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  null) ); 
    }
    
     public void deleteEvent() {
        eventBoundary.eventDelete(event);
        allEvents.remove(event);
        event = new Event();   
    }
    public List<Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(List<Event> allEvents) {
        this.allEvents = allEvents;
    }

}
