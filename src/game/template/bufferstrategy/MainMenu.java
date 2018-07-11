/*
package game.template.bufferstrategy;

import game.Utils.Sound;
import game.Utils.Utility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenu extends JPanel
{
    private BufferedImage background;
    public JButton singlePlayerGameBtn;
    public JButton multiPlayerBtn;
    public JButton settingBtn;
    public JButton aboutBtn;
    public JButton exitBtn;

    private Sound backgroundSound;

    MainMenu(JFrame frame)
    {
        setSize(1000, 700);
        setLayout(null);

        setButtons();

        background = Utility.loadImageIO("src/resource/Startup.png");
        backgroundSound = new Sound(Utility.backgroundSound, true);
        backgroundSound.playSound();

        frame.setContentPane(this);
    }



*
     * add buttons to panel!


    private void setButtons() {
        singlePlayerGameBtn = new JButton("playgame");
        multiPlayerBtn = new JButton("multiplayer");
        settingBtn = new JButton("setting");
        aboutBtn = new JButton("about");
        exitBtn = new JButton("exit");

        add(singlePlayerGameBtn);
        add(multiPlayerBtn);
        add(settingBtn);
        add(aboutBtn);
        add(exitBtn);
    }
}




  //Load Menu
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
                frame.add(twoPlayer);



//snake source code: http://it-tips.org/java-snake-open-source/


*/
