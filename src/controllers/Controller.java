package controllers;

import domains.Game;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import windows.MenuWindow;


/**
 *
 * @author Marco Fiorito and Felipe Najson
 */
public class Controller {

   
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, FontFormatException {
        File font_file = new File("src/resources/ChalkDust.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);

        Game game = new Game();
        File f1 = new File("Data");
        
        if(f1.exists()){
                FileInputStream file = new FileInputStream("Data");
                BufferedInputStream buffer = new BufferedInputStream(file);
                ObjectInputStream input = new ObjectInputStream(buffer);
                game =(Game)(input.readObject());
        }
        
         MenuWindow window = new MenuWindow(game);
         window.setVisible(true);
    }
    
}
