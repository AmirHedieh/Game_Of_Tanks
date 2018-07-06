package game.elements;

/**
 * primary gun of the tank. it has higher damage  but less fire rate than machine gun.
 */
public class MissileGun extends Gun
{

    //fields

    //constructor
    public MissileGun(double x, double y)
    { //todo : try not to pass tank from subclass to father
        super(x, y, ObjectId.MissileGun);
        ammo = 15;
        reloadTime = 1000; // millisecond
    }
    //methods

    /**
     * shoot a bullet from MissleGun.
     *
     * @param tankX
     * @param tankY
     * @param mouseX
     * @param mouseY
     * @return the bullet must be stored in arrayList so it is returned to be added to list in GameState Class.
     */
    public Bullet shoot(double tankX, double tankY, double mouseX, double mouseY)
    {
        Bullet bullet = new HeavyBullet(tankX, tankY, mouseX, mouseY);
        ammo--; //todo : bound for 0 needed
        lastShootTime = getCurrentTime();
//        System.out.println("Ammo: " + ammo + " " + "Damage: " + damage + " MissileGun");
        return bullet;
    }

}
