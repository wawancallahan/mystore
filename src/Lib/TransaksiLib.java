/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timy
 */
public class TransaksiLib {
    protected Integer id;
    protected String customer;
    protected String date;
    
    protected List<TransaksiDetailLib> transaksiDetailObject = new ArrayList<>();
    
    public TransaksiLib(int id, String customer, String date) {
        this.id = id;
        this.customer = customer;
        this.date = date;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getCustomer() {
        return this.customer;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setTransaksiDetailObject(List<String> request) {
        transaksiDetailObject.add(new TransaksiDetailLib(Integer.valueOf(request.get(0)), Integer.valueOf(request.get(1)), Integer.valueOf(request.get(2)), Integer.valueOf(request.get(3))));
    }
    
    public List<TransaksiDetailLib> transaksiDetail() {
        return this.transaksiDetailObject;
    }
    
    public Integer getTransaksiDetailCount() {
        List<TransaksiDetailLib> transaksiDetail = this.transaksiDetail();
        
        return transaksiDetail.size();
    }
}
