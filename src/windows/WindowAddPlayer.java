package windows;

import controllers.Utils;
import domains.Game;
import domains.Player;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static windows.MenuWindow.sound;
/**
 * @author Felipe Najson and Marco Fiorito
 */
public class WindowAddPlayer extends javax.swing.JFrame implements Observer {

    private Game game;
    private MenuWindow menuWindow;

    public WindowAddPlayer(Game aGame, MenuWindow mainWindow) {
        initComponents();
        game = aGame;
        menuWindow = mainWindow;
        game.addObserver(this);
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/background.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
         //Sound
        ImageIcon iconOff = new ImageIcon(getClass().getResource("/resources/speakerOff-img.png"));
        ImageIcon iconOn = new ImageIcon(getClass().getResource("/resources/speakerOn-img.png"));
        if (!game.musicOn()) {
            btnSound.setIcon(iconOff);
        }
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.alignItems();
    }

    private void alignItems() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        lblTitle.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 1);
        lblName.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 20);
        lblNickname.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 40);
        lblAge.setLocation((int) (screenWidth / 100) * 1, (int) (screenHeight / 100) * 60);

        txtName.setLocation((int) (screenWidth / 100) * 30, (int) (screenHeight / 100) * 22);
        txtNickName.setLocation((int) (screenWidth / 100) * 30, (int) (screenHeight / 100) * 42);
        txtAge.setLocation((int) (screenWidth / 100) * 30, (int) (screenHeight / 100) * 62);
        
        btnAddPlayer.setLocation((int) (screenWidth / 100) * 75, (int) (screenHeight / 100) * 80);
        btnHome.setLocation((int) (screenWidth - 100) ,(int) (30));
        btnSound.setLocation((int) (screenWidth - 100) ,(int) (screenHeight - 75));
    }

    private void cleanInputs(){
        txtName.setText("");
        txtNickName.setText("");
        txtAge.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddPlayer = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNickname = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnSound = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddPlayer.setBackground(new java.awt.Color(255, 255, 255));
        btnAddPlayer.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        btnAddPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/tick-img.png"))); // NOI18N
        btnAddPlayer.setText("Ingresar Jugador");
        btnAddPlayer.setActionCommand("   Ingresar Jugador");
        btnAddPlayer.setFocusPainted(false);
        btnAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 590, 290, 80));

        lblTitle.setFont(new java.awt.Font("Snubnose DEMO", 0, 55)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Ingreso de jugador");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, -1));

        txtName.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, 160, 30));

        lblNickname.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblNickname.setForeground(new java.awt.Color(255, 255, 255));
        lblNickname.setText("Alias:");
        getContentPane().add(lblNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, -1, -1));

        lblAge.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblAge.setForeground(new java.awt.Color(255, 255, 255));
        lblAge.setText("Edad:");
        getContentPane().add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, -1, -1));

        lblName.setFont(new java.awt.Font("Snubnose DEMO", 0, 36)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Nombre:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, -1, -1));

        txtNickName.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        txtNickName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(txtNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, 160, 30));

        txtAge.setFont(new java.awt.Font("Snubnose DEMO", 0, 24)); // NOI18N
        txtAge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 520, 160, 30));

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/speakerOn-img.png"))); // NOI18N
        btnSound.setBorderPainted(false);
        btnSound.setContentAreaFilled(false);
        btnSound.setFocusPainted(false);
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });
        getContentPane().add(btnSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 730, -1, -1));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home-img.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        if (game.musicOn()) {
            game.setMusicState(false);
        } else {
            game.setMusicState(true);
        }
    }//GEN-LAST:event_btnSoundActionPerformed

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        ArrayList<Player> listOfPlayers = game.getListOfPlayers();
        //Variables of Player
        String name;
        String nickName = "";
        int age = 0;
        
        String errorMessage =  "Ingreses valores correctos en el/los campo/s: ";

        Player auxPlayer = new Player("", "", 0);
        Player returnedPlayer;
        //Variables used in validators
        boolean ageValidator = false;
        boolean nickNameValidator = false;

        name = txtName.getText();
        //Validation of nickname
         nickName = txtNickName.getText();
         auxPlayer.setNickName(nickName);
         nickNameValidator = !(listOfPlayers.contains(auxPlayer));

         if (!nickNameValidator) {
                errorMessage += " ALIAS";
            }

        //Validation of age
        try{
            age = Integer.parseInt(txtAge.getText());
            ageValidator = Utils.validateAttribute(age, 0, 120);

        }catch(NumberFormatException e){
             ageValidator = false;
        }
        
        if(!ageValidator){
                errorMessage += " EDAD";
          }
        
        if(!ageValidator || !nickNameValidator){
             JOptionPane.showMessageDialog(this, errorMessage ,"Inputs problems",  JOptionPane.ERROR_MESSAGE);
        }else{
            returnedPlayer = new Player(name, nickName, age);
            game.addPlayer(returnedPlayer);
            cleanInputs();
            this.dispose();
            menuWindow.setVisible(true);
        }
    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        menuWindow.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSound;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNickName;
    // End of variables declaration//GEN-END:variables

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
}
