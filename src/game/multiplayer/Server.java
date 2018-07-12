package game.multiplayer;

import game.elements.Objects;
import game.elements.Tank;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    //fields
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Objects objects;

    public Server(Objects objects)
    {
        try
        {
            serverSocket = new ServerSocket(6666);
            System.out.println("Server created");
            socket = serverSocket.accept();
            System.out.println("Connection established!");
            this.objects = objects;
        }
        catch (IOException e)
        {
            System.out.println("Couldn't create server socket");
        }
    }

    public void tick(Objects objects)
    {
        sendData();
        receiveData();
    }

    private void sendData()
    {
        try
        {
            //****************
            oos = new ObjectOutputStream(socket.getOutputStream());
            TransferringData data = new TransferringData(objects);
            oos.writeObject(data);
            oos.flush();
//            System.out.println(data.getPlayers().get(0).getX()+" SENT");
            //****************
//            XStream serDes = new XStream(new StaxDriver());
//            TransferringData data = new TransferringData(objects);
//            String xml = serDes.toXML(data);
//            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
//            osw.write(xml  + "\r\n", 0, xml.length()+2);
//            osw.flush();
            //****************
        }
        catch (IOException e)
        {
            System.out.println("Sending Failed!");
            e.printStackTrace();
        }
    }

    public void receiveData()
    {
        System.out.println("REC");
        try
        {
            ois = new ObjectInputStream(socket.getInputStream());
            try
            {
//                Tank clientTank = (Tank)ois.readObject();
//                objects.replacePlayerTank(clientTank,1);
                ClientSendingData data = (ClientSendingData) ois.readObject(); //
                objects.replacePlayerTank(data.getClientTank(), 1);
                if (data.getLastShotBullet() != null)
                {
                    objects.addBullet(data.getLastShotBullet());
                }
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//    private void makeData(TransferingData data){
//        data.setPlayers(objects.getPlayers());
//    }

}



