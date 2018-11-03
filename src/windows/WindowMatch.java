/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import domains.*;
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
import javax.swing.JRadioButton;
import windows.FondoSwing;
import windows.MenuWindow;
import windows.WindowGameBoard;
import static windows.MenuWindow.sound;

/**
 *
 * @author Felipe Najson and Marco Fiorito
 */
public class WindowMatch extends javax.swing.JFrame implements Observer {

    private Game game;
    private WindowGameBoard windowGameBoard;
    private MenuWindow menuWindow;

    public WindowMatch(Game aGame, MenuWindow mainWindow) {
        initComponents();
        game = aGame;
        menuWindow = mainWindow;
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
        this.loadList();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTransparent();
    }

    public void alignItems() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        lblTitle.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 1);
        lblRedPlayer.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 20);
        lblBluePlayer.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 40);
        lblWayToFinish.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 60);
        lblQtyOfMovements.setLocation((int) (screenWidth / 100) * 15, (int) (screenHeight / 100) * 70);
        
        JSContainterRedPlayer.setLocation((int) (screenWidth / 100) * 30, (int) (screenHeight / 100) * 22);
        JSContainerBluePlayer.setLocation((int) (screenWidth / 100) * 30, (int) (screenHeight / 100) * 42);
        jrdMovements.setLocation((int) (screenWidth / 100) * 35, (int) (screenHeight / 100) * 62);
        jrdOneToken.setLocation((int) (screenWidth / 100) * 50, (int) (screenHeight / 100) * 62);
        jrdAllTokens.setLocation((int) (screenWidth / 100) * 65, (int) (screenHeight / 100) * 62);

        txtQtyMovements.setLocation((int) (screenWidth / 100) * 35, (int) (screenHeight / 100) * 70);
        jButton1.setLocation((int) (screenWidth / 100) * 75, (int) (screenHeight / 100) * 80);
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 150));
    }
    
    public void clearInputs() {
        txtQtyMovements.setText("");
        lstPlayerBlue.clearSelection();
        lstPlayerRed.clearSelection();
    }

    public void setTransparent() {
        ArrayList jbuttons = new ArrayList<>();
        ArrayList jRadioButtons = new ArrayList<>();
        jbuttons.add(btnSound);

        jRadioButtons.add(jrdMovements);
        jRadioButtons.add(jrdOneToken);
        jRadioButtons.add(jrdAllTokens);
        for (int i = 0; i < jbuttons.size(); i++) {
            JButton buttonAux = (JButton) jbuttons.get(i);
            buttonAux.setOpaque(false);
            buttonAux.setContentAreaFilled(false);
            buttonAux.setBorderPainted(false);
        }

        for (int i = 0; i < jRadioButtons.size(); i++) {
            JRadioButton radioButtonAux = (JRadioButton) jRadioButtons.get(i);
            radioButtonAux.setOpaque(false);
            radioButtonAux.setContentAreaFilled(false);
            radioButtonAux.setBorderPainted(false);
        }
    }

    public void loadList() {
        lstPlayerRed.setListData(game.getListOfPlayers().toArray());
        lstPlayerBlue.setListData(game.getListOfPlayers().toArray());
    }

    public void updateList() {
        lstPlayerRed.setListData(game.getListOfPlayers().toArray());
        lstPlayerBlue.setListData(game.getListOfPlayers().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblWayToFinish = new javax.swing.JLabel();
        lblRedPlayer = new javax.swing.JLabel();
        lblBluePlayer = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSound = new javax.swing.JButton();
        JSContainerBluePlayer = new javax.swing.JScrollPane();
        lstPlayerBlue = new javax.swing.JList();
        JSContainterRedPlayer = new javax.swing.JScrollPane();
        lstPlayerRed = new javax.swing.JList();
        jrdMovements = new javax.swing.JRadioButton();
        jrdOneToken = new javax.swing.JRadioButton();
        jrdAllTokens = new javax.swing.JRadioButton();
        txtQtyMovements = new javax.swing.JTextField();
        lblQtyOfMovements = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                manageClosingWindow(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWayToFinish.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblWayToFinish.setForeground(new java.awt.Color(255, 255, 255));
        lblWayToFinish.setText("Forma de finalizar el juego:");
        getContentPane().add(lblWayToFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        lblRedPlayer.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblRedPlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblRedPlayer.setText("Jugador Rojo:");
        getContentPane().add(lblRedPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        lblBluePlayer.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblBluePlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblBluePlayer.setText("Jugador Azul:");
        getContentPane().add(lblBluePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        lblTitle.setFont(new java.awt.Font("Snubnose DEMO", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Datos de la partida");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, -1, -1));

        jButton1.setText("Comenzar Partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 660, 150, 50));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 700, -1, -1));

        JSContainerBluePlayer.setViewportView(lstPlayerBlue);

        getContentPane().add(JSContainerBluePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 390, 110));

        JSContainterRedPlayer.setViewportView(lstPlayerRed);

        getContentPane().add(JSContainterRedPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 390, 110));

        buttonGroup1.add(jrdMovements);
        jrdMovements.setFont(new java.awt.Font("Snubnose DEMO", 0, 20)); // NOI18N
        jrdMovements.setForeground(new java.awt.Color(255, 255, 255));
        jrdMovements.setText("Movimientos");
        jrdMovements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrdMovementsMouseClicked(evt);
            }
        });
        getContentPane().add(jrdMovements, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, -1, -1));

        buttonGroup1.add(jrdOneToken);
        jrdOneToken.setFont(new java.awt.Font("Snubnose DEMO", 0, 20)); // NOI18N
        jrdOneToken.setForeground(new java.awt.Color(255, 255, 255));
        jrdOneToken.setText("Llevar una pieza");
        jrdOneToken.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrdOneTokenMouseClicked(evt);
            }
        });
        getContentPane().add(jrdOneToken, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, -1, -1));

        buttonGroup1.add(jrdAllTokens);
        jrdAllTokens.setFont(new java.awt.Font("Snubnose DEMO", 0, 20)); // NOI18N
        jrdAllTokens.setForeground(new java.awt.Color(255, 255, 255));
        jrdAllTokens.setText("LLevar todas las piezas");
        jrdAllTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdAllTokensActionPerformed(evt);
            }
        });
        getContentPane().add(jrdAllTokens, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 530, -1, -1));

        txtQtyMovements.setEnabled(false);
        getContentPane().add(txtQtyMovements, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 570, 50, 30));

        lblQtyOfMovements.setFont(new java.awt.Font("Snubnose DEMO", 0, 18)); // NOI18N
        lblQtyOfMovements.setForeground(new java.awt.Color(255, 255, 255));
        lblQtyOfMovements.setText("Cantidad de Movimientos");
        getContentPane().add(lblQtyOfMovements, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.isStateMusic()) {
            game.setStateMusic(false);
        } else {
            game.setStateMusic(true);
        }
    }//GEN-LAST:event_btnSoundActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String error = ("Ingrese valores correctos en el/los campo/s:");
        int qtyMovements = 0;
        Match match;
        boolean samePlayers = false;
        boolean wrongMovments = false;
        Player playerRed = null;
            Player playerBlue = null;
        String wayToFinish = "";

        if(!lstPlayerRed.isSelectionEmpty() && !lstPlayerBlue.isSelectionEmpty()){
             playerRed = (Player) lstPlayerRed.getSelectedValue();
             playerBlue = (Player) lstPlayerBlue.getSelectedValue();
            if (playerBlue.equals(playerRed)) {
                samePlayers = true;
                JOptionPane.showMessageDialog(this, "Debe elegir dos jugadores diferentes", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
                 samePlayers = true;
                JOptionPane.showMessageDialog(this, "Debe elegir dos jugadores", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {

            if (jrdMovements.isSelected()) {
                qtyMovements = Integer.parseInt(txtQtyMovements.getText());
                wayToFinish = "movimientos";
                if (qtyMovements <= 0) {
                    wrongMovments = true;
                    JOptionPane.showMessageDialog(this, "Cantidad de movimientos invalida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (jrdAllTokens.isSelected()) {
                wayToFinish = "fichas";
            } else if (jrdOneToken.isSelected()) {
                wayToFinish = "ficha";
            } else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar una forma de finalización", "Error", JOptionPane.ERROR_MESSAGE);
                wrongMovments = true;
            }

        } catch (Exception NumberFormException) {
            JOptionPane.showMessageDialog(this, "Cantidad de movimientos inválida", "Error", JOptionPane.ERROR_MESSAGE);

        }
            if (!samePlayers && !wrongMovments) {
                match = new Match(playerBlue, playerRed, wayToFinish, qtyMovements);
                game.addMatch(match);
                windowGameBoard = new WindowGameBoard(game, menuWindow,match);

                clearInputs();
                windowGameBoard.setVisible(true);
                this.setVisible(false);
            }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void manageClosingWindow(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_manageClosingWindow
        menuWindow.setVisible(true);

    }//GEN-LAST:event_manageClosingWindow

    private void jrdMovementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrdMovementsMouseClicked
        txtQtyMovements.enable(true);
    }//GEN-LAST:event_jrdMovementsMouseClicked

    private void jrdOneTokenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrdOneTokenMouseClicked
        txtQtyMovements.disable();
        txtQtyMovements.setText("");
    }//GEN-LAST:event_jrdOneTokenMouseClicked

    private void jrdAllTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdAllTokensActionPerformed
        txtQtyMovements.disable();
        txtQtyMovements.setText("");
    }//GEN-LAST:event_jrdAllTokensActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSContainerBluePlayer;
    private javax.swing.JScrollPane JSContainterRedPlayer;
    private javax.swing.JButton btnSound;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jrdAllTokens;
    private javax.swing.JRadioButton jrdMovements;
    private javax.swing.JRadioButton jrdOneToken;
    private javax.swing.JLabel lblBluePlayer;
    private javax.swing.JLabel lblQtyOfMovements;
    private javax.swing.JLabel lblRedPlayer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWayToFinish;
    private javax.swing.JList lstPlayerBlue;
    private javax.swing.JList lstPlayerRed;
    private javax.swing.JTextField txtQtyMovements;
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
