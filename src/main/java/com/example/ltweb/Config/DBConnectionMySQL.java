package com.example.ltweb.Config;

import com.example.ltweb.DAO.UserDaoImpl;
import com.example.ltweb.Model.UserModel;

import javax.management.MBeanAttributeInfo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionMySQL {
    private static String DB_URL = "jdbc:mysql://localhost:3306/Servlet";
    private static String USER = "root";
    private static String PASSWORD = "root";
    private static Connection con;
    public static Connection getConnection() throws IOException {
       con = null;
       try{
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           con = (Connection) DriverManager.getConnection(DB_URL,USER,PASSWORD);
       }
       catch (SQLException ex){
           Logger.getLogger(DBConnectionMySQL.class.getName()).log(Level.SEVERE,null,ex);
       }
       return (con);
    }
}

