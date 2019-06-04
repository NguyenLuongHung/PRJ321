/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import com.prj321.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class UserDAO {
    
    DBContext context = new DBContext();
    
    public User getUser(String username, String passwd){
        Connection conn = context.getConnection();
        try {
            String query = "select * from [user] where username = ? and [password] = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, passwd);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String id = rs.getString("id");
                User user = new User(id, username, passwd);
                return user;
            }
            
        } catch (Exception e){
            e.printStackTrace();
            
        }
        return null;
    }
}
