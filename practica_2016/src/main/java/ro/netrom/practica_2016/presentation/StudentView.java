/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
    private List<Student> selectedStudents;

    private Event studentevent;
    private List<Student> students;

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

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
       // studentevent = new Event();
        students = studentBoundary.getStudents();

    }

    public void save() {
        if (student.getId() == null) {
            student.getEvents().add(studentevent);
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
        studentevent = new Event();

    }

    public void update() {
        studentBoundary.updateStudent(student);
    }

    /**
     *
     */
    public void delete() {
        studentBoundary.deleteStudent(student);
        students.remove(student);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Student successfully deleted  "));
    }

}
