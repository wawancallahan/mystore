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

public class BarangLib {
    
    protected Integer id = null;
    protected String nama = null;
    protected String jenis = null;
    protected Integer harga = null;
    protected Integer qty = null;
    
    public static BarangLib NOT_FOUND = new BarangLib(0, "", "", 0, 0);
    
    public BarangLib(int id, String nama, String jenis, Integer harga, Integer qty) {
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
    
}
