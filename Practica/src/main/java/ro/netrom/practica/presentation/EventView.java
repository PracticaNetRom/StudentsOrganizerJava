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
import javax.servlet.http.HttpServletRequest;
import ro.netrom.practica.business.boundary.Events;
import ro.netrom.practica.business.boundary.Students;
import ro.netrom.practica.business.entity.Event;
import ro.netrom.practica.business.entity.Student;

/**
 *
 * @author Oana
 */
@Named
@ViewScoped
public class EventView implements Serializable {
    
    @Inject
    private Events events;
    @Inject
    private Students students;
    private Event event;
    private List<Event> eventsList;
    private Student student;
    
    @PostConstruct
    public void initEvent() {
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String studentId = req.getParameter("studentId");
        student = students.findStudent(studentId);
        event = new Event();
        eventsList = events.getEventsList();
    }
    
    public void saveEvent() {
        
        if (event.getId() == null) {            
            events.saveEvent(event);
            student.getEvents().add(event);
            students.editStudent(student);
            
        } else {
            events.editEvent(event);
        }
        event = new Event();
        addMessageToEvent("Successful!", "The event has been add.");
    }
    
    public void deleteEvent() {
        student.getEvents().remove(event);
        students.editStudent(student);
        events.deleteEvent(event);
        event = new Event();
        addMessageToEvent("Successful!", "The event has been delete.");
    }
    
    public void addMessageToEvent(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
}
