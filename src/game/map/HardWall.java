package game.map;

import game.elements.*;

import java.awt.*;

public class HardWall extends GameObject
{

    public HardWall(double x, double y, ObjectId id, String path)
    {
        super(x, y, ObjectId.HardWall, "src/resource/hardWall.png");
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, 100, 100);
    }
}
