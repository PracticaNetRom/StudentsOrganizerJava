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
import ro.netrom.practica.business.boundary.Students;
import ro.netrom.practica.business.entity.Student;

/**
 *
 * @author practice8
 */
@Named
@ViewScoped
public class StudentView implements Serializable {

    @Inject
    private Students students;
    private Student student;
    private List<Student> studentsList;

    @PostConstruct
    public void init() {
        student = new Student();
        studentsList = students.getStudentsList();
    }

    public void saveStudent() {
        students.saveStudent(student);
        student = new Student();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Integer> getYears() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2000; i <= 2020; i++) {
            list.add(i);
        }
        return list;
    }

}
