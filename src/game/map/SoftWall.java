package game.map;

import game.elements.*;

import java.awt.*;

public class SoftWall extends GameObject
{
    public SoftWall(double x, double y)
    {
        super(x, y, ObjectId.SoftWall, "src/resource/softWall.png");
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, 100, 100);
    }
}
