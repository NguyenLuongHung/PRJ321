/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class DBContext {
    protected Connection connect;
    
    public Connection getConnection() {
        
        try {
            String url = "jdbc:sqlserver://DESKTOP-L9NF8PT\\BIDDSQL2008:1434;databaseName=Mankind";
            String username = "sa";
            String password = "bivip123123123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully!");
        } catch (Exception e){
            System.out.println("Fail to connect to database");
            e.printStackTrace();
        }
        
        return connect;
    }
    public void closeConnect(Connection con, PreparedStatement st, ResultSet rs){
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(sdf.format(date));
    }
}
