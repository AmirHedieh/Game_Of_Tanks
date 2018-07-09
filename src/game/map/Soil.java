package game.map;

import game.elements.GameObject;
import game.elements.ObjectId;

public class Soil extends GameObject
{
    public Soil(double x, double y)
    {
        super(x, y, ObjectId.Soil);
    }
}
