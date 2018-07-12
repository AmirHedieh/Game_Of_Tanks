package game.multiplayer;

import game.elements.*;

import java.io.Serializable;
import java.util.ArrayList;

public class TransferringData implements Serializable
{
    private ArrayList<Tank> players;
    private ArrayList<AITank> tanks;
    private ArrayList<Bullet> bullets;
    private ArrayList<Turret> turrets;
    private ArrayList<BuriedRobot> robots;

    public ArrayList<Tank> getPlayers()
    {
        return players;
    }

    public ArrayList<AITank> getTanks()
    {
        return tanks;
    }

    public ArrayList<Bullet> getBullets()
    {
        return bullets;
    }

    public ArrayList<Turret> getTurrets()
    {
        return turrets;
    }

    public ArrayList<BuriedRobot> getRobots()
    {
        return robots;
    }

    //constructor
    public TransferringData()
    {

    }

    public TransferringData(Objects objects)
    {
        this.players = objects.getPlayers();
        this.tanks = objects.getTanks();
        this.bullets = objects.getBullets();
        this.turrets = objects.getTurrets();
        this.robots = objects.getRobots();
    }
}

