package game.savingElements;

import game.elements.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * all data that must be stored and combined in 1 Serializable object.
 * the object will be used to be written and read later.
 */
public class SavingData implements Serializable {
    //fields
    private ArrayList<Tank> players;
    private ArrayList<AITank> tanks;
    private ArrayList<Bullet> bullets;
    private ArrayList<Turret> turrets;
    private ArrayList<BuriedRobot> robots;
    private ArrayList<Upgrade> upgrades;

    public SavingData(){

    }

    public void setPlayers(ArrayList<Tank> players) {
        this.players = players;
    }

    public void setTanks(ArrayList<AITank> tanks) {
        this.tanks = tanks;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void setTurrets(ArrayList<Turret> turrets) {
        this.turrets = turrets;
    }

    public void setRobots(ArrayList<BuriedRobot> robots) {
        this.robots = robots;
    }

    public void setUpgrades(ArrayList<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    public ArrayList<Tank> getPlayers() {
        return players;
    }

    public ArrayList<AITank> getTanks() {
        return tanks;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public ArrayList<Turret> getTurrets() {
        return turrets;
    }

    public ArrayList<BuriedRobot> getRobots() {
        return robots;
    }

    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }
}
