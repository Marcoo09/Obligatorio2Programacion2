/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import controllers.serializeUtils;
import domains.Game;
import java.util.ArrayList;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class MenuWindow extends javax.swing.JFrame implements Observer{
    
    private Game game;
    private WindowAddPlayer windowAddPlayer;
    private WindowRanking windowRanking;
    private WindowMatch windowMatch;
    private WindowReplayMatch windowReplayMatch;
    private serializeUtils serializate;

    static AudioClip sound;
    
    public MenuWindow(Game aGame) {
        initComponents();
        game = aGame;
        game.addObserver(this);
        windowAddPlayer = new WindowAddPlayer(aGame, this);
        windowRanking =  new WindowRanking(aGame, this);
        windowMatch =  new WindowMatch(aGame,this);
        windowReplayMatch = new WindowReplayMatch(aGame, this);
        serializate = new serializeUtils();

        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //btnSound.setLocation((int)(screenSize.getHeight() - 100) , (int)(screenSize.getWidth() - 100));
        this.setTransparent();
        this.setLocationRelativeTo(null);
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
        jbuttons.add(btnReplayMatch);
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
        jLabel6 = new javax.swing.JLabel();
        btnReplayMatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 725));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                manageWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sumIcon-img.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 320, 240));

        jLabel3.setFont(new java.awt.Font("Snubnose DEMO", 0, 70)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Juego de las Sumas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, -1, -1));

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
        getContentPane().add(btnAddPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, -1, -1));

        btnPlay.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/controller-img.png"))); // NOI18N
        btnPlay.setText("  Jugar Partida");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, -1, -1));

        btnRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ranking-img.png"))); // NOI18N
        btnRanking.setText("  Ranking");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
        getContentPane().add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 620, 220, -1));

        btnExit.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit-img.png"))); // NOI18N
        btnExit.setText("  Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 700, -1, -1));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 750, -1, -1));

        jLabel2.setFont(new java.awt.Font("ChalkDust", 0, 70)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1+1=2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 530, -1, -1));

        jLabel4.setFont(new java.awt.Font("ChalkDust", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("23+7=30");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, -1, -1));

        jLabel5.setFont(new java.awt.Font("ChalkDust", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X+Y=Z");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("ChalkDust", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("10/2");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 210, -1, -1));

        btnReplayMatch.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnReplayMatch.setForeground(new java.awt.Color(255, 255, 255));
        btnReplayMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/loop-img.png"))); // NOI18N
        btnReplayMatch.setText("Replicar Partida");
        btnReplayMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayMatchActionPerformed(evt);
            }
        });
        getContentPane().add(btnReplayMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        windowAddPlayer.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        serializate. serialize(game);
        try {
            serializate.serializeListOfPlayersToJson(game);
        } catch (IOException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        windowMatch.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        windowRanking.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
       if(game.isStateMusic()){
           game.setStateMusic(false);
       }else{
           game.setStateMusic(true);
       }
        
    }//GEN-LAST:event_btnSoundActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnReplayMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayMatchActionPerformed
        windowReplayMatch.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReplayMatchActionPerformed

    private void manageWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_manageWindowClosing
        serializate. serialize(game);
        try {
            serializate.serializeListOfPlayersToJson(game);
        } catch (IOException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_manageWindowClosing

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnReplayMatch;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
                
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if(game.isStateMusic()){
            btnSound.setIcon(iconOn);
            sound.play();
        }else{
            btnSound.setIcon(iconOff);
            sound.stop();
        }
    }
}
