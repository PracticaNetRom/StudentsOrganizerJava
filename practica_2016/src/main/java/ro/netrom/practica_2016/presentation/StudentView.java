/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ro.netrom.practica_2016.business.entity.Student;



@Named
@ViewScoped
public class StudentView implements Serializable{
    // form to add a student (formular)
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
        student.setFirstName("Andreea"); 
    }
}
