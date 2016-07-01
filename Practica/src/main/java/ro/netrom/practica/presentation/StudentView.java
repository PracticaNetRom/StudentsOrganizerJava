/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ro.netrom.practica.business.entity.Student;

/**
 *
 * @author practice8
 */
@Named
@ViewScoped
public class StudentView implements Serializable
{
    private Student student;
    @PostConstruct
    public void init()
    {
        student = new Student() ;
        student.setFirstName("Oana");
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
            
}
