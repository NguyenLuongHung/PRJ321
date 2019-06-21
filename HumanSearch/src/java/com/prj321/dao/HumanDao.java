/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import com.prj321.model.Human;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HumanDao {

    DBContext context = new DBContext();

    public List<Human> getHumans() {
        Connection conn = context.getConnection();
        List<Human> hmList = new ArrayList();
        try {
            String query = "select * from [Human]";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("humanid");
                String name = rs.getString("humanname");
                Date date = rs.getDate("humandob");
                int humangender = rs.getInt("humangender");
                int typeId = rs.getInt("typeid");
                Human hm = new Human(id, name, date, humangender, typeId);
                hmList.add(hm);
            }
            return hmList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Human> getHumansSearch(String id, String name, String gender, String dateFrom, String dateTo, String type) {
        Connection conn = context.getConnection();
        List<Human> hmList = new ArrayList();
        ResultSet rs = null;
        try {
            if (!id.equals("")) {
                String query = "select * from [Human] where humanid = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, Integer.parseInt(id));
                rs = st.executeQuery();
            } else if (!gender.equals("all") && !type.equals("all")) {
                String query = "select * from [Human] where humangender = ? and humanname like ? and humandob > ? and humandob < ? and typeid = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, Integer.parseInt(gender));
                st.setString(2, "%"+name+"%");
                st.setString(3, dateFrom);
                st.setString(4, dateTo);
                st.setInt(5, Integer.parseInt(type));
                rs = st.executeQuery();

            } else if (!gender.equals("all")) {
                
                String query = "select * from [Human] where humangender = ? and humanname like ? and humandob > ? and humandob < ? ";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, Integer.parseInt(gender));
                st.setString(2, "%"+name+"%");
                st.setString(3, dateFrom);
                st.setString(4, dateTo);
                rs = st.executeQuery();
                

            } else if (!type.equals("all")) {
                String query = "select * from [Human] where humanname like ? and humandob > ? and humandob < ? and typeid = ? ";
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, "%"+name+"%");
                st.setString(2, dateFrom);
                st.setString(3, dateTo);
                st.setInt(4, Integer.parseInt(type));
                
                rs = st.executeQuery();
                

            } else if (gender.equals("all") && type.equals("all")) {
                System.out.println("Here also");
                String query = "select * from [Human] where humanname like ? and humandob > ? and humandob < ? ";
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, "%"+name+"%");
                st.setString(2, dateFrom);
                st.setString(3, dateTo);
                
                
                rs = st.executeQuery();
            }
            while (rs.next()){
                int hmid = rs.getInt("humanid");
                String hmname = rs.getString("humanname");
                Date date = rs.getDate("humandob");
                int humangender = rs.getInt("humangender");
                int typeId = rs.getInt("typeid");
                Human hm = new Human(hmid, hmname, date, humangender, typeId);
                hmList.add(hm);
            }
            return hmList;
            

            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
