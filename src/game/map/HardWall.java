package game.map;

import game.elements.*;

public class HardWall extends GameObject
{

    public HardWall(double x, double y, ObjectId id, String path)
    {
        super(x, y, ObjectId.HardWall, "src/resource/hardWall.png");
    }
}
