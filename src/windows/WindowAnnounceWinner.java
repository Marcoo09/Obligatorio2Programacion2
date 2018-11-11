/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.*;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import windows.FondoSwing;
import windows.FondoSwing;
import windows.MenuWindow;
import windows.MenuWindow;

/**
 *
 * @author Usuario
 */
public class WindowAnnounceWinner extends javax.swing.JFrame {

    private MenuWindow menuWindow;
    private Match currentMatch;
    private Game game;
    static AudioClip applauseSound;
   
    public WindowAnnounceWinner(Match aMatch, MenuWindow mainWindow, Game aGame) {
        initComponents();
        menuWindow = mainWindow;
        currentMatch = aMatch;
        game = aGame;
        
        //Winner
        labelWinner.setVisible(false);
        txtWonGames.setVisible(false);
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
        
        //Look and Feel
          try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.showWinner();
        this.alignItems();
        
        //ApplauseSound
        applauseSound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/applause.wav"));
        applauseSound.play();

        //Sound
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if (!game.musicOn()) {
            btnSound.setIcon(iconOff);
        }
    }
    
        private void alignItems() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        btnHome.setLocation((int) (screenWidth - 100) ,(int) (30));
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));
    }
        
        public void showWinner(){
        Player playerWinner = currentMatch.getWinner();
       
        
        if (playerWinner != null) {
                String [] data = playerWinner.toString().split(",");
                labelWinner.setVisible(true);
                txtWonGames.setVisible(true);
                jLabel1.setVisible(true);
                jLabel3.setVisible(true);
                txtWinner.setText(""+playerWinner.getNickName());
                txtWonGames.setText("Partidas ganadas: "+playerWinner.getWonGames());
                game.setMusicState(false);
                
        }else{
                txtWinner.setText(" Terminó en empate");
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        btnSound = new javax.swing.JButton();
        labelWinner = new javax.swing.JLabel();
        txtWinner = new javax.swing.JTextField();
        txtWonGames = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 140, -1, -1));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.setBorderPainted(false);
        btnSound.setContentAreaFilled(false);
        btnSound.setFocusPainted(false);
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 580, -1, -1));

        labelWinner.setFont(new java.awt.Font("Snubnose DEMO", 0, 60)); // NOI18N
        labelWinner.setForeground(new java.awt.Color(255, 255, 255));
        labelWinner.setText("El ganador es:");
        getContentPane().add(labelWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        txtWinner.setFont(new java.awt.Font("Snubnose DEMO", 0, 54)); // NOI18N
        txtWinner.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtWinner.setEnabled(false);
        getContentPane().add(txtWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 500, -1));

        txtWonGames.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        txtWonGames.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtWonGames.setEnabled(false);
        getContentPane().add(txtWonGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 380, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/trofeo (1) (1) - Copy.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/trofeo (1) (1) - Copy.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        menuWindow.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.musicOn()) {
            game.setMusicState(false);
        } else {
            game.setMusicState(true);
        }
    }//GEN-LAST:event_btnSoundActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelWinner;
    private javax.swing.JTextField txtWinner;
    private javax.swing.JTextField txtWonGames;
    // End of variables declaration//GEN-END:variables
}
