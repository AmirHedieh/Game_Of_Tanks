package game.elements;

import game.Utils.SharedData;
import game.Utils.Utility;

import java.util.ArrayList;

public class BuriedRobot extends GameObject
{
    //fields
    private double minDistance;
    private boolean activated;
    private Tank target;
    private double angle;

    //constructor
    public BuriedRobot()
    {

    }

    public BuriedRobot(double x, double y)
    {
        super(x, y, ObjectId.BuriedRobot);
        minDistance = 400;
        activated = false;
        angle = 0;
        setVelX(5);
        setVelY(5);
    }

    //methods

    /**
     * if robot is activated it moves and get closer to target
     * and if its off , it checks area to see whether player tank
     * is in range or not
     *
     * @param objects
     */
    public void tick(Objects objects)
    {
        determineTarget(objects);
        setAngle(calculateAngle(this, target));
        if (activated)
        { // pass player tank as target
            move(target);
        }
        else
        {
            checkArea();
        }
    }

    /**
     * determine which player tank is the target. if game is in coop mode
     * it will set closer tank to robot as its target.
     *
     * @param objects objects of the game
     */
    private void determineTarget(Objects objects)
    {
        if (SharedData.getData().gameType.equals(ObjectId.TwoPlayer))
        {
            double distanceNumOne = Utility.calculateDistance(this, objects.getPlayers().get(0));
            double distanceNumTwo = Utility.calculateDistance(this, objects.getPlayers().get(1));
            target = (distanceNumOne > distanceNumTwo) ? objects.getPlayers().get(1) : objects.getPlayers().get(0);
        }
        else
        { //in single player
            target = objects.getPlayers().get(0);
        }
    }

    /**
     * calculate angle between 2 objects.
     *
     * @param object1 starting point
     * @param object2 second point
     * @return
     */
    private static double calculateAngle(GameObject object1, GameObject object2)
    {
        double angle = Math.atan((object2.getY() - object1.getY()) / (object2.getX() - object1.getX()));
//        angle += Math.PI / 2;
        if (object2.getX() < object1.getX())
        {
            angle += Math.PI;
        }
        return angle;
    }

    /**
     * check area and if player tank in located in area, robot gets activated
     */
    private void checkArea()
    {
        double distance = Utility.calculateDistance(this, target);
        if (distance < minDistance)
        {
            System.out.println("in range");
            activated = true;
        }
    }

    /**
     * moves robot to get closer to player tank.
     *
     * @param target player tank
     */
    public void move(Tank target)
    {
        int vib = 6; // removes robot vibration when x or y is same as target x , y
        if (target.x > this.x + vib)
        {
            this.setX(this.getX() + this.getVelX());
        }
        else if (target.x < this.x - vib)
        {
            this.setX(this.getX() - this.getVelX());
        }

        if (target.y > this.y + vib)
        {
            this.setY(this.getY() + this.getVelY());
        }
        else if (target.y < this.y - vib)
        {
            this.setY(this.getY() - this.getVelY());
        }

        if (target.x == this.x && target.y == this.y)
        {
            activated = false;
        }
    }

    /**
     * state of robot( on or off )
     *
     * @return true if activated and false if deactivated
     */
    public boolean isActivated()
    {
        return activated;
    }

    /**
     * a buried robot get activated when player tank get
     * closer to robot than robot's minDistance.
     *
     * @param state true for activating and false for deactivating
     */
    public void setActivated(boolean state)
    {
        activated = state;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }

    public double getAngle()
    {

        return angle;
    }
}
