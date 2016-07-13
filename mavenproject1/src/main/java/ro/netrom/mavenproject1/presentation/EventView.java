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
import javax.servlet.http.HttpServletRequest;
import ro.netrom.mavenproject1.business.boundary.Events;
import ro.netrom.mavenproject1.business.boundary.Students;
import ro.netrom.mavenproject1.business.entity.Event;
import ro.netrom.mavenproject1.business.entity.Student;

/**
 *
 * @author Clau
 */
@Named
@ViewScoped
public class EventView implements Serializable{
    
    @Inject
    private Events eventBoundary;
    
    @Inject
    private Students studentBoundary;
    
    private Event event;
    
    private List<Event> events;
    
    private List<Event> studentEvents;
    
      
    
        
    @PostConstruct
    public void init() {
        event = new Event();
        events = eventBoundary.getEvents();
        
                
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String studentId = req.getParameter("studentId");
        studentEvents = studentBoundary.getEventsByStudentId(Long.valueOf(studentId));      
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

    public List<Event> getStudentEvents() {
        return studentEvents;
    }

    public void setStudentEvents(List<Event> studentEvents) {
        this.studentEvents = studentEvents;
    }
    
    
    
   /*public String goToPage(){
        return "index.xhtml";
    }*/
    
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
