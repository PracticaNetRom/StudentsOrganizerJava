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
public class StudentView implements Serializable{
    @Inject
    private Students studentBoundary;
    
    private Student student;
    private Event event;
    
    private List<Student> students;
    
    @PostConstruct
    public void init(){
        student = new Student();
        students = studentBoundary.getStudents();
    }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
    public void  saveStudent(){
        studentBoundary.saveStudent(student);
        students.add(student);
        student = new Student();
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful!") );

    }
    
     public void  editStudent(){
        studentBoundary.editStudent(student);
    }
     
      public void  deleteStudent(){
        studentBoundary.deleteStudent(student);
    }
        
 }
