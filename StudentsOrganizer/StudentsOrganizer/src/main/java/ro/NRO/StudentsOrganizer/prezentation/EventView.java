package ro.NRO.StudentsOrganizer.prezentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.NRO.StudentsOrganizer.business.boundary.Events;
import ro.NRO.StudentsOrganizer.business.entity.Event;

/**
 *
 * @author Balaci
 */
@Named
@ViewScoped
public class EventView implements Serializable {

    

    private Event event;

    

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
    public void init() {
        event = new Event();
        

    }

    public void saveEvent() {
        eventBoundary.saveEvent(event);
        events.add(event);
        event = new Event();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event Saved!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
