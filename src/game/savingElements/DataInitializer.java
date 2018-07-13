package game.savingElements;

import game.elements.Objects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataInitializer {

    public DataInitializer(Objects objects){
        readFile(objects);
    }

    private void readFile(Objects objects){
        ObjectInputStream ois = null;
        try {
            FileInputStream streamIn = new FileInputStream("E:\\save.ser");
            ois = new ObjectInputStream(streamIn);
            SavingData data = (SavingData)ois.readObject();
            initializeObjects(objects,data);
        } catch (Exception e) {
            e.printStackTrace();
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
