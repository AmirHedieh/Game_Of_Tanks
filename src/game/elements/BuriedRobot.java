package game.elements;

import java.util.ArrayList;

public class BuriedRobot extends GameObject
{
    //fields
    private double minDistance;
    public boolean activated;

    //constructor
    public BuriedRobot(){

    }

    public BuriedRobot(double x, double y)
    {
        super(x, y, ObjectId.BuriedRobot);
        minDistance = 400;
        activated = false;
        setVelX(5);
        setVelY(5);
    }

    //methods

    /**
     * if robot is activated it moves and get closer to target
     * and if its off , it checks area to see whether player tank
     * is in range or not
     * @param objects
     */
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

    /**
     * check area and if player tank in located in area, robot gets activated
     * @param target
     */
    private void checkArea(Tank target)
    {
        double distance = Math.sqrt(Math.pow(Math.abs(this.x - target.x), 2) + Math.pow(Math.abs(this.y - target.y), 2));
        if (distance - minDistance <= 0)
        {
            System.out.println("in range");
            activated = true;
        }
    }

    /**
     * moves robot to get closer to player tank.
     * @param target player tank
     */
    public void move(Tank target)
    {
        int vib = 6; // removes robot vibration when x or y is same as target x , y
        if (target.x > this.x + vib) {
            this.setX(this.getX() + this.getVelX());
        }
        else if (target.x < this.x - vib) {
            this.setX(this.getX() - this.getVelX());
        }

        if (target.y > this.y + vib) {
            this.setY(this.getY() + this.getVelY());
        }
        else if (target.y < this.y - vib) {
            this.setY(this.getY() - this.getVelY());
        }

        if (target.x == this.x && target.y == this.y) {
            activated = false;
        }
    }

    /**
     * state of robot( on or off )
     * @return true if activated and false if deactivated
     */
    public boolean isActivated()
    {
        return activated;
    }

    /**
     * a buried robot get activated when player tank get
     * closer to robot than robot's minDistance.
     * @param state true for activating and false for deactivating
     */
    public void setActivated(boolean state)
    {
        activated = state;
    }
}
