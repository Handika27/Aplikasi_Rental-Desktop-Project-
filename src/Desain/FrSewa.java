/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Desain;

/**
 *
 * @author DIKA
 */
public class FrSewa extends javax.swing.JInternalFrame {
    int hargaPerHariTemp = 0;
    public FrSewa() {
        initComponents();

        // 1. CUKUP 1 BARIS INI (Format frame & hilangkan header/border)
        Desain.FormUtils.formatFrame(this);
         // 3. TAMBAHKAN MARGIN BAWAH (Atas: 0, Kiri: 0, Bawah: 35px, Kanan: 0)
    ((javax.swing.JComponent) getContentPane()).setBorder(
        javax.swing.BorderFactory.createEmptyBorder(5, 15, 20, 15)
    );

        // 2. Load data saat form dibuka
        loadPelanggan();
        loadKendaraan();
        tampilTable();
        setTanggalOtomatis();

        // 3. Listener hitung total harga real-time saat durasi diketik
        txtDurasi.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { hitungTotal(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { hitungTotal(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { hitungTotal(); }
        });
    }

    // 1. Mengisi Tanggal Otomatis hari ini (Format: YYYY-MM-DD)
    // Tanggal terisi otomatis hari ini, tapi TIDAK DIKUNCI (bisa diedit/diubah)
    private void setTanggalOtomatis() {
        dcTglSewa.setDate(new java.util.Date());
    }

    // 2. Load Pelanggan ke ComboBox
    private void loadPelanggan() {
        try {
            java.sql.Connection conn = new myConnection.DB0().getConnection();
            java.sql.Statement st = conn.createStatement();
            String sql = "SELECT * FROM tb_pelanggan";
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            cbPelanggan.removeAllItems();
            cbPelanggan.addItem("-- Pilih Pelanggan --");
            while (rs.next()) {
                cbPelanggan.addItem(rs.getString("nik") + " - " + rs.getString("nama_pelanggan"));
            }
        } catch (Exception e) {
            System.out.println("Error load pelanggan: " + e.getMessage());
        }
    }

    // 3. Load Kendaraan yang Tersedia
    private void loadKendaraan() {
        try {
            java.sql.Connection conn = new myConnection.DB0().getConnection();
            java.sql.Statement st = conn.createStatement();
            String sql = "SELECT * FROM tb_kendaraan WHERE status = 'Tersedia'";
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            cbKendaraan.removeAllItems();
            cbKendaraan.addItem("-- Pilih Kendaraan --");
            while (rs.next()) {
                String info = rs.getString("merk_kendaraan") + " (" + rs.getString("nopol") + ") - Rp " + rs.getInt("harga_sewa");
                cbKendaraan.addItem(info);
            }
        } catch (Exception e) {
            System.out.println("Error load kendaraan: " + e.getMessage());
        }
    }

    // 4. Hitung Total Harga Otomatis Berdasarkan Harga Mobil × Durasi
    // Method untuk hitung harga otomatis sekaligus memproses durasi tanggal
    private void hitungTotal() {
        try {
            if (cbKendaraan.getSelectedIndex() > 0 && !txtDurasi.getText().isEmpty() && dcTglSewa.getDate() != null) {
                // 1. Hitung Total Harga
                String selected = cbKendaraan.getSelectedItem().toString();
                String hargaStr = selected.substring(selected.indexOf("Rp ") + 3);
                int hargaSewa = Integer.parseInt(hargaStr);
                int durasi = Integer.parseInt(txtDurasi.getText());
                
                int total = hargaSewa * durasi;
                txtTotalHarga.setText(String.valueOf(total));
                
            } else {
                txtTotalHarga.setText("");
            }
        } catch (Exception e) {
            txtTotalHarga.setText("");
        }
    }

    // 5. Menampilkan Data ke Tabel Bawah
    private void tampilTable() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("ID Sewa");
        model.addColumn("NIK");
        model.addColumn("Nopol");
        model.addColumn("Tgl Sewa");
        model.addColumn("Durasi");
        model.addColumn("Total Harga");
        model.addColumn("Status");
        
        try {
            java.sql.Connection conn = new myConnection.DB0().getConnection();
            java.sql.Statement st = conn.createStatement();
            String sql = "SELECT * FROM tb_sewa";
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_sewa"),
                    rs.getString("nik"),
                    rs.getString("nopol"),
                    rs.getString("tgl_sewa"),
                    rs.getString("durasi"),
                    rs.getString("total_harga"),
                    rs.getString("status_sewa")
                });
            }
            // Ganti tbSewa dengan nama variabel tabel Anda jika berbeda (misal jTable1)
            tbSewa.setModel(model); 
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat tabel: " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbPelanggan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbKendaraan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDurasi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSewa = new javax.swing.JTable();
        dcTglSewa = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Tanggal Sewa  :");

