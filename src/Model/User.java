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

import Config.ConnectionDB;
import Lib.BarangLib;
import java.sql.ResultSet;
import java.util.List;
import Lib.UserLib;
import java.sql.SQLException;
import java.util.ArrayList;

public class User extends ConnectionDB implements ModelInterface {
    
    protected String table = "users";
    
    protected Object[] fillable = {
       "nama",
       "username",
       "password",
       "type"
    };
    
    public User() {
        super.setConnection();
    }
    
    public List<UserLib> getItems() {
        try {
             ResultSet _ResultSet = this.list();
            if ( ! _ResultSet.isBeforeFirst()) {
                return null;
            } else {
                List<UserLib> items = new ArrayList<>();
                
                while (_ResultSet.next()) {
                    items.add(
                       new UserLib(_ResultSet.getInt("id"),
                                     _ResultSet.getString("nama"),
                                     _ResultSet.getString("username"),
                                     _ResultSet.getString("password"),
                                     _ResultSet.getString("type"))
                    );
                }
                
                return items;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public UserLib findItem(Integer id) 
    {
        String query = "SELECT * FROM " + this.table + " WHERE id = " + id;
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            if(_ResultSet.first()) {
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
    
    public UserLib findItemOnUserameAndType(String username, String type) 
    {
        String query = "SELECT * FROM " + this.table + " WHERE username = '" + username + "' AND type = '" + type + "'";
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            if(_ResultSet.first()) {
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
    
    @Override
    public ResultSet list() {
        String query = "SELECT * FROM " + this.table;
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            return _ResultSet;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public boolean create(List<String> request) {
        String query = "INSERT INTO " + table + " (id, nama, username, password, type) " +
                        "VALUES (" + 
                        "null," + 
                        "'" + request.get(0) + "'," + 
                        "'" + request.get(1) + "'," + 
                        "'" + request.get(2) + "'," + 
                        "'" + request.get(3) + "'" + 
                        ")";
        try {
            Integer _ResultSet = super.ExecuteUpdate(query);
            
            return _ResultSet >= 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean update(List<String> request, Integer id) {
        String query = "";
        try {
            Integer _ResultSet = super.ExecuteUpdate(query);
            
            return _ResultSet >= 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM " + this.table + " WHERE id = " + id;
        try {
            Integer _ResultSet = super.ExecuteUpdate(query);
            
            return _ResultSet >= 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}
