package game.template.bufferstrategy;

import game.Utils.Sound;
import game.Utils.Utility;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;

public class MainMenu
{
    private JFrame menuFrame;
    private JPanel mainPanel;
    private JButton singlePlayerGameButton;
    private JButton multiPlayerButton;
    private JButton settingButton;
    private JButton aboutButton;
    private JButton exitButton;


    private JFrame multiFrame;
    private JPanel multiPlayerPanel;
    private JLabel playAs;
    private JPanel clientServerPanel;
    private JRadioButton clientButton = new JRadioButton();
    private JRadioButton serverButton = new JRadioButton();
    private JPanel ipPanel;
    private JLabel ipTextLabel;
    private JTextField IPTextField;
    private JButton startButton;

    private JFrame settingFrame;
    private JPanel settingPanel;
    private JPanel centerPanel;
    private JPanel difficultyPanel;
    private JLabel difficultyLabel;
    private JPanel difficultyButtonsPanel;
    private JRadioButton hardGame = new JRadioButton();
    private JRadioButton mediumGame = new JRadioButton();
    private JRadioButton easyGame = new JRadioButton();
    private JPanel mapPanel;
    private JLabel mapLabel;
    private JPanel mapButtonsPanel;
    private JRadioButton firstMap = new JRadioButton();
    private JRadioButton secondMap = new JRadioButton();
    private JRadioButton thirdMap = new JRadioButton();
    private JRadioButton fourthMap = new JRadioButton();
    private JPanel downButtonsPanel;
    private JButton confirm;
    private JButton cancel;


    private Sound backgroundSound;

