package controllers;

import domains.Game;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import windows.WindowIntroduction;
/**
 * @author Marco Fiorito and Felipe Najson
 */
public class Controller {

   
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, FontFormatException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        Game game = new Game();
        File f1 = new File("Data");
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        createFonts();
        
        if(f1.exists()){
                FileInputStream file = new FileInputStream("Data");
                BufferedInputStream buffer = new BufferedInputStream(file);
                ObjectInputStream input = new ObjectInputStream(buffer);
                game =(Game)(input.readObject());
        }
          WindowIntroduction windowIntroduction = new WindowIntroduction(game);
          windowIntroduction.setVisible(true);

    }
    
    public static void createFonts() throws FontFormatException, IOException{
        InputStream font = Controller.class.getResourceAsStream("/resources/ChalkDust.ttf");
         Font ChalkDust = Font.createFont(Font.TRUETYPE_FONT, font);
         
         font = Controller.class.getResourceAsStream("/resources/snubnose.otf");
         Font SnubnoseDemo = Font.createFont(Font.TRUETYPE_FONT, font);
         
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(ChalkDust);
        ge.registerFont(SnubnoseDemo);
    }
    
}
