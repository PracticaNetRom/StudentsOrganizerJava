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
import org.primefaces.event.CellEditEvent;
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

    private Student student;

    private List<Student> students;
    
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
        event = new Event();
        students = studentBoundary.getAll();

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

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Student Deleted!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addEvent(Event event){
        
        student.getEventList().add(event);
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event Saved!!!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }

     public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

     
}
