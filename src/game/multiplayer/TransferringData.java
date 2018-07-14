package game.multiplayer;

import game.Utils.SharedData;
import game.elements.*;
import game.map.SoftWall;

import java.io.Serializable;
import java.util.ArrayList;

public class TransferringData implements Serializable
{
    private ArrayList<Tank> players;
    private ArrayList<AITank> tanks;
    private ArrayList<Bullet> bullets;
    private ArrayList<Turret> turrets;
    private ArrayList<BuriedRobot> robots;
    private ArrayList<Upgrade> upgrades;
    private ArrayList<SoftWall> walls;
    private int takenDamage;
    //
    private Boolean serverIsAlive;
    private Boolean clientIsAlive;
    private Boolean gameDone = SharedData.getData().gameDone;

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

    public ArrayList<Upgrade> getUpgrades()
    {
        return upgrades;
    }

    public Boolean getServerIsAlive()
    {
        return serverIsAlive;
    }

    public Boolean getClientIsAlive()
    {
        return clientIsAlive;
    }

    public Boolean getGameDone() {
        return gameDone;
    }

    public int getTakenDamage()
    {
        return takenDamage;
    }

    public ArrayList<SoftWall> getWalls() {
        return walls;
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
        this.upgrades = objects.getUpgrades();
        this.walls = objects.getMap().getSoftWall();

        takenDamage = SharedData.getData().clientTakenDamage;
        if (!SharedData.getData().ServerLost)
        {
            System.out.println("11111");
            serverIsAlive = true;
        }
        else
        {
            System.out.println("serverAlize false shod");
            System.out.println("22222");
            serverIsAlive = false;
        }
        if (objects.getPlayers().size() > 1)
        {
            System.out.println("3333");
            clientIsAlive = true;
        }
        else
        {
            System.out.println("4444");
            clientIsAlive = false;
            SharedData.getData().clientLost = true;
        }
    }
}

