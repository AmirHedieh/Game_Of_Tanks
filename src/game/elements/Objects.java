package game.elements;

import game.Utils.SharedData;
import game.Utils.Utility;
import game.map.*;

import java.io.Serializable;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * a class containing all created objects like tanks, bullets , turrets , ... in game
 * Ali call this class handler
 */
public class Objects implements Serializable
{

    //fields
    private ArrayList<Tank> players;
    private ArrayList<Tank> tanks;
    private ArrayList<Bullet> bullets;
    private ArrayList<Turret> turrets;
    private ArrayList<BuriedRobot> robots;
    private Map map;


    //constructor
    public Objects()
    {
        players = new ArrayList<>();
        tanks = new ArrayList<>();
        bullets = new ArrayList<>();
        turrets = new ArrayList<>();
        robots = new ArrayList<>();
        map = new Map("src/resource/map.png");
    }

    //methods

    /**
     * if the game hasn't been started before it needs to be initialized. player's tank must be create.
     */
    public void init()
    {
        //Player tank initialization
        players.add(new Tank(300, 100, 100, ObjectId.Player)); // making player's tank
        if(SharedData.getData().gameType.equals(ObjectId.TwoPlayer)){
            players.add(new Tank(300, 300, 100, ObjectId.Player)); // making player's tank
        }

        // Turrets initialization
        Turret turret = new Turret(800, 700, players);
        turrets.add(turret);

        //AI tanks initialization
//        Tank tank1 = new Tank(700,700,100,1);
//        tanks.add(tank1);

        //Buried Robots initialization
        //BuriedRobot robot1 = new BuriedRobot(700, 700);
        //robots.add(robot1);

    }

    /**
     * add a new player tank.
     * @param tank
     */
    public void addPlayerTank(Tank tank)
    {
        players.add(tank);
    }
    /**
     * add a tank to tanks ArrayList which contains all available tanks in game
     *
     * @param tank the tank which must be added
     */
    public void addTank(Tank tank)
    {
        tanks.add(tank);
    }

    /**
     * add a bullet to bullets ArrayList which contains all available bullets in game
     *
     * @param bullet the bullet which must be added
     */
    public void addBullet(Bullet bullet)
    {
        bullets.add(bullet);
    }

    /**
     * add a turret to turrets ArrayList which contains all available turrets in game
     *
     * @param turret the turret which must be added
     */
    public void addTurret(Turret turret)
    {
        turrets.add(turret);
    }

    /**
     * remove a tank from ArrayList which contains all available tanks in game
     *
     * @param tank the tank that must be removed
     */
    public void removeTank(Tank tank)
    {
        tanks.remove(tank);
    }

    /**
     * remove a bullet from ArrayList which contains all available bullets in game
     *
     * @param bullet the bullet that must be removed
     */
    public void removeBullet(Bullet bullet)
    {
        bullets.remove(bullet);
    }

    /**
     * remove a turret from ArrayList which contains all available turrets in game
     *
     * @param turret the turret that must be removed
     */
    public void removeTurret(Turret turret)
    {
        turrets.remove(turret);
    }

    /**
     * set a new arrayList for tanks
     *
     * @param tanks
     */
    public void setTanks(ArrayList<Tank> tanks)
    {
        this.tanks = tanks;
    }

    /**
     * set a new arrayList for bullets
     *
     * @param bullets
     */
    public void setBullets(ArrayList<Bullet> bullets)
    {
        this.bullets = bullets;
    }

    /**
     * set a new arrayList for turrets
     *
     * @param turrets
     */
    public void setTurrets(ArrayList<Turret> turrets)
    {
        this.turrets = turrets;
    }

    /**
     * set a new arrayList for buried robots
     *
     * @param robots
     */
    public void setRobots(ArrayList<BuriedRobot> robots)
    {
        this.robots = robots;
    }

    /**
     * return players tanks
     *
     * @return player tank
     */
    public ArrayList<Tank> getPlayers()
    {
        return players;
    }

    /**
     * get arrayList that contains all tanks
     *
     * @return
     */
    public ArrayList<Tank> getTanks()
    {
        return tanks;
    }

    /**
     * get arrayList that contains all bullets
     *
     * @return
     */
    public ArrayList<Bullet> getBullets()
    {
        return bullets;
    }

    /**
     * get arrayList that contains all turrets
     *
     * @return
     */
    public ArrayList<Turret> getTurrets()
    {
        return turrets;
    }

    /**
     * get arrayList that contains all buried robots
     *
     * @return
     */
    public ArrayList<BuriedRobot> getRobots()
    {
        return robots;
    }

    public void replacePlayerTank(Tank tank , int number){
        players.remove(players.get(number));
        players.add(tank);
    }
    public void setPlayers(ArrayList<Tank> players)
    {
        this.players = players;
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }
}
