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
import java.sql.ResultSet;
import java.util.List;
import Lib.BarangLib;
import java.sql.SQLException;
import java.util.ArrayList;

public class Barang extends ConnectionDB implements ModelInterface {
    
    protected String table = "items";
    
    protected Object[] fillable = {
       "kode",
       "nama",
       "harga",
       "qty",
       "jenis"
    };
    
    public Barang() {
        super.setConnection();
    }
    
    public List<BarangLib> getItems() {
        try {
            ResultSet _ResultSet = this.list();
            if ( ! _ResultSet.isBeforeFirst()) {
                return null;
            } else {
                List<BarangLib> barangObject = new ArrayList<>();
                
                while (_ResultSet.next()) {
                    barangObject.add(
                       new BarangLib(_ResultSet.getInt("id"),
                                     _ResultSet.getString("kode"),
                                     _ResultSet.getString("nama"),
                                     _ResultSet.getString("jenis"),
                                     _ResultSet.getInt("harga"),
                                     _ResultSet.getInt("qty"))
                    );
                }
                
                return barangObject;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public BarangLib findIitem(Integer id) {
        String query = "SELECT * FROM " + this.table + " WHERE id = " + id;
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            if(_ResultSet.first()) {
                return new BarangLib(_ResultSet.getInt("id"),
                                     _ResultSet.getString("kode"),
                                     _ResultSet.getString("nama"),
                                     _ResultSet.getString("jenis"),
                                     _ResultSet.getInt("harga"),
                                     _ResultSet.getInt("qty"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
     public boolean decrementQty(Integer qty, Integer id) {
        String query = "UPDATE " + this.table + " SET " +
                        " qty = qty - '" + qty + "'" +
                        " WHERE id = '" + id + "'";
        try {
            Integer _ResultSet = super.ExecuteUpdate(query);
            
            return _ResultSet >= 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public Boolean checkCode(String code, String oldCode) {
        String query = "";
        if (oldCode != null) {
            query = "SELECT * FROM " + this.table + " WHERE kode = '" + code + "' AND kode != '" + oldCode + "'";
        } else {
            query = "SELECT * FROM " + this.table + " WHERE kode = '" + code + "'";
        }
     
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            if(_ResultSet.first()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public ResultSet list() {
        String query = "SELECT * FROM " + this.table + " ORDER BY id DESC";
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
        String query = "INSERT INTO " + table + " (id, kode, nama, jenis, harga, qty) " +
                        "VALUES (" + 
                        "null," + 
                        "'" + request.get(0) + "'," + 
                        "'" + request.get(1) + "'," + 
                        "'" + request.get(2) + "'," + 
                        "'" + request.get(3) + "'," + 
                        "'" + request.get(4) + "'" + 
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
        String query = "UPDATE " + this.table + " SET " +
                        " kode = '" + request.get(0) + "'," +
                        " nama = '" + request.get(1) + "'," +
                        " jenis = '" + request.get(2) + "'," +
                        " harga = '" + request.get(3) + "'," +
                        " qty = '" + request.get(4) + "' " +
                        " WHERE id = '" + id + "'";
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
