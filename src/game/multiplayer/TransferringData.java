package game.multiplayer;

import game.Utils.SharedData;
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
    private ArrayList<Upgrade> upgrades;
    private int takenDamage;
//
    private Boolean serverIsAlive;
    private Boolean clientIsAlive;

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

    public Boolean getServerIsAlive() {
        return serverIsAlive;
    }

    public Boolean getClientIsAlive() {
        return clientIsAlive;
    }

    public int getTakenDamage() {
        return takenDamage;
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
        takenDamage = SharedData.getData().clientTakenDamage;
        if(!SharedData.getData().ServerLost){
            serverIsAlive = true;
        }
        else {
            System.out.println("serverAlize false shod");
            serverIsAlive = false;
        }
        if(objects.getPlayers().size() > 1){
            clientIsAlive = true;
        }
        else {
            clientIsAlive = false;
            SharedData.getData().clientLost = true;
        }
    }
}

