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
public class BarangMasukLib {
    protected Integer id;
    protected String tanggal;
    protected String pemasok;
    protected Integer item_id;
    protected Integer qty;
    
    protected List<BarangLib> itemDetailObject = new ArrayList<>();
    
    public BarangMasukLib(int id, String tanggal, String pemasok, Integer item_id, Integer qty) {
        this.id = id;
        this.tanggal = tanggal;
        this.pemasok = pemasok;
        this.item_id = item_id;
        this.qty = qty;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getTanggal() {
        return this.tanggal;
    }
    
    public String getPemasok() {
        return this.pemasok;
    }
    
    public Integer getItemId() {
        return this.item_id;
    }
    
    public Integer getQty() {
        return this.qty;
    }
    
    public void setItemDetailObject(List<String> request) {
        itemDetailObject.add(new BarangLib(Integer.valueOf(request.get(0)), request.get(1), request.get(2), request.get(3), Integer.valueOf(request.get(4)), Integer.valueOf(request.get(5)) ));
    }
    
    public List<BarangLib> itemDetail() {
        return this.itemDetailObject;
    }
    
    public Integer getItemDetailCount() {
        List<BarangLib> itemDetail = this.itemDetail();
        
        return itemDetail.size();
    }
}
