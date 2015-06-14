package com.holamundo.pame.androidclient;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Pame on 15/05/2015.
 */
public class Producir extends Thread{
    String SERVERIP = "192.168.2.4";
    String message = "";
    private int ciclo;
    private int id;
/*
    public Producir(int ciclo,int id)
    {
        this.ciclo = ciclo;
        this.id = id;

    }

    public void run()
    {

    for (int i = 0; i < ciclo; i++){
        try {
            int SERVERPORT = 13000;
            InetAddress serverAddr = InetAddress.getByName(SERVERIP);
            Socket socket = new Socket(serverAddr, SERVERPORT); //New TcpClient

            ConexionDB msg = new ConexionDB("AndroidApp", "Persona" + i, "Cedula:" + i);
            Gson gson = new Gson();
            String jsonified = gson.toJson(msg);
            byte[] data = jsonified.getBytes("UTF-8");

            DataOutputStream dataOut = new DataOutputStream((socket.getOutputStream()));
            dataOut.write(data,0,data.length);
            System.out.print("Sent: {0},{1}"+jsonified+i);
            dataOut.close();
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
    }
}
*/
}
