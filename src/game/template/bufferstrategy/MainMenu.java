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

    private Sound backgroundSound;

    int output;
    String ip = "";

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
        menuFrame.setSize(1120, 700);
        menuFrame.setUndecorated(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.BLACK);

        menuFrame.setContentPane(mainPanel);

        singlePlayerGameButton = new JButton("Play Game");
        singlePlayerGameButton.setSize(150, 50);
        singlePlayerGameButton.setBackground(Color.BLACK);
        singlePlayerGameButton.setForeground(Color.WHITE);
        singlePlayerGameButton.setLocation(70, 320);
        singlePlayerGameButton.setFocusable(false);
        singlePlayerGameButton.setOpaque(true);
        singlePlayerGameButton.setBorder(BorderFactory.createEmptyBorder());
        singlePlayerGameButton.setFont(new Font("Titillium Web", 4, 20));
        singlePlayerGameButton.addActionListener(new ActionHandler());

        multiPlayerButton = new JButton("MultiPlayer");
        multiPlayerButton.setSize(150, 50);
        multiPlayerButton.setBackground(Color.BLACK);
        multiPlayerButton.setForeground(Color.WHITE);
        multiPlayerButton.setLocation(70, 390);
        multiPlayerButton.setFocusable(false);
        multiPlayerButton.setOpaque(true);
        multiPlayerButton.setBorder(BorderFactory.createEmptyBorder());
        multiPlayerButton.setFont(new Font("Titillium Web", 4, 20));
        multiPlayerButton.addActionListener(new ActionHandler());

        settingButton = new JButton("Setting");
        settingButton.setSize(150, 50);
        settingButton.setBackground(Color.BLACK);
        settingButton.setForeground(Color.WHITE);
        settingButton.setLocation(70, 460);
        settingButton.setFocusable(false);
        settingButton.setOpaque(true);
        settingButton.setBorder(BorderFactory.createEmptyBorder());
        settingButton.setFont(new Font("Titillium Web", 4, 20));
        settingButton.addActionListener(new ActionHandler());

        aboutButton = new JButton("About");
        aboutButton.setSize(150, 50);
        aboutButton.setBackground(Color.BLACK);
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setLocation(70, 520);
        aboutButton.setFocusable(false);
        aboutButton.setOpaque(true);
        aboutButton.setBorder(BorderFactory.createEmptyBorder());
        aboutButton.setFont(new Font("Titillium Web", 4, 20));
        aboutButton.addActionListener(new ActionHandler());

        exitButton = new JButton("Exit");
        exitButton.setSize(150, 50);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setLocation(70, 590);
        exitButton.setFocusable(false);
        exitButton.setOpaque(true);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFont(new Font("Titillium Web", 4, 20));
        exitButton.addActionListener(new ActionHandler());

        mainPanel.add(singlePlayerGameButton);
        mainPanel.add(multiPlayerButton);
        mainPanel.add(settingButton);
        mainPanel.add(aboutButton);
        mainPanel.add(exitButton);

        JLabel startupLabel = new JLabel(Utility.startup);
        startupLabel.setSize(1120, 700);
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
                new Game(output, ip);
            }
            if (e.getSource().equals(multiPlayerButton))
            {
                System.out.println("multiPlayerButton");
                new MultiPlayerFrame();
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
                System.exit(10);
            }
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
                multiFrame.setVisible(false);
                new Game(output, ip);
            }
            if (clientButton.isSelected())
            {
                System.out.println("clientButton");

                ipTextLabel.setText("Enter your IP: ");

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

    public class MultiPlayerFrame
    {
        public MultiPlayerFrame()
        {
            multiFrame = new JFrame("MultiPlayer Configuration");
            multiFrame.setSize(550, 230);
            multiFrame.setLocationRelativeTo(null);
            multiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            multiFrame.setUndecorated(true);

            multiPlayerPanel = new JPanel(new GridLayout(4, 1, 5, 5));
            multiPlayerPanel.setBackground(Color.BLACK);
            multiPlayerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            multiPlayerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE.brighter(), Color.WHITE, Color.WHITE.darker()));
            multiFrame.setContentPane(multiPlayerPanel);

            playAs = new JLabel("You want to play as: ", JLabel.CENTER);
            playAs.setFont(new Font("Titillium Web", 4, 20));
            playAs.setForeground(Color.WHITE);
            playAs.setBackground(Color.BLACK);
            multiPlayerPanel.add(playAs);

            clientServerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
            clientServerPanel.setBackground(Color.BLACK);
            clientServerPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 10));

            clientButton.setText("Client");
            clientButton.setFont(new Font("Titillium Web", 4, 20));
            clientButton.setForeground(Color.WHITE);
            clientButton.setBackground(Color.BLACK);
            clientButton.setFocusable(false);
            clientButton.addActionListener(new ActionHandler());

            serverButton.setText("Server");
            serverButton.setFont(new Font("Titillium Web", 4, 20));
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
            IPTextField.setFont(new Font("Titillium Web", 4, 20));

            ipTextLabel = new JLabel("", JLabel.CENTER);
            ipTextLabel.setFont(new Font("Titillium Web", 4, 20));
            ipTextLabel.setForeground(Color.WHITE);
            ipTextLabel.setBackground(Color.BLACK);

            ipPanel.add(ipTextLabel, BorderLayout.WEST);
            ipPanel.add(IPTextField, BorderLayout.CENTER);
            multiPlayerPanel.add(ipPanel);

            startButton = new JButton("Start");
            startButton.setFont(new Font("Titillium Web", 4, 20));
            startButton.setForeground(Color.WHITE);
            startButton.setBackground(Color.BLACK);
            startButton.setFocusable(false);
            startButton.addActionListener(new ActionHandler());
            multiPlayerPanel.add(startButton);


            multiFrame.validate();
            multiFrame.repaint();
            multiFrame.setVisible(true);
        }
    }
}