/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.Utils.SharedData;
import game.Utils.Utility;
import game.elements.*;
import game.map.Camera;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.*;

/**
 * The window on which the rendering is performed.
 * This structure uses the modern BufferStrategy approach for
 * double-buffering; actually, it performs triple-buffering!
 * For more information on BufferStrategy check out:
 * http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 * http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame
{

    public static final int GAME_HEIGHT = 1024;                  // custom game resolution
    public static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;  // wide aspect ratio

    private BufferStrategy bufferStrategy;

    public GameFrame(String title)
    {
        super(title);
        if (false) // Full screen mode
        {
            // Disables decorations for this frame.
            this.setUndecorated(true);
            // Puts the frame to full screen.
            this.setExtendedState(this.MAXIMIZED_BOTH);
        }
        else // Window mode
        {
            // Size of the frame.
            this.setSize(GAME_WIDTH, GAME_HEIGHT);
            // Puts frame to center of the screen.
            this.setLocationRelativeTo(null);
            // So that frame cannot be resizable by the user.
            this.setResizable(false);
        }
        // Initialize the JFrame ...
        //
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Utility.cursor, new Point(20, 14), "custom cursor"));
    }

    /*
        linear algebra for game developers: http://blog.wolfire.com/2009/07/linear-algebra-for-game-developers-part-1/
        http://www.gametutorial.net
     */

    /**
     * This must be called once after the JFrame is shown:
     * frame.setVisible(true);
     * and before any rendering is started.
     */
    public void initBufferStrategy()
    {
        // Triple-buffering
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }


    /**
     * Game rendering with triple-buffering using BufferStrategy.
     */
    public void render(GameState state, Camera camera)
    {
        // Get a new graphics context to render the current frame
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        try
        {
            // Do the rendering
            doRendering(graphics, state, camera);
        }
        finally
        {
            // Dispose the graphics, because it is no more needed
            graphics.dispose();
        }
        // Display the buffer
        bufferStrategy.show();
        // Tell the system to do the drawing NOW;
        // otherwise it can take a few extra ms and will feel jerky!
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Rendering all game elements based on the game state.
     */
    private void doRendering(Graphics2D g2d, GameState state, Camera camera)
    {
        Utility.tankAnimation.runAnimation();
        AffineTransform gameTransform = g2d.getTransform();
//        g2d.translate(-camera.getX(), -camera.getY());

        //render map
        state.objects.getMap().render(g2d);


        //draw bullets
        ArrayList<Bullet> bullets = state.objects.getBullets();
        for (int i = 0; i < bullets.size(); i++)
        {
            drawBullet(gameTransform, g2d, bullets.get(i));
        }

        //draw player tank
        for (int i = 0; i < state.objects.getPlayers().size(); i++)
        {
            //camera.tick(state.objects.getPlayers().get(i));

            int centerX = (int) state.objects.getPlayers().get(i).getX() + state.objects.getPlayers().get(i).TANK_WIDTH / 2; //this is the X center of the player
            int centerY = (int) state.objects.getPlayers().get(i).getY() + state.objects.getPlayers().get(i).TANK_HEIGHT / 2; //this is the Y center of the player

            AffineTransform bodyTransform = g2d.getTransform();
            //TODO: rotate by wasd
            //bodyTransform.rotate(state.getBodyAngle(), centerX, centerY);
            g2d.setTransform(bodyTransform);
            if (!state.isKeyDOWN() & !state.isKeyLEFT() & !state.isKeyRIGHT() & !state.isKeyLEFT())
            {
                g2d.drawImage(Utility.tank02,
                        (int) state.objects.getPlayers().get(i).getX(), //this is the X upper left corner of the tile
                        (int) state.objects.getPlayers().get(i).getY(), //this is the Y upper left corner of the tile
                        null);
            }
            else
            {
                Utility.tankAnimation.drawAnimation(g2d, (int) state.objects.getPlayers().get(i).getX(), (int) state.objects.getPlayers().get(i).getY(), 0);
            }
           /* g2d.drawImage(Utility.tank,
                    (int) state.objects.getPlayers().get(i).getX(), //this is the X upper left corner of the tile
                    (int) state.objects.getPlayers().get(i).getY(), //this is the Y upper left corner of the tile
                    null);*/
            g2d.setTransform(gameTransform);
            //draw the Gun of the Player Tank and handle its rotation
            if (state.objects.getPlayers().get(i).getSelectedGun().getId().equals(ObjectId.MissileGun))
            {
                AffineTransform gunTransform = g2d.getTransform();
                //we know that atan2 return radian :)
                if(i == 0) {
                    double playerGunAngle = Math.atan2((state.getMouseY() - centerY), (state.getMouseX() - centerX));
                    gunTransform.rotate(playerGunAngle, centerX, centerY);
                    state.objects.getPlayers().get(0).setGunAngle(playerGunAngle); //set angle in tank info
                }
                else if(SharedData.getData().gameType.equals(ObjectId.TwoPlayer) && i == 1){
                    gunTransform.rotate(state.objects.getPlayers().get(1).getGunAngle(), centerX, centerY);
                }
                g2d.setTransform(gunTransform);
                g2d.drawImage(Utility.gun01,
                        (int) state.objects.getPlayers().get(i).getX() + 18,
                        (int) state.objects.getPlayers().get(i).getY() + 5,
                        null);
            }
            else if (state.objects.getPlayers().get(i).getSelectedGun().getId().equals(ObjectId.MachineGun))
            {
                AffineTransform gunTransform = g2d.getTransform();
                if(i == 0) {
                    double playerGunAngle = Math.atan2((state.getMouseY() - centerY), (state.getMouseX() - centerX));
                    gunTransform.rotate(playerGunAngle, centerX, centerY);
                    state.objects.getPlayers().get(0).setGunAngle(playerGunAngle); //set angle in tank info
                }
                else if(i == 1){
                    gunTransform.rotate(state.objects.getPlayers().get(1).getGunAngle(), centerX, centerY);
                }
                g2d.setTransform(gunTransform);
                g2d.drawImage(Utility.gun02,
                        (int) state.objects.getPlayers().get(i).getX() + 18 - (int)camera.getX(),
                        (int) state.objects.getPlayers().get(i).getY() - (int)camera.getY(),
                        null);
            }
            g2d.setTransform(gameTransform);
        }

        //draw tanks
        ArrayList<Tank> tanks = state.objects.getTanks();
        for (int i = 0; i < tanks.size(); i++)
        {

        }

        //draw turrets
        ArrayList<Turret> turrets = state.objects.getTurrets();
        for (int i = 0; i < turrets.size(); i++)
        {
            g2d.drawImage(Utility.turret, null, (int) turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2, (int) turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2);
        }

        //draw robots
        ArrayList<BuriedRobot> robots = state.objects.getRobots();
        for (int i = 0; i < robots.size(); i++)
        {
            if (robots.get(i).isActivated())
            {
                g2d.drawImage(Utility.buriedRobot, null, (int) robots.get(i).getX(), (int) robots.get(i).getY());
            }
        }
        //g2d.translate(camera.getX(), camera.getY());
    }

    private void drawBullet(AffineTransform gameTransform, Graphics2D g2d, Bullet bullet)
    {
        AffineTransform bulletTransform = g2d.getTransform();
        double bulletAngle;
        if (bullet.isThrown())
        {
            bulletAngle = bullet.getThrownAngle();
        }
        else
        {
            bulletAngle = bullet.getShootDirectionAngle();
            if (bullet.getTargetX() < bullet.getX())
            {
                bulletAngle += Math.PI;
            }
            bullet.setThrownAngle(bulletAngle);
            bullet.setThrown(true);
        }
        bulletTransform.rotate(bulletAngle, (int) bullet.getX() + 50, (int) bullet.getY() + 50);
        g2d.setTransform(bulletTransform);
        if (bullet.getId().equals(ObjectId.HeavyBullet))
        {
            g2d.drawImage(Utility.heavyBullet, (int) bullet.getX() + 52, (int) bullet.getY() + 50, null);
        }
        else
        {
            g2d.drawImage(Utility.lightBullet, (int) bullet.getX() + 52, (int) bullet.getY() + 50, null);
        }
        g2d.setTransform(gameTransform);
    }
}
