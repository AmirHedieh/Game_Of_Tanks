/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.elements.AITankHandler;
import game.elements.ObjectId;
import game.elements.Objects;

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
public class GameState
{

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
    public double bodyAngle;

    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    public GameState()
    {
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
    public void update()
    {
        // Update the state of all game elements
        //  based on user input and elapsed time ...
        //first element( objects.getPlayers().get(0) ) in arrayList is player's tank.
        //first element( objects.getPlayer() ) in arrayList is player's tank.
        //collision();
        if (keyUP)
        {
            objects.getPlayers().get(0).setY(objects.getPlayers().get(0).getY() - objects.getPlayers().get(0).getVelY());
        }
        if (keyDOWN)
        {
            objects.getPlayers().get(0).setY(objects.getPlayers().get(0).getY() + objects.getPlayers().get(0).getVelY());
        }
        if (keyLEFT)
        {
            objects.getPlayers().get(0).setX(objects.getPlayers().get(0).getX() - objects.getPlayers().get(0).getVelX());
        }
        if (keyRIGHT)
        {
            objects.getPlayers().get(0).setX(objects.getPlayers().get(0).getX() + objects.getPlayers().get(0).getVelX());
        }
        //
        if (shoot)
        {
            if (objects.getPlayers().get(0).getSelectedGun().readyForShoot())
            {
                objects.addBullet(objects.getPlayers().get(0).getSelectedGun().shoot(objects.getPlayers().get(0).getX(), objects.getPlayers().get(0).getY(), mouseX, mouseY)); //tank's gun shoots a bullet. bullet is added to bullets arrayList
            }
        }
        //
        if (swap)
        {
            objects.getPlayers().get(0).swapGun();
            swap = false;
        }

        //
        for (int i = 0; i < objects.getBullets().size(); i++)
        {
            objects.getBullets().get(i).setX(objects.getBullets().get(i).getX() + Math.cos(objects.getBullets().get(i).getShootDirectionAngle()) * objects.getBullets().get(i).getVelX());
            objects.getBullets().get(i).setY(objects.getBullets().get(i).getY() + Math.sin(objects.getBullets().get(i).getShootDirectionAngle()) * objects.getBullets().get(i).getVelY());
        }
        //
        for (int i = 0; i < objects.getTurrets().size(); i++)
        {
            objects.getTurrets().get(i).tick(objects);
        }
        //
        aiTankHandler.tick(objects);
        //
        for (int i = 0; i < objects.getRobots().size(); i++)
        {
            objects.getRobots().get(i).tick(objects);
        }
    }

    public void collision()
    {
        for (int i = 0; i < objects.getTurrets().size(); i++)
        {
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getTurrets().get(i).getBounds()))
            {
                objects.getPlayers().get(0).setX( objects.getPlayers().get(0).getX() + (objects.getPlayers().get(0).getVelX() * (-1)) );
                objects.getPlayers().get(0).setY( objects.getPlayers().get(0).getY() + (objects.getPlayers().get(0).getVelY() * (-1)) );

            }
        }

        for (int i = 0; i < objects.getHardWall().size(); i++)
        {
            //System.out.println("in for before if");
            if (objects.getPlayers().get(0).getBounds().intersects(objects.getHardWall().get(i).getBounds()))
            {
                System.out.println("in if");
                objects.getPlayers().get(0).setX( objects.getPlayers().get(0).getX() + (objects.getPlayers().get(0).getVelX() * (-1)) );
                objects.getPlayers().get(0).setY( objects.getPlayers().get(0).getY() + (objects.getPlayers().get(0).getVelY() * (-1)) );

            }
        }

