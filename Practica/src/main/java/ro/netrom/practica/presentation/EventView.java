/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.practica.business.boundary.Events;
import ro.netrom.practica.business.entity.Event;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
public class EventView implements Serializable {
    
    @Inject
    private Events events;
    private Event event;
    private List<Event> eventsList;
    
    @PostConstruct
    public void initEvent() {
        event = new Event();
        eventsList = events.getEventsList();
    }
    
    public void saveEvent() {
        
        if (event.getId() == null) {            
            events.saveEvent(event);
            eventsList.add(event);
            
        } else {
            events.editEvent(event);
        }
        event = new Event();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful!", null));
    }
    
    public void deleteEvent() {
        events.deleteEvent(event);
        eventsList.remove(event);
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    public Events getEvents() {
        return events;
    }
    
    public void setEvents(Events events) {
        this.events = events;
    }
    
    public List<Event> getEventsList() {
        return eventsList;
    }
    
    public void setEventsList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }
}
