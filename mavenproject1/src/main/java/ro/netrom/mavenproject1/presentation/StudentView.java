/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ro.netrom.mavenproject1.business.entity.Event;
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
        student.setLastName("Ica");
        student.setGender(Student.Gender.FEMALE);
        /*Date birthDate = new Date();
        birthDate.setMonth(5);
        birthDate.setYear(1995);
        student.setBirthDate(birthDate);*/
        student.setEmail("alexandra_claudiaica@yahoo.com");
        student.setPhoneNumbers("0748566892");
        student.setFaculty("Autoamtica, Calculatoare si Electronica");
        student.setFacultyStartYear(2014);
        /*Event event = new Event();
        event.setDepartment(Event.Department.JAVA);
        event.setEventType(Event.EventType.PRACTICE);
        Date date = new Date();
        date.setDate(27);
        date.setMonth(6);
        date.setYear(2016);
        event.setStartDate(date);
        date.setDate(17);
        date.setMonth(7);
        date.setYear(2016);
        event.setEndDate(date);
        event.setTask("Make an application");
        date.setDate(27);
        date.setMonth(6);
        date.setYear(2016);
        student.setEvents((List<Event>) event);*/
    }
}
