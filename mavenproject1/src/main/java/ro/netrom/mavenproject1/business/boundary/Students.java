/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.business.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.mavenproject1.business.entity.Event;
import ro.netrom.mavenproject1.business.entity.Student;

/**
 *
 * @author practice7
 */
@Stateless

public class Students implements Serializable {

    @PersistenceContext(name = "practicaPu")
    private EntityManager em;

    public void saveStudent(Student student) {
        em.persist(student);
    }

    public void editStudent(Student student) {
        em.merge(student);
    }
    
    

    public void deleteStudent(Student student) {
        Student aux = em.find(Student.class, student.getId());
        if (aux != null) {
            em.remove(aux);
        }
    }

    public List<Student> getStudents() {
        List<Student> studentsList = em.createQuery("Select s from Student s", Student.class).getResultList();
        return studentsList;
    }
    
    public List<Event> getEventsByStudentId(Long studentId) {
        Student student = em.createQuery("Select s from Student s where s.id= :studentId", Student.class)
                .setParameter("studentId", studentId).getSingleResult();
        return student.getEvents();
    }
    
     

}
