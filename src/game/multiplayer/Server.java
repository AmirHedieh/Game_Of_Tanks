package game.multiplayer;

import game.elements.Objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //fields
    ServerSocket serverSocket;
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Objects objects;

    public Server(Objects objects){
        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("Server created");
            socket = serverSocket.accept();
            System.out.println("Connection established!");
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            this.objects = objects;
//            oos.writeObject();
        } catch (IOException e) {
            System.out.println("Couldn't create server socket");
        }
    }

    public  void sendData(){
        try {
            oos.writeObject(objects);
            oos.flush();
//            oos.close();
        } catch (IOException e) {
            System.out.println("Sending Failed!");
        }
    }

    public void receiveData(){

    }

}

