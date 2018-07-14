package game.map;

import game.elements.*;

import java.awt.*;

public class SoftWall extends GameObject
{
    int health = 200;

    public SoftWall(double x, double y)
    {
        super(x, y, ObjectId.SoftWall);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
