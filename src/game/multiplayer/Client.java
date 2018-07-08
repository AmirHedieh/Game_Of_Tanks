package game.multiplayer;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.43.92",6666);
        } catch (IOException e) {
            System.out.println("Couldn't connect to server");
        }
    }
}
