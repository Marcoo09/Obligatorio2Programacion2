    package domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 * @author Felipe Najson and Marco Fiorito
 */

public class Game  extends Observable implements Serializable{
    private ArrayList<Match> listOfMatches;
    private ArrayList<Player> listOfPlayers;
    private boolean stateMusic;
    public Game(){
        listOfMatches = new ArrayList<>();      
        listOfPlayers = new ArrayList<>();
    }
    
    public ArrayList<Match> getListOfMatches() {
        return listOfMatches;
    }

    public boolean isStateMusic() {
        return stateMusic;
    }

    public void setStateMusic(boolean stateMusic) {
        this.stateMusic = stateMusic;
        this.setChanged();
        this.notifyObservers();
    }    

    public void addMatch(Match match){
        this.getListOfMatches().add(match);
    }
    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }
    
    public void addPlayer(Player player){
        this.getListOfPlayers().add(player);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void sortMatchesByDateTime(){
        Collections.sort(this.getListOfMatches());
    }
    public void sortPlayersByWonGames(){
        Collections.sort(listOfPlayers);
    }
    
}
