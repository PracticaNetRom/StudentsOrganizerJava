/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import ro.netrom.practica.business.entity.Student;

/**
 *
 * @author practice8
 */
@Stateless
public class Students implements Serializable{

    @PersistenceContext(name = "practicaPU")
    private EntityManager em;

    public void saveStudent(Student student) {
        em.persist(student);
    }
    public void deleteStudent(Student student)
    {
        
        em.remove(em.merge(student));
       
    }
     public void editStudent(Student student)
    {
        
        em.merge(student);
       
    }

    public List<Student> getStudentsList() {
        List<Student> rezult = em
                      .createQuery("Select a from Student a", Student.class)
                      .getResultList();
        return rezult;
    }
}
