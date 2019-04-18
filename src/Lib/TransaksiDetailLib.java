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
public class TransaksiDetailLib {
    protected Integer id;
    protected Integer transaction_id;
    protected Integer item_id;
    protected Integer qty;
    
    public TransaksiDetailLib(Integer id, Integer transaction_id, Integer item_id, Integer qty) {
        this.id = id;
        this.transaction_id = transaction_id;
        this.item_id = item_id;
        this.qty = qty;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public Integer getTransactionId() {
        return this.transaction_id;
    }
    
    public Integer getItemId() {
        return this.item_id;
    }
    
    public Integer getQty() {
        return this.qty;
    }
}
