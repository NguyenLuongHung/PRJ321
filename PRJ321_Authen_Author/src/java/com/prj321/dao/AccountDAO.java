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
public class AccountDAO {
    DBContext context = new DBContext();
    
    public Account getAccount(String username, String password){
        try {
            Account acct;
            List<String> roles = new ArrayList<String>();
            
            
            Connection conn = context.getConnection();
            String query = "select * from [account] where [account].[username] = ?"
                    + " and [account].[password] = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                query = "select * from [role_account] where [role_account].[username] = ?";
                st = conn.prepareStatement(query);
                st.setString(1, username);
                ResultSet rs1 = st.executeQuery();
                
                while (rs1.next()){
                    String roleId = rs1.getString("role_id");
                    roles.add(roleId);
                }
                acct = new Account(username, password, roles);
                conn.close();
                return acct;
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
}
