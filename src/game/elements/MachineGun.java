package game.elements;

/**
 * secondary gun of the tank. it has higher fire rate but less damage than missile gun.
 */
public class MachineGun extends Gun
{

    //fields

    //constructor
    public MachineGun(double x, double y)
    { //todo : try not to pass tank from subclass to father
        super(x, y, ObjectId.MachineGun);
        ammo = 70;
        reloadTime = 150; // millisecond
    }
    //methods

    /**
     * shoot a bullet from MachineGun
     *
     * @param tankX
     * @param tankY
     * @param mouseX
     * @param mouseY
     * @return the bullet must be stored in arrayList so it is returned to be added to list in GameState Class.
     */
    public Bullet shoot(double tankX, double tankY, double mouseX, double mouseY)
    {
        Bullet bullet = new LightBullet(tankX, tankY, mouseX, mouseY);
        ammo--; //todo : bound for 0 needed
        lastShootTime = getCurrentTime();
//        System.out.println("Ammo: " + ammo + " " + "Damage: " + damage + " MachineGun");
        return bullet;
    }
}
