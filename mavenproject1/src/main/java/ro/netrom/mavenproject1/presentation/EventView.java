/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.presentation;

import java.util.List;
import javax.annotation.PostConstruct;
import ro.netrom.mavenproject1.business.entity.Event;

/**
 *
 * @author Clau
 */
public class EventView {
    private Event event;
    private List<Event> events;
    
    @PostConstruct
    public void init() {
        event = new Event();
        //events = eventBoundary.getEvents();
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
    
    
}
