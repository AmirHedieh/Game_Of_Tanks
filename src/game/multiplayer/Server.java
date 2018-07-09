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
            //****************
//            oos.writeObject(objects.getPlayers().get(0));
//            oos.flush();
//            System.out.println(objects.getPlayers().get(0).getX()+" SENT");
            //****************
            XStream serDes = new XStream(new StaxDriver());
            TestSerDes tsd = new TestSerDes();
            tsd.TestInt = 10;
            tsd.TestStr = "Hello xml";
            String xml = serDes.toXML(objects.getPlayers().get(0));
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write(xml  + "\r\n", 0, xml.length()+2);
            osw.flush();
            //****************
        } catch (IOException e) {
            System.out.println("Sending Failed!");
            e.printStackTrace();
        }
    }

    public void receiveData(){

    }

    private void makeData(TransferingData data){
        data.setPlayers(objects.getPlayers());
    }

}



