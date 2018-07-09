package game.map;

import game.Utils.Utility;

import java.awt.image.BufferedImage;

public class Textures
{
    public static String resourceDirectory = "src/resource/";
    public static BufferedImage buriedRobot = Utility.loadBufferedImage(resourceDirectory + "buriedRobot.png");
    public static BufferedImage cursor = Utility.loadBufferedImage(resourceDirectory + "cursor.png");
    public static BufferedImage hardWall = Utility.loadBufferedImage(resourceDirectory + "hardWall.png");
    public static BufferedImage heavyBullet = Utility.loadBufferedImage(resourceDirectory + "heavyBullet.png");
    public static BufferedImage lightBullet = Utility.loadBufferedImage(resourceDirectory + "lightBullet.png");
    public static BufferedImage map = Utility.loadBufferedImage(resourceDirectory + "map.png");
    public static BufferedImage plant = Utility.loadBufferedImage(resourceDirectory + "plant.png");
    public static BufferedImage softWall = Utility.loadBufferedImage(resourceDirectory + "softWall.png");
    public static BufferedImage soil = Utility.loadBufferedImage(resourceDirectory + "soil.png");
    public static BufferedImage startup = Utility.loadBufferedImage(resourceDirectory + "startup.png");
    public static BufferedImage tank = Utility.loadBufferedImage(resourceDirectory + "tank.png");
    public static BufferedImage tankGun01 = Utility.loadBufferedImage(resourceDirectory + "tankGun01.png");
    public static BufferedImage tankGun02 = Utility.loadBufferedImage(resourceDirectory + "tankGun02.png");
    public static BufferedImage teazel = Utility.loadBufferedImage(resourceDirectory + "teazel.png");
    public static BufferedImage turret = Utility.loadBufferedImage(resourceDirectory + "turret.png");
}
