package game.savingElements;

import game.elements.Objects;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * initialize game objects if there is any save from before.
 * it reads save and init objects
 */
public class DataInitializer {

    public DataInitializer(Objects objects){
        readFile(objects);
    }

    /**
     * reads save file and calls a method to initialize game objects.
     * @param objects objects of the game
     */
    private void readFile(Objects objects){
        ObjectInputStream ois = null;
        FileInputStream streamIn = null;
        try {
           streamIn = new FileInputStream("res/save.ser");
        }catch (IOException e) {
            JFrame frame = new JFrame("NO SAVE FOUND");
            frame.setSize(500,200);
//            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            JLabel label = new JLabel("                                  There is no save to continue so new game created");
//            label.setLocation(0,250);
            frame.add(label);
            frame.setVisible(true);
        }
        try{
            ois = new ObjectInputStream(streamIn);
            SavingData data = (SavingData)ois.readObject();
            initializeObjects(objects,data);
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * initialize game objects using data that was read from save file
     * @param objects objects of the game
     * @param data data read from save file
     */
    private void initializeObjects(Objects objects,SavingData data){
        objects.setPlayers(data.getPlayers());
        objects.setUpgrades(data.getUpgrades());
        objects.setTurrets(data.getTurrets());
        objects.setRobots(data.getRobots());
        objects.setBullets(data.getBullets());
        objects.setTanks(data.getTanks());
    }
}
