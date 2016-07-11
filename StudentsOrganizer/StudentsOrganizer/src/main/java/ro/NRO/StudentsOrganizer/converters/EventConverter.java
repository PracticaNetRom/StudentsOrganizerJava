/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.NRO.StudentsOrganizer.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import ro.NRO.StudentsOrganizer.business.boundary.Events;
import ro.NRO.StudentsOrganizer.business.entity.Event;

/**
 *
 * @author practice6
 */
@FacesConverter("eventConverter")
public class EventConverter implements Converter {

    @Inject
    private Events eventBoundary;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Event event = eventBoundary.findEventById(Long.valueOf(value));

        return event;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        Event event = (Event) value;

        return event.getId().toString();

    }

}