        //and other arrayLists
    }

    public void findBodyAngle()
    {
        //TODO: find angle from wasd
		/*
		one is for right
		two is for up
		three is for left
		four is for down
		 */
		/*int isPressed;
		if (keyDOWN)
		{
			isPressed = 4;
		}
		else if (keyLEFT)
		{
			isPressed = 3;
		}
		else if (keyRIGHT)
		{
			isPressed = 1;
		}
		else if (keyUP)
		{
			isPressed = 2;
		}
		else
		{
			bodyAngle = 0;
			return;
		}

		switch ( (isPressed - lastKey) % 2)
		{
			case 0:
				bodyAngle = 0;
				break;
			case 1:
				if (isPressed > lastKey)
				{
					bodyAngle = Math.PI / 2;
				}
				else
				{
					bodyAngle = (3 / 2) * Math.PI;
				}
				break;
		}*/
		/*if (keyDOWN)
		{
			switch (lastKey)
			{
				case 1:
					bodyAngle = (3 / 2) * Math.PI;
					break;
				case 2:
					bodyAngle = 0;
					break;
				case 3:
					bodyAngle = Math.PI / 2;
					break;
				case 4:
					bodyAngle = 0;
					break;
			}
		}
		else if (keyLEFT)
		{
			switch (lastKey)
			{
				case 1:
					bodyAngle = 0;
					break;
				case 2:
					bodyAngle = Math.PI / 2;
					break;
				case 3:
					bodyAngle = 0;
					break;
				case 4:
					bodyAngle = (3 / 2) * Math.PI;
					break;
			}
		}
		else if (keyRIGHT)
		{
			switch (lastKey)
			{
				case 1:
					bodyAngle = 0;
					break;
				case 2:
					bodyAngle = (3 / 2) * Math.PI;
					break;
				case 3:
					bodyAngle = 0;
					break;
				case 4:
					bodyAngle = Math.PI / 2;
					break;
			}
		}
		else if (keyUP)
		{
			switch (lastKey)
			{
				case 1:
					bodyAngle = Math.PI / 2;
					break;
				case 2:
					bodyAngle = 0;
					break;
				case 3:
					bodyAngle = (3 / 2) * Math.PI;
					break;
				case 4:
					bodyAngle = 0;
					break;
			}
		}
		else
		{
			bodyAngle = 0;
			return;
		}*/
        if (keyDOWN)
        {
            bodyAngle = -Math.PI / 2;
        }
        else if (keyLEFT)
        {
            bodyAngle = 0;
        }
        else if (keyRIGHT)
        {
            bodyAngle = 0;
        }
        else if (keyUP)
        {
            bodyAngle = Math.PI / 2;
        }
        else
        {
            bodyAngle = 0;
            return;
        }

    }

    /**
     * @return x of the mouse
     */
    public double getMouseX()
    {
        return mouseX;
    }

    /**
     * @return y of the mouse
     */
    public double getMouseY()
    {
        return mouseY;
    }

    public double getBodyAngle()
    {
        return bodyAngle;
    }

    /**
     * The mouse and key handler.
     */
    public KeyListener getKeyListener()
    {
        return keyHandler;
    }

    public MouseListener getMouseListener()
    {
        return mouseHandler;
    }

    public MouseMotionListener getMouseMotionListener()
    {
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
    class KeyHandler implements KeyListener
    {


        @Override
        public void keyTyped(KeyEvent e)
        {
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
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
            findBodyAngle();
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_W:
                    keyUP = false;
                    lastKey = 2;
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = false;
                    lastKey = 4;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = false;
                    lastKey = 3;
                    break;
                case KeyEvent.VK_D:
                    keyRIGHT = false;
                    lastKey = 1;
                    break;
            }

        }

    }

    class MouseHandler implements MouseListener, MouseMotionListener
    {


        @Override
        public void mouseClicked(MouseEvent e)
        {
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            if (e.getButton() == MouseEvent.BUTTON1)
            { // when pressing LEFT CLICK it shoots
                mouseX = e.getX();
                mouseY = e.getY();
                shoot = true;
            }

        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            shoot = false;
            if (e.getButton() == MouseEvent.BUTTON3)
            { // when pressing RIGHT CLICK it swaps tank gun
                swap = true;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            // maybe user clicks and drags so it must be updated without clicking again.
            mouseX = e.getX();
            mouseY = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e)
        {
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }
}

