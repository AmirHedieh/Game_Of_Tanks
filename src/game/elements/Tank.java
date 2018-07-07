package game.elements;

import java.awt.*;

/**
 * an entity which is a moving object though the map.
 * it contains a gun to hit other objects. it also has
 * specific amount of health. if health comes down to zero
 * the tank becomes dead.
 * type determines that if the tank is AI or Player(1 for AI, 0 for Player).
 */
public class Tank extends GameObject
{
    //fields
    public final int TANK_WIDTH = 100;
    public final int TANK_HEIGHT = 100;

    private int health;
    private int type;

    private Gun selectedGun;
    private MissileGun missileGun;
    private MachineGun machineGun;

    //constructor
    public Tank(double x, double y, int health, ObjectId id)
    { // gun must be added manually after making tank
        super(x, y, id, "src/resource/tank.png");
        missileGun = new MissileGun(this.x, this.y);
        this.setMissileGun(missileGun);

        machineGun = new MachineGun(this.x, this.y);
        this.setMachineGun(machineGun);

        this.selectedGun = missileGun;
        this.health = health;
        this.type = type;

        setVelX(12); //  set X velocity
        setVelY(12); // set y velocity
    }

    //methods

    /**
     * swap gun between missile and machine guns.
     */
    public void swapGun()
    {
        if (selectedGun == missileGun)
        {
            selectedGun = machineGun;
        }
        else if (selectedGun == machineGun)
        {
            selectedGun = missileGun;
        }
    }

    /**
     * set amount of health for tank.
     *
     * @param health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * set a Missile gun for tank.
     *
     * @param gun
     */
    public void setMissileGun(MissileGun gun)
    {
        this.missileGun = gun;
    }

    /**
     * set a Machine gun for tank.
     *
     * @param gun
     */
    public void setMachineGun(MachineGun gun)
    {
        this.machineGun = gun;
    }

    /**
     * set the gun for tank to use(equip gun).
     */
    public void setSelectedGun(Gun selectedGun)
    {
        this.selectedGun = selectedGun;
    }

    /**
     * set a type for tank(1 for AI, 0 for Player).
     *
     * @param type
     */
    public void setType(int type)
    {
        this.type = type;
    }

    /**
     * @return amount of health remained for tank
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * @return Missile gun of tank
     */
    public MissileGun getMissileGun()
    {
        return missileGun;
    }

    /**
     * @return Machine gun of tank
     */
    public MachineGun getMachineGun()
    {
        return machineGun;
    }

    /**
     * @return the gun that tank is using right now(equipped gun).
     */
    public Gun getSelectedGun()
    {
        return selectedGun;
    }

    /**
     * 0 if tank is AI.
     * 1 if tank is Player.
     *
     * @return the type of tank
     */
    public int getType()
    {
        return type;
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, 100, 100);
    }
}
