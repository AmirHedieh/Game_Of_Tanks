/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.*;
import game.Utils.*;
import game.map.Camera;
import game.map.SpriteSheet;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        //
        // Initialize the JFrame ...
        //
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/resource/cursor.png").getImage(), new Point(0, 0), "custom cursor"));
    }

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
    public void render(GameState state, Camera camera, SpriteSheet spriteSheet)
    {
        // Get a new graphics context to render the current frame
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        try
        {
            // Do the rendering
            doRendering(graphics, state, camera, spriteSheet);
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
    private void doRendering(Graphics2D g2d, GameState state, Camera camera, SpriteSheet spriteSheet)
    {
        AffineTransform gameTransform = g2d.getTransform();
        g2d.translate(-camera.getX(), -camera.getY());

        //draw map components
        BufferedImage map = Utility.loadImage("src/resource/map.png");
        for (int xx = 0; xx < map.getWidth(); xx++)
        {
            for (int yy = 0; yy < map.getHeight(); yy++)
            {
                int pixel = map.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if ((red == 255) && (green == 255) && (blue == 0)) //HardWall
                {
                    g2d.drawImage(state.objects.getHardWall().getTexture(), xx * 100, yy * 100, null);
                }
                if ((red == 0) && (green == 0) && (blue == 255)) //SoftWall
                {
                    g2d.drawImage(state.objects.getSoftWall().getTexture(), xx * 100, yy * 100, null);
                }

                if ((red == 0) && (green == 255) && (blue == 0)) //Plant
                {
                    g2d.drawImage(state.objects.getPlant().getTexture(), xx * 100, yy * 100, null);
                }

                if ((red == 255) && (green == 255) && (blue == 255)) //Soil
                {
                    g2d.drawImage(state.objects.getSoil().getTexture(), xx * 100, yy * 100, null);
                }

                if ((red == 255) && (green == 0) && (blue == 255)) //Teazel
                {
                    g2d.drawImage(state.objects.getTeazel().getTexture(), xx * 100, yy * 100, null);
                }
            }
        }


        //render camera
        //camera.tick(state.objects.getPlayer());


        //draw player tank
        for (int i = 0; i < state.objects.getPlayers().size(); i++)
        {
            int centerX = (int) state.objects.getPlayers().get(i).getX();
            int centerY = (int) state.objects.getPlayers().get(i).getY();

            AffineTransform bodyTransform = g2d.getTransform();
            //TODO: rotate by wasd
            //bodyTransform.rotate(state.getBodyAngle(), centerX, centerY);
            g2d.setTransform(bodyTransform);
            g2d.drawImage(state.objects.getPlayers().get(i).getTexture(), (int) state.objects.getPlayers().get(i).getX() - state.objects.getPlayers().get(i).TANK_WIDTH / 2, (int) state.objects.getPlayers().get(i).getY() - state.objects.getPlayers().get(i).TANK_HEIGHT / 2, null);
            g2d.setTransform(gameTransform);

            //draw the Gun of the Player Tank and handle its rotation
            BufferedImage gun = null;
            if (state.objects.getPlayers().get(i).getSelectedGun().getId().equals(ObjectId.MissileGun))
            {
                AffineTransform gunTransform = g2d.getTransform();
                //we know that atan2 return radian :)
                double playerGunAngle = Math.atan2((state.getMouseY() - centerY), (state.getMouseX() - centerX));
                gunTransform.rotate(playerGunAngle, centerX, centerY);
                g2d.setTransform(gunTransform);
            }
            else if (state.objects.getPlayers().get(i).getSelectedGun().getId().equals(ObjectId.MachineGun))
            {
                AffineTransform gunTransform = g2d.getTransform();
                double playerGunAngle = Math.atan2((state.getMouseY() - centerY), (state.getMouseX() - centerX));
                gunTransform.rotate(playerGunAngle, centerX, centerY);
                g2d.setTransform(gunTransform);
            }
            g2d.drawImage(state.objects.getPlayers().get(i).getSelectedGun().getTexture(), (int) state.objects.getPlayers().get(i).getX() - state.objects.getPlayers().get(i).TANK_WIDTH / 2 + 18, (int) state.objects.getPlayers().get(i).getY() - state.objects.getPlayers().get(i).TANK_HEIGHT / 2, null);
            g2d.setTransform(gameTransform);
        }


        //draw tanks
        ArrayList<Tank> tanks = state.objects.getTanks();
        for (int i = 0; i < tanks.size(); i++)
        {

        }

        ArrayList<Bullet> bullets = state.objects.getBullets();
        for (int i = 0; i < bullets.size(); i++)
        {
            if (bullets.get(i).getId().equals(ObjectId.HeavyBullet))
            {
                AffineTransform bulletTransform = g2d.getTransform();
                double gunAngle = Math.atan2((bullets.get(i).getTargetY() - (int) bullets.get(i).getY()), (bullets.get(i).getTargetX() - (int) bullets.get(i).getX()));
                bulletTransform.rotate(gunAngle, (int) bullets.get(i).getX(), (int) bullets.get(i).getY());
                g2d.setTransform(bulletTransform);
                g2d.drawImage(bullets.get(i).getTexture(), (int) bullets.get(i).getX(), (int) bullets.get(i).getY(), null);
                g2d.setTransform(gameTransform);
            }
            else if (bullets.get(i).getId().equals(ObjectId.LightBullet))
            {
                AffineTransform bulletTransform = g2d.getTransform();
                double gunAngle = Math.atan2((bullets.get(i).getTargetY() - (int) bullets.get(i).getY()), (bullets.get(i).getTargetX() - (int) bullets.get(i).getX()));
                bulletTransform.rotate(gunAngle, (int) bullets.get(i).getX(), (int) bullets.get(i).getY());
                g2d.setTransform(bulletTransform);
                g2d.drawImage(bullets.get(i).getTexture(), (int) bullets.get(i).getX(), (int) bullets.get(i).getY(), null);
                g2d.setTransform(gameTransform);
            }
        }

        ArrayList<Turret> turrets = state.objects.getTurrets();
        for (int i = 0; i < turrets.size(); i++)
        {
            g2d.drawImage(turrets.get(i).getTexture(), null, (int) turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2, (int) turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2);
        }

        ArrayList<BuriedRobot> robots = state.objects.getRobots();
        for (int i = 0; i < robots.size(); i++)
        {
            if (robots.get(i).isActivated())
            {
                g2d.drawImage(robots.get(i).getTexture(), null, (int) robots.get(i).getX(), (int) robots.get(i).getY());
            }
        }
        g2d.translate(camera.getX(), camera.getY());
    }
}
