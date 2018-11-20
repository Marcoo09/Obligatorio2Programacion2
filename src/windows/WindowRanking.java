package windows;

import domains.Game;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static windows.MenuWindow.sound;
/**
 * @author Marco Fiorito and Felipe Najson
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
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/background.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.alignItems();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
         //Sound
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if (!game.musicOn()) {
            btnSound.setIcon(iconOff);
        }
    }

    
    private void alignItems() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        lblTitle.setLocation((int) (screenWidth * 0.4 ), (int) (screenHeight * 0.01) );
        JSContainterRanking.setLocation((int) (screenWidth * 0.25), (int) (screenHeight * 0.1) );
        
        btnHome.setLocation((int) (screenWidth - 100) ,(int) ( 30));
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));
    }

    private void loadList() {
        game.sortPlayersByWonGames();
        lstRanking.setListData(game.getListOfPlayers().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSound = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        JSContainterRanking = new javax.swing.JScrollPane();
        lstRanking = new javax.swing.JList();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.setBorderPainted(false);
        btnSound.setContentAreaFilled(false);
        btnSound.setOpaque(false);
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
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, -1, -1));

        lstRanking.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        JSContainterRanking.setViewportView(lstRanking);

        getContentPane().add(JSContainterRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 750, 550));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, -1, -1));

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSContainterRanking;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList lstRanking;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.loadList();

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
}
