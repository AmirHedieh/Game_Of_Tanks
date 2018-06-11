package game.elements;

import java.util.ArrayList;

/**
 * a class containing all created objects like tanks, bullets , turrets , ... in game
 * it is created once and is usable through all classes.
 */
public class Objects {

    //fields
    public ArrayList<Tank> tanks;
    public ArrayList<Bullet> bullets;
    public ArrayList<Turret> turrets;

    private static Objects objects; //the object which is usable all across the other class.

    //constructor

    public Objects(){
        objects = this;
        tanks = new ArrayList<>();
        bullets = new ArrayList<>();
        turrets = new ArrayList<>();
    }

    //methods

    /**
     * returns the objects(field) object which contains all game objects.
     * @return
     */
    public static Objects getObjects() {
        return objects;
    }

//    public void init(){
//        Gun playerTankGun = new Gun(40,25);
//        Tank playerTank = new Tank(100,100,100,playerTankGun,0);
//
//    }

    /**
     * add a tank to tanks ArrayList which contains all available tanks in game
     * @param tank the tank which must be added
     */
    public void addTank(Tank tank){
        tanks.add(tank);
    }

    /**
     * add a bullet to bullets ArrayList which contains all available bullets in game
     * @param bullet the bullet which must be added
     */
    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }

    /**
     * add a turret to turrets ArrayList which contains all available turrets in game
     * @param turret the turret which must be added
     */
    public void addTurret(Turret turret){
        turrets.add(turret);
    }

    /**
     * remove a tank from ArrayList which contains all available tanks in game
     * @param tank the tank that must be removed
     */
    public void removeTank(Tank tank){
        tanks.remove(tank);
    }

    /**
     * remove a bullet from ArrayList which contains all available bullets in game
     * @param bullet the bullet that must be removed
     */
    public void removeBullet(Bullet bullet){
        bullets.remove(bullet);
    }

    /**
     * remove a turret from ArrayList which contains all available turrets in game
     * @param turret the turret that must be removed
     */
    public void removeTurret(Turret turret){
        turrets.remove(turret);
    }
}
