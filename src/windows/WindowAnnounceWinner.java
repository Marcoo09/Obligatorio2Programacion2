/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Match;
import domains.Player;
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
   
    public WindowAnnounceWinner(Match aMatch, MenuWindow mainWindow) {
        initComponents();
        menuWindow = mainWindow;
        currentMatch = aMatch;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(txtWinner, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(566, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnHome)
                .addGap(159, 159, 159)
                .addComponent(txtWinner, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        menuWindow.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JTextField txtWinner;
    // End of variables declaration//GEN-END:variables
}
