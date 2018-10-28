/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static windows.MenuWindow.sound;

/**
 *
 * @author felip
 */
public class WindowAddPlayer extends javax.swing.JFrame implements Observer {

    private Game game;
    
    public WindowAddPlayer(Game aGame) {
        initComponents();
        game = aGame;
        game.addObserver(this);
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTransparent();
    }

    public void setTransparent() {
        ArrayList jbuttons = new ArrayList<>();
        jbuttons.add(btnSound);
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

        btnAddPlayer = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNickname = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnSound = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddPlayer.setText("Ingresar Jugador");
        getContentPane().add(btnAddPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 600, 150, 50));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Ingreso de jugador");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtName.setOpaque(false);
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, 160, 30));

        lblNickname.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNickname.setForeground(new java.awt.Color(255, 255, 255));
        lblNickname.setText("Alias:");
        getContentPane().add(lblNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, -1, -1));

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblAge.setForeground(new java.awt.Color(255, 255, 255));
        lblAge.setText("Edad:");
        getContentPane().add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Nombre:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, -1, -1));

        txtNickName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNickName.setOpaque(false);
        getContentPane().add(txtNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, 160, 30));

        txtAge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAge.setOpaque(false);
        getContentPane().add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 520, 160, 30));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 700, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if(game.isStateMusic()){
           game.setStateMusic(false);
       }else{
           game.setStateMusic(true);
       }
    }//GEN-LAST:event_btnSoundActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNickName;
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