/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.dao;

import com.prj321.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeDAO {
    
    DBContext context = new DBContext();
    protected Connection con = context.getConnection();
    
    public List<Employee> getEmployees(){
        List<Employee> empList = new ArrayList<Employee>();
        try {
            String query = "select e.id,"
                    + "e.first_name,"
                    + "e.last_name,"
                    + "e.address,"
                    + "e.gender,"
                    + "e.join_date"
                    + " from employee e";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String join_date = rs.getString("join_date");
                
                Employee newEmp = new Employee(id, first_name, last_name,
                                                address, gender, join_date);
                empList.add(newEmp);
                
            }
            context.closeConnect(con, st, rs);
            return empList;
            
        }
        catch (SQLException e){
            e.printStackTrace();
            
        }
        return null;
        
    }
    
    public List<Employee> getEmployeesBySize(int pageSize, int pageIndex){
        List<Employee> empList = new ArrayList<Employee>();
        try {
            String query = "select [id], [first_name], [last_name], [address], [gender] , [join_date]\n"
                    + "from\n"
                    + "(select ROW_NUMBER() OVER(order by [id]) as [row_num], [id], [first_name], [last_name], [address], [gender], [join_date] from [Employee]) as e\n"
                    + "where [row_num] >= ((?-1)*? + 1) AND [row_num] <= ? * ?;";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            st.setInt(4, pageIndex);
            ResultSet rs = st.executeQuery();
            System.out.println("pageIndex = " + pageIndex);
            System.out.println("pageSize = " + pageSize);
            
            
            
            while(rs.next()){
                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String join_date = rs.getString("join_date");
                
                Employee newEmp = new Employee(id, first_name, last_name,
                                                address, gender, join_date);
                empList.add(newEmp);
                
            }
            context.closeConnect(con, st, rs);
            return empList;
            
        }
        catch (SQLException e){
            e.printStackTrace();
            
        }
        return null;
        
    }
    
    
    
    
    
    public Employee getEmployee(String id){
        try {
            String query = "select e.id,"
                    + "e.first_name,"
                    + "e.last_name,"
                    + "e.address,"
                    + "e.gender,"
                    + "e.join_date"
                    + " from employee e where e.id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String join_date = rs.getString("join_date");
                
                Employee newEmp = new Employee(id, first_name, last_name,
                                                address, gender, join_date);
                context.closeConnect(con, st, rs);
                return newEmp;
            }
           
            
        }
        catch (SQLException e){
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void addEmployee(Employee e){
        try {
            String query = "insert into employee ("
                    + "id,"
                    + "first_name,"
                    + "last_name,"
                    + "address,"
                    + "gender,"
                    + "join_date)"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, e.getId());
            st.setString(2, e.getFirsName());
            st.setString(3, e.getLastName());
            st.setString(4, e.getAddress());
            st.setString(5, e.getGender());
            st.setString(6, e.getJoin_date());
            st.executeQuery();
            context.closeConnect(con, st, null);
            
            
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void updateEmployee(Employee e, String id){
        try {
            String query = "update employee set "
                    + "id=?,"
                    + "first_name=?,"
                    + "last_name=?,"
                    + "address=?,"
                    + "gender=?,"
                    + "join_date=? "
                    + "where id=?";
                    
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, e.getId());
            st.setString(2, e.getFirsName());
            st.setString(3, e.getLastName());
            st.setString(4, e.getAddress());
            st.setString(5, e.getGender());
            st.setString(6, e.getJoin_date());
            st.setString(7, id);
            
            st.executeQuery();
            context.closeConnect(con, st, null);
            
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void deleteEmployee(String id){
        try {
            String query = "delete from employee where id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, id);
            st.executeQuery();
            context.closeConnect(con, st, null);
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
     public int count(){
        try {
            String query = "select COUNT(*) as total_row from Employee;";
                    
            PreparedStatement st = con.prepareStatement(query);         
            ResultSet rs =  st.executeQuery();
            if (rs.next()){
                return rs.getInt("total_row");
            }
            context.closeConnect(con, st, null);
            
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    /*
    try {
            String query = "select e.id,"
                    + "e.first_name,"
                    + "e.last_name,"
                    + "e.address,"
                    + "e.gender,"
                    + "e.join_date"
                    + " from employee e";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
*/
    
    
}
