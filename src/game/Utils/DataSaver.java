package game.Utils;

import game.elements.*;

import java.io.Serializable;
import java.util.ArrayList;

public class DataSaver implements Serializable {

    //fields
    private ArrayList<Tank> players;
    private ArrayList<AITank> tanks;
    private ArrayList<Bullet> bullets;
    private ArrayList<Turret> turrets;
    private ArrayList<BuriedRobot> robots;
    private ArrayList<Upgrade> upgrades;

    public DataSaver(Objects objects){
        players = objects.getPlayers();
        tanks = objects.getTanks();
        bullets = objects.getBullets();
        turrets = objects.getTurrets();
        robots = objects.getRobots();
        upgrades = objects.getUpgrades();
    }

}
