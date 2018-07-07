package game.multiplayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            System.out.println("Connection established!");
        } catch (IOException e) {
            System.out.println("Couldn't create server socket");
        }
    }


}

