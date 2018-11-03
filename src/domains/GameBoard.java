package domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import views.Interface;
/**
 * @author Felipe Najson and Marco Fiorito
 */
public class GameBoard implements Serializable{

    private Token[][] tokenMatrix;
    private ArrayList<Player> listOfPlayers;
    private int tokenPositionX;
    private int tokenPositionY;

    public static String[] posibleDirectionsMovements = {"I", "A", "D"};

    public GameBoard(ArrayList<Player> listOfPlayers) {
        this.tokenMatrix = new Token[8][9];
        this.listOfPlayers = listOfPlayers;
    }    

    public int getTokenPositionX() {
        return tokenPositionX;
    }

    public void setTokenPositionX(int tokenPositionX) {
        this.tokenPositionX = tokenPositionX;
    }

    public int getTokenPositionY() {
        return tokenPositionY;
    }

    public void setTokenPositionY(int tokenPositionY) {
        this.tokenPositionY = tokenPositionY;
    }

    public Token[][] getTokenMatrix() {
        return tokenMatrix;
    }

    public void setTokenMatrix(Token[][] tokenMatrix) {
        this.tokenMatrix = tokenMatrix;
    }

    public Player getPlayerRed() {
        return this.listOfPlayers.get(1);
    }

    public Player getPlayerBlue() {
        return this.listOfPlayers.get(0);
    }

    public ArrayList<Integer> getPossibleMovements(int parmNumber, int positionOfTokenX, int positionOfTokenY) {

        return this.sumOfDiagonalsAndEdges(parmNumber, positionOfTokenX, positionOfTokenY);
    }

    //Intial matrix of the game
    public void fillInitialMatrix(int[] tokenNumbers) {
        int row = this.tokenMatrix.length;
        int col = this.tokenMatrix[0].length;
        int counter = 0;
        Player currentPlayer;

        Token currentToken = new Token();

        for (int i = 0; i < row; i += row - 1) {
            currentPlayer = listOfPlayers.get(counter);
            for (int j = 1; j < col; j++) {
                currentToken = new Token();
                
                //if is the first the row, draw the tokens of blue player
                if (i == 0) {
                    currentToken.setPlayer(currentPlayer);
                    currentToken.setTokenNumber(tokenNumbers[j]);
                    currentToken.setColor("\033[34m");
                    this.tokenMatrix[i][j] = currentToken;
                }
                //if is the the row is the last, draw the tokens of red player
                else {
                    currentToken.setPlayer(currentPlayer);
                    currentToken.setTokenNumber(tokenNumbers[col - j]);
                    currentToken.setColor("\033[31m");
                    this.tokenMatrix[i][j - 1] = currentToken;
                }
            }
            counter++;
        }
    }

    public void searchPositionOfToken(int tokenNumber, Player aPlayer) {
        Token[][] tokenMatrix = this.getTokenMatrix();
        int positionX = 0;
        int positionY = 0;
        boolean founded = false;

        for (int i = 0; i < tokenMatrix.length && !founded; i++) {
            for (int j = 0; j < tokenMatrix[0].length && !founded; j++) {
                Token currentToken = tokenMatrix[i][j];
                if (currentToken != null) {
                    if (currentToken.getTokenNumber() == tokenNumber && currentToken.getPlayer().equals(aPlayer)) {
                        positionX = j;
                        positionY = i;
                        founded = true;
                    }
                }
            }
        }
        this.setTokenPositionX(positionX);
        this.setTokenPositionY(positionY);

    }

