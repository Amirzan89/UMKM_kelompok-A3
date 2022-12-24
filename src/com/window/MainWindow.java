package com.window;

import com.data.db.Database;
import com.manage.Message;
import com.media.Audio;
import com.media.Gambar;
import com.users.Karyawan;
import com.users.Users;
import com.window.dialogs.ConfirmLogout;
import com.window.panels.DataBarang;
import com.window.panels.DataSupplier;
import com.window.panels.LaporanBeli;
import com.window.panels.LaporanJual;
import com.window.panels.TransaksiBeli;
import com.window.panels.TransaksiJual;
import com.window.panels.Dashboard;
import com.window.panels.DataKaryawan;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Achmad Baihaqi
 */
public class MainWindow extends javax.swing.JFrame {

    private final Karyawan karyawan = new Karyawan();
    private final Users user = new Users();
    private final Database db = new Database();

    private JLabel activated;

    private JLabel[] btns;

    public MainWindow() throws ParseException {
        initComponents();
        this.setTitle("Dashboard");
        this.setIconImage(Gambar.getWindowIcon());
//        this.setExtendedState(this.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.lblNamaUser.setText(this.karyawan.getIdKaryawan(this.user.getCurrentLogin()));
        this.btns = new JLabel[]{
            this.btnDashboard, this.btnSupplier, this.btnBarang, this.btnKaryawan,
            this.btnTrJual, this.btnTrBeli, this.btnLpJual, this.btnLpBeli, this.btnLogout
        };
        this.activated = this.btnDashboard;

        // reset window
        this.pnlMenu.removeAll();
        this.pnlMenu.repaint();
        this.pnlMenu.revalidate();
        // menampilkan ulang
        this.pnlMenu.add(new com.window.panels.Dashboard());
        this.pnlMenu.repaint();
        this.pnlMenu.revalidate();

        this.setActivatedButton(btnDashboard);
        this.hoverButton(btns);
        this.setResizable(false);
    }
    //digunakan untuk mengubah icon button yang aktif
    private void setActivatedButton(JLabel activated) {
        this.activated = activated;
        // set menjadi activated
        activated.setIcon(Gambar.getAktiveIcon(activated.getIcon().toString()));
        // mereset warna button/label
        for (JLabel btn : btns) {
            if (btn != this.activated) {
                if (Gambar.isAktifIcon(btn.getIcon().toString())) {
                    btn.setIcon(Gambar.getBiasaIcon(btn.getIcon().toString()));
                }
            }
        }
    }

