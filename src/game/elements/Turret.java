package game.elements;

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

    MissileGun gun;
    private double rangeOfView;
    private Tank target;

    //constructor
    public Turret(){

    }
    public Turret(double x, double y, ArrayList<Tank> targets)
    {
        super(x, y, ObjectId.Turret);
        target = targets.get(0);
        if(targets.size() > 1) {
            determineTarget(targets);
        }
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
    public void tick(Objects objects)
    {
        if (checkArea() == true)
        {
            if (gun.readyForShoot())
            {
                objects.addBullet(gun.shoot(this.x, this.y, target.x + 50, target.y + 50));
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

    private double calculateDistance(Tank tank){
        double distance = Math.sqrt(Math.pow(Math.abs(this.x - tank.x), 2) + Math.pow(Math.abs(this.y - tank.y), 2));
        return distance;
    }

}
