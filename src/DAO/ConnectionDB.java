package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NT
 */
public class ConnectionDB {
   
        
    
    private static String url = "jdbc:sqlserver://localhost:1433;database=DA_QLKho25";
    private static String user = "sa";
    private static String pass = "tuan252002";
   
    public  Connection conn = null;
    private static ConnectionDB instance;

    public static ConnectionDB getIntance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }
    public Connection getconn()
    {
        return conn;
    }

    // xu ly ngoai le khi tuong tac voi csdl 


    public void displayError(SQLException ex) {
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }
    public void open() {// mo ket noi den csdl 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);//tao ket noi den co so du lieu 
            System.out.println("Ket noi thanh cong");
        } catch (SQLException ex) {// xu ly ngoai le 
            displayError(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Thieu JDBC");
        }
    }
    public void close() {// dong ket noi co so du lieu 
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            displayError(ex);
        }
    }
    public Connection getConnect() {
        return conn;
    }
    //tao va thuc thi cac cau lenh sql 
     /*public  ResultSet excuteQuery(String sql) {// danh cho cau lenh select 
        
        try {
            Statement stm = conn.createStatement();
            

            return stm.executeQuery(sql);

        } catch (SQLException ex) {
            displayError(ex);
        }
        return null;
    }*/
    public ResultSet excuteQuery(String sql, ArrayList<Object> arr) {// danh cho cau lenh select 
        ResultSet rs = null;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }

            rs = stm.executeQuery();

        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }
    public int excuteUpdate(String sql, ArrayList<Object> arr) {// danh cho cau lenh select 
        int rs = 1;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }
            stm.executeUpdate();
        } catch (SQLException ex) {
            displayError(ex);
            return -1;
        }
        return rs;
    }

    public boolean excute(String sql, ArrayList<Object> arr) {// danh cho cau lenh secect 
        boolean rs = false;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }

            rs = stm.execute();

        } catch (SQLException ex) {
            displayError(ex);
        }
        this.close();
        return rs;
    }
    public void excuteQuery(String sql) {// danh cho cau lenh seLect 
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();

        } catch (SQLException ex) {
            displayError(ex);
        }
    }

}
   