    public ArrayList<Integer> sumOfDiagonalsAndEdges(int initialValue, int positionOfTokenX, int positionOfTokenY) {
        ArrayList<Integer> sum = new ArrayList<>();
        //Initial point of diagonal
        int positionX = positionOfTokenX;
        int positionY = positionOfTokenY;

        int firstDiagonal = initialValue;
        int secondDiagonal = initialValue;
        int horizontalSum = initialValue;
        int verticalSum = initialValue;

        //First Diagonal
        while (positionY != 0 && positionX != 0) {
            positionY--;
            positionX--;
            if (tokenMatrix[positionY][positionX] != null) {
                firstDiagonal += tokenMatrix[positionY][positionX].getTokenNumber();
            }
        }

        positionX = positionOfTokenX;
        positionY = positionOfTokenY;

        while (positionY != tokenMatrix.length - 1 && positionX != tokenMatrix[0].length - 1) {
            positionY++;
            positionX++;
            if (tokenMatrix[positionY][positionX] != null) {
                firstDiagonal += tokenMatrix[positionY][positionX].getTokenNumber();
            }
        }

        if (firstDiagonal != initialValue && firstDiagonal < 9 && !(sum.contains(firstDiagonal))) {
            sum.add(firstDiagonal);
        }

        positionX = positionOfTokenX;
        positionY = positionOfTokenY;

        //Second Diagonala
        while (positionY != 0 && positionX != tokenMatrix[0].length - 1) {
            positionY--;
            positionX++;
            if (tokenMatrix[positionY][positionX] != null) {
                secondDiagonal += tokenMatrix[positionY][positionX].getTokenNumber();
            }
        }
        positionX = positionOfTokenX;
        positionY = positionOfTokenY;

        while (positionY != tokenMatrix.length - 1 && positionX != 0) {
            positionY++;
            positionX--;
            if (tokenMatrix[positionY][positionX] != null) {
                secondDiagonal += tokenMatrix[positionY][positionX].getTokenNumber();
            }
        }

        if (secondDiagonal != initialValue && secondDiagonal < 9 && !(sum.contains(secondDiagonal))) {
            sum.add(secondDiagonal);
        }

        positionX = positionOfTokenX;
        positionY = positionOfTokenY;

        //Horizontal Sum
        for (int i = 0; i < tokenMatrix.length; i++) {
            if (tokenMatrix[i][positionX] != null && i != positionY) {
                horizontalSum += tokenMatrix[i][positionX].getTokenNumber();
            }
        }

        if (horizontalSum != initialValue && horizontalSum < 9 && !(sum.contains(horizontalSum))) {
            sum.add(horizontalSum);
        }

        //Vertical Sum
        for (int j = 0; j < tokenMatrix[0].length; j++) {
            if (tokenMatrix[positionY][j] != null && j != positionX) {
                verticalSum += tokenMatrix[positionY][j].getTokenNumber();
            }
        }

        if (verticalSum != initialValue && verticalSum < 9 && !(sum.contains(verticalSum))) {
            sum.add(verticalSum);
        }

        
        return sum;
    }
    
       public static GameBoard movePiece(Player auxPlayer, GameBoard actualGameBoard, int positionOfTokenX, int positionOfTokenY, String movementDirection) {
        Token[][] matrix = actualGameBoard.getTokenMatrix();

        //Player Red
        if (auxPlayer.equals(actualGameBoard.getPlayerRed())) {
            if (movementDirection.equalsIgnoreCase("D")) {
                matrix[positionOfTokenY - 1][positionOfTokenX + 1] = matrix[positionOfTokenY][positionOfTokenX];
                matrix[positionOfTokenY][positionOfTokenX] = null;
            }
            if (movementDirection.equalsIgnoreCase("I")) {
                matrix[positionOfTokenY - 1][positionOfTokenX - 1] = matrix[positionOfTokenY][positionOfTokenX];
                matrix[positionOfTokenY][positionOfTokenX] = null;

            }
            if (movementDirection.equalsIgnoreCase("A")) {
                matrix[positionOfTokenY - 1][positionOfTokenX] = matrix[positionOfTokenY][positionOfTokenX];
                matrix[positionOfTokenY][positionOfTokenX] = null;

            }
        } //Player Blue
        else if (auxPlayer.equals(actualGameBoard.getPlayerBlue())) {
            if (movementDirection.equalsIgnoreCase("D")) {
                matrix[positionOfTokenY + 1][positionOfTokenX - 1] = matrix[positionOfTokenY][positionOfTokenX];
                matrix[positionOfTokenY][positionOfTokenX] = null;
            }
            if (movementDirection.equalsIgnoreCase("I")) {
                matrix[positionOfTokenY + 1][positionOfTokenX + 1] = matrix[positionOfTokenY][positionOfTokenX];
                matrix[positionOfTokenY][positionOfTokenX] = null;

            }
            if (movementDirection.equalsIgnoreCase("A")) {
                matrix[positionOfTokenY + 1][positionOfTokenX] = matrix[positionOfTokenY][positionOfTokenX];
                matrix[positionOfTokenY][positionOfTokenX] = null;

            }
        }

        actualGameBoard.setTokenMatrix(matrix);
        return actualGameBoard;
    }
       
