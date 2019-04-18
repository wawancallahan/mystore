/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.admin_kasir.transaksi;

/**
 *
 * @author Timy
 */

import Lib.BarangComboBoxLib;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import Lib.BarangLib;
import Model.Barang;
import Lib.TransaksiTemporaryLib;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Model.Transaksi;
import Model.TransaksiDetail;
import java.awt.HeadlessException;

public class TransaksiCreate extends javax.swing.JFrame {

    private final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private final Object[] column = new String[]{"item_id", "#", "Nama", "Harga", "Qty", "Total"};

    private Object[][] data = new Object[][]{
    };
            
    private DefaultTableModel model = new DefaultTableModel(data, column){

        @Override
            public boolean isCellEditable(int row, int col){
                    return false;
            }
    };
    
    private List<TransaksiTemporaryLib> transaksiTemporaryObject;
    
    protected Barang barangModel;
    protected Transaksi transaksiModel;
    protected TransaksiDetail transaksiDetailModel;
    
    private static TransaksiCreate transaksiCreateForm = null;
    
    
    /**
     * Creates new form TransaksiCreate
     */
    public TransaksiCreate() {
        initComponents();
        
        barangModel = new Barang();
        transaksiTemporaryObject = new ArrayList<>();
        transaksiModel = new Transaksi();
        transaksiDetailModel = new TransaksiDetail();
        
        setDateText();
        disabledDateText();
        zeroFillTable();
        setTable();
        setCmbBarang();
    }
    
    public static TransaksiCreate showForm() {
        if (transaksiCreateForm == null) {
            transaksiCreateForm = new TransaksiCreate();
        }
        
        return transaksiCreateForm;
    }
    
    
    private void zeroFillTable() {
        model.setRowCount(0);
    }
    
    private void setTable() {
        this.table.setModel(model);
        this.table.getColumnModel().getColumn(0).setMinWidth(0);
        this.table.getColumnModel().getColumn(0).setMaxWidth(0);
        this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void setDateText() {
        Date dateNow = new Date();
        String dateString = sdf.format(dateNow);
        
        txtTanggal.setText(dateString);
    }
    
    private void disabledDateText() {
        txtTanggal.setEnabled(false);
    }
    
    private void setCmbBarang() {
        try {
            List<BarangLib> barangObject = barangModel.getItems();
            
            if (barangObject != null) {
                DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();
                
                for (BarangLib item: barangObject) {
                    cmbModel.addElement(new BarangComboBoxLib(item.getId(), item.getNama(), item.getJenis(), item.getHarga(), item.getQty()));
                }
               
                cmbBarang.setModel(cmbModel); 
                cmbBarang.setSelectedIndex(-1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void resetTable() {
        zeroFillTable();
        int index = 0;
        for (TransaksiTemporaryLib transaksiItem: transaksiTemporaryObject) {
            index++;
            transaksiItem.setId(index);
            
            Object[] rowData = new Object[] {
                transaksiItem.getItemId(),
                transaksiItem.getId(),
                transaksiItem.getNama(),
                transaksiItem.getHarga(),
                transaksiItem.getQty(),
                transaksiItem.getTotal()
            };

            model.addRow(rowData);
        }
        
        setTable();
    }
    
    private void addItemToTemporaryTable() {
        BarangComboBoxLib item = (BarangComboBoxLib) cmbBarang.getSelectedItem();
        
        int hasRow = 0;
        
        for (TransaksiTemporaryLib transaksiItem: transaksiTemporaryObject) {
            if (transaksiItem.getItemId().equals(item.getId())) {
                hasRow = 1;
                
                transaksiItem.addQty(Integer.valueOf(txtQty.getText()));
                break;
            }
        }
        
        if (hasRow == 0) {
            transaksiTemporaryObject.add(new TransaksiTemporaryLib(0, item.getId(), item.getNama(), item.getHarga(), Integer.valueOf(txtQty.getText())));
        }
        
        resetTable();
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
        txtTanggal = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbBarang = new javax.swing.JComboBox<>();
        txtQty = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 150, -1));
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 150, -1));

        jLabel2.setText("Nama");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, 20));
        jPanel1.add(cmbBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 260, -1));

        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });
        jPanel1.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 60, -1));

        jLabel1.setText("Qty");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, 20));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 69, -1, 22));

        jLabel3.setText("Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel4.setText("Tanggal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 440, 340));

        jLabel5.setText("Tambah Transaksi");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 460, 110, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_PERIOD))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQtyKeyTyped

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if (cmbBarang.getSelectedIndex() == -1 || txtQty.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Semua Input Harus Terisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else if (Integer.valueOf(txtQty.getText()) <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Qty Tidak Boleh Sama Dengan 0", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            addItemToTemporaryTable();
            cmbBarang.setSelectedIndex(-1);
            txtQty.setText("");
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        int row = table.getSelectedRow();
        
        if (row != -1) {
            for (Iterator<TransaksiTemporaryLib> iter = transaksiTemporaryObject.listIterator(); iter.hasNext(); ) {
              TransaksiTemporaryLib item = iter.next();
              
              if (String.valueOf(item.getId()).equals(String.valueOf(table.getValueAt(row, 0)))) {
                  iter.remove();
              }
            }
            
            resetTable();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        zeroFillTable();
        setTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            if (txtNama.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Bidang Isian Nama Harus Diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else if (table.getRowCount() < 1) {
                JOptionPane.showMessageDialog(rootPane, "Minimal Item Transaksi Berjumlah 1", "Perintagan", JOptionPane.WARNING_MESSAGE);
            } else {
                List<String> request = new ArrayList<>();
                
                request.add(0, txtNama.getText());
                request.add(0, txtTanggal.getText());
                
                boolean create = this.transaksiModel.create(request);
                
                if (create) {
                    Integer lastId = this.transaksiModel.getLastId();
                    
                    for (TransaksiTemporaryLib transaksiItem: transaksiTemporaryObject) {
                        List<String> requestDetail = new ArrayList<>();
                        
                        requestDetail.add(0, String.valueOf(lastId));
                        requestDetail.add(1, String.valueOf(transaksiItem.getItemId()));
                        requestDetail.add(2, String.valueOf(transaksiItem.getQty()));
                        
                        transaksiDetailModel.create(requestDetail);
                    }
                    
                    btnReset.doClick();
                    txtNama.setText("");
                    
                    TransaksiForm.showForm().fillTable();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Transaksi Gagal Tersimpan");
                }
            }
        } catch (HeadlessException e) {
            System.out.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        TransaksiCreate.transaksiCreateForm = null;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(TransaksiCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiCreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
