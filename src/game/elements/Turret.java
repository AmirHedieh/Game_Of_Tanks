package game.elements;

import game.Utils.SharedData;
import game.Utils.Utility;
import game.map.Camera;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.ArrayList;

/**
 * a Turret is a unmovable kind of weapon stuck to the ground.
 * turrets have infinite amount of ammo.
 * turrets also has health, when it gets down to zero means it is destroyed.
 */
public class Turret extends GameObject implements Serializable
{

    //fields
    public final int TURRET_WIDTH = 128;
    public final int TURRET_HEIGHT = 128;

    private MissileGun gun;
    private double rangeOfView;
    private ArrayList<Tank> targets;
    private Tank target;
    private double gunAngle;

    //constructor
    public Turret(){

    }
    public Turret(double x, double y, ArrayList<Tank> targets)
    {
        super(x, y, ObjectId.Turret);
        gunAngle = 0;
        target = targets.get(0);
        this.targets = targets;
        gun = new MissileGun(this.x, this.y);
        rangeOfView = 800;
    }

    //methods

    /**
     * if more than 1 player is playing then turret will shoot the player which is closer to turret
     * @param tanks
     */
    public void determineTarget(ArrayList<Tank> tanks){
        for(int i = 0 ; i < tanks.size() ; i++){
            double distance = calculateDistance(tanks.get(i));
            if(distance < calculateDistance(target)){
                target = tanks.get(i);
            }
        }
    }


    /**
     * process of a turret during each loop including checking area,
     * shooting target, ... .
     * @param objects objects of the game
     */
    public void tick(Objects objects)
    {
        if(SharedData.getData().gameType.equals(ObjectId.TwoPlayer)) {
            determineTarget(targets);
        }
        if (checkArea() == true)
        {
            setGunAngle(calculateAngle(this,target)); // angle between turret and tank
            if (gun.readyForShoot())
            {
                objects.addBullet(gun.shoot(this.x, this.y, target.x + target.TANK_WIDTH / 2, target.y + target.TANK_HEIGHT / 2));
                target = objects.getPlayers().get(0);
            }
        }
    }


    public boolean checkArea()
    {
        double distance = calculateDistance(target);
        if (distance - rangeOfView <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * calculate the distance between turret and target(player tank).
     * @param tank target
     * @return distance between turret and player tank
     */
    private double calculateDistance(Tank tank){
        double distance = Math.sqrt(Math.pow(Math.abs(this.x - tank.x), 2) + Math.pow(Math.abs(this.y - tank.y), 2));
        return distance;
    }

    public Tank getTarget()
    {
        return target;
    }

    public void setTarget(Tank target)
    {
        this.target = target;
    }

    public void setGunAngle(double gunAngle) {
        this.gunAngle = gunAngle;
    }

    public double getGunAngle() {

        return gunAngle;
    }

    /**
     * calculate angle between 2 objects.
     * @param object1 starting point
     * @param object2 second point
     * @return
     */
    private static double calculateAngle(GameObject object1, GameObject object2){
        double angle = Math.atan( ( object2.getY() - object1.getY() ) / (object2.getX() - object1.getX()));
        if(object2.getX() < object1.getX()){
            angle += Math.PI;
        }
        return angle;
    }
}
