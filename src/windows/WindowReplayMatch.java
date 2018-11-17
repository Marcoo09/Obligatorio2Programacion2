package windows;

import domains.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static windows.MenuWindow.sound;
/**
 * @author Felipe Najson and Marco Fiorito
 */
public class WindowReplayMatch extends javax.swing.JFrame implements Observer {

    private Game game;
    private MenuWindow menuWindow;
    private JButton[][] botones;
    private Match selectedMatch;
    private int i = 0;

    public WindowReplayMatch(Game aGame, MenuWindow mainWindow) {
        initComponents();
        game = aGame;
        menuWindow = mainWindow;
        game.addObserver(this);

        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/background.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.alignItems();
        
         //Sound
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if (!game.musicOn()) {
            btnSound.setIcon(iconOff);
        }
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

        btnHome.setLocation((int) (screenWidth - 100) ,(int) ( 30));
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));
    }
    
    private void createButtonMatrix(){
       panelJuego.setLayout(new GridLayout(8, 9));
       botones = new JButton[9][10];
       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 9; j++) {
               JButton jButton = new JButton();
               panelJuego.add(jButton);
               botones[i][j] = jButton;
               botones[i][j].setBackground(Color.WHITE);
               botones[i][j].setForeground(Color.WHITE);
               botones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
           }
       }        
   }
    
    private void fillButtonMatrix() {
  
        GameBoard gameboard = selectedMatch.getListOfGameBoard().get(i);
        Token[][] tokenMatrix = gameboard.getTokenMatrix();
        Player playerRed = selectedMatch.getListOfPlayers().get(1);

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
    
    private void playMusic(){
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if(game.musicOn()){
            btnSound.setIcon(iconOn);
            sound.loop();
        }else{
            btnSound.setIcon(iconOff);
            sound.stop();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSound = new javax.swing.JButton();
        panelJuego = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnFollowGameBoard = new javax.swing.JButton();
        btnBeginAnotherMatch = new javax.swing.JButton();
        JSContainerLstMatches = new javax.swing.JScrollPane();
        lstMatches = new javax.swing.JList();
        btnConfirm = new javax.swing.JButton();
        lblTurn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.setBorderPainted(false);
        btnSound.setContentAreaFilled(false);
        btnSound.setFocusPainted(false);
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 650, -1, -1));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 710, 470));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, -1, -1));

        btnFollowGameBoard.setBackground(new java.awt.Color(255, 255, 255));
        btnFollowGameBoard.setFont(new java.awt.Font("Snubnose DEMO", 0, 18)); // NOI18N
        btnFollowGameBoard.setText("Siguiente");
        btnFollowGameBoard.setFocusPainted(false);
        btnFollowGameBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowGameBoardActionPerformed(evt);
            }
        });
        getContentPane().add(btnFollowGameBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 710, 100, 40));

        btnBeginAnotherMatch.setBackground(new java.awt.Color(255, 255, 255));
        btnBeginAnotherMatch.setFont(new java.awt.Font("Snubnose DEMO", 0, 18)); // NOI18N
        btnBeginAnotherMatch.setText("Comenzar otra partida");
        btnBeginAnotherMatch.setFocusPainted(false);
        btnBeginAnotherMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeginAnotherMatchActionPerformed(evt);
            }
        });
        getContentPane().add(btnBeginAnotherMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 710, 190, 40));

        lstMatches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstMatchesMouseClicked(evt);
            }
        });
        JSContainerLstMatches.setViewportView(lstMatches);

        getContentPane().add(JSContainerLstMatches, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 480, 366));

        btnConfirm.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirm.setFont(new java.awt.Font("Snubnose DEMO", 0, 18)); // NOI18N
        btnConfirm.setText("Confirmar");
        btnConfirm.setFocusPainted(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 120, 40));

        lblTurn.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblTurn.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 320, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.musicOn()) {
            game.setMusicState(false);
        } else {
            game.setMusicState(true);
        }
    }//GEN-LAST:event_btnSoundActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        menuWindow.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnFollowGameBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowGameBoardActionPerformed
        i++;
        
        if (i < selectedMatch.getListOfGameBoard().size()) {
           //TURN
            Player currentPlayer = selectedMatch.getListOfPlayerTurn().get(i);
            String player;
            if(currentPlayer.equals(selectedMatch.getListOfGameBoard().get(0).getPlayerRed())){
                player = "Turno Jugador Rojo";
            }else{
                player = "Turno Jugador Azul" ;
            }
            lblTurn.setText(player);
            
            this.fillButtonMatrix();
        }else{
            i--;
            JOptionPane.showMessageDialog(this, "No hay mas tableros", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFollowGameBoardActionPerformed

    private void lstMatchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMatchesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lstMatchesMouseClicked

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        if (lstMatches.getSelectedValue()!=null) {
            selectedMatch = (Match)lstMatches.getSelectedValue();
            this.fillButtonMatrix();
            
            Player currentPlayer = selectedMatch.getListOfPlayerTurn().get(i);
            String player;
            if(currentPlayer.equals(selectedMatch.getListOfGameBoard().get(0).getPlayerRed())){
                player = "Turno Jugador Rojo";
            }else{
                player = "Turno Jugador Azul" ;
            }
            lblTurn.setText(player);
            
            JSContainerLstMatches.setVisible(false);
            panelJuego.setVisible(true);
            btnConfirm.setVisible(false);
            btnBeginAnotherMatch.setVisible(true);
            btnFollowGameBoard.setVisible(true);
        }else{
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnBeginAnotherMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeginAnotherMatchActionPerformed
            ArrayList<Player> listOfPlayers = selectedMatch.getListOfPlayers();
            String wayToFinish = selectedMatch.getWayToFinish();
            int qtyOfMovements = selectedMatch.getInitialQtyOfMovements();
            
          Match newMatch = new Match(listOfPlayers.get(0), listOfPlayers.get(1), wayToFinish, qtyOfMovements);
          
         GameBoard currentGameboard = selectedMatch.getListOfGameBoard().get(i);
         GameBoard auxGameboard = new GameBoard(listOfPlayers);
            
         Token[][] auxMatrix = auxGameboard.getTokenMatrix();
          //Clone each token to save another gameboard and not modify all the gameboards
          for (int i = 0; i < auxMatrix.length; i++) {
                for (int j = 0; j < auxMatrix[0].length; j++) {
                     if (currentGameboard.getTokenMatrix()[i][j] != null) {
                    auxMatrix[i][j] = (Token) currentGameboard.getTokenMatrix()[i][j].clone();
                 }
             }
         }
          
            newMatch.setGameBoard(auxGameboard);
            game.addMatch(newMatch);
            
            WindowGameBoard windowGameBoard = new WindowGameBoard(game, menuWindow, newMatch);
            windowGameBoard.setVisible(true);
            this.dispose();
                    
    }//GEN-LAST:event_btnBeginAnotherMatchActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if (game.musicOn()) {
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
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnFollowGameBoard;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JList lstMatches;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
