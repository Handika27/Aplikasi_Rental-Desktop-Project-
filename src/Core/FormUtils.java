package Desain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class FormUtils {

    public static void formatFrame(JInternalFrame frame) {
        // 1. Warna Hijau Terang (Toska) untuk semua Form Internal
        Color hijauTerang = new Color(0, 210, 196);

        // 2. Hilangkan Header Abu-abu bawaan Windows
        if (frame.getUI() instanceof BasicInternalFrameUI) {
            BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
            ui.setNorthPane(null);
        }

        // 3. Hilangkan Border bawaan
        frame.setBorder(null);

        // 4. PADDING / MARGIN DALAM (Atas: 20px, Kiri: 20px, Bawah: 25px, Kanan: 20px)
        // Kunci utama agar konten/tabel TIDAK MENEMPEL ke tepi luar
        ((JComponent) frame.getContentPane()).setBorder(
            BorderFactory.createEmptyBorder(20, 20, 25, 20)
        );

        // 5. Set Background Hijau Terang
        frame.getContentPane().setBackground(hijauTerang);

        // 6. Samakan warna seluruh JPanel di dalamnya
        UbahWarnaPanel(frame.getContentPane(), hijauTerang);

        frame.revalidate();
        frame.repaint();
    }

    private static void UbahWarnaPanel(Component comp, Color warna) {
        if (comp instanceof JPanel) {
            comp.setBackground(warna);
        }
        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                UbahWarnaPanel(child, warna);
            }
        }
    }
}