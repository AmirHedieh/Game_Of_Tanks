/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.Bullet;
import game.elements.Tank;
import game.elements.Turret;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The window on which the rendering is performed.
 * This structure uses the modern BufferStrategy approach for 
 * double-buffering; actually, it performs triple-buffering!
 * For more information on BufferStrategy check out:
 *    http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 *    http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame {
	
	public static final int GAME_HEIGHT = 1024;                  // custom game resolution
	public static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;  // wide aspect ratio
	
	private BufferStrategy bufferStrategy;
	
	public GameFrame(String title) {
		super(title);
		setResizable(false);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		//
		// Initialize the JFrame ...
		//
	}
	
	/**
	 * This must be called once after the JFrame is shown:
	 *    frame.setVisible(true);
	 * and before any rendering is started.
	 */
	public void initBufferStrategy() {
		// Triple-buffering
		createBufferStrategy(3);
		bufferStrategy = getBufferStrategy();
	}

	
	/**
	 * Game rendering with triple-buffering using BufferStrategy.
	 */
	public void render(GameState state) {
		// Get a new graphics context to render the current frame
		Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
		try {
			// Do the rendering
			doRendering(graphics, state);
		} finally {
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
	private void doRendering(Graphics2D g2d, GameState state) {

		// Draw background
		BufferedImage backGround = loadImage("src/resource/Sahara.png");
		g2d.drawImage(backGround, null, 0, 0);
		/*g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);*/

		//draw tanks
        ArrayList<Tank> tanks = state.objects.getTanks();
		for(int i = 0 ; i < tanks.size() ; i++){
			BufferedImage tank = loadImage("src/resource/tank.png");
            g2d.drawImage(tank, null, (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2,(int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2);

            BufferedImage gun = loadImage("src/resource/tankGun01.png");

			/*int mouseY = MouseInfo.getPointerInfo().getLocation().y;
            int mouseX = MouseInfo.getPointerInfo().getLocation().x;

            int centerX = (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2;
            int centerY = (int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2;

            double angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI / 2;
            gun.createGraphics().rotate(angle, centerX, centerY);
*/

            g2d.drawImage(gun, null, (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2 + 18,(int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2 + 11);
			//g2d.setColor(Color.orange);
			//g2d.fillRect((int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2,(int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2, tanks.get(i).TANK_WIDTH, tanks.get(i).TANK_HEIGHT);
		}

		ArrayList<Bullet> bullets = state.objects.getBullets();
		for(int i = 0 ; i < bullets.size() ; i++){
			g2d.setColor(Color.CYAN);
			g2d.fillRect( (int) bullets.get(i).getX() ,(int) bullets.get(i).getY() , 5,5 );
		}

		ArrayList<Turret> turrets = state.objects.getTurrets();
		for(int i= 0 ; i < turrets.size() ; i++){
            BufferedImage turret = loadImage("src/resource/tank_turret.png");
            g2d.drawImage(turret, null, (int)turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2,(int)turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2);
			/*g2d.setColor(Color.GREEN);
			g2d.fillRect((int)turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2,(int)turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2, turrets.get(i).TURRET_WIDTH, turrets.get(i).TURRET_HEIGHT);*/
		}
	}

	public BufferedImage loadImage(String path)
    {
        BufferedImage temp = null;
        try
        {
            temp = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
	
}
