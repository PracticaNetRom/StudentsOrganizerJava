/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.practica_2016.business.boundary.Events;
import ro.netrom.practica_2016.business.entity.Event;

/**
 *
 * @author Andreea Mateiasi
 */
@Named
@ViewScoped
public class EventView implements Serializable {

    @Inject
    private Events eventBoundary;

    private Event event;
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @PostConstruct
    public void initInstances() {
        event = new Event();
        events = eventBoundary.getEvents();

    }

    public void saveEv() {
        if (event.getId() == null) {
            eventBoundary.saveEvent(event);
            events.add(event);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Event successfully added  "));
        } else {
            eventBoundary.updateEvent(event);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Event successfully edited  "));
        }
        event = new Event();

    }

    public void updateEv() {
        eventBoundary.updateEvent(event);
    }

    /**
     *
     */
    public void deleteEv() {
        eventBoundary.deleteEvent(event);
        events.remove(event);
        event = new Event();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Event successfully deleted  "));
    }
}
