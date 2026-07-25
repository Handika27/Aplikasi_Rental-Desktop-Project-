package Desain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;

public class FrPreview extends javax.swing.JDialog {

    private JTable tblPreview;
    private JPanel pnlKertas;
    private JComboBox<String> cbOrientasi;
    private JButton btnCetak;

    public FrPreview(Frame parent, DefaultTableModel modelTabel) {
        super(parent, "Preview Laporan & Pengaturan Cetak", true);
        initComponentsCustom(modelTabel);
    }

    private void initComponentsCustom(DefaultTableModel modelTabel) {
        // --- PENGATURAN UKURAN WINDOW (SESUAI REQUEST: 800 x 500) ---
        setSize(800, 500);
        setPreferredSize(new Dimension(800, 500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- 1. PANEL KONTROL / ATAS ---
        JPanel pnlControl = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlControl.setBackground(new Color(240, 240, 240));

        pnlControl.add(new JLabel("Orientasi Kertas:"));
        cbOrientasi = new JComboBox<>(new String[]{"Landscape", "Portrait"});
        pnlControl.add(cbOrientasi);

        btnCetak = new JButton("🖨️ CETAK / SIMPAN PDF");
        btnCetak.setBackground(new Color(0, 150, 136));
        btnCetak.setForeground(Color.WHITE);
        btnCetak.setFont(new Font("Tahoma", Font.BOLD, 12));
        pnlControl.add(btnCetak);

        add(pnlControl, BorderLayout.NORTH);

        // --- 2. PANEL SIMULASI KERTAS / TENGAH ---
        JPanel pnlContainer = new JPanel(new GridBagLayout()); // Menjaga kertas tetap di tengah
        pnlContainer.setBackground(new Color(180, 180, 180));

        pnlKertas = new JPanel(new BorderLayout(10, 10));
        pnlKertas.setBackground(Color.WHITE);
        pnlKertas.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Judul Laporan di Kertas Preview
        JLabel lblJudul = new JLabel("LAPORAN RIWAYAT TRANSAKSI SEWA KENDARAAN", JLabel.CENTER);
        lblJudul.setFont(new Font("Tahoma", Font.BOLD, 14));
        pnlKertas.add(lblJudul, BorderLayout.NORTH);

        // Tabel Preview
        tblPreview = new JTable(modelTabel);
        tblPreview.setEnabled(false); // Hanya untuk tampilan preview
        tblPreview.setRowHeight(22);
        
        JScrollPane spTabel = new JScrollPane(tblPreview);
        pnlKertas.add(spTabel, BorderLayout.CENTER);

        pnlContainer.add(pnlKertas);

        JScrollPane spUtama = new JScrollPane(pnlContainer);
        add(spUtama, BorderLayout.CENTER);

        // --- 3. EVENT HANDLER ---
        cbOrientasi.addActionListener(e -> sesuaikanUkuranKertas());
        btnCetak.addActionListener(e -> prosesCetak());

        // Set awal ke Landscape
        sesuaikanUkuranKertas();
    }

    // Mengubah bentuk kertas visual secara otomatis di layar agar pas di window 800x500
    private void sesuaikanUkuranKertas() {
        String orientasi = cbOrientasi.getSelectedItem().toString();
        if (orientasi.equalsIgnoreCase("Landscape")) {
            pnlKertas.setPreferredSize(new Dimension(710, 370)); // Disesuaikan agar proporsional di window 800x500
        } else {
            pnlKertas.setPreferredSize(new Dimension(500, 600));
        }
        pnlKertas.revalidate();
        pnlKertas.repaint();
    }

    // Proses Pencetakan dengan Kunci Orientasi Presisi
    private void prosesCetak() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            PageFormat pf = job.defaultPage();

            // Paksa orientasi kertas ke PrinterJob agar tidak miring di PDF
            if (cbOrientasi.getSelectedItem().toString().equalsIgnoreCase("Landscape")) {
                pf.setOrientation(PageFormat.LANDSCAPE);
            } else {
                pf.setOrientation(PageFormat.PORTRAIT);
            }

            MessageFormat header = new MessageFormat("LAPORAN RIWAYAT TRANSAKSI SEWA KENDARAAN");
            MessageFormat footer = new MessageFormat("Halaman {0,number,integer}");

            // Hubungkan Printable JTable dengan PageFormat
            job.setPrintable(tblPreview.getPrintable(
                    JTable.PrintMode.FIT_WIDTH, header, footer
            ), pf);

            if (job.printDialog()) {
                job.print();
                JOptionPane.showMessageDialog(this, "Proses Cetak / Simpan PDF Selesai!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Mencetak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}