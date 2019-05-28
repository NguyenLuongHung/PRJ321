/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.model;

/**
 *
 * @author Admin
 */
public class Employee {
    private String id;
    private String firsName;
    private String lastName;
    private String address;
    private String gender;
    private String join_date;
    
    public Employee(){
        
    }

    public Employee(String id, String firsName, String lastName, String address, String gender, String join_date) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.join_date = join_date;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }
    
    
}
