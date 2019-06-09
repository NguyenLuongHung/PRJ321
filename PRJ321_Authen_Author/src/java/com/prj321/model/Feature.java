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
public class Feature {
    private String servletPath;
    private String servletName;

    public Feature() {
    }

    public Feature(String servletPath, String servletName) {
        this.servletPath = servletPath;
        this.servletName = servletName;
    }

    public String getServletPath() {
        return servletPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }
    
    
}
