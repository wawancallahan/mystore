/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.ConnectionDB;
import Lib.BarangLib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Timy
 */
public class TransaksiDetail extends ConnectionDB implements ModelInterface {
     protected String table = "transaction_details";
    
    protected Object[] fillable = {
       "transaction_id",
       "item_id",
       "qty"
    };
    
    public TransaksiDetail() {
        super.setConnection();
    }
    
    @Override
    public ResultSet list() {
        return null;
    }

    @Override
    public boolean create(List<String> request) {
        String query = "INSERT INTO " + table + " (id, transaction_id, item_id, qty) " +
                        "VALUES (" + 
                        "null," + 
                        "'" + request.get(0) + "'," + 
                        "'" + request.get(1) + "'," +
                        "'" + request.get(2) + "'" +
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
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return true;
    }
}
