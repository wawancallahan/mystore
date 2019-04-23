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
import Lib.TransaksiLib;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class Transaksi extends ConnectionDB implements ModelInterface {

    protected String table = "transactions";
    
    protected Object[] fillable = {
       "customer",
       "date",
       "total",
       "pembayaran",
       "kembalian"
    };
    
    public Transaksi() {
        super.setConnection();
    }
    
    public List<TransaksiLib> getItems() {
        try {
            ResultSet _ResultSet = this.list();
            if ( ! _ResultSet.isBeforeFirst()) {
                return null;
            } else {
                List<TransaksiLib> items = new ArrayList<>();
                
                while (_ResultSet.next()) {
                    
                    String id = _ResultSet.getString("id");
                    
                    Optional<TransaksiLib> constainItem = items.stream().filter(item -> String.valueOf(item.getId()).equals(id)).findFirst();
                   
                    if (constainItem.isPresent()) {
                        List<String> request = new ArrayList<>();
                            
                        request.add(0, _ResultSet.getString("transaction_details_id"));
                        request.add(1, _ResultSet.getString("transaction_id"));
                        request.add(2, _ResultSet.getString("item_id"));
                        request.add(3, _ResultSet.getString("qty"));
                            
                        constainItem.get().setTransaksiDetailObject(request);
                    } else {
                        TransaksiLib newItem = new TransaksiLib(
                            _ResultSet.getInt("id"), 
                            _ResultSet.getString("customer"),
                            _ResultSet.getString("date"),
                            _ResultSet.getInt("total")
                        );
                        
                        String transaction_details_id = _ResultSet.getString("transaction_details_id");
                        
                        if ( ! _ResultSet.wasNull()) {
                            
                            List<String> request = new ArrayList<>();
                            
                            request.add(0, _ResultSet.getString("transaction_details_id"));
                            request.add(1, _ResultSet.getString("transaction_id"));
                            request.add(2, _ResultSet.getString("item_id"));
                            request.add(3, _ResultSet.getString("qty"));
                            
                            newItem.setTransaksiDetailObject(request);
                        }
                        
                        items.add(
                            newItem
                         );
                    }
                }
                
                return items;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public Integer getLastId() {
        String query = "SELECT id FROM " + this.table + 
                       " ORDER BY id DESC";
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            if (_ResultSet.first()) {
                return _ResultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return 0;
    }
    
    @Override
    public ResultSet list() {
        String query = "SELECT * FROM " + this.table + 
                        " LEFT JOIN (" + 
                        " SELECT id AS transaction_details_id, item_id, transaction_id, qty " +
                        " FROM transaction_details " + 
                        ") transaction_details ON transaction_details.transaction_id = transactions.id " +
                        "  ORDER BY transactions.id DESC";
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
        String query = "INSERT INTO " + table + " (id, customer, date, total, pembayaran, kembalian) " +
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
        String query = " DELETE FROM transaction_details WHERE transaction_details.transaction_id = '" + id + "';" +
                       " DELETE FROM " + this.table + " WHERE id = '" + id + "';";
        try {
            Integer _ResultSet = super.ExecuteUpdate(query);
            
            return _ResultSet >= 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
}
