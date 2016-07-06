package ro.NRO.StudentsOrganizer.prezentation;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
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

    private ScheduleEvent event1 = new DefaultScheduleEvent();
    private ScheduleModel eventModel;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void saveEvent() {
        eventBoundary.saveEvent(event);
        event = new Event();
        System.out.print("event");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event Saved!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event1 = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event1 = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event1);
        } else {
            eventModel.updateEvent(event1);
        }

        event1 = new DefaultScheduleEvent();
    }

}
