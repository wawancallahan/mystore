/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Timy
 */

import Lib.UserLib;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth extends User {
    
    public Auth() {
        super();
    }
    
    public UserLib Login(String username, String password) {
        try {
            String query = "SELECT * FROM " + super.table + " " +
                            "WHERE username = '" + username + "' AND " +
                            "password = '" + password + "' LIMIT 1";
            
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            if (_ResultSet.first()) {
                return new UserLib(_ResultSet.getInt("id"), 
                                   _ResultSet.getString("nama"), 
                                   _ResultSet.getString("username"), 
                                   _ResultSet.getString("password"),
                                   _ResultSet.getString("type"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
}
