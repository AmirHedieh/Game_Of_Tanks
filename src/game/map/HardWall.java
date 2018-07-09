package game.map;

import game.elements.*;

import java.awt.*;


public class HardWall extends GameObject
{

    public HardWall(double x, double y)
    {
        super(x, y, ObjectId.HardWall, "src/resource/hardWall.png");
    }
}
