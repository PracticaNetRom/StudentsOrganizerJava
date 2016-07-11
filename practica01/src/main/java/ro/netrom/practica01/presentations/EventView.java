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
import javax.servlet.http.HttpServletRequest;
import ro.netrom.practica01.bussnies.boundary.Events;
import ro.netrom.practica01.bussnies.boundary.Students;
import ro.netrom.practica01.bussnies.entity.Event;
import ro.netrom.practica01.bussnies.entity.Student;

/**
 *
 * @author practica01
 */
@Named
@ViewScoped
public class EventView implements Serializable { 

    @Inject
    private Events eventBoundary;
    @Inject
    private Students studentBoundary;
    private Event event;
    private List<Event> allEvents;
    private Student student;

    @PostConstruct
    public void init() {    
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String studentId = req.getParameter("studentId");
        student = studentBoundary.findStudent(studentId);
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
        if (event.getId() == null) {
            eventBoundary.eventSave(event);
            student.getEvent().add(event); 
            studentBoundary.studentEdit(student);
        } else {
            eventBoundary.eventEdit(event);
        }
        event = new Event();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "The event has been add."));
    }

    public void deleteEvent() {
        student.getEvent().remove(event);
        studentBoundary.studentEdit(student);
        eventBoundary.eventDelete(event);
        event = new Event();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "The event has been delete."));
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(List<Event> allEvents) {
        this.allEvents = allEvents;
    }
    
     public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
