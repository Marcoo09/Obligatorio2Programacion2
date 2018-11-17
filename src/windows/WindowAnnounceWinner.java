package windows;

import domains.*;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * @author Marco Fiorito and Felipe Najson
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
        lblWinner.setVisible(false);
        txtWonGames.setVisible(false);
        rightTrophy.setVisible(false);
        leftTrophy.setVisible(false);
        
        //Look and Feel
          try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/background.jpg")));
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
        
        leftTrophy.setLocation((int) (screenWidth / 100) *30, (int) (screenHeight / 100) * 25);
        lblWinner.setLocation((int) (screenWidth / 100) *40, (int) (screenHeight / 100) * 25);
        rightTrophy.setLocation((int) (screenWidth / 100) *72, (int) (screenHeight / 100) * 25);
        
        txtWinner.setLocation((int) (screenWidth / 100) *35, (int) (screenHeight / 100) * 45);
        txtWonGames.setLocation((int) (screenWidth / 100) *40, (int) (screenHeight / 100) * 65);
       
        btnHome.setLocation((int) (screenWidth - 100) ,(int) (30));
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));
    }
        
        public void showWinner(){
        Player playerWinner = currentMatch.getWinner();
       
        
        if (playerWinner != null) {
                String [] data = playerWinner.toString().split(",");
                lblWinner.setVisible(true);
                txtWonGames.setVisible(true);
                rightTrophy.setVisible(true);
                leftTrophy.setVisible(true);
                txtWinner.setText(""+playerWinner.getNickName());
                txtWonGames.setText("Partidas ganadas: "+playerWinner.getWonGames());
                game.setMusicState(false);
                
        }else{
                txtWinner.setText(" Termino en empate");
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        btnSound = new javax.swing.JButton();
        lblWinner = new javax.swing.JLabel();
        txtWinner = new javax.swing.JTextField();
        txtWonGames = new javax.swing.JTextField();
        rightTrophy = new javax.swing.JLabel();
        leftTrophy = new javax.swing.JLabel();

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

        lblWinner.setFont(new java.awt.Font("Snubnose DEMO", 0, 60)); // NOI18N
        lblWinner.setForeground(new java.awt.Color(255, 255, 255));
        lblWinner.setText("El ganador es:");
        getContentPane().add(lblWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 410, 70));

        txtWinner.setFont(new java.awt.Font("Snubnose DEMO", 0, 54)); // NOI18N
        txtWinner.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtWinner.setEnabled(false);
        getContentPane().add(txtWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 500, 70));

        txtWonGames.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        txtWonGames.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtWonGames.setEnabled(false);
        getContentPane().add(txtWonGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 380, 60));

        rightTrophy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/trophy.png"))); // NOI18N
        getContentPane().add(rightTrophy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 240, 80, 90));

        leftTrophy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/trophy.png"))); // NOI18N
        getContentPane().add(leftTrophy, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 80, 90));

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
    private javax.swing.JLabel lblWinner;
    private javax.swing.JLabel leftTrophy;
    private javax.swing.JLabel rightTrophy;
    private javax.swing.JTextField txtWinner;
    private javax.swing.JTextField txtWonGames;
    // End of variables declaration//GEN-END:variables
}
