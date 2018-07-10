/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.Utils.Sound;
import game.Utils.Utility;
import game.elements.ObjectId;
import game.map.Camera;
import game.multiplayer.Client;
import game.multiplayer.Server;

import javax.rmi.CORBA.Util;

import java.util.Date;
import java.util.Scanner;

/**
 * A very simple structure for the main game loop.
 * THIS IS NOT PERFECT, but works for most situations.
 * Note that to make this work, none of the 2 methods
 * in the while loop (update() and render()) should be
 * long running! Both must execute very quickly, without
 * any waiting and blocking!
 * <p>
 * Detailed discussion on different game loop design
 * patterns is available in the following link:
 * http://gameprogrammingpatterns.com/game-loop.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameLoop implements Runnable
{

    /**
     * Frame Per Second.
     * Higher is better, but any value above 24 is fine.
     */
    public static final int FPS = 30;

    private GameFrame canvas;
    private GameState state;
    private Camera camera;
    private ObjectId gameType,playerType;
    private Server server;
    private long sentTime; // gap between sending 2 data to client
    private Client client;
    private Sound backGroundSound;

    public GameLoop(GameFrame frame)
    {
        canvas = frame;
    }

    /**
     * This must be called before the game loop starts.
     */
    public void init()
    {
        // Perform all initializations ...
        state = new GameState();
        //camera = new Camera(803, 5450);
        camera = new Camera(1000, 0);
        canvas.addKeyListener(state.getKeyListener());
        canvas.addMouseListener(state.getMouseListener());
        canvas.addMouseMotionListener(state.getMouseMotionListener());
        if(gameType.equals(ObjectId.TwoPlayer) && playerType.equals(ObjectId.ServerPlayer)){
            server = new Server();
            sentTime = new Date().getTime();
        }
        else if(gameType.equals(ObjectId.TwoPlayer) && playerType.equals(ObjectId.ClientPlayer)){
            client = new Client();
        }
        backGroundSound = new Sound(Utility.backgroundSound, true);
//        backGroundSound.playSound();
    }

    @Override
    public void run()
    {
        boolean gameOver = false;
        while (!gameOver)
        {
            try
            {
                long start = System.currentTimeMillis();
                //
                if(gameType.equals(ObjectId.SinglePlayer)) {
                    state.update();
                    canvas.render(state, camera);
                }
                else if(gameType.equals(ObjectId.TwoPlayer)){
                    if(playerType.equals(ObjectId.ServerPlayer)){
                        state.update();
                        canvas.render(state, camera);
                        server.sendData(state.objects);
                        long time = new Date().getTime();
                        if(time - sentTime > 150){

                            sentTime = time;
                        }
//                        server.receiveData();
//                        Scanner scanner = new Scanner(System.in);
                    }
                    else if(playerType.equals(ObjectId.ClientPlayer)){
                        client.receiveData(state.objects);
                        canvas.render(state, camera);
                    }
                }
                //
                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0)
                {
                    Thread.sleep(delay);
                }
            }
            catch (InterruptedException ex)
            {
            }
        }
    }

    public void setGameType(ObjectId id){
        gameType = id;
    }

    public void setPlayerType(ObjectId id){
        playerType = id;
    }
}
