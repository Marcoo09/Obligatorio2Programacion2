/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Domains.Game;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MenuWindow extends javax.swing.JFrame {
    
    private Game game;
    
    public MenuWindow(Game aGame) {
        initComponents();
        game = aGame;
        this.setLocationRelativeTo(null);
        this.setTransparent();
    }
    
    public void setTransparent(){
        ArrayList jbuttons = new ArrayList<>();
        jbuttons.add(btnAddPlayer);
        jbuttons.add(btnPlay);
        jbuttons.add(btnRanking);
        jbuttons.add(btnExit);
           for (int i = 0; i < jbuttons.size(); i++) {
              JButton buttonAux = (JButton) jbuttons.get(i);
              buttonAux.setOpaque(false);
              buttonAux.setContentAreaFilled(false);
              buttonAux.setBorderPainted(false);
           }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddPlayer = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        LblSound = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1907, 958));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sumIcon-img.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Snubnose DEMO", 0, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Juego de las Sumas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        btnAddPlayer.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnAddPlayer.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user-img.png"))); // NOI18N
        btnAddPlayer.setText(" Agregar Jugador");
        btnAddPlayer.setActionCommand("Agregar Jugador");
        btnAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        btnPlay.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/controller-img.png"))); // NOI18N
        btnPlay.setText("  Jugar Partida");
        jPanel1.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        btnRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ranking-img.png"))); // NOI18N
        btnRanking.setText("  Ranking");
        jPanel1.add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 220, -1));

        btnExit.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit-img.png"))); // NOI18N
        btnExit.setText("  Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, -1, -1));

        LblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        LblSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblSoundMouseClicked(evt);
            }
        });
        jPanel1.add(LblSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/background-img.jpeg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void LblSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblSoundMouseClicked
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        LblSound.setIcon(iconOff);
    }//GEN-LAST:event_LblSoundMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblSound;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRanking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
