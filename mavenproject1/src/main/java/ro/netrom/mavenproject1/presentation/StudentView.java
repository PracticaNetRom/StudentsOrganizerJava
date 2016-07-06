/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.mavenproject1.business.boundary.Students;
import ro.netrom.mavenproject1.business.entity.Event;
import ro.netrom.mavenproject1.business.entity.Student;

/**
 *
 * @author practice7
 */
@Named
@ViewScoped
public class StudentView implements Serializable {

    @Inject
    private Students studentBoundary;

    private Student selectedStudent;
    private Event event;

    private List<Student> students;

    @PostConstruct
    public void init() {
        selectedStudent = new Student();
        students = studentBoundary.getStudents();
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void save() {
        if (selectedStudent.getId() == null) {
            studentBoundary.saveStudent(selectedStudent);
            students.add(selectedStudent);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Student saved!"));
        } else {
            studentBoundary.editStudent(selectedStudent);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Student edited!"));
        }
        selectedStudent = new Student();

    }

    public void edit() {

        studentBoundary.editStudent(selectedStudent);

    }

    public void delete() {
        
        
        studentBoundary.deleteStudent(selectedStudent);
        students.remove(selectedStudent);
        selectedStudent = new Student();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Student deleted!"));
    }

}
