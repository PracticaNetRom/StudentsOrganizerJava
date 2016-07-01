/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.busnies.boundary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author practice10
 */
public class Students {
    @PersistenceContext( name = "practicaPU")
   private EntityManager em;
}
