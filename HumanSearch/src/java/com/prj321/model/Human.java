/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Human {
    
    private int id;
    private String name;
    private Date birth;
    private int gender;
    private int typeId;

    public Human() {
    }
    
    

    public Human(int id, String name, Date birth, int gender, int typeId) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
    
}
