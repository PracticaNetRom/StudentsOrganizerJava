/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.netrom.practica01.bussnies.entity;

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
 * @author practice01
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
    private Departments department;
    private String taskReceived;
    private String remarks;

    public enum Type {

        PRACTICE, INTERSHIP, NSA
    }

    public enum Departments {

        JAVA, NET, MOBILE
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getEvent() {
        return event;
    }

    public void setEvent(Type event) {
        this.event = event;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public String getTaskReceived() {
        return taskReceived;
    }

    public void setTaskReceived(String taskReceived) {
        this.taskReceived = taskReceived;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    
}
