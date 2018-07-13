package game.savingElements;

import game.elements.*;

import java.io.*;
import java.util.ArrayList;

public class DataSaver implements Serializable {

    //fields


    public DataSaver(Objects objects){

        SavingData data = new SavingData();

        data.setPlayers(objects.getPlayers());
        data.setBullets(objects.getBullets());
        data.setRobots(objects.getRobots());
        data.setTanks(objects.getTanks());
        data.setUpgrades(objects.getUpgrades());
        data.setTurrets(objects.getTurrets());

        writeFile(data);
    }

    private void writeFile(SavingData data){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("/save.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
