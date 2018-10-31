/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import static windows.MenuWindow.sound;

/**
 *
 * @author felip
 */
public class WindowGameBoard extends javax.swing.JFrame implements Observer{

    private JButton[][] botones;
    private Game game;
    private MenuWindow windowMenu;
    
    public WindowGameBoard(Game aGame,MenuWindow mainWindow) {
        initComponents();
        game = aGame;
        windowMenu = mainWindow;
        game.addObserver(this);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         this.setTransparent();
        //Set players in textfields
        
        //Create GamebBoard
        panelJuego.setLayout(new GridLayout(8, 9));
        botones = new JButton[9][10];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 9; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                if (i == 1) {
                    botones[i][j].setBackground(Color.BLUE);
                    if(j!=1){
                       botones[i][j].setText(""+(j-1));
                    }
                } else if (i == 8) {
                    botones[i][j].setBackground(Color.RED);
                    if(j!=1){
                       botones[i][j].setText(""+ (10- j));
                    }
                } else {
                    botones[i][j].setBackground(Color.WHITE);
                }
            }
        }
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

        panelJuego = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPossibleMovementsRed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNicknamePlayerRed = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnExitPlayerRed = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPossibleMovementsBlue = new javax.swing.JTextField();
        btnExitPlayerBlue = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNicknamePlayerBlue = new javax.swing.JTextField();
        btnSound = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                manageWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 580, 440));

        jLabel2.setFont(new java.awt.Font("Snubnose DEMO", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jugador rojo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel1.setFont(new java.awt.Font("Snubnose DEMO", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jugador azul");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 170, -1, -1));

        txtPossibleMovementsRed.setEnabled(false);
        getContentPane().add(txtPossibleMovementsRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 280, 30));

        jLabel3.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Posibles movimientos:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        txtNicknamePlayerRed.setEnabled(false);
        txtNicknamePlayerRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknamePlayerRedActionPerformed(evt);
            }
        });
        getContentPane().add(txtNicknamePlayerRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 280, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, 10));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 240, 300, 10));

        jLabel4.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alias:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        btnExitPlayerRed.setBackground(new java.awt.Color(237, 83, 83));
        btnExitPlayerRed.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExitPlayerRed.setForeground(new java.awt.Color(255, 255, 255));
        btnExitPlayerRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/error (1).png"))); // NOI18N
        btnExitPlayerRed.setText("  Abandonar");
        getContentPane().add(btnExitPlayerRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jLabel5.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Posibles movimientos:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 350, -1, -1));

        txtPossibleMovementsBlue.setEnabled(false);
        getContentPane().add(txtPossibleMovementsBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 390, 280, 30));

        btnExitPlayerBlue.setBackground(new java.awt.Color(237, 83, 83));
        btnExitPlayerBlue.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExitPlayerBlue.setForeground(new java.awt.Color(255, 255, 255));
        btnExitPlayerBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/error (1).png"))); // NOI18N
        btnExitPlayerBlue.setText("  Abandonar");
        getContentPane().add(btnExitPlayerBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alias:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, -1, -1));

        txtNicknamePlayerBlue.setEnabled(false);
        txtNicknamePlayerBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknamePlayerBlueActionPerformed(evt);
            }
        });
        getContentPane().add(txtNicknamePlayerBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 300, 280, 30));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 600, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_manageWindowClosing
        windowMenu.setVisible(true);
    }//GEN-LAST:event_manageWindowClosing

    private void txtNicknamePlayerRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknamePlayerRedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknamePlayerRedActionPerformed

    private void txtNicknamePlayerBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknamePlayerBlueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknamePlayerBlueActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if(game.isStateMusic()){
            game.setStateMusic(false);
        }else{
            game.setStateMusic(true);
        }

    }//GEN-LAST:event_btnSoundActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExitPlayerBlue;
    private javax.swing.JButton btnExitPlayerRed;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JTextField txtNicknamePlayerBlue;
    private javax.swing.JTextField txtNicknamePlayerRed;
    private javax.swing.JTextField txtPossibleMovementsBlue;
    private javax.swing.JTextField txtPossibleMovementsRed;
    // End of variables declaration//GEN-END:variables
    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
// en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
// cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {

// Método a completar!.
// En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla
// fila 1 y columna 1 corresponden a la posición de arriba a la izquierda.
// Debe indicarse cómo responder al click de ese botón.
    }
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
