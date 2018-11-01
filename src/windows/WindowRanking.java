/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.Game;
import java.awt.Dimension;
import java.awt.Toolkit;
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
public class WindowRanking extends javax.swing.JFrame implements Observer {

    private Game game;
    private MenuWindow menuWindow;

    public WindowRanking(Game aGame, MenuWindow mainWindow) {
        initComponents();
        game = aGame;
        menuWindow = mainWindow;
        this.loadList();
        game.addObserver(this);
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.alignItems();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTransparent();
    }

    
    public void alignItems() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        lblTitle.setLocation((int) (screenWidth / 100) * 35, (int) (screenHeight / 100) * 15);
        
        lstRanking.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 20);

        btnSound.setLocation((int) (screenWidth - 100), (int) (screenHeight - 150));
    }

    public void loadList() {
        lstRanking.setListData(game.getListOfPlayers().toArray());
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

        btnSound = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRanking = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                manageWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 760, -1, -1));

        lblTitle.setFont(new java.awt.Font("Snubnose DEMO", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Ranking");
        lblTitle.setToolTipText("");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, -1, -1));

        lstRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(lstRanking);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 740, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.isStateMusic()) {
            game.setStateMusic(false);
        } else {
            game.setStateMusic(true);
        }

    }//GEN-LAST:event_btnSoundActionPerformed

    private void manageWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_manageWindowClosing
        menuWindow.setVisible(true);
    }//GEN-LAST:event_manageWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSound;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList lstRanking;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.loadList();

        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));

        if (game.isStateMusic()) {
            btnSound.setIcon(iconOn);
            sound.play();
        } else {
            btnSound.setIcon(iconOff);
            sound.stop();
        }
    }
}
