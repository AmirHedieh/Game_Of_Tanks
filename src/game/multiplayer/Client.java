package game.multiplayer;

import game.elements.ObjectId;
import game.elements.Objects;
import game.template.bufferstrategy.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    //fields
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client() {
        try {
            socket = new Socket("192.168.1.8",6666);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Couldn't connect to server");
        }
    }

    public void receiveData(Objects objects){
        try {
            TransferingData updatedObjects = (TransferingData) ois.readObject();
            System.out.println(updatedObjects.getPlayers().get(0).getVelX());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("couldn't read objects");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found while reading!");
        }
    }

}
