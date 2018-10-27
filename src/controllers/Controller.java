/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Game;
import windows.MenuWindow;


/**
 *
 * @author Usuario
 */
public class Controller {

   
    public static void main(String[] args) {
        
        Game game = new Game();
        MenuWindow window = new MenuWindow(game);
        window.setVisible(true);
    }
    
}
