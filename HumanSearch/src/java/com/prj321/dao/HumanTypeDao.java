/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import com.prj321.model.HumanType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HumanTypeDao {
    
    DBContext context = new DBContext();
    
    public List<HumanType> getHumanTypes(){
        Connection conn = context.getConnection();
        List<HumanType> hmTypeList = new ArrayList();
        try {
            String query = "select * from [HumanType]";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("typeid");
                String typeName = rs.getString("typename");
                HumanType hmType = new HumanType(id, typeName);
                hmTypeList.add(hmType);
            }
            return hmTypeList;
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    public HumanType getHumanType(int id){
        Connection conn = context.getConnection();
        try {
            String query = "select * from [HumanType] where typeid = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String typeName = rs.getString("typename");
                return new HumanType (id, typeName);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
}
//Connection conn = context.getConnection();
//try {
//            String query = "";
//            PreparedStatement st = null;
//            ResultSet rs = null;
//            
//        } catch (Exception e){
//            e.printStackTrace();
//        }


