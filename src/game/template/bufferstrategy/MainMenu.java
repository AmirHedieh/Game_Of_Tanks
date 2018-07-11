package game.template.bufferstrategy;

import game.Utils.SharedData;
import game.Utils.Sound;
import game.Utils.Utility;
import game.elements.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MainMenu extends JFrame
{
    private JFrame gameFrame;
    private JPanel mainPanel;
    private JButton singlePlayerGameButton;
    private JButton multiPlayerButton;
    private JButton settingButton;
    private JButton aboutButton;
    private JButton exitButton;

    private JOptionPane multiplayerOptionPane;

    private Sound backgroundSound;

    int output;

    public MainMenu()
    {
        super("Normal Tanks");
        setSize(1120, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.BLACK);
        setContentPane(mainPanel);

        singlePlayerGameButton = new JButton("Play Game");
        singlePlayerGameButton.setSize(150, 30);
        singlePlayerGameButton.setBackground(Color.BLACK);
        singlePlayerGameButton.setForeground(Color.WHITE);
        singlePlayerGameButton.setLocation(50, 300);
        singlePlayerGameButton.setFocusable(false);
        singlePlayerGameButton.setOpaque(true);
        singlePlayerGameButton.setBorder(BorderFactory.createEmptyBorder());
        singlePlayerGameButton.setFont(new Font("Arial", Font.BOLD, 20));
        singlePlayerGameButton.addActionListener(new ActionHandler());

        multiPlayerButton = new JButton("MultiPlayer");
        multiPlayerButton.setSize(150, 30);
        multiPlayerButton.setBackground(Color.BLACK);
        multiPlayerButton.setForeground(Color.WHITE);
        multiPlayerButton.setLocation(50, 350);
        multiPlayerButton.setFocusable(false);
        multiPlayerButton.setOpaque(true);
        multiPlayerButton.setBorder(BorderFactory.createEmptyBorder());
        multiPlayerButton.setFont(new Font("Arial", Font.BOLD, 20));
        multiPlayerButton.addActionListener(new ActionHandler());

        settingButton = new JButton("Setting");
        settingButton.setSize(150, 30);
        settingButton.setBackground(Color.BLACK);
        settingButton.setForeground(Color.WHITE);
        settingButton.setLocation(50, 400);
        settingButton.setFocusable(false);
        settingButton.setOpaque(true);
        settingButton.setBorder(BorderFactory.createEmptyBorder());
        settingButton.setFont(new Font("Arial", Font.BOLD, 20));
        settingButton.addActionListener(new ActionHandler());

        aboutButton = new JButton("About");
        aboutButton.setSize(150, 30);
        aboutButton.setBackground(Color.BLACK);
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setLocation(50, 450);
        aboutButton.setFocusable(false);
        aboutButton.setOpaque(true);
        aboutButton.setBorder(BorderFactory.createEmptyBorder());
        aboutButton.setFont(new Font("Arial", Font.BOLD, 20));
        aboutButton.addActionListener(new ActionHandler());

        exitButton = new JButton("Exit");
        exitButton.setSize(150, 30);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setLocation(50, 500);
        exitButton.setFocusable(false);
        exitButton.setOpaque(true);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.addActionListener(new ActionHandler());

        mainPanel.add(singlePlayerGameButton);
        mainPanel.add(multiPlayerButton);
        mainPanel.add(settingButton);
        mainPanel.add(aboutButton);
        mainPanel.add(exitButton);

        JLabel startupLabel = new JLabel(new ImageIcon(String.valueOf(new File("src/resource/startup.png"))));
        startupLabel.setSize(1120, 700);
        mainPanel.add(startupLabel);

        repaint();

        backgroundSound = new Sound(Utility.backgroundSound, true);
        backgroundSound.playSound();



        //multiplayerOptionPane = new
        Object[] options = {"Host", "Client"};
       // int n = JOptionPane.showOptionDialog(this, "Play as: ", "MultiPlayer", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        setVisible(true);

    }

    public class ActionHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource().equals(singlePlayerGameButton))
            {
                System.out.println("singlePlayerGameButton");
                output = 10;
            }
            if (e.getSource().equals(multiPlayerButton))
            {
                System.out.println("multiPlayerButton");
            }
            if (e.getSource().equals(settingButton))
            {
                System.out.println("settingButton");
            }
            if (e.getSource().equals(aboutButton))
            {
                System.out.println("aboutButton");
            }
            if (e.getSource().equals(exitButton))
            {
                System.out.println("exitButton");
            }
        }
    }

    public class FocusHandler implements FocusListener
    {
        @Override
        public void focusGained(FocusEvent e)
        {
            //if (((JButton)e.getSource().)
        }

        @Override
        public void focusLost(FocusEvent e)
        {

        }
    }


}