package game.elements;

import java.io.Serializable;

/**
 * primary gun of the tank. it has higher damage  but less fire rate than machine gun.
 */
public class MissileGun extends Gun implements Serializable
{

    //fields

    //constructor
    public MissileGun()
    {

    }

    public MissileGun(double x, double y)
    { //todo : try not to pass tank from subclass to father
        super(x, y, ObjectId.MissileGun, "src/resource/tankGun01.png");
        damage = 100;
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
        Bullet bullet = new HeavyBullet(tankX, tankY, mouseX, mouseY,damage);
        ammo--;
        lastShootTime = getCurrentTime();
//        System.out.println("Ammo: " + ammo + " " + "Damage: " + damage + " MissileGun");
        return bullet;
    }

}