    private int output;
    private String ip = "";
    private int difficulty = 1;
    private int whichMap = 1;

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        new MainMenu();
    }

    public MainMenu()
    {
        menuFrame = new JFrame("Normal Tanks");
        menuFrame.setSize(1920, 1080);
        menuFrame.setUndecorated(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setExtendedState(menuFrame.MAXIMIZED_BOTH);

        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.BLACK);

        menuFrame.setContentPane(mainPanel);

        singlePlayerGameButton = new JButton("Play Game");
        singlePlayerGameButton.setSize(275, 70);
        singlePlayerGameButton.setBackground(Color.BLACK);
        singlePlayerGameButton.setForeground(Color.WHITE);
        singlePlayerGameButton.setLocation(-10, 320);
        singlePlayerGameButton.setFocusable(false);
        singlePlayerGameButton.setOpaque(true);
        singlePlayerGameButton.setBorder(BorderFactory.createEmptyBorder());
        singlePlayerGameButton.setFont(new Font("Titillium Web", 4, 30));
        singlePlayerGameButton.addActionListener(new ActionHandler());

        multiPlayerButton = new JButton("MultiPlayer");
        multiPlayerButton.setSize(275, 70);
        multiPlayerButton.setBackground(Color.BLACK);
        multiPlayerButton.setForeground(Color.WHITE);
        multiPlayerButton.setLocation(-10, 410);
        multiPlayerButton.setFocusable(false);
        multiPlayerButton.setOpaque(true);
        multiPlayerButton.setBorder(BorderFactory.createEmptyBorder());
        multiPlayerButton.setFont(new Font("Titillium Web", 4, 30));
        multiPlayerButton.addActionListener(new ActionHandler());

        settingButton = new JButton("Setting");
        settingButton.setSize(275, 70);
        settingButton.setBackground(Color.BLACK);
        settingButton.setForeground(Color.WHITE);
        settingButton.setLocation(-10, 500);
        settingButton.setFocusable(false);
        settingButton.setOpaque(true);
        settingButton.setBorder(BorderFactory.createEmptyBorder());
        settingButton.setFont(new Font("Titillium Web", 4, 30));
        settingButton.addActionListener(new ActionHandler());

        aboutButton = new JButton("About");
        aboutButton.setSize(275, 70);
        aboutButton.setBackground(Color.BLACK);
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setLocation(-10, 590);
        aboutButton.setFocusable(false);
        aboutButton.setOpaque(true);
        aboutButton.setBorder(BorderFactory.createEmptyBorder());
        aboutButton.setFont(new Font("Titillium Web", 4, 30));
        aboutButton.addActionListener(new ActionHandler());

        exitButton = new JButton("Exit");
        exitButton.setSize(275, 70);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setLocation(-10, 680);
        exitButton.setFocusable(false);
        exitButton.setOpaque(true);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFont(new Font("Titillium Web", 4, 30));
        exitButton.addActionListener(new ActionHandler());

        mainPanel.add(singlePlayerGameButton);
        mainPanel.add(multiPlayerButton);
        mainPanel.add(settingButton);
        mainPanel.add(aboutButton);
        mainPanel.add(exitButton);

        Dimension dimension = new Dimension();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel startupLabel = null;
        if (dimension.width >= 3840)
        {
            startupLabel = new JLabel(Utility.mainMenuBackGroundBig);
        }
        else
        {
            startupLabel = new JLabel(Utility.mainMenuBackGroundMedium);
        }
        startupLabel.setSize(dimension.width, dimension.height);
        mainPanel.add(startupLabel);

        backgroundSound = new Sound(Utility.backgroundSound, true);
        //backgroundSound.playSound();

        menuFrame.revalidate();
        menuFrame.repaint();
        menuFrame.setVisible(true);

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
                menuFrame.setVisible(false);
                new Game(output, ip, difficulty, whichMap);
            }
            if (e.getSource().equals(multiPlayerButton))
            {
                System.out.println("multiPlayerButton");
                new MultiPlayerFrame();
            }
            if (e.getSource().equals(settingButton))
            {
                System.out.println("settingButton");
                new Settings();
            }
            if (e.getSource().equals(aboutButton))
            {
                System.out.println("aboutButton");
            }
            if (e.getSource().equals(exitButton))
            {
                System.out.println("exitButton");
                System.exit(10);
            }

            //multiPlayer
            if (e.getSource().equals(startButton))
            {
                System.out.println("startButton");
                if (clientButton.isSelected())
                {
                    output = 21;
                    ip = IPTextField.getText();
                }
                else if (serverButton.isSelected())
                {
                    output = 22;
                    ip = IPTextField.getText();
                }
                menuFrame.setVisible(false);
                multiFrame.dispose();
                new Game(output, ip, difficulty, whichMap);
            }
            if (clientButton.isSelected())
            {
                System.out.println("clientButton");

                ipTextLabel.setText("Enter Host IP: ");

                IPTextField.setText("");

                multiFrame.revalidate();
                multiFrame.repaint();
                multiFrame.setVisible(true);
            }
            if (serverButton.isSelected())
            {
                System.out.println("serverButton");

                ipTextLabel.setText("Your IP is: ");
                try
                {
                    InetAddress IP = InetAddress.getLocalHost();
                    IPTextField.setText(IP.getHostAddress());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                multiFrame.revalidate();
                multiFrame.repaint();
                multiFrame.setVisible(true);
            }


            //setting
            if (e.getSource().equals(cancel))
            {
                System.out.println("cancel");
                settingFrame.dispose();
            }
            if (e.getSource().equals(confirm))
            {
                System.out.println("confirm");
                //difficulty
                if (hardGame.isSelected())
                {
                    System.out.println("hardGame");
                    difficulty = 3;
                }
                if (mediumGame.isSelected())
                {
                    System.out.println("mediumGame");
                    difficulty = 2;
                }
                if (easyGame.isSelected())
                {
                    System.out.println("easyGame");
                    difficulty = 1;
                }
                //maps
                if (firstMap.isSelected())
                {
                    System.out.println("firstMap");
                    whichMap = 1;
                }
                if (secondMap.isSelected())
                {
                    System.out.println("secondMap");
                    whichMap = 2;
                }
                if (thirdMap.isSelected())
                {
                    System.out.println("thirdMap");
                    whichMap = 3;
                }
                if (fourthMap.isSelected())
                {
                    System.out.println("fourthMap");
                    whichMap = 4;
                }
                settingFrame.setVisible(false);
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

    private class MultiPlayerFrame
    {
        public MultiPlayerFrame()
        {
            multiFrame = new JFrame("MultiPlayer Configuration");
            multiFrame.setSize(650, 300);
            multiFrame.setLocationRelativeTo(null);
            multiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            multiFrame.setUndecorated(true);

            multiPlayerPanel = new JPanel(new GridLayout(4, 1, 5, 5));
            multiPlayerPanel.setBackground(Color.BLACK);
            multiPlayerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            multiPlayerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE.brighter(), Color.WHITE, Color.WHITE.darker()));
            multiFrame.setContentPane(multiPlayerPanel);

            playAs = new JLabel("You want to play as: ", JLabel.CENTER);
            playAs.setFont(new Font("Titillium Web", 4, 30));
            playAs.setForeground(Color.WHITE);
            playAs.setBackground(Color.BLACK);
            multiPlayerPanel.add(playAs);

            clientServerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
            clientServerPanel.setBackground(Color.BLACK);
            clientServerPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 10));

            clientButton.setText("Client");
            clientButton.setFont(new Font("Titillium Web", 4, 30));
            clientButton.setForeground(Color.WHITE);
            clientButton.setBackground(Color.BLACK);
            clientButton.setFocusable(false);
            clientButton.addActionListener(new ActionHandler());

            serverButton.setText("Server");
            serverButton.setFont(new Font("Titillium Web", 4, 30));
            serverButton.setForeground(Color.WHITE);
            serverButton.setBackground(Color.BLACK);
            serverButton.setFocusable(false);
            serverButton.addActionListener(new ActionHandler());

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(clientButton);
            buttonGroup.add(serverButton);

            clientServerPanel.add(clientButton);
            clientServerPanel.add(serverButton);
            multiPlayerPanel.add(clientServerPanel);

            ipPanel = new JPanel(new BorderLayout(20, 50));
            ipPanel.setBackground(Color.BLACK);
            ipPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 80));

            IPTextField = new JTextField();
            IPTextField.setFont(new Font("Titillium Web", 4, 30));

            ipTextLabel = new JLabel("", JLabel.CENTER);
            ipTextLabel.setFont(new Font("Titillium Web", 4, 30));
            ipTextLabel.setForeground(Color.WHITE);
            ipTextLabel.setBackground(Color.BLACK);

            ipPanel.add(ipTextLabel, BorderLayout.WEST);
            ipPanel.add(IPTextField, BorderLayout.CENTER);
            multiPlayerPanel.add(ipPanel);

            startButton = new JButton("Start");
            startButton.setFont(new Font("Titillium Web", 4, 30));
            startButton.setForeground(Color.WHITE);
            startButton.setBackground(Color.BLACK);
            startButton.setFocusable(false);
            startButton.addActionListener(new MainMenu.ActionHandler());
            multiPlayerPanel.add(startButton);


            multiFrame.validate();
            multiFrame.repaint();
            multiFrame.setVisible(true);
        }
    }

    private class Settings
    {
        public Settings()
        {
            settingFrame = new JFrame("Setting");
            settingFrame.setSize(650, 450);
            settingFrame.setLocationRelativeTo(null);
            settingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            settingFrame.setUndecorated(true);

            settingPanel = new JPanel(new BorderLayout(5, 5));
            settingPanel.setBackground(Color.BLACK);
            settingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            settingPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE.brighter(), Color.WHITE, Color.WHITE.darker()));
            settingFrame.setContentPane(settingPanel);


            centerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
            centerPanel.setBackground(Color.BLACK);
            centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


            difficultyPanel = new JPanel(new BorderLayout(5, 5));

            difficultyLabel = new JLabel("Difficulty: ", JLabel.CENTER);
            difficultyLabel.setFont(new Font("Titillium Web", 4, 30));
            difficultyLabel.setBackground(Color.WHITE);
            difficultyLabel.setForeground(Color.BLACK);

            difficultyButtonsPanel = new JPanel(new GridLayout(1, 3, 5, 5));
            difficultyButtonsPanel.setBackground(Color.BLACK);
            difficultyButtonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));

            hardGame.setText("Hard");
            hardGame.setFont(new Font("Titillium Web", 4, 30));
            hardGame.setForeground(Color.WHITE);
            hardGame.setBackground(Color.BLACK);
            hardGame.setFocusable(false);
            hardGame.addActionListener(new ActionHandler());

            mediumGame.setText("Medium");
            mediumGame.setFont(new Font("Titillium Web", 4, 30));
            mediumGame.setForeground(Color.WHITE);
            mediumGame.setBackground(Color.BLACK);
            mediumGame.setFocusable(false);
            mediumGame.addActionListener(new ActionHandler());

            easyGame.setText("Easy");
            easyGame.setFont(new Font("Titillium Web", 4, 30));
            easyGame.setForeground(Color.WHITE);
            easyGame.setBackground(Color.BLACK);
            easyGame.setFocusable(false);
            easyGame.addActionListener(new ActionHandler());
            easyGame.setSelected(true);

            ButtonGroup difficultyGroup = new ButtonGroup();
            difficultyGroup.add(easyGame);
            difficultyGroup.add(mediumGame);
            difficultyGroup.add(hardGame);

            difficultyPanel.add(difficultyLabel, BorderLayout.NORTH);
            difficultyButtonsPanel.add(easyGame);
            difficultyButtonsPanel.add(mediumGame);
            difficultyButtonsPanel.add(hardGame);
            difficultyPanel.add(difficultyButtonsPanel, BorderLayout.CENTER);
            centerPanel.add(difficultyPanel);


            mapPanel = new JPanel(new BorderLayout(5, 5));

            mapLabel = new JLabel("Select your Map: ", JLabel.CENTER);
            mapLabel.setFont(new Font("Titillium Web", 4, 30));
            mapLabel.setBackground(Color.WHITE);
            mapLabel.setForeground(Color.BLACK);

            mapButtonsPanel = new JPanel(new GridLayout(1, 4, 5, 5));
            mapButtonsPanel.setBackground(Color.BLACK);
            mapButtonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 45, 10, 10));

            firstMap.setText("First");
            firstMap.setFont(new Font("Titillium Web", 4, 30));
            firstMap.setForeground(Color.WHITE);
            firstMap.setBackground(Color.BLACK);
            firstMap.setFocusable(false);
            firstMap.addActionListener(new ActionHandler());
            firstMap.setSelected(true);

            secondMap.setText("Second");
            secondMap.setFont(new Font("Titillium Web", 4, 30));
            secondMap.setForeground(Color.WHITE);
            secondMap.setBackground(Color.BLACK);
            secondMap.setFocusable(false);
            secondMap.addActionListener(new ActionHandler());

            thirdMap.setText("Third");
            thirdMap.setFont(new Font("Titillium Web", 4, 30));
            thirdMap.setForeground(Color.WHITE);
            thirdMap.setBackground(Color.BLACK);
            thirdMap.setFocusable(false);
            thirdMap.addActionListener(new ActionHandler());

            fourthMap.setText("Fourth");
            fourthMap.setFont(new Font("Titillium Web", 4, 30));
            fourthMap.setForeground(Color.WHITE);
            fourthMap.setBackground(Color.BLACK);
            fourthMap.setFocusable(false);
            fourthMap.addActionListener(new ActionHandler());

            ButtonGroup mapGroup = new ButtonGroup();
            mapGroup.add(firstMap);
            mapGroup.add(secondMap);
            mapGroup.add(thirdMap);
            mapGroup.add(fourthMap);

            mapPanel.add(mapLabel, BorderLayout.NORTH);
            mapButtonsPanel.add(firstMap);
            mapButtonsPanel.add(secondMap);
            mapButtonsPanel.add(thirdMap);
            mapButtonsPanel.add(fourthMap);
            mapPanel.add(mapButtonsPanel, BorderLayout.CENTER);
            centerPanel.add(mapPanel);
            settingPanel.add(centerPanel, BorderLayout.CENTER);


            downButtonsPanel = new JPanel(new GridLayout(1, 2, 1, 1));

            confirm = new JButton("Confirm");
            confirm.setFont(new Font("Titillium Web", 4, 30));
            confirm.setForeground(Color.WHITE);
            confirm.setBackground(Color.BLACK);
            confirm.setFocusable(false);
            confirm.addActionListener(new MainMenu.ActionHandler());

            cancel = new JButton("Cancel");
            cancel.setFont(new Font("Titillium Web", 4, 30));
            cancel.setForeground(Color.WHITE);
            cancel.setBackground(Color.BLACK);
            cancel.setFocusable(false);
            cancel.addActionListener(new MainMenu.ActionHandler());

            downButtonsPanel.add(confirm);
            downButtonsPanel.add(cancel);
            settingPanel.add(downButtonsPanel, BorderLayout.SOUTH);


            settingFrame.validate();
            settingFrame.repaint();
            settingFrame.setVisible(true);
        }
    }
}