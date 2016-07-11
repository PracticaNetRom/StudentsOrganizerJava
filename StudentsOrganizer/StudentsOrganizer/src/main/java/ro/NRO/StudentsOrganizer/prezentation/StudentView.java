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
import ro.NRO.StudentsOrganizer.business.boundary.Students;
import ro.NRO.StudentsOrganizer.business.entity.Event;
import ro.NRO.StudentsOrganizer.business.entity.Student;

/**
 *
 * @author practice6
 */
@Named
@ViewScoped
public class StudentView implements Serializable {

    @Inject
    private Students studentBoundary;

    @Inject
    private Events eventBoundary;

    private Student student;

    private List<Student> students;

    private Event event;

    private List<Event> events;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @PostConstruct
    public void init() {
        student = new Student();
        
        students = studentBoundary.getAll();
        events = eventBoundary.getAll();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void saveStudent() {
        studentBoundary.saveStudent(student);
        students.add(student);
        student = new Student();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Student Saved!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void deleteStudent() {

        studentBoundary.deleteStudent(student);
        students.remove(student);
        student = new Student();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Student Deleted!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addEvent() {

        student.getEventList().add(event);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event Saved!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void onCellEdit(CellEditEvent event) {
        DataTable o = (DataTable) event.getSource();

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        Student editedStudent = (Student) o.getRowData();

        if (newValue != null && !newValue.equals(oldValue)) {
            studentBoundary.editStudent(editedStudent);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
    }

}
