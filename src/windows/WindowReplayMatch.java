/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
public class WindowReplayMatch extends javax.swing.JFrame implements Observer {

    private Game game;
    private MenuWindow menuWindow;
    private WindowGameBoard windowGameBoard;
    private JButton[][] botones;

    public WindowReplayMatch(Game aGame, MenuWindow mainWindow) {
        initComponents();
        game = aGame;
        menuWindow = mainWindow;
      //  windowGameBoard = new WindowGameBoard(aGame, mainWindow);
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
        this.alignItems();
        
        this.createButtonMatrix();
        
        btnBeginAnotherMatch.setVisible(false);
        btnFollowGameBoard.setVisible(false);
        panelJuego.setVisible(false);
        lstMatches.setListData(game.getListOfMatches().toArray());
    }

    private void alignItems() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // panelJuego.setLocation((int) (screenWidth / 100) *1 ,(int) (screenHeight  / 100) * 1);
        btnHome.setLocation((int) (screenWidth - 100) ,(int) (30));        
        btnSound.setLocation((int) (screenWidth - 100), (int) (screenHeight - 75));
    }

    private void setTransparent() {
        ArrayList jbuttons = new ArrayList<>();
        jbuttons.add(btnSound);
        for (int i = 0; i < jbuttons.size(); i++) {
            JButton buttonAux = (JButton) jbuttons.get(i);
            buttonAux.setOpaque(false);
            buttonAux.setContentAreaFilled(false);
            buttonAux.setBorderPainted(false);
        }
    }
    
    private void createButtonMatrix(){
       panelJuego.setLayout(new GridLayout(8, 9));
       botones = new JButton[9][10];
       for (int i = 1; i <= 8; i++) {
           for (int j = 1; j <= 9; j++) {
               JButton jButton = new JButton();
               panelJuego.add(jButton);
               botones[i][j] = jButton;
               if (i == 1) {
                 //  botones[i][j].setBackground(Color.BLUE);
                   if (j != 1) {
                    //   botones[i][j].setText("" + (j - 1));
                   }
               } else if (i == 8) {
                  // botones[i][j].setBackground(Color.RED);
                   if (j != 1) {
                     //  botones[i][j].setText("" + (10 - j));
                   }
               } else {
                   botones[i][j].setBackground(Color.WHITE);
               }
           }
       }        
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSound = new javax.swing.JButton();
        panelJuego = new javax.swing.JPanel();
        JSContainerLstMatches = new javax.swing.JScrollPane();
        lstMatches = new javax.swing.JList();
        btnHome = new javax.swing.JButton();
        btnFollowGameBoard = new javax.swing.JButton();
        btnBeginAnotherMatch = new javax.swing.JButton();
        btnReplayMatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, -1, -1));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 730, 470));

        lstMatches.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        JSContainerLstMatches.setViewportView(lstMatches);

        getContentPane().add(JSContainerLstMatches, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 230));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, -1));

        btnFollowGameBoard.setText("Next");
        btnFollowGameBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowGameBoardActionPerformed(evt);
            }
        });
        getContentPane().add(btnFollowGameBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 710, -1, -1));

        btnBeginAnotherMatch.setText("Begin Another Match");
        getContentPane().add(btnBeginAnotherMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 710, -1, -1));

        btnReplayMatch.setText("jButton1");
        btnReplayMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayMatchActionPerformed(evt);
            }
        });
        getContentPane().add(btnReplayMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 700, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.isStateMusic()) {
            game.setStateMusic(false);
        } else {
            game.setStateMusic(true);
        }
    }//GEN-LAST:event_btnSoundActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        menuWindow.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnFollowGameBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowGameBoardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFollowGameBoardActionPerformed

    private void btnReplayMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayMatchActionPerformed
        btnReplayMatch.setVisible(false);
        JSContainerLstMatches.setVisible(false);
        
        btnFollowGameBoard.setVisible(true);
        btnBeginAnotherMatch.setVisible(true);
        
        panelJuego.setVisible(true);
    }//GEN-LAST:event_btnReplayMatchActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if (game.isStateMusic()) {
            btnSound.setIcon(iconOn);
            sound.loop();
        } else {
            btnSound.setIcon(iconOff);
            sound.stop();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSContainerLstMatches;
    private javax.swing.JButton btnBeginAnotherMatch;
    private javax.swing.JButton btnFollowGameBoard;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReplayMatch;
    private javax.swing.JButton btnSound;
    private javax.swing.JList lstMatches;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
