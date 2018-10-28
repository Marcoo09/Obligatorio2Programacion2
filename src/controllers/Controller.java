/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Game;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import windows.MenuWindow;


/**
 *
 * @author Usuario
 */
public class Controller {

   
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
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