    //digunakan untuk mengubah icon button yang di hover
    private void hoverButton(JLabel[] btns) {

        for (JLabel btn : btns) {
            btn.addMouseListener(new java.awt.event.MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mousePressed(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (btn != activated) {
                        btn.setIcon(Gambar.getHoverIcon(btn.getIcon().toString()));
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (btn != activated) {
                        btn.setIcon(Gambar.getBiasaIcon(btn.getIcon().toString()));
                    }
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblNamaUser = new javax.swing.JLabel();
        btnBarang = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        btnKaryawan = new javax.swing.JLabel();
        btnSupplier = new javax.swing.JLabel();
        btnTrBeli = new javax.swing.JLabel();
        btnTrJual = new javax.swing.JLabel();
        btnLpJual = new javax.swing.JLabel();
        btnLpBeli = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 990, -1));

        lblNamaUser.setForeground(new java.awt.Color(0, 0, 0));
        lblNamaUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblNamaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 50, 50, 16));

        btnBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-dataBarang-075.png"))); // NOI18N
        btnBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBarangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBarangMouseEntered(evt);
            }
        });
        pnlMain.add(btnBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 170, -1, -1));

        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-Dashboard-075.png"))); // NOI18N
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        pnlMain.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 105, -1, -1));

        btnKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-dataKaryawan-075.png"))); // NOI18N
        btnKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKaryawanMouseClicked(evt);
            }
        });
        pnlMain.add(btnKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 235, -1, -1));

        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-dataSupplier-075.png"))); // NOI18N
        btnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierMouseClicked(evt);
            }
        });
        pnlMain.add(btnSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 300, -1, -1));

        btnTrBeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-Transaksi-beli-075.png"))); // NOI18N
        btnTrBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrBeliMouseClicked(evt);
            }
        });
        pnlMain.add(btnTrBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 365, -1, -1));

        btnTrJual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-Transaksi-jual-075.png"))); // NOI18N
        btnTrJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrJualMouseClicked(evt);
            }
        });
        pnlMain.add(btnTrJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 430, -1, -1));

        btnLpJual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-Laporan-pemasukan-075.png"))); // NOI18N
        btnLpJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLpJualMouseClicked(evt);
            }
        });
        pnlMain.add(btnLpJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 495, -1, -1));

        btnLpBeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-Laporan-pengeluaran-075.png"))); // NOI18N
        btnLpBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLpBeliMouseClicked(evt);
            }
        });
        pnlMain.add(btnLpBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 570, -1, -1));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar_icon/sidebar-logout-075.png"))); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        pnlMain.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 80, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/gambar/app-mainWindow-075.png"))); // NOI18N
        pnlMain.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1));

        jScrollPane1.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBarangMouseClicked
        //jika btn barang di klik
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.setTitle("Data Barang");
        this.setActivatedButton(this.btnBarang);
        // menghapus panel lama
        db.closeConnection();
        pnlMenu.removeAll();
        pnlMenu.repaint();
        pnlMenu.revalidate();

        db.startConnection();
        // menambahkan panel baru
        pnlMenu.add(new DataBarang());
        pnlMenu.repaint();
        pnlMenu.revalidate();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBarangMouseClicked

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            this.setTitle("Dashboard");
            this.setActivatedButton(this.btnDashboard);

            // menghaspus panel lama
            db.closeConnection();
            pnlMenu.removeAll();
            pnlMenu.repaint();
            pnlMenu.revalidate();

            // menambahkan panel baru
            db.startConnection();
            pnlMenu.add(new com.window.panels.Dashboard());
            pnlMenu.repaint();
            pnlMenu.revalidate();
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } catch (ParseException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKaryawanMouseClicked
        if(this.user.isAdmin()){
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
        this.setTitle("Data Karyawan");
        this.setActivatedButton(this.btnKaryawan);

        // menghapus panel lama
        db.closeConnection();
        pnlMenu.removeAll();
        pnlMenu.repaint();
        pnlMenu.revalidate();

        // menambahkan panel baru
        db.startConnection();
        pnlMenu.add(new DataKaryawan());
        pnlMenu.repaint();
        pnlMenu.revalidate();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }else{
            Message.showWarning(this, "Anda bukan Admin !");
        }
    }//GEN-LAST:event_btnKaryawanMouseClicked

    private void btnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.setTitle("Data Supplier");
        this.setActivatedButton(this.btnSupplier);
        // menghapus panel lama
        db.closeConnection();
        pnlMenu.removeAll();
        pnlMenu.repaint();
        pnlMenu.revalidate();

        // menambahkan panel baru
        db.startConnection();
        pnlMenu.add(new DataSupplier());
        pnlMenu.repaint();
        pnlMenu.revalidate();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSupplierMouseClicked

    private void btnTrBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrBeliMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.setTitle("Transaksi Beli");
        this.setActivatedButton(this.btnTrBeli);

        // menghapus panel lama
//        
        pnlMenu.removeAll();
        pnlMenu.repaint();
        pnlMenu.revalidate();

        // menambahkan panel baru
        pnlMenu.add(new TransaksiBeli());
        pnlMenu.repaint();
        pnlMenu.revalidate();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnTrBeliMouseClicked

    private void btnTrJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrJualMouseClicked
        //        this.lblMenuName.setText("Transaksi Jual");
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.setTitle("Transaksi Jual");
        this.setActivatedButton(this.btnTrJual);

        // menghapus panel lama
        pnlMenu.removeAll();
        pnlMenu.repaint();
        pnlMenu.revalidate();

        // menambahkan panel baru
        pnlMenu.add(new TransaksiJual());
        pnlMenu.repaint();
        pnlMenu.revalidate();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrJualMouseClicked

    private void btnLpJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLpJualMouseClicked
        try {
            if(this.user.isAdmin()){
                
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            this.setTitle("Laporan Jual");
            this.setActivatedButton(this.btnLpJual);

            // menghapus panel lama
            pnlMenu.removeAll();
            pnlMenu.repaint();
            pnlMenu.revalidate();

            // menambahkan panel baru
            pnlMenu.add(new LaporanJual());
            pnlMenu.repaint();
            pnlMenu.revalidate();
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }else{
                Message.showWarning(this, "Anda bukan Admin !");
            }
        } catch (ParseException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLpJualMouseClicked

    private void btnLpBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLpBeliMouseClicked
        try {
            if(this.user.isAdmin()){
                
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            this.setTitle("Laporan Beli");
            this.setActivatedButton(this.btnLpBeli);

            // menghapus panel lama
            pnlMenu.removeAll();
            pnlMenu.repaint();
            pnlMenu.revalidate();

            // menambahkan panel baru
            pnlMenu.add(new LaporanBeli());
            pnlMenu.repaint();
            pnlMenu.revalidate();
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }else{
                Message.showWarning(this, "Anda bukan Admin!");
            }
        } catch (ParseException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLpBeliMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        Audio.play(Audio.SOUND_WARNING);
        new ConfirmLogout(this, true).setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBarangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBarangMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel btnBarang;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnKaryawan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnLpBeli;
    private javax.swing.JLabel btnLpJual;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btnTrBeli;
    private javax.swing.JLabel btnTrJual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
