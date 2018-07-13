package game.savingElements;

import game.elements.Objects;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataInitializer {

    public DataInitializer(Objects objects){
        readFile(objects);
    }

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

    private void initializeObjects(Objects objects,SavingData data){
        objects.setPlayers(data.getPlayers());
        objects.setUpgrades(data.getUpgrades());
        objects.setTurrets(data.getTurrets());
        objects.setRobots(data.getRobots());
        objects.setBullets(data.getBullets());
        objects.setTanks(data.getTanks());
    }
}
