
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.practica_2016.business.entity.Student;

/**
 *
 * @author practice9
 */
@Stateless
public class Students implements Serializable {

    @PersistenceContext(name = "practica_2016PU")
    private EntityManager em;

    public void saveStudent(Student student) {
        em.persist(student);
    }

    public void updateStudent(Student student) {
        em.merge(student);
    }

    public void deleteStudent(Student student) {
        em.remove(student);
    }

    public List<Student> getStudents() {
        List<Student> listOfStudents = em
                                         .createQuery("Select s from Student s", Student.class)
                                         .getResultList();
        return listOfStudents;
    }
}
