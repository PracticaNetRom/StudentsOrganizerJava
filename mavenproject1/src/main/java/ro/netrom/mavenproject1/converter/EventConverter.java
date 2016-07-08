/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import ro.netrom.mavenproject1.business.boundary.Events;
import ro.netrom.mavenproject1.business.entity.Event;

/**
 *
 * @author practice7
 */
@FacesConverter("eventConverter")
public class EventConverter implements Converter {

    @Inject
    private Events eventBoundary;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return eventBoundary.findById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Event event = (Event) value;
        return event.getId().toString();
    }

}
