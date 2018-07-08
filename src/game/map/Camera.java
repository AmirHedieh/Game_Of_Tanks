package game.map;

import game.elements.GameObject;

public class Camera
{
    private double x, y;

    public Camera(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject player)
    {
        x += ((player.getX() - x) - 1820 / 2) * 0.05f;
        y += ((player.getY() - y) - 1024 / 2) * 0.05f;

        if (x <= 0)
        {
            x = 0;
        }
        if (x >= 1670)
        {
            x = 1670;
        }
        if (y <= 0)
        {
            y = 0;
        }
        if (y >= 5450)
        {
            y = 5450;
        }

    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }
}
