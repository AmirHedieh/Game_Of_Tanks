package game.elements;

import java.io.Serializable;
import java.util.Date;

/**
 * a weapon that can provide damage to other objects.
 * two kind of guns are available: 1- MissileGun launcher 2- Machine gun
 * each gun has a damage field which is the amount of damage that it provides.
 * each gun has an specific amount of ammo.
 */
public abstract class Gun extends GameObject implements Serializable
{
    //fields
    protected int damage;
    protected int ammo;
    protected long lastShootTime;
    protected long reloadTime;

    //constructor
    public Gun(){

    }
    public Gun(double x, double y, ObjectId id, String path)
    {
        super(x, y, id);
    }

    //methods

    /**
     * shooting bullet from gun(creating a bullet).
     *
     * @param tankX
     * @param tankY
     * @param mouseX
     * @param mouseY
     * @return the bullet must be stored in arrayList so it is returned to be added to list in GameState Class.
     */
    public abstract Bullet shoot(double tankX, double tankY, double mouseX, double mouseY);

    /**
     * checks that Gun is ready to shot or not(it is reloading or not).
     *
     * @return true if ready | false if reloading
     */
    public boolean readyForShoot()
    {
        if (getCurrentTime() - lastShootTime > reloadTime && ammo > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * to get current system time with millisecond accuracy.
     *
     * @return current system time
     */
    protected long getCurrentTime()
    {
        long time = new Date().getTime() % 10000000;
        return time;
    }

    /**
     * how much ammunition gun must have.
     *
     * @param ammo amount of ammo for th gun
     */
    public void setAmmo(int ammo)
    {
        this.ammo = ammo;
    }

    /**
     * how much ammunition has.
     *
     * @return amount of ammo
     */
    public int getAmmo()
    {
        return ammo;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
