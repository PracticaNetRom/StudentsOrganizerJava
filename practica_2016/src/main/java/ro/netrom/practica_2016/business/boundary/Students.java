
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica_2016.business.boundary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author practice9
 */
public class Students {
    @PersistenceContext(name = "practica_2016PU")
    private EntityManager em;
}
