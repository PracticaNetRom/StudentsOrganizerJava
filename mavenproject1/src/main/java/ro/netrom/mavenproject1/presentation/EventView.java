/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.mavenproject1.business.boundary.Events;
import ro.netrom.mavenproject1.business.entity.Event;

/**
 *
 * @author Clau
 */
@Named
@ViewScoped
public class EventView implements Serializable{
    
    @Inject
    private Events eventBoundary;
    
    private Event event;
    
    private List<Event> events;
    
        
    @PostConstruct
    public void init() {
        event = new Event();
        events = eventBoundary.getEvents();
     
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    public String goToPage(){
        return "index.xhtml";
    }
    
     public void save() {
        if (event.getId() == null) {
            eventBoundary.saveEvent(event);
            events.add(event);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Event saved!"));
        } else {
            eventBoundary.editEvent(event);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Event edited!"));
        }
        event = new Event();

    }
    
    public void edit() {

        eventBoundary.editEvent(event);

    }
    
    public void delete() {

        eventBoundary.deleteEvent(event);
        events.remove(event);
        event = new Event();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Event deleted!"));
    }
}