        jLabel2.setText("Pilih Pelanggan :");

        cbPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Kendaraan  :");

        cbKendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Durasi(Hari) :");

        txtDurasi.addActionListener(this::txtDurasiActionPerformed);
        txtDurasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDurasiKeyReleased(evt);
            }
        });

        jLabel5.setText("Total Harga :");

        txtTotalHarga.setEditable(false);

        tbSewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSewaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSewa);

        jPanel1.setOpaque(false);

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(this::btnHapusActionPerformed);
        jPanel1.add(btnHapus);

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        jPanel1.add(btnUpdate);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(this::btnClearActionPerformed);
        jPanel1.add(btnClear);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);
        jPanel1.add(btnSimpan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbKendaraan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dcTglSewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDurasi, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalHarga)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)))
                            .addComponent(cbPelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcTglSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurasiActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
  try {
    // Validasi Form Kosong
    if (cbPelanggan.getSelectedIndex() == 0 || cbKendaraan.getSelectedIndex() == 0 || txtDurasi.getText().isEmpty() || dcTglSewa.getDate() == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Silakan lengkapi data transaksi terlebih dahulu!");
        return;
    }

    // 1. Format Tanggal Murni untuk MySQL (YYYY-MM-DD)
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String strTglMulai = sdf.format(dcTglSewa.getDate());

    // 2. Ambil NIK dan Nopol
    String selectedPelanggan = cbPelanggan.getSelectedItem().toString();
    String nik = selectedPelanggan.split(" - ")[0].trim();

    String selectedKendaraan = cbKendaraan.getSelectedItem().toString();
    String nopol = selectedKendaraan.substring(selectedKendaraan.indexOf("(") + 1, selectedKendaraan.indexOf(")")).trim();

    String idSewa = "SWR" + (System.currentTimeMillis() % 10000); 
    int durasiHari = Integer.parseInt(txtDurasi.getText());
    int totalHarga = Integer.parseInt(txtTotalHarga.getText());

    // 3. Query INSERT yang Valid untuk MySQL
    String sqlSewa = "INSERT INTO tb_sewa (id_sewa, nik, nopol, tgl_sewa, durasi, total_harga, status_sewa) VALUES ('"
            + idSewa + "', '" + nik + "', '" + nopol + "', '" + strTglMulai + "', " + durasiHari + ", " + totalHarga + ", 'Sedang Disewa')";
    
    // Eksekusi DML
    Core.DML.EQuery(sqlSewa);

    // 4. Update status kendaraan di tabel tb_kendaraan
    String sqlUpdate = "UPDATE tb_kendaraan SET status = 'Tidak Tersedia' WHERE nopol = '" + nopol + "'";
    Core.DML.EQuery(sqlUpdate);

    // Pesan Sukses
    javax.swing.JOptionPane.showMessageDialog(this, "Transaksi Sewa Berhasil Disimpan!");
    
    // 5. Reset Inputan Form
    txtDurasi.setText("");
    txtTotalHarga.setText("");
    cbPelanggan.setSelectedIndex(0);
    cbKendaraan.setSelectedIndex(0);
    dcTglSewa.setDate(new java.util.Date());
    
    // 6. Refresh Tabel & Dropdown Kendaraan
    tampilTable();     
    loadKendaraan();   

} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
    e.printStackTrace();
}      // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
     dcTglSewa.setDate(new java.util.Date());
    cbPelanggan.setSelectedIndex(0);
    cbKendaraan.setSelectedIndex(0);
    txtDurasi.setText("");
    txtTotalHarga.setText("");
    tbSewa.clearSelection();   // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
     int row = tbSewa.getSelectedRow();
    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Pilih transaksi pada tabel yang ingin dihapus/dibatalkan!");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
            "Membatalkan transaksi ini akan mengembalikan status kendaraan menjadi 'Tersedia'. Lanjutkan?", 
            "Konfirmasi Hapus Transaksi", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        try {
            String idSewa = tbSewa.getValueAt(row, 0).toString();
            String nopol = tbSewa.getValueAt(row, 2).toString();

            // 1. Hapus transaksi dari tb_sewa
            String sqlDelete = "DELETE FROM tb_sewa WHERE id_sewa = '" + idSewa + "'";
            Core.DML.EQuery(sqlDelete);

            // 2. Kembalikan status kendaraan menjadi Tersedia
            String sqlUpdateKendaraan = "UPDATE tb_kendaraan SET status = 'Tersedia' WHERE nopol = '" + nopol + "'";
            Core.DML.EQuery(sqlUpdateKendaraan);

            javax.swing.JOptionPane.showMessageDialog(this, "Transaksi Sewa Berhasil Dihapus & Status Kendaraan Kembali Tersedia!");

            btnClearActionPerformed(evt);
            tampilTable();
            loadKendaraan(); // Refresh pilihan kendaraan pada ComboBox
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus transaksi: " + e.getMessage());
        }
    }   // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tbSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSewaMouseClicked
    int row = tbSewa.getSelectedRow();
    if (row != -1) {
        try {
            String idSewa = tbSewa.getValueAt(row, 0).toString();
            String nik = tbSewa.getValueAt(row, 1).toString();
            String tglStr = tbSewa.getValueAt(row, 3).toString();
            int durasi = Integer.parseInt(tbSewa.getValueAt(row, 4).toString());
            int totalHarga = Integer.parseInt(tbSewa.getValueAt(row, 5).toString());

            // 1. Hitung harga per hari mobil dari transaksi ini
            hargaPerHariTemp = totalHarga / durasi;

            // 2. Set Tanggal
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            dcTglSewa.setDate(sdf.parse(tglStr));

            // 3. Set ComboBox Pelanggan
            for (int i = 0; i < cbPelanggan.getItemCount(); i++) {
                if (cbPelanggan.getItemAt(i).toString().startsWith(nik)) {
                    cbPelanggan.setSelectedIndex(i);
                    break;
                }
            }

            // 4. Set Durasi dan Total Harga ke TextField
            txtDurasi.setText(String.valueOf(durasi));
            txtTotalHarga.setText(String.valueOf(totalHarga));

        } catch (Exception e) {
            System.out.println("Error klik tabel: " + e.getMessage());
        }
    }   // TODO add your handling code here:
    }//GEN-LAST:event_tbSewaMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      int row = tbSewa.getSelectedRow();
    
    // Validasi apakah pengguna sudah memilih baris di tabel
    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Pilih transaksi dari tabel yang ingin di-update terlebih dahulu!");
        return;
    }

    try {
        // Ambil ID Sewa dari baris yang sedang dipilih di tabel
        String idSewa = tbSewa.getValueAt(row, 0).toString();

        // Format Tanggal untuk MySQL (YYYY-MM-DD)
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String strTglMulai = sdf.format(dcTglSewa.getDate());

        int durasiHari = Integer.parseInt(txtDurasi.getText());
        int totalHarga = Integer.parseInt(txtTotalHarga.getText());

        // Query UPDATE data transaksi
        String sqlUpdate = "UPDATE tb_sewa SET "
                + "tgl_sewa = '" + strTglMulai + "', "
                + "durasi = " + durasiHari + ", "
                + "total_harga = " + totalHarga + " "
                + "WHERE id_sewa = '" + idSewa + "'";

        Core.DML.EQuery(sqlUpdate);

        javax.swing.JOptionPane.showMessageDialog(this, "Data Transaksi Sewa Berhasil Di-update!");

        // Reset form input & Refresh tabel
        btnClearActionPerformed(evt);
        tampilTable();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal meng-update data: " + e.getMessage());
        e.printStackTrace();
    }  // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtDurasiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDurasiKeyReleased
    try {
        if (!txtDurasi.getText().isEmpty()) {
            int durasi = Integer.parseInt(txtDurasi.getText());
            int hargaPerHari = 0;

            // Jika ComboBox Kendaraan dipilih, ambil dari ComboBox
            if (cbKendaraan.getSelectedIndex() > 0) {
                String selected = cbKendaraan.getSelectedItem().toString();
                String strHarga = selected.substring(selected.lastIndexOf("Rp ") + 3).trim();
                hargaPerHari = Integer.parseInt(strHarga);
            } else {
                // Jika ComboBox kosong (mode Update transaksi), pakai harga temp
                hargaPerHari = hargaPerHariTemp;
            }

            // Hitung Total Harga Baru
            txtTotalHarga.setText(String.valueOf(hargaPerHari * durasi));
        } else {
            txtTotalHarga.setText("");
        }
    } catch (Exception e) {
        txtTotalHarga.setText("");
    }   // TODO add your handling code here:
    }//GEN-LAST:event_txtDurasiKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbKendaraan;
    private javax.swing.JComboBox<String> cbPelanggan;
    private com.toedter.calendar.JDateChooser dcTglSewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbSewa;
    private javax.swing.JTextField txtDurasi;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
