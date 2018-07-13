package game.map;

import game.elements.GameObject;
import game.elements.ObjectId;

public class End extends GameObject
{
    public End(double x, double y)
    {
        super(x, y, ObjectId.End);
    }
}
