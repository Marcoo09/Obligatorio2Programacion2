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
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
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
    static AudioClip sound;
    
        
    public MenuWindow(Game aGame) throws IOException {
        initComponents();
        game = aGame;
        game.addObserver(this);
        windowAddPlayer = new WindowAddPlayer(aGame, this);
        windowRanking =  new WindowRanking(aGame, this);
        windowMatch =  new WindowMatch(aGame,this);
        windowReplayMatch = new WindowReplayMatch(aGame, this);
        
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTransparent();
        this.alignItems();
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/menuSound.wav"));
        sound.loop();

    }
    
    public void alignItems(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        lblLogo.setLocation((int) (screenWidth / 100) * 50 - 150, (int) (screenHeight / 100) *1);
        lblLegtToTheLogo.setLocation((int) (screenWidth / 100) * 32, (int) (screenHeight / 100) * 26 );
        lblRightToTheLogo.setLocation((int) (screenWidth / 100) * 62, (int) (screenHeight / 100) * 24);
        lblNameOfThePlay.setLocation((int) (screenWidth / 100) * 50 - 270, (int) (screenHeight / 100) * 35);
        
        lblLeftToTheMenu.setLocation((int) (screenWidth / 100) * 15 ,(int) (screenHeight / 100) * 75);
        lblRightToTheMenu.setLocation((int) (screenWidth / 100) * 70 ,(int) (screenHeight / 100) * 65);
        
        btnAddPlayer.setLocation((int) (screenWidth / 100) * 42 ,(int) (screenHeight / 100) * 47);
        btnPlay.setLocation((int) (screenWidth / 100) * 42 ,(int) (screenHeight / 100) * 56);
        btnReplayMatch.setLocation((int) (screenWidth / 100) * 42 ,(int) (screenHeight / 100) * 64);
        btnRanking.setLocation((int) (screenWidth / 100) * 42 ,(int) (screenHeight / 100) * 74);
        btnExit.setLocation((int) (screenWidth / 100) * 41 ,(int) (screenHeight / 100) * 84);
        
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 150));
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
        sound.loop();
    }
    
    public void stopMusic(){
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/menuSound.wav"));
        sound.stop();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblNameOfThePlay = new javax.swing.JLabel();
        btnAddPlayer = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSound = new javax.swing.JButton();
        lblRightToTheMenu = new javax.swing.JLabel();
        lblLeftToTheMenu = new javax.swing.JLabel();
        lblLegtToTheLogo = new javax.swing.JLabel();
        lblRightToTheLogo = new javax.swing.JLabel();
        btnReplayMatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 725));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                manageWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sumIcon-img.png"))); // NOI18N
        lblLogo.setToolTipText("");
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 320, 240));

        lblNameOfThePlay.setFont(new java.awt.Font("Snubnose DEMO", 0, 70)); // NOI18N
        lblNameOfThePlay.setForeground(new java.awt.Color(255, 255, 255));
        lblNameOfThePlay.setText("Juego de las Sumas");
        getContentPane().add(lblNameOfThePlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, -1, -1));

        btnAddPlayer.setBackground(new java.awt.Color(153, 153, 153));
        btnAddPlayer.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnAddPlayer.setForeground(new java.awt.Color(240, 240, 240));
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
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 290, -1));

        btnRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ranking-img.png"))); // NOI18N
        btnRanking.setText("  Ranking");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
        getContentPane().add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, 250, -1));

        btnExit.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit-img.png"))); // NOI18N
        btnExit.setText("  Salir");
        btnExit.setActionCommand("      Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 700, 240, -1));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 750, -1, -1));

        lblRightToTheMenu.setFont(new java.awt.Font("ChalkDust", 0, 70)); // NOI18N
        lblRightToTheMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblRightToTheMenu.setText("1+1=2");
        getContentPane().add(lblRightToTheMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 530, -1, -1));

        lblLeftToTheMenu.setFont(new java.awt.Font("ChalkDust", 0, 48)); // NOI18N
        lblLeftToTheMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblLeftToTheMenu.setText("23+7=30");
        getContentPane().add(lblLeftToTheMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, -1, -1));

        lblLegtToTheLogo.setFont(new java.awt.Font("ChalkDust", 0, 36)); // NOI18N
        lblLegtToTheLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLegtToTheLogo.setText("X+Y=Z");
        getContentPane().add(lblLegtToTheLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        lblRightToTheLogo.setFont(new java.awt.Font("ChalkDust", 0, 48)); // NOI18N
        lblRightToTheLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblRightToTheLogo.setText("10/2");
        getContentPane().add(lblRightToTheLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 210, -1, -1));

        btnReplayMatch.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnReplayMatch.setForeground(new java.awt.Color(255, 255, 255));
        btnReplayMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/loop-img.png"))); // NOI18N
        btnReplayMatch.setText("Replicar Partida");
        btnReplayMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayMatchActionPerformed(evt);
            }
        });
        getContentPane().add(btnReplayMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 290, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        windowAddPlayer.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        serializeUtils. serialize(game);
        try {
            serializeUtils.serializeListOfPlayersToJson(game);
        } catch (IOException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (game.getListOfPlayers().size()>1) {
            windowMatch.setVisible(true);
        this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Debes registrar por lo menos dos jugadores", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        if (!game.getListOfPlayers().isEmpty() || !game.getListOfMatches().isEmpty()) {
                     windowRanking.setVisible(true);
        this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Debes jugar una partida previamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
       

    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
       if(game.isStateMusic()){
           game.setStateMusic(false);
       }else{
           game.setStateMusic(true);
       }
        
    }//GEN-LAST:event_btnSoundActionPerformed

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked
       
    }//GEN-LAST:event_lblLogoMouseClicked

    private void btnReplayMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayMatchActionPerformed
        if (!game.getListOfMatches().isEmpty()) {
            windowReplayMatch.setVisible(true);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Debes jugar al menos una partida previemente", "Error", JOptionPane.ERROR_MESSAGE); 
        }
         
    }//GEN-LAST:event_btnReplayMatchActionPerformed

    private void manageWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_manageWindowClosing
        serializeUtils. serialize(game);
        try {
            serializeUtils.serializeListOfPlayersToJson(game);
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
    private javax.swing.JLabel lblLeftToTheMenu;
    private javax.swing.JLabel lblLegtToTheLogo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNameOfThePlay;
    private javax.swing.JLabel lblRightToTheLogo;
    private javax.swing.JLabel lblRightToTheMenu;
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
