/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import ro.netrom.practica_2016.business.boundary.Students;
import ro.netrom.practica_2016.business.entity.Event;
import ro.netrom.practica_2016.business.entity.Student;

@Named
@ViewScoped
public class StudentView implements Serializable {

    // form to add a student (formular)
    @Inject
    private Students studentBoundary;
    private Student student;

    private Event studentevent;
    private List<Student> students;

        
    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Event getStudentevent() {
        return studentevent;
    }

    public void setStudentevent(Event studentevent) {
        this.studentevent = studentevent;
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
        studentevent = new Event();
        students = studentBoundary.getStudents();

    }

    public void save() {
        student.getEvents().add(studentevent);
        studentBoundary.saveStudent(student);
        students.add(student);
        student = new Student();
        studentevent = new Event();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Student successfully added  "));
    }

    public void update() {
        studentBoundary.updateStudent(student);
    }

    public void delete(Student student) {
        studentBoundary.deleteStudent(student);
       
        
    }

}
