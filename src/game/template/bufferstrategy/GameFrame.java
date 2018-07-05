/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.Bullet;
import game.elements.BuriedRobot;
import game.elements.Tank;
import game.elements.Turret;
import game.Utils.*;

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
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/resource/cursor.png").getImage(),new Point(0,0),"custom cursor"));
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
	private void doRendering(Graphics2D g2d, GameState state)
	{
		AffineTransform gameTransform = g2d.getTransform();

		// Draw background
		//BufferedImage backGround = Utility.loadImage("src/resource/field.png");
		BufferedImage backGround = Utility.loadImage("src/resource/Sahara.png");
		g2d.drawImage(backGround, null, 0, 0);

		//draw tanks
        ArrayList<Tank> tanks = state.objects.getTanks();
		for(int i = 0 ; i < tanks.size() ; i++){
			BufferedImage tank = Utility.loadImage("src/resource/tank.png");
            //g2d.drawImage(tank, null, (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2,(int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2);

			int centerX = (int)tanks.get(i).getX();
			int centerY = (int)tanks.get(i).getY();

			AffineTransform bodyTransform = g2d.getTransform();
			bodyTransform.rotate(state.getBodyAngle(), centerX, centerY);
			g2d.setTransform(bodyTransform);
			g2d.drawImage(tank, (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2, (int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2, null);
			g2d.setTransform(gameTransform);

			//draw and rotate gun
			BufferedImage gun = Utility.loadImage("src/resource/tankGun01.png");
			AffineTransform gunTransform = g2d.getTransform();
			//we know that atan2 return radian :)
			double gunAngle = Math.atan2( (state.getMouseYPointer() - centerY), (state.getMouseXPointer() - centerX) );
			gunTransform.rotate(gunAngle, centerX, centerY);
			g2d.setTransform(gunTransform);
			g2d.drawImage(gun, (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2 + 18,(int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2, null);
			g2d.setTransform(gameTransform);
		}

		ArrayList<Bullet> bullets = state.objects.getBullets();
		for(int i = 0 ; i < bullets.size() ; i++){
			BufferedImage bullet = Utility.loadImage("src/resource/LightBullet.png");
			g2d.drawImage(bullet, null, (int) bullets.get(i).getX(), (int) bullets.get(i).getY());
			/*g2d.setColor(Color.BLACK);
			g2d.fillRect( (int) bullets.get(i).getX() ,(int) bullets.get(i).getY() , 5,5 );*/
		}

		ArrayList<Turret> turrets = state.objects.getTurrets();
		for(int i = 0 ; i < turrets.size() ; i++){
            BufferedImage turret = Utility.loadImage("src/resource/tank_turret.png");
            g2d.drawImage(turret, null, (int)turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2,(int)turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2);
			/*g2d.setColor(Color.GREEN);
			g2d.fillRect((int)turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2,(int)turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2, turrets.get(i).TURRET_WIDTH, turrets.get(i).TURRET_HEIGHT);*/
		}

		ArrayList<BuriedRobot> robots = state.objects.getRobots();
		for(int i = 0 ; i < robots.size() ; i++) {
			if(robots.get(i).isActivated()) {
				BufferedImage turret = Utility.loadImage("src/resource/buriedRobot.png");
				g2d.drawImage(turret, null, (int) robots.get(i).getX(),(int) robots.get(i).getY());
				/*g2d.setColor(Color.BLACK);
				g2d.fillRect((int) robots.get(i).getX(), (int) robots.get(i).getY(), 20, 20);*/
			}
		}
	}
}
