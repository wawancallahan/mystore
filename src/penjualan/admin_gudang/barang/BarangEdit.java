/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.admin_gudang.barang;

import Lib.BarangLib;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Barang;
import java.util.Optional;

/**
 *
 * @author Timy
 */
public class BarangEdit extends javax.swing.JFrame {

    private static BarangEdit barangEditForm = null;
    protected Barang barangModel;
    public Integer id;
    /**
     * Creates new form BarangEdit
     */
    public BarangEdit() {
        initComponents();
        
        barangModel = new Barang();
    }
    
    public static BarangEdit showForm(Integer id) {
        if (barangEditForm == null) {
            barangEditForm = new BarangEdit().setId(id).setModelForm();
        }
        
        return barangEditForm;
    }
    
    public BarangEdit setId(Integer id) {
        this.id = id;
        
        return this;
    }
    
    private BarangEdit setModelForm() {
        if (this.id != null) {
            BarangLib item = barangModel.findIitem(this.id);
            
            if (item != null) {
                txtNama.setText(item.getNama());
                txtJenis.setText(item.getJenis());
                txtHarga.setText(item.getHarga().toString());
                txtQty.setText(item.getQty().toString());
            }
        }
        
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtJenis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 290, -1));
        jPanel1.add(txtJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 290, -1));

        jLabel2.setText("Jenis");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaKeyTyped(evt);
            }
        });
        jPanel1.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 290, -1));

        jLabel3.setText("Harga");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });
        jPanel1.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 290, -1));

        jLabel4.setText("Qty");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel5.setText("Edit Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_PERIOD))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHargaKeyTyped

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_PERIOD))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQtyKeyTyped

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (txtNama.getText().equals("") || txtJenis.getText().equals("") || txtHarga.getText().equals("") || txtQty.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Semua Input Harus Diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);

            return;
        }

        List<String> request = new ArrayList<>();
        request.add(0, txtNama.getText());
        request.add(1, txtJenis.getText());
        request.add(2, txtHarga.getText());
        request.add(3, txtQty.getText());

        boolean update = this.barangModel.update(request, this.id);

        if (update) {
            
            BarangForm.showForm().fillTable();
            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan Proses Simpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarangEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}