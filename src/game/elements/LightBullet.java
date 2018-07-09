package game.elements;

/**
 * kind of bullet that has a mid level damage.
 * it is fired from MachineGun
 */
public class LightBullet extends Bullet
{

    //constructor
    public LightBullet(){

    }
    public LightBullet(double startX, double startY, double mouseX, double mouseY)
    {
        super(startX, startY, mouseX, mouseY, ObjectId.LightBullet, "src/resource/LightBullet.png");
        damage = 20;
    }

}
