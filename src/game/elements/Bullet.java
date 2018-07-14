package game.elements;

import java.awt.*;

/**
 * each Gun makes bullets to hit others.
 * Bullets takes their damages from the gun which made them.
 */
public class Bullet extends GameObject
{
    //fields
    public final int BULLET_WIDTH = 5;
    public final int BULLET_HEIGHT = 5;

    protected int damage;
    private double shootDirectionAngle;
    private double targetX, targetY;
    private boolean isThrown;
    private double thrownAngle;
    private ObjectId shooter;

    //constructor
    public Bullet()
    {

    }

    public Bullet(double startX, double startY, double mouseX, double mouseY, ObjectId id, ObjectId shooter)
    {
        super(startX, startY, id);
        targetX = mouseX;
        targetY = mouseY;
        startX += 50;//this must be changed if tank size changes
        startY += 50; //this must be changed if tank size changes
        shootDirectionAngle = calculateShootAngle(startX, startY, mouseX, mouseY);
        this.shooter = shooter;
        //moving in 4 direction needs specific velocity
//        System.out.println(mouseX + " " + mouseY + " " + startX + " " + startY);
//        System.out.println(shootDirectionAngle);
////        System.out.println("PI" + Math.PI / 2);
        if (mouseX > startX && mouseY > startY)
        {
//            System.out.println("1");
            velX = 14;
            velY = 14;
        }
        else if (mouseX > startX && mouseY < startY)
        {
//            System.out.println("2");
            velX = 14;
            velY = 14;
        }
        else if (mouseX < startX && mouseY < startY)
        {
//            System.out.println("3");
            velX = -14;
            velY = -14;
        }
        else if (mouseX < startX && mouseY > startY)
        {
//            System.out.println("4");
            velX = -14;
            velY = -14;
        }
        //from now on if conditions are for times where angle is 0 or PI/2
        else if (mouseX == startX && mouseY > startY)
        {
//            System.out.println("5");
            velX = 0;
            velY = 14;
        }
        else if (mouseX == startX && mouseY < startY)
        {
//            System.out.println("6");
            velX = 0;
            velY = 14; //idk why but its true
        }
        else if (mouseX > startX && mouseY == startY)
        {
//            System.out.println("7");
            velX = 14;
            velY = 0;
        }
        else if (mouseX < startX && mouseY == startY)
        {
//            System.out.println("8");
            velX = -14;
            velY = 0;
        }
        this.isThrown = false;
    }

    //methods

    /**
     * calculate the angle that bullet must go.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    private double calculateShootAngle(double x1, double y1, double x2, double y2)
    {
        return Math.atan((y2 - y1) / (x2 - x1));
    }

    /**
     * set damage for bullet
     *
     * @param damage amount of damage it must provides
     */
    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    /**
     * get damage of bullet
     *
     * @return amount of damage it provides
     */
    public int getDamage()
    {
        return damage;
    }

    /**
     * the X position where bullet is going to(where mouse was clicked)
     *
     * @return X of where mouse was clicked to shoot there
     */
    public double getTargetX()
    {
        return targetX;
    }

    /**
     * the Y position where bullet is going to(where mouse was clicked)
     *
     * @return Y of where mouse was clicked to shoot there
     */
    public double getTargetY()
    {
        return targetY;
    }

    /**
     * returns the angle of the way bullet must go.
     *
     * @return the angle that way of bullet go.
     */
    public double getShootDirectionAngle()
    {
        return shootDirectionAngle;
    }

    public boolean isThrown()
    {
        return isThrown;
    }

    public void setThrown(boolean thrown)
    {
        isThrown = thrown;
    }

    public double getThrownAngle()
    {
        return thrownAngle;
    }

    public void setThrownAngle(double thrownAngle)
    {
        this.thrownAngle = thrownAngle;
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int) x + 50, (int) y + 50, 22, 22);
    }

    public ObjectId getShooter()
    {
        return shooter;
    }
}
