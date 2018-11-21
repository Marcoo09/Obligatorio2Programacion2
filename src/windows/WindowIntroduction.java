package windows;

import domains.Game;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Marco Fiorito and Felipe Najson
 */
public class WindowIntroduction extends javax.swing.JFrame {

   private Game game;
   private Timer timer;
   private ActionListener actionListener;
   private static WindowIntroduction wIntroduction;
   static  MenuWindow menuWindow;
   static  int imageIndex;
   String[] listOfResources = {
                "/resources/transition1-img.png",
                "/resources/transition2-img.png",
                "/resources/transition3-img.png",
                "/resources/transition4-img.png",
                "/resources/transition5-img.png"
    };
    
    public WindowIntroduction(Game aGame) throws IOException {
        initComponents();
        game = aGame;
        wIntroduction = this;
        menuWindow = new MenuWindow(game);
        imageIndex = 0;
        
        
        try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(getClass().getResource("/resources/background.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
            panel.setLayout(null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.alignItems();
       
       //Slider
        setImageSize(0);
        img.setVisible(true);
        //ProgressBar
        this.beginProgressBar();
       
    }
    
    public void alignItems(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        img.setSize((int)(screenWidth * 0.7), (int)(screenHeight * 0.7));
        img.setLocation((int) (screenWidth * 0.175) , (int) (screenHeight * 0.05));
        
        jpgBar.setSize((int)(screenWidth * 0.8), 30);
        jpgBar.setLocation((int) (screenWidth * 0.125) , (int) (screenHeight * 0.8));
        
        btnSkip.setLocation((int) (screenWidth - 125) ,(int) (screenHeight - 75));

    }
        
    private void setImageSize(int i){
        ImageIcon icon = new ImageIcon(getClass().getResource(listOfResources[i]));
        Image imgResource = icon.getImage();
        Image newImage = imgResource.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImage);
        img.setIcon(newImc);
    }
    private static void openMenu() throws IOException{
         menuWindow.setVisible(true);
    }
    private void beginProgressBar(){
        jpgBar.setVisible(true);
        
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int jpgBarValue = jpgBar.getValue();
                if( jpgBarValue < 100){
                    if(jpgBarValue % 20 == 0){
                        setImageSize(imageIndex);
                        imageIndex++;
                        if(imageIndex>= listOfResources.length){
                            imageIndex = 0;
                        }
                    }
                  jpgBar.setValue(jpgBarValue + 1);                  
                }else{                    
                    try {
                        openMenu();
                    } catch (IOException ex) {
                        Logger.getLogger(WindowIntroduction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                    timer.stop();
                };
            }
        });
        
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpgBar = new javax.swing.JProgressBar();
        img = new javax.swing.JLabel();
        btnSkip = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpgBar.setForeground(new java.awt.Color(0, 132, 55));
        jpgBar.setOpaque(true);
        jpgBar.setStringPainted(true);
        getContentPane().add(jpgBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 1000, 30));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/transition1-img.png"))); // NOI18N
        getContentPane().add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 970, 540));

        btnSkip.setBackground(new java.awt.Color(255, 255, 255));
        btnSkip.setFont(new java.awt.Font("Snubnose DEMO", 0, 30)); // NOI18N
        btnSkip.setForeground(new java.awt.Color(255, 255, 255));
        btnSkip.setText("Skip");
        btnSkip.setBorderPainted(false);
        btnSkip.setContentAreaFilled(false);
        btnSkip.setFocusPainted(false);
        btnSkip.setOpaque(false);
        btnSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipActionPerformed(evt);
            }
        });
        getContentPane().add(btnSkip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 660, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipActionPerformed
        try {
            openMenu();
        } catch (IOException ex) {
            Logger.getLogger(WindowIntroduction.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        timer.stop();
    }//GEN-LAST:event_btnSkipActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSkip;
    private javax.swing.JLabel img;
    private javax.swing.JProgressBar jpgBar;
    // End of variables declaration//GEN-END:variables
}
