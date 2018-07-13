/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import game.Utils.SharedData;
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
    private Server server;
    private long sentTime; // gap between sending 2 data to client
    private Client client;

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
        canvas.addKeyListener(state.getKeyListener());
        canvas.addMouseListener(state.getMouseListener());
        canvas.addMouseMotionListener(state.getMouseMotionListener());
        if (SharedData.getData().gameType.equals(ObjectId.TwoPlayer) && SharedData.getData().playerType.equals(ObjectId.ServerPlayer))
        {
            server = new Server(state.objects);
            sentTime = new Date().getTime();
        }
        else if (SharedData.getData().gameType.equals(ObjectId.TwoPlayer) && SharedData.getData().playerType.equals(ObjectId.ClientPlayer))
        {
            client = new Client(state.objects);
        }
    }

    @Override
    public void run()
    {
        while (!Utility.checkEnd(state.objects))
        {
            try
            {
                long start = System.currentTimeMillis();
                //
//                if(SharedData.getData().removePlayer) {
//                    Utility.removePlayer(state.objects,SharedData.getData().playerToRemove);
//                    if (state.objects.getPlayers().size() == 0) {
//                        System.out.println("DONE");
//                        while (true){
//                            System.out.println("here");
//                        }
//                    }
//                }
                if (SharedData.getData().gameType.equals(ObjectId.SinglePlayer))
                {
                    state.update();
                    canvas.render(state);
                }
                else if (SharedData.getData().gameType.equals(ObjectId.TwoPlayer))
                {
                    if (SharedData.getData().playerType.equals(ObjectId.ServerPlayer))
                    {
                        state.update();
                        canvas.render(state);
                        server.tick(state.objects);
//                        long time = new Date().getTime();
//                        if(time - sentTime > 0){
//                            sentTime = time;
//                        }
//                        if(SharedData.getData().clientSending){
//
//                        }
                    }
                    else if (SharedData.getData().playerType.equals(ObjectId.ClientPlayer))
                    {
                        client.tick();
                        state.update();
                        canvas.render(state);
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
        if(SharedData.getData().result.equals(ObjectId.Won)){
            Utility.showVictoryEnding();
        }
        else if(SharedData.getData().result.equals(ObjectId.Lost)){
            Utility.showDefeatedEnding();
        }
    }
}
