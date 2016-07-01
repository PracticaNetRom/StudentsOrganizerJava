/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.business.boundary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

/**
 *
 * @author practice8
 */
public class Students 
{
    @PersistenceContext( name = "practicaPU")
    private EntityManager em;
}
