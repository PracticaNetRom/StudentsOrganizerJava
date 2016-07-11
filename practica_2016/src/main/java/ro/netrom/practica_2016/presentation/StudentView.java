/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.practica_2016.business.boundary.Events;
import ro.netrom.practica_2016.business.boundary.Students;
import ro.netrom.practica_2016.business.entity.Event;
import ro.netrom.practica_2016.business.entity.Student;

@Named
@ViewScoped
@ManagedBean
public class StudentView implements Serializable {

    @Inject
    private Students studentBoundary;
    
    @Inject
    private Events eventBoundary;
    
    private Student student;

    private List<Student> students;
    
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @PostConstruct
    public void init() {
        student = new Student();
        students = studentBoundary.getStudents();
        events = eventBoundary.getEvents();

    }

    public void save() {
        if (student.getId() == null) {
            //student.getEvents().add(studentevent);
            studentBoundary.saveStudent(student);
            students.add(student);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Student successfully added  "));

        } else {
            studentBoundary.updateStudent(student);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Student successfully edited  "));
        }
        student = new Student();
    }

    public void update() {
        studentBoundary.updateStudent(student);
        //student = new Student();
    }

    /**
     *
     */
    public void delete() {
        studentBoundary.deleteStudent(student);
        students.remove(student);
        student = new Student();
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Student successfully deleted  "));
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
