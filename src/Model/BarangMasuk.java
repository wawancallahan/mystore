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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import Lib.BarangMasukLib;

public class BarangMasuk extends ConnectionDB implements ModelInterface {
    protected String table = "import_transactions";
    
    protected Object[] fillable = {
       "tanggal",
       "pemasok",
       "item_id",
       "qty"
    };
    
    public BarangMasuk() {
        super.setConnection()
                ;
    }
    
    public List<BarangMasukLib> getItems() {
        try {
            ResultSet _ResultSet = this.list();
            if ( ! _ResultSet.isBeforeFirst()) {
                return null;
            } else {
                List<BarangMasukLib> items = new ArrayList<>();
                
                while (_ResultSet.next()) {
                    
                    String id = _ResultSet.getString("id");
                    
                    Optional<BarangMasukLib> constainItem = items.stream().filter(item -> String.valueOf(item.getId()).equals(id)).findFirst();
                   
                    if (constainItem.isPresent()) {
                        List<String> request = new ArrayList<>();
                            
                        request.add(0, _ResultSet.getString("items_id"));
                        request.add(1, _ResultSet.getString("items_kode"));
                        request.add(2, _ResultSet.getString("items_nama"));
                        request.add(3, _ResultSet.getString("items_jenis"));
                        request.add(4, _ResultSet.getString("items_harga"));
                        request.add(5, _ResultSet.getString("items_qty"));
                            
                        constainItem.get().setItemDetailObject(request);
                    } else {
                        BarangMasukLib newItem = new BarangMasukLib(
                            _ResultSet.getInt("id"), 
                            _ResultSet.getString("tanggal"),
                            _ResultSet.getString("pemasok"),
                            _ResultSet.getInt("item_id"),
                            _ResultSet.getInt("qty")
                        );
                        
                        String item_id = _ResultSet.getString("item_id");
                        
                        if ( ! _ResultSet.wasNull()) {
                            
                            List<String> request = new ArrayList<>();
                            
                            request.add(0, _ResultSet.getString("items_id"));
                            request.add(1, _ResultSet.getString("items_kode"));
                            request.add(2, _ResultSet.getString("items_nama"));
                            request.add(3, _ResultSet.getString("items_jenis"));
                            request.add(4, _ResultSet.getString("items_harga"));
                            request.add(5, _ResultSet.getString("items_qty"));
                            
                            newItem.setItemDetailObject(request);
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
    
    public BarangMasukLib findIitem(Integer id) {
        String query = "SELECT import_transactions.id, import_transactions.item_id, import_transactions.tanggal, import_transactions.pemasok, import_transactions.qty, " +
                        " items.id AS items_id, items.kode AS items_kode, items.nama AS items_nama, items.jenis AS items_jenis, items.harga AS items_harga, items.qty AS items_qty " +
                        " FROM " + this.table + 
                        " LEFT JOIN " +
                        " items ON items.id = (" +
                        " SELECT id FROM items WHERE items.id = " + this.table + ".item_id" +
                        " LIMIT 1 )" +
                        " WHERE import_transactions.id = '" + id + "' ORDER BY id DESC";
        try {
            ResultSet _ResultSet = super.ExecuteQuery(query);
            
            if(_ResultSet.first()) {
                BarangMasukLib item = new BarangMasukLib(
                        _ResultSet.getInt("id"), 
                        _ResultSet.getString("tanggal"),
                        _ResultSet.getString("pemasok"),
                        _ResultSet.getInt("item_id"),
                        _ResultSet.getInt("qty")
                );
                
                String item_id = _ResultSet.getString("item_id");
                        
                if ( ! _ResultSet.wasNull()) {

                    List<String> request = new ArrayList<>();

                    request.add(0, _ResultSet.getString("items_id"));
                    request.add(1, _ResultSet.getString("items_kode"));
                    request.add(2, _ResultSet.getString("items_nama"));
                    request.add(3, _ResultSet.getString("items_jenis"));
                    request.add(4, _ResultSet.getString("items_harga"));
                    request.add(5, _ResultSet.getString("items_qty"));

                    item.setItemDetailObject(request);
                }
                
                return item;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public ResultSet list() {
        String query = "SELECT import_transactions.id, import_transactions.item_id, import_transactions.tanggal, import_transactions.pemasok, import_transactions.qty, " +
                        " items.id AS items_id, items.kode AS items_kode, items.nama AS items_nama, items.jenis AS items_jenis, items.harga AS items_harga, items.qty AS items_qty " +
                        " FROM " + this.table + 
                        " LEFT JOIN " +
                        " items ON items.id = (" +
                        " SELECT id FROM items WHERE items.id = " + this.table + ".item_id" +
                        " LIMIT 1 )" +
                        "  ORDER BY id DESC";
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
        String query = "INSERT INTO " + table + " (id, tanggal, pemasok, item_id, qty) " +
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
        String query = "UPDATE " + this.table + " SET " +
                       "tanggal = '" + request.get(0) + "', " +
                       "pemasok = '" + request.get(1) + "', " + 
                       "item_id = '" + request.get(2) + "', " + 
                       "qty = '" + request.get(3) + "'" +
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
        String query = "DELETE FROM " + this.table + " WHERE id = '" + id + "'";
        try {
            Integer _ResultSet = super.ExecuteUpdate(query);
            
            return _ResultSet >= 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}
