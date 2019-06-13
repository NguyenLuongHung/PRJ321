/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

/**
 *
 * @author sonnt
 */
public class DBContext {
   protected Connection connection;
   public DBContext()
   {
       try {
           String url = "jdbc:sqlserver://DESKTOP-B4D1141:1433;databaseName=Mankind";
           String username = "sonnt";
           String password = "12345678";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection = DriverManager.getConnection(url, username, password);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   
   public ArrayList<Human> paging(int pageindex, int pagesize)
   {
       String sql = "SELECT humanid,humanname,humandob,humangender,typeid,typename\n" +
                    "FROM\n" +
                    "(SELECT ROW_NUMBER() OVER (ORDER BY humanid ASC) as rownum, h.humanid, h.humanname,h.humandob,h.humangender,ht.typeid,ht.typename FROM Human h INNER JOIN HumanType ht ON h.typeid = ht.typeid) as tblHuman\n" +
                    "WHERE\n" +
                    "rownum >= ((?-1) * ?) + 1 AND rownum <= ? * ?";
       ArrayList<Human> humans = new ArrayList<>();
       PreparedStatement statement;
       try {
           statement = connection.prepareStatement(sql);
           statement.setInt(1, pageindex);
           statement.setInt(2, pagesize);
           statement.setInt(3, pagesize);
           statement.setInt(4, pageindex);
           ResultSet rs = statement.executeQuery();
           while(rs.next())
           {
               Human h = new Human();
               h.setID( rs.getInt("humanid") );
               h.setName(rs.getString("humanname") );
               h.setDob(rs.getDate("humandob") );
               h.setGender(rs.getBoolean("humangender") );
               
               HumanType ht = new HumanType();
               ht.setTypeID(rs.getInt("typeid") );
               ht.setTypeName(rs.getString("typename") );
               
               h.setType(ht);
               humans.add(h);
           }
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return humans;
   }
   
   
   
   
   public ArrayList<Human> getAllHumans()
   {
       String sql = "SELECT h.humanid, h.humanname,h.humandob,h.humangender,ht.typeid,ht.typename FROM Human h INNER JOIN HumanType ht\n" +
                    "ON h.typeid = ht.typeid";
       ArrayList<Human> humans = new ArrayList<>();
       PreparedStatement statement;
       try {
           statement = connection.prepareStatement(sql);
           ResultSet rs = statement.executeQuery();
           while(rs.next())
           {
               Human h = new Human();
               h.setID( rs.getInt("humanid") );
               h.setName(rs.getString("humanname") );
               h.setDob(rs.getDate("humandob") );
               h.setGender(rs.getBoolean("humangender") );
               
               HumanType ht = new HumanType();
               ht.setTypeID(rs.getInt("typeid") );
               ht.setTypeName(rs.getString("typename") );
               
               h.setType(ht);
               humans.add(h);
           }
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return humans;
   }
   
   public int count()
   {
       String sql = "SELECT COUNT(*) as totalrow FROM Human";
       PreparedStatement statement;
       try {
           statement = connection.prepareStatement(sql);
           ResultSet rs = statement.executeQuery();
           if(rs.next())
           {
               return rs.getInt("totalrow");
           }
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return 0;
   }
   
   
   
   public ArrayList<HumanType> getHumanTypes()
   {
       String sql = "SELECT [typeid]\n" +
                    "      ,[typename]\n" +
                    "  FROM [HumanType]";
       ArrayList<HumanType> types = new ArrayList<>();
       PreparedStatement statement;
       try {
           statement = connection.prepareStatement(sql);
           ResultSet rs = statement.executeQuery();
           while(rs.next())
           {
               HumanType ht = new HumanType();
               ht.setTypeID(rs.getInt("typeid") );
               ht.setTypeName(rs.getString("typename") );
               types.add(ht);
           }
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return types;
   }
   
   
   public void insert(Human human)
   {
       try {
           String sql = "INSERT INTO [Human]\n" +
                   "           ([humanid]\n" +
                   "           ,[humanname]\n" +
                   "           ,[humandob]\n" +
                   "           ,[humangender]\n" +
                   "           ,[typeid])\n" +
                   "     VALUES\n" +
                   "           (?\n" +
                   "           ,?\n" +
                   "           ,?\n" +
                   "           ,?\n" +
                   "           ,?)";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setInt(1, human.getID());
           statement.setString(2, human.getName());
           statement.setDate(3, human.getDob());
           statement.setBoolean(4, human.isGender());
           statement.setInt(5, human.getType().getTypeID());
           statement.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
   }
   
   
}
