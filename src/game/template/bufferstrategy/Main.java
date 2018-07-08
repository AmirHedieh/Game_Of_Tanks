/*** In The Name of Allah ***/
package game.template.bufferstrategy;

import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;
import game.elements.Objects;

import java.awt.*;
import javax.swing.*;

/**
 * Program start.
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class Main
{
    /*  //Load Menu
                ImageIcon ImageBackGround = new ImageIcon("src/resource/Startup.png");
                JLabel startup = new JLabel(ImageBackGround);
                frame.add(startup);

                JButton onePlayer = new JButton("Play Game");
                onePlayer.setSize(100, 30);
                onePlayer.setFont(new Font(null, 20 ,20));
                onePlayer.setForeground(Color.WHITE);
                onePlayer.setLocation(100, 800);
                onePlayer.setOpaque(false);
                onePlayer.setContentAreaFilled(false);
                onePlayer.setBorderPainted(false);
                frame.add(onePlayer);

                JButton twoPlayer = new JButton("MultiPlayer");
                twoPlayer.setSize(100, 30);
                twoPlayer.setFont(new Font(null, 20 ,20));
                twoPlayer.setForeground(Color.WHITE);
                twoPlayer.setLocation(300, 800);
                twoPlayer.setOpaque(false);
                twoPlayer.setContentAreaFilled(false);
                twoPlayer.setBorderPainted(false);
                frame.add(twoPlayer);*/

    public static void main(String[] args)
    {
        // Initialize the global thread-pool
        ThreadPool.init();

        // After the player clicks 'PLAY' ...
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GameFrame frame = new GameFrame("Normal Tanks ( Beta )");
                frame.setLocationRelativeTo(null); // put frame at center of screen
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLayout(null);
                frame.initBufferStrategy();
                // Create and execute the game-loop
                GameLoop game = new GameLoop(frame);
                game.init();
                ThreadPool.execute(game);
                // and the game starts ...
            }
        });
    }
}
