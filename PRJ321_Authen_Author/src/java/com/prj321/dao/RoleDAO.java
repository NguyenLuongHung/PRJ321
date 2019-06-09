/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import com.prj321.model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoleDAO {
    DBContext context = new DBContext();
    public Role getRole(String roleId){
        try {
            Role role;
            List<String> servletPath = new ArrayList<String>();
            Connection conn = context.getConnection();
            String query = "select * from [role] where [role].[role_id] = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, roleId);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String roleName = rs.getString("role_name");
                query = "select * from [role_feature] where [role_feature].[role_id] = ?";
                st.setString(1, roleId);
                ResultSet rs1 = st.executeQuery();
                while (rs1.next()){
                    String path = rs1.getString("servlet_path");
                    servletPath.add(path);
                }
                role = new Role(roleId, roleName, servletPath);
                context.closeConnect(null, null, rs1);
                context.closeConnect(conn, st, rs);
                return role;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
}
