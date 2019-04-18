/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Timy
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
    
    // JDBC URL, username and password of MySQL server
    private final String url = "jdbc:mysql://localhost:3306/penjualan?zeroDateTimeBehavior=convertToNull";
    private final String user = "root";
    private final String password = "";
    
    protected Connection getConnection = null;
    private ResultSet _ResultSet;
    private Statement _Statement;
    
    protected void setConnection() {
        try {
            if (getConnection == null) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);

                getConnection = con;

                if (getConnection != null) {
                    System.out.println("Connection Success");
                } else {
                    System.out.println("Connection Failed");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed " + e.getMessage());
        }
    }
    
    protected ResultSet ExecuteQuery(String query) {
        try {
            this._Statement = this.getConnection.createStatement();
            this._ResultSet = this._Statement.executeQuery(query);
            
            return this._ResultSet;
        } catch (SQLException e) {
            System.out.println("Query Failed " + e.getMessage());
        }
        
        return null;
    }
    
    protected Integer ExecuteUpdate(String query) {
        try {
            this._Statement = this.getConnection.createStatement();
            Integer result = this._Statement.executeUpdate(query);
            
            return result;
        } catch (SQLException e) {
            System.out.println("Query Failed " + e.getMessage());
        }
        
        return 0;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
  
}
