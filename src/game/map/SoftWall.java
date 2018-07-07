package game.map;

import game.elements.*;

public class SoftWall extends GameObject
{
    public SoftWall(double x, double y, ObjectId id, String path)
    {
        super(x, y, ObjectId.SoftWall, "src/resource/softWall.png");
    }
}
