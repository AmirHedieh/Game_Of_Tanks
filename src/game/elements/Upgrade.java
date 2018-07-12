package game.elements;

import game.Utils.SharedData;
import game.Utils.Utility;

import java.io.Serializable;

/**
 * an upgrade is options to make gun stronger or reset health.
 * they get activated in some conditions like killing some tanks.
 */
public class Upgrade extends GameObject implements Serializable
{

    //fields
    private Objects objects;
    private Boolean activation;
    private Tank user;

    //constructor
    public Upgrade()
    {

    }

    public Upgrade(double x, double y, Objects objects, ObjectId type)
    {
        super(x, y, type);
        this.objects = objects;
        activation = false;
    }

    //methods
    public void tick()
    {
        determineTarget();
        checkToBeUsed();
    }

    /**
     * checks whether a tank is close to upgrade or not, if its close enough
     * it applies upgrade to tank based on the type(id) of the upgrade.
     */
    public void checkToBeUsed()
    {
        if (Math.abs(user.x - this.x) < 95 && Math.abs(user.y - this.y) < 95)
        {
            System.out.println("INNNNNNNN");
            if (id.equals(ObjectId.DamageUpgrade))
            {
                user.getMissileGun().setDamage(user.getMissileGun().damage + 20);
                user.getMachineGun().setDamage(user.getMachineGun().damage + 20);
                activation = false;
            }
            else if (id.equals(ObjectId.HealthUpgrade))
            {
                user.setHealth(user.health + 100);
                activation = false;
            }
            else if (id.equals(ObjectId.MachineGunUpgrade))
            {
                user.getMachineGun().setAmmo(user.getMachineGun().ammo + 15);
                activation = false;
            }
            else if (id.equals(ObjectId.MissileGunUpgrade))
            {
                user.getMissileGun().setAmmo(user.getMissileGun().ammo + 15);
                activation = false;
            }
            else if (id.equals(ObjectId.ShieldUpgrade))
            {
                user.activateShield();
                activation = false;
            }
        }
    }

    /**
     * set user to the tank which is closer to upgrade
     */
    public void determineTarget()
    {
        for (int i = 0; i < objects.getPlayers().size(); i++)
        {
            if (SharedData.getData().gameType.equals(ObjectId.TwoPlayer))
            {
                user = (Utility.calculateDistance(this, objects.getPlayers().get(0)) > Utility.calculateDistance(this, objects.getPlayers().get(1))) ?
                        objects.getPlayers().get(1) : objects.getPlayers().get(0);
            }
            else
            { //in single player
                user = objects.getPlayers().get(0);
            }
        }
    }

    /**
     * an upgrade is not activated in default. true if it is activated
     * and false if not
     *
     * @return
     */
    public Boolean getActivation()
    {
        return activation;
    }

    /**
     * for drawing in map and ticking in GameState upgrade must be activated.
     * when some tanks die or destroying wall it gets activated
     *
     * @param activated
     */
    public void setActivation(Boolean activated)
    {
        this.activation = activated;
    }
}
