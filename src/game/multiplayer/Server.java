package game.multiplayer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import game.elements.Objects;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //fields
    ServerSocket serverSocket;
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public Server(){
        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("Server created");
            socket = serverSocket.accept();
            System.out.println("Connection established!");
//            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Couldn't create server socket");
        }
    }

    public  void sendData(Objects objects){
        try {
            //****************
            oos = new ObjectOutputStream(socket.getOutputStream());
            TransferringData data = new TransferringData(objects);
            oos.writeObject(data);
            oos.flush();
            System.out.println(data.getPlayers().get(0).getX()+" SENT");
            //****************
//            XStream serDes = new XStream(new StaxDriver());
//            TransferringData data = new TransferringData(objects);
//            String xml = serDes.toXML(data);
//            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
//            osw.write(xml  + "\r\n", 0, xml.length()+2);
//            osw.flush();
            //****************
        } catch (IOException e) {
            System.out.println("Sending Failed!");
            e.printStackTrace();
        }
    }

    public void receiveData(){

    }

//    private void makeData(TransferingData data){
//        data.setPlayers(objects.getPlayers());
//    }

}



