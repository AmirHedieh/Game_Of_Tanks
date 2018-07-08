package game.elements;

import game.map.*;

import java.util.ArrayList;

/**
 * a class containing all created objects like tanks, bullets , turrets , ... in game
 * Ali call this class handler
 */
public class Objects
{

    //fields
    private ArrayList<Tank> players;
    private ArrayList<Tank> tanks;
    private ArrayList<Bullet> bullets;
    private ArrayList<Turret> turrets;
    private ArrayList<BuriedRobot> robots;
    private HardWall hardWall;
    private Plant plant;
    private SoftWall softWall;
    private Teazel teazel;
    private Soil soil;

    //constructor
    public Objects()
    {
        players = new ArrayList<>();
        tanks = new ArrayList<>();
        bullets = new ArrayList<>();
        turrets = new ArrayList<>();
        robots = new ArrayList<>();
        hardWall = new HardWall(0, 0);
        softWall = new SoftWall(0, 0);
        plant = new Plant(0, 0);
        teazel = new Teazel(0, 0);
        soil = new Soil(0, 0);

    }

    //methods

    /**
     * if the game hasn't been started before it needs to be initialized. player's tank must be create.
     */
    public void init()
    {
        //Player tank initialization
        players.add(new Tank(100, 100, 100, ObjectId.Player)); // making player's tank
        // Turrets initialization
        Turret turret = new Turret(1500, 700, players);
        turrets.add(turret);
        //AI tanks initialization
//        Tank tank1 = new Tank(700,700,100,1);
//        tanks.add(tank1);
        // Buried Robots initialization
//        BuriedRobot robot1 = new BuriedRobot(700, 700);
//        robots.add(robot1);
    }

    /**
     * add a new player tank.
     * @param tank
     */
    public void addPlayerTank(Tank tank){players.add(tank);
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

    public void setPlayers(ArrayList<Tank> players)
    {
        this.players = players;
    }

    public HardWall getHardWall()
    {
        return hardWall;
    }

    public void setHardWall(HardWall hardWall)
    {
        this.hardWall = hardWall;
    }

    public Plant getPlant()
    {
        return plant;
    }

    public void setPlant(Plant plant)
    {
        this.plant = plant;
    }

    public SoftWall getSoftWall()
    {
        return softWall;
    }

    public void setSoftWall(SoftWall softWall)
    {
        this.softWall = softWall;
    }

    public Teazel getTeazel()
    {
        return teazel;
    }

    public void setTeazel(Teazel teazel)
    {
        this.teazel = teazel;
    }

    public Soil getSoil()
    {
        return soil;
    }

    public void setSoil(Soil soil)
    {
        this.soil = soil;
    }

}
