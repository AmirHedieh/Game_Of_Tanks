/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.Utils.SharedData;
import game.Utils.Sound;
import game.Utils.Utility;
import game.elements.*;
import game.map.Camera;

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

    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    public Camera camera;

    public GameState()
    {
//        Sound sound = new Sound(Utility.backgroundSound, true);
//        sound.playSound();
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
        aiTankHandler = new AITankHandler(objects);
        //
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
//        camera = new Camera(803, 5450);
        camera = new Camera(0, 0);
    }

    /**
     * The method which updates the game state.
     */
    public void update()
    {
        //Update the state of all game elements
        //based on user input and elapsed time ...
        //first element( objects.getPlayers().get(0) ) in arrayList is player's tank.
        if (keyUP)
        {
            if (!Physics.checkHardWallsCollisionUp(objects)) {
                    objects.getPlayers().get(0).setY(objects.getPlayers().get(0).getY() - objects.getPlayers().get(0).getVelY());
                    objects.getPlayers().get(0).getSelectedGun().setY(objects.getPlayers().get(0).getSelectedGun().getY() - objects.getPlayers().get(0).getVelY());
            }
            Physics.checkMapBounds(objects.getPlayers().get(0));
        }
        if (keyDOWN)
        {
            if (!Physics.checkHardWallsCollisionDown(objects)) {
                    objects.getPlayers().get(0).setY(objects.getPlayers().get(0).getY() + objects.getPlayers().get(0).getVelY());
                    objects.getPlayers().get(0).getSelectedGun().setY(objects.getPlayers().get(0).getSelectedGun().getY() + objects.getPlayers().get(0).getVelY());
            }
            Physics.checkMapBounds(objects.getPlayers().get(0));
        }
        if (keyLEFT)
        {
            if (!Physics.checkHardWallsCollisionLeft(objects)) {
                    objects.getPlayers().get(0).setX(objects.getPlayers().get(0).getX() - objects.getPlayers().get(0).getVelX());
                    objects.getPlayers().get(0).getSelectedGun().setX(objects.getPlayers().get(0).getSelectedGun().getX() - objects.getPlayers().get(0).getVelX());
            }
            Physics.checkMapBounds(objects.getPlayers().get(0));
        }
        if (keyRIGHT)
        {
            if (!Physics.checkHardWallsCollisionRight(objects)) {
                    objects.getPlayers().get(0).setX(objects.getPlayers().get(0).getX() + objects.getPlayers().get(0).getVelX());
                    objects.getPlayers().get(0).getSelectedGun().setX(objects.getPlayers().get(0).getSelectedGun().getX() + objects.getPlayers().get(0).getVelX());
            }
            Physics.checkMapBounds(objects.getPlayers().get(0));
        }
        //

        if (shoot)
        {
            if (objects.getPlayers().get(0).getSelectedGun().readyForShoot())
            {
                objects.addBullet(objects.getPlayers().get(0).getSelectedGun().shoot(objects.getPlayers().get(0).getX(), objects.getPlayers().get(0).getY(), mouseX, mouseY)); //tank's gun shoots a bullet. bullet is added to bullets arrayList
                if(objects.getPlayers().get(0).getSelectedGun() instanceof MissileGun) {
                    Sound sound = new Sound(Utility.heavyShotSound, false);
                    sound.playSound();
                }
                else if(objects.getPlayers().get(0).getSelectedGun() instanceof MachineGun){
                    Sound sound = new Sound(Utility.lightShotSound, false);
                    sound.playSound();
                }

                if(SharedData.getData().playerType.equals(ObjectId.ClientPlayer)){
                    SharedData.getData().clientShot = true;
                    SharedData.getData().clientLastShotBullet = objects.getBullets().get(objects.getBullets().size() - 1); //save last bullet to pass it to server
                }
            }
        }
        //
        if (swap)
        {
            objects.getPlayers().get(0).swapGun();
            swap = false;
        }
//        Physics.checkBulletsCollision(objects);
        //things that client side must not do
        if(SharedData.getData().gameType.equals(ObjectId.SinglePlayer) || SharedData.getData().playerType.equals(ObjectId.ServerPlayer)) {
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
            for (int i = 0; i < objects.getRobots().size(); i++)
            {
                objects.getRobots().get(i).tick(objects);
            }
            //1

            aiTankHandler.tick();
            //
        }
        objects.getPlayers().get(0).rotate(keyUP,keyDOWN,keyRIGHT,keyLEFT);
        //
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

    public boolean isKeyUP()
    {
        return keyUP;
    }

    public void setKeyUP(boolean keyUP)
    {
        this.keyUP = keyUP;
    }

    public boolean isKeyDOWN()
    {
        return keyDOWN;
    }

    public void setKeyDOWN(boolean keyDOWN)
    {
        this.keyDOWN = keyDOWN;
    }

    public boolean isKeyRIGHT()
    {
        return keyRIGHT;
    }

    public void setKeyRIGHT(boolean keyRIGHT)
    {
        this.keyRIGHT = keyRIGHT;
    }

    public boolean isKeyLEFT()
    {
        return keyLEFT;
    }

    public void setKeyLEFT(boolean keyLEFT)
    {
        this.keyLEFT = keyLEFT;
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
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
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
            {
                // when pressing LEFT CLICK it shoots
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
            {
                // when pressing RIGHT CLICK it swaps tank gun
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

