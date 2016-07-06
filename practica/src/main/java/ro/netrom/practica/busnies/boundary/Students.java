/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.busnies.boundary;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ro.netrom.practica.busnies.entity.Student;

/**
 *
 * @author practice10
 */
@Stateless
public class Students implements Serializable {

    @PersistenceContext(name = "practicaPU")
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

    public List<Student> getAll() {
        List<Student> results = em
                .createQuery("Select a from Student a", Student.class)
                .getResultList();
        return results;
    }

}
