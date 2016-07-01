/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica01.presentations;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ro.netrom.practica01.bussnies.entity.Student;



/**
 *
 * @author practice11
 */
@Named
@ViewScoped
public class Studentview implements Serializable{
    private Student student;
    @PostConstruct
    public void imit() {
       student = new Student();
       student.setFirstName("Dogaru Valentin");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
