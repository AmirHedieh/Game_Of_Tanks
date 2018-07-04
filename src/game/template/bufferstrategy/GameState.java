/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.AITankHandler;
import game.elements.Objects;
import game.elements.Tank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;

/**
 * This class holds the state of the game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

    public Objects objects = new Objects(); // objects of the game
	private AITankHandler aiTankHandler; // AI tanks manager

    private boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
    private boolean shoot;
    private boolean swap;
    private double mouseX, mouseY;

    /*
    this is a temp for last key pressed
    one is for right
    two is for up
    three is for left
    four is for down
     */
    private int lastKey;
    public static double bodyAngle;

    private KeyHandler keyHandler;
	private MouseHandler mouseHandler;
	
	public GameState() {
		// Initialize the game state and all elements ...
        keyUP = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;
        //
        shoot = false;
        swap = false;
        //
		objects.init(); //initialize game objects
		aiTankHandler = new AITankHandler();
        //
		keyHandler = new KeyHandler();
		mouseHandler = new MouseHandler();
	}
	
	/**
	 * The method which updates the game state.
	 */
	public void update() {
		// Update the state of all game elements 
		//  based on user input and elapsed time ...
        //first element( objects.getTanks().get(0) ) in arrayList is player's tank.
        if (keyUP)
            objects.getTanks().get(0).setY( objects.getTanks().get(0).getY() - objects.getTanks().get(0).getVelY() );
        if (keyDOWN)
            objects.getTanks().get(0).setY( objects.getTanks().get(0).getY() + objects.getTanks().get(0).getVelY() );
        if (keyLEFT)
            objects.getTanks().get(0).setX( objects.getTanks().get(0).getX() - objects.getTanks().get(0).getVelX() );
        if (keyRIGHT)
            objects.getTanks().get(0).setX( objects.getTanks().get(0).getX() + objects.getTanks().get(0).getVelX() );
        //
        if(shoot)
			if(objects.getTanks().get(0).getSelectedGun().readyForShoot()) {
				objects.addBullet(objects.getTanks().get(0).getSelectedGun().shoot(objects.getTanks().get(0).getX(), objects.getTanks().get(0).getY(), mouseX, mouseY)); //tank's gun shoots a bullet. bullet is added to bullets arrayList
			}
		//
		if(swap) {
			objects.getTanks().get(0).swapGun();
			swap = false;
		}

		//
        for(int i = 0 ; i < objects.getBullets().size() ; i++){
        	objects.getBullets().get(i).setX(objects.getBullets().get(i).getX() + Math.cos(objects.getBullets().get(i).getShootDirectionAngle()) * objects.getBullets().get(i).getVelX());
			objects.getBullets().get(i).setY(objects.getBullets().get(i).getY() + Math.sin(objects.getBullets().get(i).getShootDirectionAngle()) * objects.getBullets().get(i).getVelY());
		}
		//
		for(int i = 0 ; i < objects.getTurrets().size() ; i++){
        	objects.getTurrets().get(i).tick(objects);
		}
		//
		aiTankHandler.tick(objects);
        //
		for(int i = 0 ; i < objects.getRobots().size() ; i++){
			objects.getRobots().get(i).tick(objects);
		}
	}

	
	
	
	public KeyListener getKeyListener() {
		return keyHandler;
	}
	public MouseListener getMouseListener() {
		return mouseHandler;
	}
	public MouseMotionListener getMouseMotionListener() {
		return mouseHandler;
	}



	/**
	 * The keyboard handler.
     * W for moving up.
     * S for moving down.
     * A for moving left.
     * D for moving right.
     * process : when a key is pressed its boolean field gets true until it gets released, keyReleased method make boolean false.
	 */
	class KeyHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    keyUP = true;
                    lastKey = 2;
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = true;
                    lastKey = 4;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = true;
                    lastKey = 3;
                    break;
                case KeyEvent.VK_D:
                    keyRIGHT = true;
                    lastKey = 1;
                    break;
            }
		}

		@Override
		public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    keyUP = false;
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = false;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = false;
                    break;
                case KeyEvent.VK_D:
                    keyRIGHT = false;
                    break;
            }

        }

	}

	/**
	 * The mouse handler.
	 */
	class MouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) { // when pressing LEFT CLICK it shoots
				mouseX = e.getX();
				mouseY = e.getY();
				shoot = true;
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		    shoot = false;
		    if(e.getButton() == MouseEvent.BUTTON3){ // when pressing RIGHT CLICK it swaps tank gun
				swap = true;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
            // maybe user clicks and drags so it must be updated without clicking again.
            mouseX = e.getX();
            mouseY = e.getY();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
}

