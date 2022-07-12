/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkkp;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author timot
 */
public class TransaksiTes extends javax.swing.JFrame {
    Connection Con;
    ResultSet RsBrg;
    Statement stm;
    
    Boolean ada = false;
    Boolean edit= false;
    
    private Object[][] dataTable = null;
    private String[] header = {"No Peserta","Nama Peserta","Nilai Tertulis","Nilai Wawancara","Nilai Akhir"};

    /**
     * Creates new form TransaksiTes
     */
    public TransaksiTes() {
        setTitle("Seleksi Tertulis dan Wawancara");
        initComponents();
        open_db();
        baca_data();
        kosong();
        aktif(false);
        setTombol(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNoPst = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNmPst = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTertulis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtWawancara = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAkhir = new javax.swing.JTextField();
        cmdTambah = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        cmdKoreksi = new javax.swing.JButton();
        cmdHapus = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHasil = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        cmdCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleksi Tes Tertulis & Wawancara");

        jLabel2.setText("No Peserta");

        jLabel3.setText("Nama Peserta");

        jLabel4.setText("Nilai Tes Tertulis");

        jLabel5.setText("Nilai Tes Wawancara");

        jLabel6.setText("Nilai Akhir");

        txtAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAkhirActionPerformed(evt);
            }
        });

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        cmdKoreksi.setText("Koreksi");
        cmdKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKoreksiActionPerformed(evt);
            }
        });

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdKeluar.setText("Keluar");
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        tblHasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No Peserta", "Nama Peserta", "Nilai Tertulis", "Nilai Wawancara", "Nilai Akhir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHasilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHasil);

        text.setColumns(20);
        text.setRows(5);
        jScrollPane2.setViewportView(text);

        cmdCetak.setText("Cetak");
        cmdCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdKoreksi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoPst)
                            .addComponent(txtNmPst)
                            .addComponent(txtTertulis)
                            .addComponent(txtWawancara)
                            .addComponent(txtAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNoPst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNmPst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTertulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtWawancara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTambah)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdKoreksi)
                    .addComponent(cmdHapus)
                    .addComponent(cmdBatal)
                    .addComponent(cmdKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(cmdCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAkhirActionPerformed
        // TODO add your handling code here:
        hitung_akhir();
    }//GEN-LAST:event_txtAkhirActionPerformed

    private void tblHasilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHasilMouseClicked
        // TODO add your handling code here:
        setField();
    }//GEN-LAST:event_tblHasilMouseClicked

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        // TODO add your handling code here:
        aktif2(true);
        setTombol(false);
        kosong();
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cmdKeluarActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        // TODO add your handling code here:
        aktif(false);
        setTombol(true);
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "delete from tes where no_peserta='" + txtNoPst.getText() + "'";
            stm.executeUpdate(sql);
            baca_data();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmdHapusActionPerformed

    private void cmdKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKoreksiActionPerformed
        // TODO add your handling code here:
        edit = true;
        aktif(true);
        setTombol(false);
        txtNoPst.setEditable(false);
        txtAkhir.setEditable(false);
    }//GEN-LAST:event_cmdKoreksiActionPerformed

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
        // TODO add your handling code here:
        String tNoPeserta=txtNoPst.getText();
        String tNama=txtNmPst.getText();
        String tTertulis=txtTertulis.getText();
        String tWawancara=txtWawancara.getText();
        String tAkhir=txtAkhir.getText();
        try {
            if(edit==true){
                stm.executeUpdate("UPDATE tes " + "SET " + "nm_peserta= '" +tNama + "'," + "tertulis = '" +tTertulis+ "'," + "wawancara = '"+tWawancara+ "'," + "nilai = '" +tAkhir+ "'" + "WHERE " + "no_peserta = '" +tNoPeserta+ "';");
            }else {
                stm.executeUpdate("INSERT into tes VALUES('"+tNoPeserta+"','"+tNama+"','"+tTertulis+"','"+tWawancara+"','"+tAkhir+"')");
            }
            tblHasil.setModel(new DefaultTableModel(dataTable,header));
            baca_data();
            aktif(false);
            setTombol(true);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCetakActionPerformed
        // TODO add your handling code here:
//        String ctk="Nota Pembayaran\nNo :"+txtNoBayar.getText()+"\nTanggal :"+tanggal;
//        ctk=ctk+"\n"+"-------------------------------------------------------------------------------------------------------------------------";
        String ctk = "No Peserta\tNama Peserta\tTertulis\tWawancara\tTotal";
        for(int i = 0;i<tblHasil.getRowCount();i++){
            String xkd=(String)tblHasil.getValueAt(i,0);
            String xnama=(String)tblHasil.getValueAt(i,1);
            String xtertulis=(String)tblHasil.getValueAt(i,2);
            String xwawancara=(String)tblHasil.getValueAt(i,3);
            String xakhir=(String)tblHasil.getValueAt(i,4);
            ctk=ctk+"\n"+xkd+"\t"+xnama+"\t"+xtertulis+"\t"+xwawancara+"\t"+xakhir;
        }
        text.setText(ctk);
        String headerField = "";
        String footerField = "";
        MessageFormat header = new MessageFormat(headerField);
        MessageFormat footer = new MessageFormat(footerField);
        boolean interactive = true;
        //interactiveCheck.isSelected();
        boolean background = true;
        //backgroundCheck.isSelected();
        PrintingTask task = new PrintingTask(header, footer, interactive);
        if(background){
            task.execute();
        } else {
            task.run();
        }
    }//GEN-LAST:event_cmdCetakActionPerformed
    private void open_db(){
        try {
            KoneksiDatabase kon = new KoneksiDatabase("127.0.0.1","root","","pkkp");
            Con = kon.getConnection();
            System.out.println("Berhasil");
        } catch(Exception e) {
            System.out.println("Error : " + e);
        }
    }
    private void baca_data(){
        try {
            stm = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            RsBrg = stm.executeQuery("select * from tes");
            
            ResultSetMetaData meta = RsBrg.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while(RsBrg.next()){
                baris = RsBrg.getRow();
            }
            
            dataTable = new Object[baris][col];
            int x = 0;
            RsBrg.beforeFirst();
            while(RsBrg.next()){
                dataTable[x][0] = RsBrg.getString("no_peserta");
                dataTable[x][1] = RsBrg.getString("nm_peserta");
                dataTable[x][2] = RsBrg.getString("tertulis");
                dataTable[x][3] = RsBrg.getString("wawancara");
                dataTable[x][4] = RsBrg.getString("nilai");
                x++;
            }
            tblHasil.setModel(new DefaultTableModel(dataTable,header));
            RsBrg.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void hitung_akhir(){
        float grade,nilai_tertulis,nilai_wawancara;
        String akhir;
        nilai_tertulis = Float.parseFloat(txtTertulis.getText());
        nilai_wawancara = Float.parseFloat(txtWawancara.getText());
        grade = (nilai_tertulis + nilai_wawancara)/2;
        akhir = Float.toString(grade);
        txtAkhir.setText(akhir);
   }
    private void kosong(){
        txtNoPst.setText("");
        txtNmPst.setText("");
        txtTertulis.setText("");
        txtWawancara.setText("");
        txtAkhir.setText("");
        txtAkhir.setEditable(false);
    }
    private void aktif(boolean x) {
        txtNoPst.setEditable(x);
        txtNmPst.setEditable(x);
        txtTertulis.setEditable(x);
        txtWawancara.setEditable(x);
        txtAkhir.setEditable(x);
    }
    private void aktif2(boolean x) {
        txtNoPst.setEditable(x);
        txtNmPst.setEditable(x);
        txtTertulis.setEditable(x);
        txtWawancara.setEditable(x);
        txtAkhir.setEditable(x);
    }
    private void setTombol(boolean t){
        cmdTambah.setEnabled(t);
        cmdKoreksi.setEnabled(t);
        cmdHapus.setEnabled(t);
        cmdSimpan.setEnabled(!t);
        cmdBatal.setEnabled(!t);
        cmdKeluar.setEnabled(t);
    }
    private void setField(){
        int row = tblHasil.getSelectedRow();
        txtNoPst.setText((String)tblHasil.getValueAt(row,0));
        txtNmPst.setText((String)tblHasil.getValueAt(row,1));
        txtTertulis.setText((String)tblHasil.getValueAt(row,2));
        txtWawancara.setText((String)tblHasil.getValueAt(row,3));
        txtAkhir.setText((String)tblHasil.getValueAt(row,4));
    }
    private class PrintingTask extends SwingWorker<Object, Object> {
        private final MessageFormat headerFormat;
        private final MessageFormat footerFormat;
        private final boolean interactive;
        private volatile boolean complete = false;
        private volatile String message;
        public PrintingTask(MessageFormat header, MessageFormat footer, boolean interactive){
            this.headerFormat = header;
            this.footerFormat = footer;
            this.interactive = interactive;
        }
        @Override
        protected Object doInBackground(){
            try{
                complete = text.print(headerFormat, footerFormat, true, null, null, interactive);
                message = "Printing " + (complete ? "complete" : "canceled");
            } catch (PrinterException ex){
                message = "Sorry, a printer error occured";
            } catch (SecurityException ex) {
                message = "Sorry, cannot access the printer due to security";
            }
            return null;
        }
        @Override
        protected void done(){
            message(!complete, message);
        }
        private void message(boolean b, String message){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
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
            java.util.logging.Logger.getLogger(TransaksiTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiTes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdCetak;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdKoreksi;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHasil;
    private javax.swing.JTextArea text;
    private javax.swing.JTextField txtAkhir;
    private javax.swing.JTextField txtNmPst;
    private javax.swing.JTextField txtNoPst;
    private javax.swing.JTextField txtTertulis;
    private javax.swing.JTextField txtWawancara;
    // End of variables declaration//GEN-END:variables
}
