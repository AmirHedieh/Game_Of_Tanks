package game.elements;

/**
 * a weapon that can provide damage to other objects.
 * two kind of guns are available: 1- Missle launcher 2- Machine gun
 *each gun has a damage field which is the amount of damage that it provides.
 * each gun has an specific amount of ammo.
 */
public class Gun extends GameObject{
    //fields
    private int damage;
    private int ammo;

    //constructor
    public Gun(int damage , int ammo , Tank tank){
        super(tank.x,tank.y);
    }

    //methods

    /**
     * set damage for the gun.
     * @param damage amount of damage it must provide.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * how much ammunition gun must have.
     * @param ammo amount of ammo for th gun
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    /**
     * how much damage th gun provides.
     * @return amount of damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * how much ammunition has.
     * @return amount of ammo
     */
    public int getAmmo() {
        return ammo;
    }
}
