package game.template.bufferstrategy;

import game.elements.GameObject;
import game.elements.Objects;

public class Physics
{
    public static void checkCollision(Objects objects)
    {
        for (int i = 0; i < objects.getTurrets().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTurrets().get(i).getBounds()))
            {
                objects.getPlayers().get(0).setX( objects.getPlayers().get(0).getX() + (objects.getPlayers().get(0).getVelX() * (-1)) );
                objects.getPlayers().get(0).setY( objects.getPlayers().get(0).getY() + (objects.getPlayers().get(0).getVelY() * (-1)) );

            }
        }

        for (int i = 0; i < objects.getHardWall().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getHardWall().get(i).getBounds()))
            {
                objects.getPlayers().get(0).setX( objects.getPlayers().get(0).getX() + (objects.getPlayers().get(0).getVelX() * (-1)) );
                objects.getPlayers().get(0).setY( objects.getPlayers().get(0).getY() + (objects.getPlayers().get(0).getVelY() * (-1)) );

            }
        }
    }

    public static void checkMapBounds(GameObject object)
    {
        if (object.getX() > 3400)
        {
            object.setX(3400);
        }
        else if (object.getX() < 0)
        {
            object.setX(0);
        }

        if (object.getY() > 6400)
        {
            object.setY(6400);
        }
        else if (object.getY() < 0)
        {
            object.setY(0);
        }

    }
}
