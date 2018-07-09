package game.multiplayer;

import game.elements.Tank;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * data that must be transferred between server and client.
 */
public class TransferingData implements Serializable{

    private ArrayList<Tank> players;

    public void setPlayers(ArrayList<Tank> players){
        this.players = players;
    }

    public ArrayList<Tank> getPlayers() {
        return players;
    }
}
