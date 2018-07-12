package game.elements;

/**
 * kind of bullet that has a mid level damage.
 * it is fired from MachineGun
 */
public class LightBullet extends Bullet
{

    //constructor
    public LightBullet()
    {

    }
    public LightBullet(double startX, double startY, double mouseX, double mouseY, int damage)
    {
        super(startX, startY, mouseX, mouseY, ObjectId.LightBullet);
        this.damage = damage;
    }

}
