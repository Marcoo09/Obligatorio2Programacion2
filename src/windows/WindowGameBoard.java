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
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import static windows.MenuWindow.sound;

/**
 *
 * @author Felipe Najson and Marco Fiorito
 */
public class WindowGameBoard extends javax.swing.JFrame implements Observer {

    private static JButton[][] botones;
    private Game game;
    private MenuWindow windowMenu;
    private GameBoard currentGameBoard;
    private Match currentMatch;
    private static Player currentPlayer;
    private static boolean clickFlag;
    private static boolean passedTurn;
    private static int currentX;
    private static int currentY;
    private static int newX;
    private static int newY;
    private static int lastNumberMoved;

    private ArrayList<Integer> posibleTokenMovementsBlue = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    private ArrayList<Integer> posibleTokenMovementsRed = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

    private Player playerBlue;
    private Player playerRed;

    private boolean stateOfTheGameboardChange = false;

    public WindowGameBoard(Game aGame, MenuWindow mainWindow, Match match) {
        initComponents();

        //Flags
        clickFlag = true;

        //Receive parameters
        game = aGame;
        windowMenu = mainWindow;
        currentMatch = match;

        //Look and feel
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/resources/1.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setTransparent();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Data of the play
        playerBlue = currentMatch.getListOfPlayers().get(0);
        playerRed = currentMatch.getListOfPlayers().get(1);

        currentPlayer = playerRed;

        if (currentMatch.getListOfGameBoard().isEmpty()) {
            currentGameBoard = new GameBoard(match.getListOfPlayers());
            currentGameBoard.fillInitialMatrix(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
            currentMatch.setGameBoard(currentGameBoard);
        }

        //Subscribe as observers
        game.addObserver(this);
        currentGameBoard.addObserver(this);

        //Create GamebBoard and fill text of the screen
        this.fillTexts(match);
        this.fillInitialButtonMatrix();
        this.modifyAppearenceOfNotCurrentPlayer();

    }

    private void announceWinner() {
        Player playerWinner = currentMatch.getWinner();

        if (playerWinner != null) {
            if (currentMatch.getWinner().equals(playerBlue)) {
                playerBlue.setWonGames(playerBlue.getWonGames() + 1);
            } else {
                playerRed.setWonGames(playerRed.getWonGames() + 1);
            }
        }
        WindowAnnounceWinner windowAnnounceWinner = new WindowAnnounceWinner(currentMatch, windowMenu);
        windowAnnounceWinner.setVisible(true);
        this.dispose();
    }

    private void modifyAppearenceOfNotCurrentPlayer() {
        if (currentPlayer.equals(playerRed)) {
            lblBluePlayerTitle.setEnabled(false);
            lblBluePlayerNickName.setEnabled(false);
            lblBluePlayerPosibleMovements.setEnabled(false);
            txtNicknamePlayerBlue.setBackground(Color.GRAY);
            txtPossibleMovementsBlue.setBackground(Color.GRAY);
            btnExitPlayerBlue.setEnabled(false);

            lblRedPlayerTitle.setEnabled(true);
            lblRedPlayerPosibleMovements.setEnabled(true);
            lblRedPlayerNickName.setEnabled(true);
            txtNicknamePlayerRed.setBackground(Color.WHITE);
            txtPossibleMovementsRed.setBackground(Color.WHITE);
            btnExitPlayerRed.setEnabled(true);
        } else {
            lblBluePlayerTitle.setEnabled(true);
            lblBluePlayerNickName.setEnabled(true);
            lblBluePlayerPosibleMovements.setEnabled(true);
            txtNicknamePlayerBlue.setBackground(Color.WHITE);
            txtPossibleMovementsBlue.setBackground(Color.WHITE);
            btnExitPlayerBlue.setEnabled(true);

            lblRedPlayerTitle.setEnabled(false);
            lblRedPlayerPosibleMovements.setEnabled(false);
            lblRedPlayerNickName.setEnabled(false);
            txtNicknamePlayerRed.setBackground(Color.GRAY);
            txtPossibleMovementsRed.setBackground(Color.GRAY);
            btnExitPlayerRed.setEnabled(false);
        }
    }

    private void fillTexts(Match currentMatch) {

        txtNicknamePlayerBlue.setText(playerBlue.getNickName());
        txtPossibleMovementsBlue.setText(posibleTokenMovementsBlue.toString());

        txtNicknamePlayerRed.setText(playerRed.getNickName());
        txtPossibleMovementsRed.setText(posibleTokenMovementsBlue.toString());

    }

    private void fillInitialButtonMatrix() {
        Token[][] tokenMatrix = currentGameBoard.getTokenMatrix();
        int col = tokenMatrix.length;
        int row = tokenMatrix[0].length;

        panelJuego.setLayout(new GridLayout(8, 9));
        botones = new JButton[9][10];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;

                if (tokenMatrix[i][j] != null) {
                    if (tokenMatrix[i][j].getPlayer().equals(playerRed)) {
                        botones[i][j].setBackground(Color.RED);
                        botones[i][j].setText("" + tokenMatrix[i][j].getTokenNumber());

                    } else {
                        botones[i][j].setBackground(Color.BLUE);
                        botones[i][j].setText("" + tokenMatrix[i][j].getTokenNumber());
                    }
                } else {
                    botones[i][j].setBackground(Color.WHITE);
                }
            }
        }

    }

    private void fillButtonMatrix() {
        Token[][] tokenMatrix = currentGameBoard.getTokenMatrix();
        int col = tokenMatrix.length;
        int row = tokenMatrix[0].length;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (tokenMatrix[i][j] != null) {
                    if (tokenMatrix[i][j].getPlayer().equals(playerRed)) {
                        botones[i][j].setBackground(Color.RED);
                        botones[i][j].setText("" + tokenMatrix[i][j].getTokenNumber());

                    } else {
                        botones[i][j].setBackground(Color.BLUE);
                        botones[i][j].setText("" + tokenMatrix[i][j].getTokenNumber());
                    }
                } else {
                    botones[i][j].setBackground(Color.WHITE);
                    botones[i][j].setText("");

                }
            }
        }

    }

    private void updateCurrentPlayerData() {
        if (currentPlayer.equals(playerRed)) {
            posibleTokenMovementsRed = currentGameBoard.getPossibleMovements(currentPlayer, lastNumberMoved, newX, newY);
            txtPossibleMovementsRed.setText(posibleTokenMovementsRed.toString());
            if (posibleTokenMovementsRed.isEmpty()) {
                currentPlayer = playerBlue;
                changeTurn();
            }
        } else {
            posibleTokenMovementsBlue = currentGameBoard.getPossibleMovements(currentPlayer, lastNumberMoved, newX, newY);
            txtPossibleMovementsBlue.setText(posibleTokenMovementsBlue.toString());
            if (posibleTokenMovementsBlue.isEmpty()) {
                currentPlayer = playerRed;
                changeTurn();
            }
        }
    }

    private void changeTurn() {
        ArrayList<Integer> movements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        movements = currentGameBoard.removeTokensWithAnyPosibleMovement(movements, currentPlayer);
        modifyAppearenceOfNotCurrentPlayer();

        if (currentPlayer.equals(playerRed)) {
            posibleTokenMovementsRed = movements;
            txtPossibleMovementsRed.setText(posibleTokenMovementsRed.toString());
        } else {
            posibleTokenMovementsBlue = movements;
            txtPossibleMovementsBlue.setText(posibleTokenMovementsBlue.toString());
        }
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

    private void giveUp(){
       currentMatch.setFinished(true);
       if(currentPlayer.equals(playerRed)){
           currentMatch.setWinner(playerBlue);
       }else{
           currentMatch.setWinner(playerRed);
       }
       
       WindowAnnounceWinner windowAnnounceWinner = new WindowAnnounceWinner(currentMatch, windowMenu);
       windowAnnounceWinner.setVisible(true);
       this.dispose();
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        lblRedPlayerTitle = new javax.swing.JLabel();
        lblBluePlayerTitle = new javax.swing.JLabel();
        txtPossibleMovementsRed = new javax.swing.JTextField();
        lblRedPlayerPosibleMovements = new javax.swing.JLabel();
        txtNicknamePlayerRed = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblRedPlayerNickName = new javax.swing.JLabel();
        btnExitPlayerRed = new javax.swing.JButton();
        lblBluePlayerPosibleMovements = new javax.swing.JLabel();
        txtPossibleMovementsBlue = new javax.swing.JTextField();
        btnExitPlayerBlue = new javax.swing.JButton();
        lblBluePlayerNickName = new javax.swing.JLabel();
        txtNicknamePlayerBlue = new javax.swing.JTextField();
        btnSound = new javax.swing.JButton();
        btnTurn = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
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

        lblRedPlayerTitle.setFont(new java.awt.Font("Snubnose DEMO", 0, 48)); // NOI18N
        lblRedPlayerTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblRedPlayerTitle.setText("Jugador rojo");
        getContentPane().add(lblRedPlayerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lblBluePlayerTitle.setFont(new java.awt.Font("Snubnose DEMO", 0, 48)); // NOI18N
        lblBluePlayerTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblBluePlayerTitle.setText("Jugador azul");
        getContentPane().add(lblBluePlayerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 170, -1, -1));

        txtPossibleMovementsRed.setBackground(new java.awt.Color(240, 240, 240));
        txtPossibleMovementsRed.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPossibleMovementsRed.setForeground(new java.awt.Color(240, 240, 240));
        txtPossibleMovementsRed.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPossibleMovementsRed.setEnabled(false);
        getContentPane().add(txtPossibleMovementsRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 280, 30));

        lblRedPlayerPosibleMovements.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        lblRedPlayerPosibleMovements.setForeground(new java.awt.Color(255, 255, 255));
        lblRedPlayerPosibleMovements.setText("Posibles movimientos:");
        getContentPane().add(lblRedPlayerPosibleMovements, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        txtNicknamePlayerRed.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNicknamePlayerRed.setForeground(new java.awt.Color(255, 255, 255));
        txtNicknamePlayerRed.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNicknamePlayerRed.setEnabled(false);
        txtNicknamePlayerRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknamePlayerRedActionPerformed(evt);
            }
        });
        getContentPane().add(txtNicknamePlayerRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 280, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, 10));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 240, 300, 10));

        lblRedPlayerNickName.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        lblRedPlayerNickName.setForeground(new java.awt.Color(255, 255, 255));
        lblRedPlayerNickName.setText("Alias:");
        getContentPane().add(lblRedPlayerNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        btnExitPlayerRed.setBackground(new java.awt.Color(237, 83, 83));
        btnExitPlayerRed.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExitPlayerRed.setForeground(new java.awt.Color(255, 255, 255));
        btnExitPlayerRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/error (1).png"))); // NOI18N
        btnExitPlayerRed.setText("  Abandonar");
        btnExitPlayerRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitPlayerRedActionPerformed(evt);
            }
        });
        getContentPane().add(btnExitPlayerRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        lblBluePlayerPosibleMovements.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        lblBluePlayerPosibleMovements.setForeground(new java.awt.Color(255, 255, 255));
        lblBluePlayerPosibleMovements.setText("Posibles movimientos:");
        getContentPane().add(lblBluePlayerPosibleMovements, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 350, -1, -1));

        txtPossibleMovementsBlue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPossibleMovementsBlue.setForeground(new java.awt.Color(255, 255, 255));
        txtPossibleMovementsBlue.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPossibleMovementsBlue.setEnabled(false);
        getContentPane().add(txtPossibleMovementsBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 390, 280, 30));

        btnExitPlayerBlue.setBackground(new java.awt.Color(237, 83, 83));
        btnExitPlayerBlue.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnExitPlayerBlue.setForeground(new java.awt.Color(255, 255, 255));
        btnExitPlayerBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/error (1).png"))); // NOI18N
        btnExitPlayerBlue.setText("  Abandonar");
        btnExitPlayerBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitPlayerBlueActionPerformed(evt);
            }
        });
        getContentPane().add(btnExitPlayerBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 460, -1, -1));

        lblBluePlayerNickName.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        lblBluePlayerNickName.setForeground(new java.awt.Color(255, 255, 255));
        lblBluePlayerNickName.setText("Alias:");
        getContentPane().add(lblBluePlayerNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, -1, -1));

        txtNicknamePlayerBlue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNicknamePlayerBlue.setToolTipText("");
        txtNicknamePlayerBlue.setDisabledTextColor(new java.awt.Color(0, 0, 0));
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

        btnTurn.setText("Pasar turno");
        btnTurn.setActionCommand("");
        btnTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnActionPerformed(evt);
            }
        });
        getContentPane().add(btnTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 150, 40));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNicknamePlayerRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknamePlayerRedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknamePlayerRedActionPerformed

    private void txtNicknamePlayerBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknamePlayerBlueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknamePlayerBlueActionPerformed

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.isStateMusic()) {
            game.setStateMusic(false);
        } else {
            game.setStateMusic(true);
        }

    }//GEN-LAST:event_btnSoundActionPerformed

    private void btnTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnActionPerformed
        if (currentPlayer.equals(playerRed)) {
            currentPlayer = playerBlue;
        } else {
            currentPlayer = playerRed;
        }
        this.changeTurn();
    }//GEN-LAST:event_btnTurnActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        windowMenu.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnExitPlayerRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitPlayerRedActionPerformed
        this.giveUp();
    }//GEN-LAST:event_btnExitPlayerRedActionPerformed

    private void btnExitPlayerBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitPlayerBlueActionPerformed
        this.giveUp();
    }//GEN-LAST:event_btnExitPlayerBlueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExitPlayerBlue;
    private javax.swing.JButton btnExitPlayerRed;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSound;
    private javax.swing.JButton btnTurn;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBluePlayerNickName;
    private javax.swing.JLabel lblBluePlayerPosibleMovements;
    private javax.swing.JLabel lblBluePlayerTitle;
    private javax.swing.JLabel lblRedPlayerNickName;
    private javax.swing.JLabel lblRedPlayerPosibleMovements;
    private javax.swing.JLabel lblRedPlayerTitle;
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
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {

        if (clickFlag) {
            currentX = columna;
            currentY = fila;
            Token selectedToken = currentGameBoard.getTokenMatrix()[currentY][currentX];

            if (selectedToken != null) {
                Player tokenPlayer = selectedToken.getPlayer();

                if (tokenPlayer.equals(currentPlayer)) {
                    if (currentPlayer.equals(playerBlue)) {
                        if (!posibleTokenMovementsBlue.contains(selectedToken.getTokenNumber())) {
                            JOptionPane.showMessageDialog(this, "No tienes la posibilidad de mover este token", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            clickFlag = false;
                        }
                    } else if (currentPlayer.equals(playerRed)) {
                        if (!posibleTokenMovementsRed.contains(selectedToken.getTokenNumber())) {
                            JOptionPane.showMessageDialog(this, "No tienes la posibilidad de mover este token", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            clickFlag = false;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Elegiste una ficha del otro jugador", "Error jugador", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "No elegite ficha alguna", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //currentGameBoard.getTokenMatrix()[cu]           
        } else {
            newX = columna;
            newY = fila;

            if (!currentGameBoard.validatePositionMovement(currentPlayer, currentY, currentX, newY, newX)) {
                JOptionPane.showMessageDialog(this, "Movimiento invalido", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                clickFlag = true;
                stateOfTheGameboardChange = true;
                if (currentGameBoard.getTokenMatrix()[newY][newX] == null) {
                    lastNumberMoved = currentGameBoard.getTokenMatrix()[currentY][currentX].getTokenNumber();
                    currentGameBoard.movePiece(currentX, currentY, newX, newY);

                    GameBoard auxGameboard = new GameBoard(currentMatch.getListOfPlayers());
                    Token[][] auxMatrix = auxGameboard.getTokenMatrix();
                    //Clone each token to save another gameboard and not modify all the gameboards
                    for (int i = 0; i < auxMatrix.length; i++) {
                        for (int j = 0; j < auxMatrix[0].length; j++) {
                            if (currentGameBoard.getTokenMatrix()[i][j] != null) {
                                auxMatrix[i][j] = (Token) currentGameBoard.getTokenMatrix()[i][j].clone();
                            }
                        }
                    }
                    currentMatch.setGameBoard(auxGameboard);

                    if (currentMatch.isFinished()) {
                        JOptionPane.showMessageDialog(this, "Terminó el juego", "Terminó", JOptionPane.ERROR_MESSAGE);
                        this.announceWinner();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Se encuentra una ficha en esa posición", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }

    }

    @Override
    public void update(Observable o, Object arg) {
        //Change music of the play      
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));

        if (game.isStateMusic() && btnSound.getIcon().equals(iconOff)) {
            sound.loop();
            System.out.println("entro");
            btnSound.setIcon(iconOn);
        } else if (!game.isStateMusic()) {
            btnSound.setIcon(iconOff);
            sound.stop();
        }
        //Draw the gameboard again

        if (stateOfTheGameboardChange) {
            this.fillButtonMatrix();
            this.updateCurrentPlayerData();
            stateOfTheGameboardChange = false;
            passedTurn = false;
        }
    }

}
