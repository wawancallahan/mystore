/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.admin_gudang.barang;

/**
 *
 * @author Timy
 */



import Lib.BarangLib;
import Lib.LoginInformation;
import Model.Barang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class BarangForm extends javax.swing.JFrame {
    
    protected Barang barangModel;
    protected BarangCreate barangCreateForm;
    
    private static BarangForm barangIndexForm = null;
    
    /**
     * Creates new form BarangForm
     */
    public BarangForm() {
        initComponents();
        
        barangModel = new Barang();
        
        this.fillTable();
        
        if (LoginInformation.type != null) {
            switch (LoginInformation.type) {
            case "Admin Kasir":
                    btnEdit.setVisible(false);
                    btnHapus.setVisible(false);
                break;
            }
        }
    }
    
    public static BarangForm showForm() {
        if (barangIndexForm == null) {
            barangIndexForm = new BarangForm();
        }
        
        return barangIndexForm;
    }
    
    public void fillTable() {
        try {
            
            Object[] column = new String[]{"id", "#", "Nama", "Jenis", "Harga", "Qty"};

            Object[][] data = new Object[][]{
            };
            
            DefaultTableModel model = new DefaultTableModel(data, column){

                @Override
                    public boolean isCellEditable(int row, int col){
                            return false;
                    }
            };

            List<BarangLib> barangObject = this.barangModel.getItems();
            model.setRowCount(0);
            
            if (barangObject != null) {
                int index = 0;

                for (BarangLib item : barangObject) {
                    index++;

                    Object[] rowData = new Object[] {
                       item.getId(),
                       String.valueOf(index),
                       item.getNama(),
                       item.getJenis(),
                       item.getHarga(),
                       item.getQty()
                    };

                    model.addRow(rowData);
                }
            }

            this.table.setModel(model);
            this.table.getColumnModel().getColumn(0).setMinWidth(0);
            this.table.getColumnModel().getColumn(0).setMaxWidth(0);
            this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
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
        txtCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 390, -1));

        jLabel1.setText("Pencarian");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

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
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 390, 320));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, -1));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        BarangCreate.showForm().setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        final int rowIndex = table.getSelectedRow();
        
        if (rowIndex != -1) {
            final Integer id = Integer.valueOf(table.getValueAt(rowIndex, 0).toString());
        
            boolean deleteRow = this.barangModel.delete(id);

            if (deleteRow) {
                this.fillTable();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan Proses Hapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            
            return;
        }
        
        JOptionPane.showMessageDialog(rootPane, "Data Belum Terpilih", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        BarangForm.barangIndexForm = null;
    }//GEN-LAST:event_formWindowClosing

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        final int rowIndex = table.getSelectedRow();
        
        if (rowIndex != -1) {
            final Integer id = Integer.valueOf(table.getValueAt(rowIndex, 0).toString());

            BarangEdit.showForm(id).setVisible(true);
            
            return;
        }
        
        JOptionPane.showMessageDialog(rootPane, "Data Belum Terpilih", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}