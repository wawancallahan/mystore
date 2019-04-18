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
public class BarangComboBoxLib {
    
    protected Integer id;
    protected String nama;
    protected String jenis;
    protected Integer harga;
    protected Integer qty;
    
    public BarangComboBoxLib(Integer id, String nama, String jenis, Integer harga, Integer qty) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.qty = qty;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public String getJenis() {
        return this.jenis;
    }
    
    public Integer getHarga() {
        return this.harga;
    }
    
    public Integer getQty() {
        return this.qty;
    }
    
    
    @Override
    public String toString() {
        return this.nama + " - " + String.valueOf(this.harga);
    }
}
