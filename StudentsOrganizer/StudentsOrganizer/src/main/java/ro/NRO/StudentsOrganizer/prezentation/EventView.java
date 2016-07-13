/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.NRO.StudentsOrganizer.prezentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import ro.NRO.StudentsOrganizer.business.boundary.Events;
import ro.NRO.StudentsOrganizer.business.entity.Event;

/**
 *
 * @author Balaci
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


    @PostConstruct
    public void init() {
        event = new Event();
        events = eventBoundary.getAll();
    }

    
    public void saveEvent() {

        eventBoundary.saveEvent(event);
        events.add(event);
        event = new Event();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event Saved!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onCellEdit(CellEditEvent event) {
        DataTable o = (DataTable) event.getSource();

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        Event editedEvent = (Event) o.getRowData();

        if (newValue != null && !newValue.equals(oldValue)) {
            eventBoundary.editEvent(editedEvent);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
    }
    
    public void deleteEvent() {

        eventBoundary.deleteEvent(event);
        events.remove(event);
        event = new Event();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event Deleted!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
