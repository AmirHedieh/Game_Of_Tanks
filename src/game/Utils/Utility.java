package game.Utils;

import game.elements.GameObject;
import game.elements.ObjectId;
import game.elements.Objects;
import game.elements.Tank;
import game.savingElements.DataInitializer;
import game.savingElements.DataSaver;
import game.template.bufferstrategy.GameFrame;
import game.template.bufferstrategy.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utility
{
    public static String resourceDirectory = "res/";
    public static Image cursor = new ImageIcon(resourceDirectory + "cursor.png").getImage();

    public static BufferedImage buriedRobot01 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot01.png");
    public static BufferedImage buriedRobot02 = loadBufferedImage(resourceDirectory + "buriedRobot/buriedRobot02.png");
    public static Animation buriedRobotAnimation = new Animation(2, buriedRobot01, buriedRobot02);

    public static BufferedImage heavyBullet = loadBufferedImage(resourceDirectory + "bullet/heavyBullet.png");
    public static BufferedImage lightBullet = loadBufferedImage(resourceDirectory + "bullet/lightBullet.png");

    public static BufferedImage firstEasyMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/1/easy.png");
    public static BufferedImage firstMediumMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/1/medium.png");
    public static BufferedImage firstHardMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/1/hard.png");
    public static BufferedImage secondEasyMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/2/easy.png");
    public static BufferedImage secondMediumMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/2/medium.png");
    public static BufferedImage secondHardMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/2/hard.png");
    public static BufferedImage thirdEasyMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/3/easy.png");
    public static BufferedImage thirdMediumMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/3/medium.png");
    public static BufferedImage thirdHardMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/3/hard.png");
    public static BufferedImage fourthEasyMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/4/easy.png");
    public static BufferedImage fourthMediumMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/4/medium.png");
    public static BufferedImage fourthHardMap = loadBufferedImage(resourceDirectory + "map/spriteSheet/4/hard.png");

    public static ImageIcon mainMenuBackGroundMedium = loadImageIcon(resourceDirectory + "MainMenuBackGroundMedium.jpg");
    public static ImageIcon mainMenuBackGroundBig = loadImageIcon(resourceDirectory + "MainMenuBackGroundBig.jpg");

    public static ImageIcon loseMedium = loadImageIcon(resourceDirectory + "finishGame/lose/loseMedium.jpg");
    public static ImageIcon loseBig = loadImageIcon(resourceDirectory + "finishGame/lose/loseBig.jpg");
    public static ImageIcon winMedium = loadImageIcon(resourceDirectory + "finishGame/win/winMedium.jpg");
    public static ImageIcon winBig = loadImageIcon(resourceDirectory + "finishGame/win/winBig.jpg");

    public static BufferedImage tank01 = loadBufferedImage(resourceDirectory + "Player Tank/Body/tank01.png");
    public static BufferedImage tank02 = loadBufferedImage(resourceDirectory + "Player Tank/Body/tank02.png");
    public static BufferedImage tank03 = loadBufferedImage(resourceDirectory + "Player Tank/Body/tank03.png");
    public static Animation tankAnimation = new Animation(3, tank01, tank02, tank03);
    public static BufferedImage gun01 = loadBufferedImage(resourceDirectory + "Player Tank/Gun/gun001.png");
    public static BufferedImage gun02 = loadBufferedImage(resourceDirectory + "Player Tank/Gun/gun002.png");

    public static BufferedImage teazel = loadBufferedImage(resourceDirectory + "map/environment/teazel.png");
    public static BufferedImage plant = loadBufferedImage(resourceDirectory + "map/environment/plant.png");
    public static BufferedImage soil = loadBufferedImage(resourceDirectory + "map/environment/soil.png");
    public static BufferedImage hardWall = loadBufferedImage(resourceDirectory + "map/environment/hardWall.png");
    public static BufferedImage end = loadBufferedImage(resourceDirectory + "map/environment/end.png");

    public static BufferedImage softWall01 = loadBufferedImage(resourceDirectory + "map/environment/softWalls/softWall01.png");
    public static BufferedImage softWall02 = loadBufferedImage(resourceDirectory + "map/environment/softWalls/softWall02.png");
    public static BufferedImage softWall03 = loadBufferedImage(resourceDirectory + "map/environment/softWalls/softWall03.png");
    public static BufferedImage softWall04 = loadBufferedImage(resourceDirectory + "map/environment/softWalls/softWall04.png");
    public static BufferedImage softWall05 = loadBufferedImage(resourceDirectory + "map/environment/softWalls/softWall05.png");

    public static BufferedImage AITank = loadBufferedImage(resourceDirectory + "tank/AITank.png");

    public static BufferedImage missileGunUpgrade = loadBufferedImage(resourceDirectory + "upgrade/missileGunUpgrade.png");
    public static BufferedImage machineGunUpgrade = loadBufferedImage(resourceDirectory + "upgrade/MachinGunUpgrade.png");
    public static BufferedImage shieldUpgrade = loadBufferedImage(resourceDirectory + "upgrade/shieldUpgrade.png");
    public static BufferedImage healthUpgrade = loadBufferedImage(resourceDirectory + "upgrade/healthUpgrade.png");
    public static BufferedImage damageUpgrade = loadBufferedImage(resourceDirectory + "upgrade/damageUpgrade.png");


    public static BufferedImage turretBody = loadBufferedImage(resourceDirectory + "turret/turret.png");
    public static BufferedImage turretGun01 = loadBufferedImage(resourceDirectory + "turret/tankGun01.png");
    public static BufferedImage turretGun02 = loadBufferedImage(resourceDirectory + "turret/tankGun02.png");

    public static BufferedImage numberOfHeavyBullet = loadBufferedImage(resourceDirectory + "NumberOfHeavyBullet.png");
    public static BufferedImage numberOfLightBullet = loadBufferedImage(resourceDirectory + "NumberOfLightBullet.png");

    public static BufferedImage pause = loadBufferedImage(resourceDirectory + "pause.png");
    public static BufferedImage exit = loadBufferedImage(resourceDirectory + "exit.png");
    public static BufferedImage resume = loadBufferedImage(resourceDirectory + "resume.png");
    public static BufferedImage save = loadBufferedImage(resourceDirectory + "save.png");

    public static File backgroundSound = new File(resourceDirectory + "sounds/backgroundSound.wav");
    public static File heavyShotSound = new File(resourceDirectory + "sounds/HSL.wav");
    public static File lightShotSound = new File(resourceDirectory + "sounds/LSS.wav");
    public static File emptyGun = new File(resourceDirectory + "sounds/empty.wav");
    public static File explosion = new File(resourceDirectory + "sounds/explosion.wav");
    public static File upgrade = new File(resourceDirectory + "sounds/upgrade.wav");
    public static File robotExplosion = new File(resourceDirectory + "sounds/smallEx.wav");
    public static File bulletHitHardWall = new File(resourceDirectory + "sounds/bulletHitHardWall.wav");
    public static File softWalldestruction = new File(resourceDirectory + "sounds/softWall.wav");

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

    public static void removePlayer(Objects objects, Tank tank)
    {
        objects.getPlayers().remove(tank);
    }

    /**
     * save game states
     *
     * @param objects objects of the game
     */
    public static void saveGame(Objects objects)
    {
        new DataSaver(objects);
    }

    /**
     * if there is any save file, it initialize game objects
     *
     * @param objects
     */
    public static void initGame(Objects objects)
    {
        new DataInitializer(objects);
    }

    public static Boolean checkEnd(Objects objects){
        for(int i = 0 ; i < objects.getPlayers().size() ; i++){
            Rectangle rectangle = new Rectangle((int)objects.getMap().getEnd().getX()+40,(int)objects.getMap().getEnd().getY()+40,50,50);
            if(objects.getPlayers().get(i).getBounds().intersects(rectangle)){
                SharedData.getData().result = ObjectId.Won; // one of the players reached the end of the map
                return true;
            }
        }
        if(objects.getPlayers().size() == 0){ //all players got destroyed that means losing
            SharedData.getData().result = ObjectId.Lost;
            return true;
        }
        return false;
    }

    public static void showVictoryEnding(GameFrame canvas){ //victory frame must be drawn here
        System.out.println("YOU WON");

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.BLACK);

        canvas.setContentPane(mainPanel);
        canvas.setLayout(null);

        JButton exitButton = new JButton("Exit");
        exitButton.setSize(400, 100);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusable(false);
        exitButton.setOpaque(true);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFont(new Font("Titillium Web", 4, 50));
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals(exitButton))
                {
                    System.exit(10);
                }
            }
        });

        mainPanel.add(exitButton);

        Dimension dimension = new Dimension();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel startupLabel = null;
        if (dimension.width >= 3840)
        {
            startupLabel = new JLabel(Utility.winBig);
            exitButton.setLocation(1700, 2000);
        }
        else
        {
            startupLabel = new JLabel(Utility.winMedium);
            exitButton.setLocation(500, 700);
        }
        startupLabel.setSize(dimension.width, dimension.height);
        mainPanel.add(startupLabel);


        canvas.revalidate();
        canvas.repaint();
        canvas.setVisible(true);
    }

    public static void showDefeatedEnding(GameFrame canvas){ // //losing frame must be drawn here
        System.out.println("YOU Lost");

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.BLACK);

        canvas.setContentPane(mainPanel);
        canvas.setLayout(null);

        JButton exitButton = new JButton("Exit");
        exitButton.setSize(400, 100);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusable(false);
        exitButton.setOpaque(true);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFont(new Font("Titillium Web", 4, 50));
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals(exitButton))
                {
                    System.exit(10);
                }
            }
        });

        mainPanel.add(exitButton);

        Dimension dimension = new Dimension();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel startupLabel = null;
        if (dimension.width >= 3840)
        {
            startupLabel = new JLabel(Utility.loseBig);
            exitButton.setLocation(1700, 2000);
        }
        else
        {
            startupLabel = new JLabel(Utility.loseMedium);
            exitButton.setLocation(500, 700);
        }
        startupLabel.setSize(dimension.width, dimension.height);
        mainPanel.add(startupLabel);


        canvas.revalidate();
        canvas.repaint();
        canvas.setVisible(true);
    }

    /*
        This is how to delete a directory from the repository:
            git rm -r --cached node_modules
            git commit -m 'Remove the now ignored directory node_modules'
            git push origin master
    */

}
