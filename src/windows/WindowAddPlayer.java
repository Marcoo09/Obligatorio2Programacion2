/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import javax.swing.JFrame;

/**
 *
 * @author felip
 */
public class WindowAddPlayer extends javax.swing.JFrame {

    private Game game;
    
    public WindowAddPlayer(Game aGame) {
        initComponents();
        game = aGame;
        this.setLocationRelativeTo(null);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNickname = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Ingresar Jugador");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 150, 50));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Ingreso de jugador");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtName.setOpaque(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 160, 30));

        lblNickname.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNickname.setForeground(new java.awt.Color(255, 255, 255));
        lblNickname.setText("Alias:");
        jPanel1.add(lblNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblAge.setForeground(new java.awt.Color(255, 255, 255));
        lblAge.setText("Edad:");
        jPanel1.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Nombre:");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        txtNickName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNickName.setOpaque(false);
        jPanel1.add(txtNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 160, 30));

        txtAge.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAge.setOpaque(false);
        jPanel1.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 160, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/OGA3KP0_1.jpg"))); // NOI18N
        lblBackground.setToolTipText("");
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNickName;
    // End of variables declaration//GEN-END:variables
}
