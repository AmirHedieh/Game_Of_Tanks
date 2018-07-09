package game.elements;

import java.util.ArrayList;

public class BuriedRobot extends GameObject
{
    //fields
    private double minDistance;
    public boolean activated;

    //constructor
    public BuriedRobot(double x, double y)
    {
        super(x, y, ObjectId.BuriedRobot);
        minDistance = 400;
        activated = false;
        setVelX(5);
        setVelY(5);
    }

    //methods
    public void tick(Objects objects)
    {
        if (activated)
        { // pass player tank as target
            move(objects.getPlayers().get(0));
        }
        else
        {
            checkArea(objects.getPlayers().get(0));
        }
    }

    private void checkArea(Tank target)
    {
        double distance = Math.sqrt(Math.pow(Math.abs(this.x - target.x), 2) + Math.pow(Math.abs(this.y - target.y), 2));
        if (distance - minDistance <= 0)
        {
            System.out.println("in range");
            activated = true;
        }
    }

    public void move(Tank target)
    {
        if (target.x >= this.x)
        {
            this.setX(this.getX() + this.getVelX());
        }
        else if (target.x <= this.x)
        {
            this.setX(this.getX() - this.getVelX());
        }

        if (target.y >= this.y)
        {
            this.setY(this.getY() + this.getVelY());
        }
        else if (target.y <= this.y)
        {
            this.setY(this.getY() - this.getVelY());
        }

        if (target.x == this.x && target.y == this.y)
        {
            activated = false;
        }
    }

    public boolean isActivated()
    {
        return activated;
    }

    public void setActivated(boolean state)
    {
        activated = state;
    }
}
