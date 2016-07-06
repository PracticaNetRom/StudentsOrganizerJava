 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica01.bussnies.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ro.netrom.practica01.bussnies.entity.Student;

/**
 *
 * @author practice11
 */
@Stateless
public class Students implements Serializable {

    @PersistenceContext(name = "practicapu")
    private EntityManager em;

    public void studentSave(Student student) {
        em.persist(student);
    }

    public void studentEdit(Student student) {
        em.merge(student);   
    }

    public void studentDelete(Student student) {
        em.remove(em.merge(student)); 
    }

    public List<Student> getAllStudents() {
        final String query = "SELECT s from Student s";
        TypedQuery<Student> query1 = em.createQuery(query, Student.class);
        final List<Student> students = query1.getResultList();
        return students;
    }
    
}
