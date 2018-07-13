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
    public static Image cursor = new ImageIcon(resourceDirectory + "cursor.png").getImage();

    public static BufferedImage buriedRobot01 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot01.png");
    public static BufferedImage buriedRobot02 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot02.png");
    public static Animation buriedRobotAnimation = new Animation(2, buriedRobot01, buriedRobot02);

    public static BufferedImage heavyBullet = loadBufferedImage(resourceDirectory + "bullet/heavyBullet.png");
    public static BufferedImage lightBullet = loadBufferedImage(resourceDirectory + "bullet/lightBullet.png");
    public static BufferedImage mapOriginal = loadBufferedImage(resourceDirectory + "map/mapOriginal.png");

    public static ImageIcon startup = loadImageIcon(resourceDirectory + "startup.png");

    public static BufferedImage tank01 = loadBufferedImage(resourceDirectory + "Player Tank/Body/tank01.png");
    public static BufferedImage tank02 = loadBufferedImage(resourceDirectory + "Player Tank/Body/tank02.png");
    public static BufferedImage tank03 = loadBufferedImage(resourceDirectory + "Player Tank/Body/tank03.png");
    public static Animation tankAnimation = new Animation(3, tank01, tank02, tank03);
    public static BufferedImage gun01 = loadBufferedImage(resourceDirectory + "Player Tank/Gun/gun001.png");
    public static BufferedImage gun02 = loadBufferedImage(resourceDirectory + "Player Tank/Gun/gun002.png");

    public static BufferedImage teazel = loadBufferedImage(resourceDirectory + "map/teazel.png");
    public static BufferedImage plant = loadBufferedImage(resourceDirectory + "map/plant.png");
    public static BufferedImage softWall = loadBufferedImage(resourceDirectory + "map/softWall.png");
    public static BufferedImage soil = loadBufferedImage(resourceDirectory + "map/soil.png");
    public static BufferedImage hardWall = loadBufferedImage(resourceDirectory + "map/hardWall.png");

    public static BufferedImage AITank = loadBufferedImage(resourceDirectory + "tank/AITank.png");

    public static BufferedImage MissileGunUpgrade = loadBufferedImage(resourceDirectory + "upgrade/missileGunUpgrade.png");
    public static BufferedImage MachineGunUpgrade = loadBufferedImage(resourceDirectory + "upgrade/MachinGunUpgrade.png");

    public static BufferedImage turretBody = loadBufferedImage(resourceDirectory + "turret/turret.png");
    public static BufferedImage turretGun01 = loadBufferedImage(resourceDirectory + "turret/tankGun01.png");
    public static BufferedImage turretGun02 = loadBufferedImage(resourceDirectory + "turret/tankGun02.png");

    public static BufferedImage numberOfHeavyBullet = loadBufferedImage(resourceDirectory + "NumberOfHeavyBullet.png");
    public static BufferedImage numberOfLightBullet = loadBufferedImage(resourceDirectory + "NumberOfLightBullet.png");

    public static File backgroundSound = new File(resourceDirectory + "sounds/backgroundSound.wav");
    public static File heavyShotSound = new File(resourceDirectory + "sounds/HSL.wav");
    public static File lightShotSound = new File(resourceDirectory + "sounds/LSS.wav");
    public static File emptyGun = new File(resourceDirectory + "sounds/empty.wav");
    public static File bulletHitHardWall = new File(resourceDirectory + "sounds/bulletHitHardWall.wav");

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
     *
     * @param object1 obj num1
     * @param object2 obj num2
     * @return distance between Ai tank and player tank
     */
    public static double calculateDistance(GameObject object1, GameObject object2)
    {
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
