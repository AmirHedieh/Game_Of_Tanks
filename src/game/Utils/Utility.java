package game.Utils;

import game.elements.ObjectId;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utility
{
    public static String resourceDirectory = "src/resource/";
    public static Image cursor = new ImageIcon("src/resource/cursor.png").getImage();

    public static BufferedImage buriedRobot = Utility.loadBufferedImage(resourceDirectory + "buriedRobot.png");

    public static BufferedImage heavyBullet = Utility.loadBufferedImage(resourceDirectory + "heavyBullet.png");
    public static BufferedImage lightBullet = Utility.loadBufferedImage(resourceDirectory + "lightBullet.png");
    public static BufferedImage mapOriginal = Utility.loadBufferedImage(resourceDirectory + "mapOriginal.png");
    public static BufferedImage mapRotated = Utility.loadBufferedImage(resourceDirectory + "mapRotated.png");

    public static BufferedImage startup = Utility.loadBufferedImage(resourceDirectory + "startup.png");
    public static BufferedImage tank = Utility.loadBufferedImage(resourceDirectory + "tank.png");

    public static BufferedImage tank01 = Utility.loadBufferedImage(resourceDirectory + "tank01.png");
    public static BufferedImage tank02 = Utility.loadBufferedImage(resourceDirectory + "tank02.png");
    public static BufferedImage tank03 = Utility.loadBufferedImage(resourceDirectory + "tank03.png");
    public static BufferedImage gun01 = Utility.loadBufferedImage(resourceDirectory + "gun001.png");
    public static BufferedImage gun02 = Utility.loadBufferedImage(resourceDirectory + "gun002.png");
    public static Animation tankAnimation = new Animation(3, tank01, tank02, tank03);

    public static BufferedImage teazel = Utility.loadBufferedImage(resourceDirectory + "teazel.png");
    public static BufferedImage plant = Utility.loadBufferedImage(resourceDirectory + "plant.png");
    public static BufferedImage softWall = Utility.loadBufferedImage(resourceDirectory + "softWall.png");
    public static BufferedImage soil = Utility.loadBufferedImage(resourceDirectory + "soil.png");
    public static BufferedImage hardWall = Utility.loadBufferedImage(resourceDirectory + "hardWall.png");

    public static BufferedImage turret = Utility.loadBufferedImage(resourceDirectory + "turret.png");

    public static File backgroundSound = new File("src/resource/backgroundSound.wav");
    public static File heavyShotSound = new File("src/resource/HSL.wav");
    public static File lightShotSound = new File("src/resource/LSS.wav");

    public static BufferedImage loadBufferedImage(String path)
    {
        BufferedImage temp = null;
        try
        {
            temp = ImageIO.read(new File(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    public static BufferedImage loadImageIO(String path)
    {
        BufferedImage temp = null;
        try
        {
            temp = ImageIO.read(new File(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    /*
        This is how to delete a directory from the repository:
            git rm -r --cached node_modules
            git commit -m 'Remove the now ignored directory node_modules'
            git push origin master
    */

}
