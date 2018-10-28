/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import java.util.ArrayList;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;


public class MenuWindow extends javax.swing.JFrame {
    
    private Game game;
    private WindowAddPlayer windowAddPlayer;
    private WindowRanking windowRanking;
    private WindowMatch windowMatch;
    private AudioClip sound;
    
    public MenuWindow(Game aGame) {
        initComponents();
        game = aGame;
        windowAddPlayer = new WindowAddPlayer(aGame);
        windowRanking =  new WindowRanking(aGame);
        windowMatch = new WindowMatch(aGame);
        this.setTransparent();
        
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/menuSound.wav"));
        sound.play();

    }
    
    public void setTransparent(){
        ArrayList jbuttons = new ArrayList<>();
        jbuttons.add(btnAddPlayer);
        jbuttons.add(btnPlay);
        jbuttons.add(btnRanking);
        jbuttons.add(btnExit);
        jbuttons.add(btnSound);
         for (int i = 0; i < jbuttons.size(); i++) {
              JButton buttonAux = (JButton) jbuttons.get(i);
              buttonAux.setOpaque(false);
              buttonAux.setContentAreaFilled(false);
              buttonAux.setBorderPainted(false);
           }
    }

    public void playMusic(){
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/menuSound.wav"));
        sound.play();
    }
    
    public void stopMusic(){
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/menuSound.wav"));
        sound.stop();
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
        btnSound = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1907, 958));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sumIcon-img.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
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
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        btnRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ranking-img.png"))); // NOI18N
        btnRanking.setText("  Ranking");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
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

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        jPanel1.add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 600, -1, -1));

        jLabel2.setFont(new java.awt.Font("ChalkDust", 0, 70)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1+1=2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("ChalkDust", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("23+7=30");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("ChalkDust", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X+Y=Z");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/OGA3KP0_1.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        windowAddPlayer.setVisible(true);
    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        windowMatch.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        windowRanking.setVisible(true);
    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
      
        if(btnSound.getIcon().toString().equals(iconOn.toString())){
            btnSound.setIcon(iconOff);
            sound.stop();
        }else{
            btnSound.setIcon(iconOn);
            sound.play();
        }
        
    }//GEN-LAST:event_btnSoundActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    }//GEN-LAST:event_jLabel1MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
