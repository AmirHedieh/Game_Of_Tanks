package game.map;

import game.elements.*;

import java.awt.*;

public class SoftWall extends GameObject
{
    public SoftWall(double x, double y)
    {
        super(x, y, ObjectId.SoftWall);
    }
}