      /*public static boolean validatePositionMovement(Player auxPlayer, GameBoard actualGameBoard, int positionOfTokenX, int positionOfTokenY, String movementDirection) {
        Token[][] matrix = actualGameBoard.getTokenMatrix();
        Token auxTokenToCompare = null;

        boolean isValidPositionMovement = false;
        boolean isOutOfRangeY;
        boolean isOutOfRangeX;

        //Player Red
        if (auxPlayer.equals(actualGameBoard.getPlayerRed())) {
            isOutOfRangeY = Interface.validateRange(positionOfTokenY - 1, 0, 7);

            if (movementDirection.equalsIgnoreCase("D")) {
                isOutOfRangeX = Interface.validateRange(positionOfTokenX + 1, 0, 8);

                if (isOutOfRangeX && isOutOfRangeY) {
                    auxTokenToCompare = matrix[positionOfTokenY - 1][positionOfTokenX + 1];

                    if (auxTokenToCompare == null) {
                        isValidPositionMovement = true;
                    }
                }

            } else if (movementDirection.equalsIgnoreCase("I")) {
                isOutOfRangeX = Interface.validateRange(positionOfTokenX - 1, 0, 8);

                if (isOutOfRangeX && isOutOfRangeY) {
                    auxTokenToCompare = matrix[positionOfTokenY - 1][positionOfTokenX - 1];

                    if (auxTokenToCompare == null) {
                        isValidPositionMovement = true;
                    }
                }

            } else if (movementDirection.equalsIgnoreCase("A")) {
                isOutOfRangeX = Interface.validateRange(positionOfTokenX, 0, 8);

                if (isOutOfRangeX && isOutOfRangeY) {
                    auxTokenToCompare = matrix[positionOfTokenY - 1][positionOfTokenX];

                    if (auxTokenToCompare == null) {
                        isValidPositionMovement = true;
                    }

                }

            }
        } //Player blue
        else if (auxPlayer.equals(actualGameBoard.getPlayerBlue())) {

            isOutOfRangeY = Interface.validateRange(positionOfTokenY + 1, 0, 7);

            if (movementDirection.equalsIgnoreCase("D")) {
                isOutOfRangeX = Interface.validateRange(positionOfTokenX - 1, 0, 8);

                if (isOutOfRangeX && isOutOfRangeY) {
                    auxTokenToCompare = matrix[positionOfTokenY + 1][positionOfTokenX - 1];

                    if (auxTokenToCompare == null) {
                        isValidPositionMovement = true;
                    }

                }

            } else if (movementDirection.equalsIgnoreCase("I")) {
                isOutOfRangeX = Interface.validateRange(positionOfTokenX + 1, 0, 8);

                if (isOutOfRangeX && isOutOfRangeY) {
                    auxTokenToCompare = matrix[positionOfTokenY + 1][positionOfTokenX + 1];

                    if (auxTokenToCompare == null) {
                        isValidPositionMovement = true;
                    }

                }

            } else if (movementDirection.equalsIgnoreCase("A")) {
                isOutOfRangeX = Interface.validateRange(positionOfTokenX, 0, 8);

                if (isOutOfRangeX && isOutOfRangeY) {
                    auxTokenToCompare = matrix[positionOfTokenY + 1][positionOfTokenX];

                    if (auxTokenToCompare == null) {
                        isValidPositionMovement = true;
                    }

                }

            }
        }

        return isValidPositionMovement;
    }*/

}
