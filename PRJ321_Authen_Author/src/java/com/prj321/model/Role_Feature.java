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
public class Role_Feature {
    private String roleId;
    private String servletPath;

    public Role_Feature() {
    }

    public Role_Feature(String roleId, String servletPath) {
        this.roleId = roleId;
        this.servletPath = servletPath;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getServletPath() {
        return servletPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }
    
    
}
