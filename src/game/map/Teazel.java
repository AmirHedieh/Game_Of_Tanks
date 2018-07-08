package game.map;

import game.elements.*;

import java.awt.*;

public class Teazel extends GameObject
{
    public Teazel(double x, double y)
    {
        super(x, y, ObjectId.Teazel, "src/resource/teazel.png");
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, 100, 100);
    }
}
