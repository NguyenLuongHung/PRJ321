/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import com.prj321.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoleFeatureDAO {

    DBContext context = new DBContext();

    public List<String> getServletPath(String roleId){
        List<String> servletPath = new ArrayList<String>();
        try {
            Connection conn = context.getConnection();
            String query = "select * from [role_feature] where [role_id] = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,roleId);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String path = rs.getString("servlet_path");
                servletPath.add(path);
            }
            return servletPath;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
