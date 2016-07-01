/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ro.netrom.mavenproject1.business.entity.Student;

/**
 *
 * @author practice7
 */

@Named
@ViewScoped
public class StudentView implements Serializable{
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    @PostConstruct
    public void init(){
        student = new Student();
        student.setFirstName("Alexandra");
    }
}
