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
import ro.NRO.StudentsOrganizer.business.boundary.Students;
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
    
    private List<Student> filteredCars;

    public List<Student> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Student> filteredCars) {
        this.filteredCars = filteredCars;
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
        
    }

    public void saveStudent() {
        studentBoundary.saveStudent(student);
        students.add(student);
        student = new Student();
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Student Saved!!!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    


    
   
}
