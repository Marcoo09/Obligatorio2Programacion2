package windows;

import controllers.Utils;
import domains.Game;
import java.util.ArrayList;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author Marco Fiorito and Felipe Najson
 */

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
        
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/1.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTransparent();
        this.alignItems();
        
        //Sound
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/resources/menuSound.wav"));
        game.setMusicState(true);

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
        
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));
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
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1020, 725));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sumIcon-img.png"))); // NOI18N
        lblLogo.setToolTipText("");
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 320, 240));

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
        btnAddPlayer.setFocusPainted(false);
        btnAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, 290, -1));

        btnPlay.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/controller-img.png"))); // NOI18N
        btnPlay.setText("  Jugar Partida");
        btnPlay.setFocusPainted(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 270, -1));

        btnRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ranking-img.png"))); // NOI18N
        btnRanking.setText("  Ranking");
        btnRanking.setFocusPainted(false);
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
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 700, 240, -1));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.setFocusPainted(false);
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

        lblLeftToTheMenu.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblLeftToTheMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblLeftToTheMenu.setText("23+7=30");
        getContentPane().add(lblLeftToTheMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, -1, -1));

        lblLegtToTheLogo.setFont(new java.awt.Font("ChalkDust", 0, 36)); // NOI18N
        lblLegtToTheLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLegtToTheLogo.setText("X+Y=Z");
        getContentPane().add(lblLegtToTheLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        lblRightToTheLogo.setFont(new java.awt.Font("ChalkDust", 0, 48)); // NOI18N
        lblRightToTheLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblRightToTheLogo.setText("10/2");
        getContentPane().add(lblRightToTheLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 210, -1, -1));

        btnReplayMatch.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnReplayMatch.setForeground(new java.awt.Color(255, 255, 255));
        btnReplayMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/loop-img.png"))); // NOI18N
        btnReplayMatch.setText("Replicar Partida");
        btnReplayMatch.setFocusPainted(false);
        btnReplayMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayMatchActionPerformed(evt);
            }
        });
        getContentPane().add(btnReplayMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        windowAddPlayer = new WindowAddPlayer(game, this);
        windowAddPlayer.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Utils.serialize(game);
        try {
            Utils.serializeListOfPlayersToJson(game);
        } catch (IOException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        windowMatch =  new WindowMatch(game,this);
        if (game.getListOfPlayers().size()>1) {
            windowMatch.setVisible(true);
        this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Debes registrar por lo menos dos jugadores", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        windowRanking =  new WindowRanking(game, this);
        if (!game.getListOfPlayers().isEmpty() || !game.getListOfMatches().isEmpty()) {
                     windowRanking.setVisible(true);
        this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Debes jugar una partida previamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
       

    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
       if(game.musicOn()){
           game.setMusicState(false);
       }else{
           game.setMusicState(true);
       }
        
    }//GEN-LAST:event_btnSoundActionPerformed

    private void btnReplayMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayMatchActionPerformed
        windowReplayMatch = new WindowReplayMatch(game, this);
     
        if (!game.getListOfMatches().isEmpty()) {
            windowReplayMatch.setVisible(true);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Debes jugar al menos una partida previemente", "Error", JOptionPane.ERROR_MESSAGE); 
        }
         
    }//GEN-LAST:event_btnReplayMatchActionPerformed

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked

    }//GEN-LAST:event_lblLogoMouseClicked

    
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
        if(game.musicOn()){
            btnSound.setIcon(iconOn);
            sound.loop();
        }else{
            btnSound.setIcon(iconOff);
            sound.stop();
        }
    }
}
