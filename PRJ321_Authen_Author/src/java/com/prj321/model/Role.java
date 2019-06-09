/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Role {
    
    private String roleId;
    private String roleName;
    private List<String> servletPath;

    public Role() {
    }

    public Role(String roleId, String roleName, List<String> servletPath) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.servletPath = servletPath;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getServletPath() {
        return servletPath;
    }

    public void setServletPath(List<String> servletPath) {
        this.servletPath = servletPath;
    }  
}
