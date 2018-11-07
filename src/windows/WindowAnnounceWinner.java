/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import domains.Match;
import domains.Player;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import windows.FondoSwing;
import windows.MenuWindow;

/**
 *
 * @author Usuario
 */
public class WindowAnnounceWinner extends javax.swing.JFrame {

    private MenuWindow menuWindow;
    private Match currentMatch;
    private Player playerBlue;
    private Player playerRed;
   private Game game;
   
    public WindowAnnounceWinner(Match aMatch, MenuWindow mainWindow, Game aGame) {
        initComponents();
        menuWindow = mainWindow;
        currentMatch = aMatch;
        game = aGame;
        playerBlue = currentMatch.getListOfPlayers().get(0);
        playerRed = currentMatch.getListOfPlayers().get(1);
          try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.showWinner();
        this.alignItems();
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
        String [] data = playerWinner.toString().split(",");
        
        if (playerWinner != null) {
                txtWinner.setText("El ganador es: "+"\n"+ playerWinner);
        }else{
                txtWinner.setText("El juego terminó en empate");
        }
                
        }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        txtWinner = new javax.swing.JTextField();
        btnSound = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1307, 36, -1, -1));
        getContentPane().add(txtWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 264, 497, 305));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 730, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        menuWindow.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.isStateMusic()) {
            game.setStateMusic(false);
        } else {
            game.setStateMusic(true);
        }
    }//GEN-LAST:event_btnSoundActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSound;
    private javax.swing.JTextField txtWinner;
    // End of variables declaration//GEN-END:variables
}
