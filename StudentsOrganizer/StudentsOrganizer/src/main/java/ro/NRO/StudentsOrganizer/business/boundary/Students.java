/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.NRO.StudentsOrganizer.business.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ro.NRO.StudentsOrganizer.business.entity.Student;

/**
 *
 * @author practice6
 */
@Stateless
public class Students implements Serializable {

    @PersistenceContext(name = "StudentsOrganizerPU")
    private EntityManager em;

    public void saveStudent(Student student) {

        em.persist(student);
    }
    
    public void deleteStudent(Student student){
        
        em.remove(student);
        
    }

    public List<Student> getAll() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }
}
