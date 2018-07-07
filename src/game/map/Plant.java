package game.map;

import game.elements.*;

public class Plant extends GameObject
{
    public Plant(double x, double y, ObjectId id, String path)
    {
        super(x, y, ObjectId.Plant, "src/resource/plant.png");
    }
}
