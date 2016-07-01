/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica.busnies.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author practice10
 */
@Entity
public class Event implements Serializable {
     @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
     @Enumerated(EnumType.STRING)
  private Type event;
     @Temporal(javax.persistence.TemporalType.DATE)
  private Date startDate;
     @Temporal(javax.persistence.TemporalType.DATE)
  private Date endDate;
     @Enumerated(EnumType.STRING)
  private Department department;
  private String taskReceived;
  private String remarks;
  public enum Type{
      PRACTICE, INTERSHIP, NSA
  }
  public enum Department{
      PHP, JAVA, MOBILE 
  }
}
