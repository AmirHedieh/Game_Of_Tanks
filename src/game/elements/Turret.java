package game.elements;

/**
 * a Turret is a unmovable kind of weapon stuck to the ground.
 * turrets have infinite amount of ammo.
 * turrets also has health, when it gets down to zero means it is destroyed.
 */
public class Turret extends GameObject
{

    //fields
    public final int TURRET_WIDTH = 128;
    public final int TURRET_HEIGHT = 128;

    MissileGun gun;
    private double rangeOfView;
    private Tank target;

    //constructor
    public Turret(double x, double y, Tank target)
    {
        super(x, y, ObjectId.Turret, "src/resource/tank_turret.png");
        gun = new MissileGun(this.x, this.y);
        rangeOfView = 800;
        this.target = target;
    }

    //methods
    public void tick(Objects objects)
    {
        if (checkArea() == true)
        {
            if (gun.readyForShoot())
            {
                objects.addBullet(gun.shoot(this.x, this.y, target.x, target.y));
            }
        }
    }

    public boolean checkArea()
    {
        double distance = Math.sqrt(Math.pow(Math.abs(this.x - target.x), 2) + Math.pow(Math.abs(this.y - target.y), 2));
        if (distance - rangeOfView <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
