/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Usuario
 */
public class utils {
     /*Utils used above*/
//    //This method ask for a String and return the value
//    public static String askForString(String whatToAsk) {
//        Scanner inputString = new Scanner(System.in);
//        System.out.print("Ingrese " + whatToAsk + ": ");
//        return inputString.nextLine();
//    }
//
//    //This method ask for a Number and return the value
//    public static int askForNumeric(String whatToAsk) {
//        boolean repeat = true;
//        Scanner inputNumeric = new Scanner(System.in);
//        int ret = 0;
//
//        while (repeat) {
//            try {
//                System.out.print("Ingrese " + whatToAsk + ": ");
//                ret = inputNumeric.nextInt();
//                repeat = false;
//            } catch (InputMismatchException e) {
//                if (e.toString().equals("java.util.InputMismatchException")) {
//                    System.out.println("Debes ingresar un número");
//                } else {
//                    System.out.println("Debes ingresar un número más corto");
//                }
//                repeat = true;
//                inputNumeric.next();
//            }
//        }
//        return ret;
//    }
//
   //Range Validator in attribute
    public static boolean validateAttribute(int numberToValidate, int intialRange, int finalRange) {
        //Check if the first parameter is between the range
        boolean returnValue = (numberToValidate >= intialRange && numberToValidate <= finalRange);
        return returnValue;
    }
//
//    //Range Validator in values only (without system out)
//    public static boolean validateRange(int numberToValidate, int intialRange, int finalRange) {
//        //Check if the first parameter is between the range        
//        return (numberToValidate >= intialRange && numberToValidate <= finalRange);
//    }
//
//    public static boolean validMovementDirectionInput(String inputMovement) {
//        boolean isValidMovement = false;
//        for (int i = 0; i < GameBoard.posibleDirectionsMovements.length; i++) {
//            String currentValue = GameBoard.posibleDirectionsMovements[i];
//            if (inputMovement.equalsIgnoreCase(currentValue)) {
//                isValidMovement = true;
//            }
//        }
//        return isValidMovement;
//    }
//
//    public static void showPosibleDirectionsMovements(ArrayList<Integer> posibleTokenMovents, int tokenMoved) {
//        int currentValue;
//        ArrayList<Integer> auxArraylist = new ArrayList<>();
//        Iterator<Integer> it = posibleTokenMovents.iterator();
//
//        while (it.hasNext()) {
//            currentValue = it.next();
//            System.out.print(currentValue + " ");
//        }
//
//    }
//    
//    public static ArrayList<Integer> removeTokensWithAnyPosibleMovement(GameBoard gameboard, ArrayList<Integer> posibleTokenMovements, String playerColor, Player player) {
//        int size = posibleTokenMovements.size();
//        int currentTokenValue;
//        ArrayList<Integer> returnedArrayList = new ArrayList<>();
//        
//        boolean hasMovementsToA = true;
//        boolean hasMovementsToD = true;
//        boolean hasMovementsToI = true;
//        
//        int positionOfTokenX;
//        int positionOfTokenY;
//        
//        if (playerColor.equalsIgnoreCase("red")) {
//            for (int i = 0; i < size; i++) {
//                currentTokenValue = posibleTokenMovements.get(i);
//                gameboard.searchPositionOfToken(currentTokenValue, player);
//                
//                positionOfTokenX = gameboard.getTokenPositionX();
//                positionOfTokenY = gameboard.getTokenPositionY();
//                
//                hasMovementsToA = Interface.validatePositionMovement(player,gameboard,positionOfTokenX,positionOfTokenY,"A");
//                hasMovementsToD = Interface.validatePositionMovement(player,gameboard,positionOfTokenX,positionOfTokenY ,"D");
//                hasMovementsToI = Interface.validatePositionMovement(player,gameboard,positionOfTokenX,positionOfTokenY,"I");
//                
//                if(hasMovementsToA || hasMovementsToD || hasMovementsToI){
//                    returnedArrayList.add(currentTokenValue);
//                }
//            }
//        } else if (playerColor.equalsIgnoreCase("blue")) {
//            for (int i = 0; i < size; i++) {
//                currentTokenValue = posibleTokenMovements.get(i);
//                gameboard.searchPositionOfToken(currentTokenValue, player);
//                
//                positionOfTokenX = gameboard.getTokenPositionX();
//                positionOfTokenY = gameboard.getTokenPositionY();
//                
//                hasMovementsToA = Interface.validatePositionMovement(player,gameboard,positionOfTokenX,positionOfTokenY ,"A");
//                hasMovementsToD = Interface.validatePositionMovement(player,gameboard,positionOfTokenX ,positionOfTokenY,"D");
//                hasMovementsToI = Interface.validatePositionMovement(player,gameboard,positionOfTokenX,positionOfTokenY,"I");
//                
//                if(hasMovementsToA || hasMovementsToD || hasMovementsToI){
//                    returnedArrayList.add(currentTokenValue);
//                }
//            }
//        }
//        
//        return returnedArrayList;
//    }
//        
//    public static void showRanking(Game game) {
//        game.sortPlayersByWonGames();
//        ArrayList<Player> listOfPlayers = game.getListOfPlayers();
//        System.out.println("\n      :: RANKING ::     \n");
//        for (int i = 0; i < listOfPlayers.size(); i++) {
//            System.out.println("..: " + (i + 1) + " :.." + listOfPlayers.get(i));
//        }
//    }

}
