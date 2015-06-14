package com.holamundo.pame.androidclient;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Pame on 15/05/2015.
 */
public class Consumir extends Thread {
    String SERVERIP = "192.168.2.4"; //your computer IP address
    String message = "1";
    String responseData = null;
    private int num;

    public Consumir(int num)
    {
        this.num = num;
    }

    public void run(){
    try {
        int SERVERPORT = 13000;
        InetAddress serverAddr = InetAddress.getByName(SERVERIP);
        Socket socket = new Socket(serverAddr, SERVERPORT); //New TcpClient
        byte[] data = message.getBytes("US_ASCII"); //Convert a Java String to an ASCII byte array

        DataOutputStream dataOut = new DataOutputStream((socket.getOutputStream()));
        dataOut.write(data,0,data.length);
        data = new byte[2048];

        DataInputStream dataIN = new DataInputStream((socket.getInputStream()));
        int bytes = dataIN.read(data,0,data.length);
        responseData = new String(data,"UTF-8");  //Convert an ASCII byte array to Java String


        dataIN.close();
        //dataOut.close();
        socket.close();
    }
    catch (SocketException e)
    {
        System.out.print("SocketException:{0}" + e);
    }
    catch (Exception e)
    {
        System.out.print("Exception: {0}" + e);
    }

    System.out.print("\n Press Enter to continue...");
    //Random rnd = new Random();
    //int numrnd = rnd.nextInt(3000);

    if (!responseData.equals(null)) {

        Gson gson = new Gson();
        DefaultMensaje def_message = gson.fromJson("{}",DefaultMensaje.class); //Deserializa un objeto
        def_message.insertMensaje(SERVERIP);

    }

}
}

