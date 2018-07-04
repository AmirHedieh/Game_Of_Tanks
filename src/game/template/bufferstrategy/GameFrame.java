/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.Bullet;
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
		AffineTransform oldTransform = g2d.getTransform();

		// Draw background
		BufferedImage backGround = Utility.loadImage("src/resource/Sahara.png");
		g2d.drawImage(backGround, null, 0, 0);
		/*g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);*/

		//draw tanks
        ArrayList<Tank> tanks = state.objects.getTanks();
		for(int i = 0 ; i < tanks.size() ; i++){
			BufferedImage tank = Utility.loadImage("src/resource/tank.png");
            g2d.drawImage(tank, null, (int)tanks.get(i).getX() - tanks.get(i).TANK_WIDTH / 2,(int)tanks.get(i).getY() - tanks.get(i).TANK_HEIGHT / 2);

            BufferedImage gun = Utility.loadImage("src/resource/tankGun01.png");

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
            BufferedImage turret = Utility.loadImage("src/resource/tank_turret.png");
            g2d.drawImage(turret, null, (int)turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2,(int)turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2);
			/*g2d.setColor(Color.GREEN);
			g2d.fillRect((int)turrets.get(i).getX() - turrets.get(i).TURRET_WIDTH / 2,(int)turrets.get(i).getY() - turrets.get(i).TURRET_HEIGHT / 2, turrets.get(i).TURRET_WIDTH, turrets.get(i).TURRET_HEIGHT);*/
		}
	}

		/*// Draw background
		VcamX=state.camlocX;
		VcamY=state.camlocY;
		while(VcamX%200!=0){
			VcamX--;
			temp++;
		}
		VcamX=-temp;
		temp=0;
		while(VcamY%200!=0){
			VcamY--;
			temp++;
		}
		VcamY=-temp;
		temp=0;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				g2d.drawImage(groundimage,VcamX+200*i,VcamY+200*j,200,200,null);
			}
		}
		// Draw tank
		locationX = tankbodyimage.getWidth() / 2;
		locationY = tankbodyimage.getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians(state.tanktheta), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(tankbodyimage,null),state.locNX-100,state.locNY-70,null);
		//Draw shots
		for(int i=0;i<state.shots.size();i++){
			if(state.shots.get(i).locX-state.camlocX<=1800 && state.shots.get(i).locX-state.camlocX>=0 && state.shots.get(i).locY-state.camlocY<=1000 && state.shots.get(i).locY-state.camlocY>=0) {
				if (state.shots.get(i).isCannon) {
					try {
						shotimage = ImageIO.read(new File("src/Images/cannonShot.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						shotimage = ImageIO.read(new File("src/Images/ArcheryShot.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				locationX = shotimage.getWidth() / 2;
				locationY = shotimage.getHeight() / 2;
				tx = AffineTransform.getRotateInstance(state.shots.get(i).theta, locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(shotimage, null), state.shots.get(i).locNX, state.shots.get(i).locNY, null);
			}
			state.shots.get(i).locX+=10*Math.cos(state.shots.get(i).theta);
			state.shots.get(i).locY+=10*Math.sin(state.shots.get(i).theta);
			state.shots.get(i).locNX+=10*Math.cos(state.shots.get(i).theta);
			state.shots.get(i).locNY+=10*Math.sin(state.shots.get(i).theta);
			if(state.shots.get(i).locX<=0 || state.shots.get(i).locX>=6000 || state.shots.get(i).locY<=0 || state.shots.get(i).locY>=10000){
				state.shots.remove(i);
				i--;
			}
		}
		//Draw Weapon
		if(state.isCannon) {
			try {
				weaponimage=ImageIO.read(new File("src/Images/canoon.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				weaponimage=ImageIO.read(new File("src/Images/Archery.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (state.locNX + 100 > state.mouseX) {
			rotationRequired = Math.atan(((double) state.mouseY - state.locNY - 100) / (state.mouseX - state.locNX - 100)) + Math.toRadians(180);
		} else {
			rotationRequired = Math.atan(((double) state.mouseY - state.locNY - 100) / (state.mouseX - state.locNX - 100));
		}
		locationX = weaponimage.getWidth() / 2;
		locationY = weaponimage.getHeight() / 2;
		tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(weaponimage, null), state.locNX-60, state.locNY-40, null);
		//Draw Enemy
		g2d.setColor(Color.WHITE);
		for(int i=0;i<5;i++){
			if(state.BEnemies[i].locX-state.camlocX<=1800 && state.BEnemies[i].locX-state.camlocX>=-250 && state.BEnemies[i].locY-state.camlocY<=1000 && state.BEnemies[i].locY-state.camlocY>=-250){
				EnemyNX=state.BEnemies[i].locX-state.camlocX;
				EnemyNY=state.BEnemies[i].locY-state.camlocY;
				g2d.drawImage(BEnemyimage,EnemyNX,EnemyNY,null);
				if (EnemyNX+200 > state.locNX + 100) {
					rotationRequired = Math.atan(((double) state.locNY+100 - EnemyNY-200) / (state.locNX+100 - EnemyNX-200)) + Math.toRadians(180);
				} else {
					rotationRequired = Math.atan(((double) state.locNY+100 - EnemyNY-200) / (state.locNX+100 - EnemyNX-200));
				}
				locationX = BEnemyGun.getWidth() / 2;
				locationY = BEnemyGun.getHeight() / 2;
				tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(BEnemyGun, null), EnemyNX+50, EnemyNY+50, null);
				state.BEnemies[i].locX+=3*Math.cos(rotationRequired);
				state.BEnemies[i].locY+=3*Math.sin(rotationRequired);
			}
			if(state.SEnemies[i].locX-state.camlocX<=1800 && state.SEnemies[i].locX-state.camlocX>=-200 && state.SEnemies[i].locY-state.camlocY<=1000 && state.SEnemies[i].locY-state.camlocY>=-200){
				EnemyNX=state.SEnemies[i].locX-state.camlocX;
				EnemyNY=state.SEnemies[i].locY-state.camlocY;
				g2d.drawImage(SEnemyimage,EnemyNX,EnemyNY,null);
				if (EnemyNX+130 > state.locNX + 100) {
					rotationRequired = Math.atan(((double) state.locNY+100 - EnemyNY-130) / (state.locNX+100 - EnemyNX-130)) + Math.toRadians(180);
				} else {
					rotationRequired = Math.atan(((double) state.locNY+100 - EnemyNY-130) / (state.locNX+100 - EnemyNX-130));
				}
				locationX = SEnemyGun.getWidth() / 2;
				locationY = SEnemyGun.getHeight() / 2;
				tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(SEnemyGun, null), EnemyNX+30, EnemyNY+30, null);
				state.SEnemies[i].locX+=3*Math.cos(rotationRequired);
				state.SEnemies[i].locY+=3*Math.sin(rotationRequired);
			}
		}
		//Draw status
		g2d.drawImage(Cstat,15,50,null);
		g2d.drawImage(Astat,20,115,null);
		g2d.setFont(new Font(null,Font.BOLD,20));
		g2d.drawString(Integer.toString(state.CCount),100,75);
		g2d.drawString(Integer.toString(state.ACount),100,140);
	}
*/

}
