/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toyota.generarecodbare.connection;

import java.io.File;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;

//import static jdk.internal.net.http.HttpConnection.getConnection;

/**
 *
 * @author calin
 */
public class ConnectDB {
      static Connection conn=null;
    public static Connection ConnectDb() throws SQLException {
//     File workingDirectory = new File(System.getProperty("user.dir").toString() + "\\Db\\Piese.db");
//    String adresa1 = workingDirectory.toString();
//    adresa1 = adresa1.replace("\\", "\\\\");
//     String adresa2 = "jdbc:sqlite:";
//    String adresa = adresa2 + adresa1;
//        try {
//            Class.forName("org.sqlite.JDBC");
//        Connection conn = DriverManager.getConnection(adresa);
//      //  JOptionPane.showMessageDialog(null, "Connection established");
//        return conn;
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//            return null;}

                Properties connectionProps = new Properties();
        connectionProps.put("user", "sa");
        connectionProps.put("password", "am@123#");

        conn = DriverManager.getConnection(
                //"jdbc:sqlserver://OR-SQL//AM;database=GMRO011P",
                "jdbc:jtds:sqlserver://OR-SQL/GMRO011P;instance=AM",
                connectionProps);
        return conn;
    }

}
