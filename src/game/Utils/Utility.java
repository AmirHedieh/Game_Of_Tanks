package game.Utils;

import game.elements.GameObject;
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

    public static BufferedImage buriedRobot01 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot01.png");
    public static BufferedImage buriedRobot02 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot02.png");
    public static BufferedImage buriedRobot03 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot03.png");
    public static BufferedImage buriedRobot04 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot04.png");
    public static BufferedImage buriedRobot05 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot05.png");
    public static Animation buriedRobotAnimation = new Animation(5, buriedRobot01, buriedRobot05, buriedRobot02, buriedRobot04, buriedRobot03);

    public static BufferedImage heavyBullet = loadBufferedImage(resourceDirectory + "heavyBullet.png");
    public static BufferedImage lightBullet = loadBufferedImage(resourceDirectory + "lightBullet.png");
    public static BufferedImage mapOriginal = loadBufferedImage(resourceDirectory + "mapOriginal.png");
    public static BufferedImage mapRotated = loadBufferedImage(resourceDirectory + "mapRotated.png");

    public static BufferedImage tank = loadBufferedImage(resourceDirectory + "tank.png");

    public static ImageIcon startup = loadImageIcon(resourceDirectory + "startup.png");

    public static BufferedImage tank01 = loadBufferedImage(resourceDirectory + "tank01.png");
    public static BufferedImage tank02 = loadBufferedImage(resourceDirectory + "tank02.png");
    public static BufferedImage tank03 = loadBufferedImage(resourceDirectory + "tank03.png");
    public static Animation tankAnimation = new Animation(3, tank01, tank02, tank03);
    public static BufferedImage gun01 = loadBufferedImage(resourceDirectory + "gun001.png");
    public static BufferedImage gun02 = loadBufferedImage(resourceDirectory + "gun002.png");

    public static BufferedImage teazel = loadBufferedImage(resourceDirectory + "teazel.png");
    public static BufferedImage plant = loadBufferedImage(resourceDirectory + "plant.png");
    public static BufferedImage softWall = loadBufferedImage(resourceDirectory + "softWall.png");
    public static BufferedImage soil = loadBufferedImage(resourceDirectory + "soil.png");
    public static BufferedImage hardWall = loadBufferedImage(resourceDirectory + "hardWall.png");

    public static BufferedImage turret = loadBufferedImage(resourceDirectory + "turret.png");

    public static BufferedImage tmpTurret = loadBufferedImage(resourceDirectory + "tank.png"); //tmp turret picture
    public static BufferedImage tmpTurretGun = loadBufferedImage(resourceDirectory + "tankGun01.png"); // tmp turret gun picture

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

    public static ImageIcon loadImageIcon(String path)
    {
        return new ImageIcon(String.valueOf(new File(path)));
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

    /**
     * calculate the distance between two object(tanks here).
     * @param object1 obj num1
     * @param object2 obj num2
     * @return distance between Ai tank and player tank
     */
    public static double calculateDistance(GameObject object1, GameObject object2){
        double distance = Math.sqrt(Math.pow(Math.abs(object1.getX() - object2.getX()), 2) + Math.pow(Math.abs(object1.getY() - object2.getY()), 2));
        return distance;
    }


    /*
        This is how to delete a directory from the repository:
            git rm -r --cached node_modules
            git commit -m 'Remove the now ignored directory node_modules'
            git push origin master
    */

}
