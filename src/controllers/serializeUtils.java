/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import domains.Game;
import domains.Player;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import windows.MenuWindow;

/**
 *
 * @author Marco Fiorito and Felipe Najson
 */
public class serializeUtils {
  
     public static void serialize(Game game){
             FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream("Data");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      BufferedOutputStream buffer = new BufferedOutputStream(fileOutput);
      ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(buffer);
        } catch (IOException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stream.writeObject(game);
             stream.flush();
            stream.close();
        } catch (IOException ex) {
            Logger.getLogger(MenuWindow.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
        
    public static void serializeListOfPlayersToJson(Game game) throws IOException{
        ArrayList<Player> listOfPlayers = game.getListOfPlayers();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("ListOfPlayers.json"),listOfPlayers);
    }
}
