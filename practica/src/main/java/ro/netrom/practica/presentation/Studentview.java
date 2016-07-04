/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ro.netrom.practica.busnies.boundary.Students;
import ro.netrom.practica.busnies.entity.Student;

/**
 *
 * @author practice10
 */
@Named
@ViewScoped
public class Studentview implements Serializable {
    @Inject
    private Students students;
    private Student student;
    private List <Student> allstudents;

    @PostConstruct
    public void init() {
        student = new Student();
allstudents=students.getAll();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Integer> getYears() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 2010; i < 2030; i++) {
            lista.add(i);
        }
        return lista;
    }

    public void saveStudent() {
        students.studentSave(student);
        student = new Student();
    }

    public List<Student> getAllstudents() {
        return allstudents;
    }

    public void setAllstudents(List<Student> allstudents) {
        this.allstudents = allstudents;
    }

}
