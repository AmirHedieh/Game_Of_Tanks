/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.Objects;
import game.elements.Tank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class holds the state of the game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

    public Objects objects = new Objects(); // objects of the game

    private boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
    private boolean mousePress;
    private int mouseX, mouseY;

    private KeyHandler keyHandler;
	private MouseHandler mouseHandler;
	
	public GameState() {
		// Initialize the game state and all elements ...

		objects.init(); //initialize game objects

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
        Tank player = objects.getTanks().get(0); //first element in arrayList is player tank
        if (keyUP)
            player.setY( player.getY() - player.getVelY() );
        if (keyDOWN)
            player.setY( player.getY() + player.getVelY() );
        if (keyLEFT)
            player.setX( player.getX() - player.getVelX() );
        if (keyRIGHT)
            player.setX( player.getX() + player.getVelX() );
		//
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
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = true;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = true;
                    break;
                case KeyEvent.VK_D:
                    keyRIGHT = true;
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
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
}

