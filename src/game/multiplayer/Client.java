package game.multiplayer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import game.Utils.SharedData;
import game.elements.Objects;

import java.io.*;
import java.net.Socket;

public class Client
{
    //fields
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ClientSendingData clientData;
    private Objects objects;

    public Client(Objects objects)
    {
        try
        {
            socket = new Socket("127.0.0.1", 6666);
            clientData = new ClientSendingData();
            this.objects = objects;
            clientData.setClientTank(objects.getPlayers().get(0));
//            ois = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            System.out.println("Couldn't connect to server");
        }
    }

    public void tick()
    {
        receiveData();
//        sendLocationData(objects);
        sendData();

    }

    private void receiveData()
    {
        try
        {
            ois = new ObjectInputStream(socket.getInputStream());
            TransferringData data = (TransferringData) ois.readObject();
//            System.out.println(data.getPlayers().get(0).getX());
            updateObjects(data);
            //******************
//            byte[] bytes = new byte[1024];
//            int rd = socket.getInputStream().read();
//            int index = 0;
//            while(rd != -1)
//            {
//                bytes[index++] = (byte)rd;
//                rd = socket.getInputStream().read();
//            }
            //***********
//            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//            BufferedReader br = new BufferedReader(isr);
//            String str = br.readLine();
//            TransferringData updatedObjects = (TransferringData) (new XStream(new StaxDriver())).fromXML(str);
//            updateObjects(objects,updatedObjects);
//            System.out.println(updatedObjects.getPlayers().get(0).getX());
            //***********
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("couldn't read objects");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found while reading!");
        }
    }

    private void updateObjects(TransferringData data)
    { // called in receive data
//        objects.setPlayers(data.getPlayers());
        objects.replacePlayerTank(data.getPlayers().get(0), 1);
        objects.setBullets(data.getBullets());
        objects.setRobots(data.getRobots());
        objects.setTanks(data.getTanks());
        objects.setTurrets(data.getTurrets());
    }

//    private void sendLocationData(Objects objects){
//        try {
//            System.out.println("Data");
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(objects.getPlayers().get(0));
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Couldn't send from client side");
//        }
//
//    }

    private void sendData()
    {
        try
        {
            oos = new ObjectOutputStream(socket.getOutputStream());
            //check which items must be sent
            if (SharedData.getData().clientShot)
            {
                addClientDataNewBullet();
            }
            //
            oos.writeObject(clientData);
            //making clientData null ('cause of checking in server)
            clientData.setLastShotBullet(null);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void addClientDataNewBullet()
    {
        clientData.setLastShotBullet(SharedData.getData().clientLastShotBullet);
        SharedData.getData().clientShot = false;
    }
}
