/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static windows.MenuWindow.sound;

/**
 *
 * Marco Fiorito and Felipe Najson
 */
public class WindowIntroduction extends javax.swing.JFrame {

    private Game game;

    public WindowIntroduction(Game aGame) {
        initComponents();
        game = aGame;
        
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
        
      /*  lblLogo.setLocation((int) (screenWidth / 100) * 50 - 150, (int) (screenHeight / 100) *1);
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
        
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));*/
    }
    
    public void setTransparent(){
/*        ArrayList jbuttons = new ArrayList<>();
         for (int i = 0; i < jbuttons.size(); i++) {
              JButton buttonAux = (JButton) jbuttons.get(i);
              buttonAux.setOpaque(false);
              buttonAux.setContentAreaFilled(false);
              buttonAux.setBorderPainted(false);
           }*/
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 46, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
