/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.Tank;

import java.awt.*;
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
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		//draw tanks
        ArrayList<Tank> tanks = state.objects.getTanks();
		for(int i = 0 ; i < tanks.size() ; i++){
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("F:\\AP\\HW\\Normal Tanks\\NormalTanks\\src\\resource\\texture\\8.png"));
				//FIXME: hey Amas...change this path...
			} catch (IOException e) {
				e.printStackTrace();
			}
			g2d.drawImage(img, null, tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2,tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2);
			//g2d.setColor(Color.orange);
			//g2d.fillRect(tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2,tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2, tanks.get(i).TANK_WIDTH, tanks.get(i).TANK_HEIGHT);
		}
	}
	
}
