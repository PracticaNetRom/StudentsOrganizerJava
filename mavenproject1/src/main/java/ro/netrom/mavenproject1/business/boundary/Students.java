/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.mavenproject1.business.boundary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author practice7
 */
public class Students {

    @PersistenceContext(name = "practicaPu")
    private EntityManager em;
}
