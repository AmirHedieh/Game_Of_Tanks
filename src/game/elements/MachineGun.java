package game.elements;

import java.io.Serializable;

/**
 * secondary gun of the tank. it has higher fire rate but less damage than missile gun.
 */
public class MachineGun extends Gun implements Serializable
{

    //fields

    //constructor
    public MachineGun()
    {

    }

    public MachineGun(double x, double y)
    {
        super(x, y, ObjectId.MachineGun, "src/resource/tankGun02.png");
        damage = 20;
        ammo = 70;
        reloadTime = 150; // millisecond
    }
    //methods

    /**
     * shoot a bullet from MachineGun
     * @param tankX
     * @param tankY
     * @param mouseX
     * @param mouseY
     * @return the bullet must be stored in arrayList so it is returned to be added to list in GameState Class.
     */
    public Bullet shoot(double tankX, double tankY, double mouseX, double mouseY,ObjectId shooter)
    {
        System.out.println(shooter);
        Bullet bullet = new LightBullet(tankX, tankY, mouseX, mouseY,damage,shooter);
        ammo--;
        lastShootTime = getCurrentTime();
//        System.out.println("Ammo: " + ammo + " " + "Damage: " + damage + " MachineGun");
        return bullet;
    }
}
