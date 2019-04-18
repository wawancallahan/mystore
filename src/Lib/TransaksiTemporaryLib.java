/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

/**
 *
 * @author Timy
 */
public class TransaksiTemporaryLib {
    protected Integer id;
    protected Integer item_id;
    protected String nama;
    protected Integer harga;
    protected Integer qty;
    
    public TransaksiTemporaryLib(Integer id, Integer item_id, String nama, Integer harga, Integer qty) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.qty = qty;
        this.item_id = item_id;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getItemId() {
        return this.item_id;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public Integer getHarga() {
        return this.harga;
    }
    
    public Integer getQty() {
        return this.qty;
    }
    
    public void addQty(Integer qty) {
        this.qty += qty;
    }
    
    public Integer getTotal() {
        return this.harga * this.qty;
    }
    
}
