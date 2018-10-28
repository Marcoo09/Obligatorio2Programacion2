/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import domains.Match;
import javax.swing.JFrame;

/**
 *
 * @author felip
 */
public class WindowMatch extends javax.swing.JFrame {

    private Game game;
    
    public WindowMatch(Game aGame) {
        initComponents();
        game = aGame;
        jListWayToFinish.setListData(Match.ways);
        this.setLocationRelativeTo(null);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMatchData = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtRedPlayer = new javax.swing.JTextField();
        lblBluePlayer = new javax.swing.JLabel();
        lblWayToFinish = new javax.swing.JLabel();
        lblRedPlayer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListWayToFinish = new javax.swing.JList<>();
        txtBluePlyaer = new javax.swing.JTextField();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMatchData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Comenzar Partida");
        jPanelMatchData.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 150, 50));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Datos de la partida");
        jPanelMatchData.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        txtRedPlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRedPlayer.setOpaque(false);
        txtRedPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedPlayerActionPerformed(evt);
            }
        });
        jPanelMatchData.add(txtRedPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 160, 30));

        lblBluePlayer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblBluePlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblBluePlayer.setText("Jugador Azul:");
        jPanelMatchData.add(lblBluePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        lblWayToFinish.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblWayToFinish.setForeground(new java.awt.Color(255, 255, 255));
        lblWayToFinish.setText("Forma de finalizar el juego:");
        jPanelMatchData.add(lblWayToFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        lblRedPlayer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblRedPlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblRedPlayer.setText("Jugador Rojo:");
        jPanelMatchData.add(lblRedPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jListWayToFinish.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListWayToFinish);

        jPanelMatchData.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 230, 90));

        txtBluePlyaer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBluePlyaer.setOpaque(false);
        jPanelMatchData.add(txtBluePlyaer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 160, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/OGA3KP0_1.jpg"))); // NOI18N
        lblBackground.setToolTipText("");
        jPanelMatchData.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelMatchData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRedPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRedPlayerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jListWayToFinish;
    private javax.swing.JPanel jPanelMatchData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBluePlayer;
    private javax.swing.JLabel lblRedPlayer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWayToFinish;
    private javax.swing.JTextField txtBluePlyaer;
    private javax.swing.JTextField txtRedPlayer;
    // End of variables declaration//GEN-END:variables
}
