package com.sacredcoder.cryptoremote;

import javax.print.attribute.standard.Severity;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {





        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(2408);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.err.println("Started server on port 2408");
        LockGui lockGui=new LockGui();


        while (true)
        {
            Socket socket=null;


            try{
                socket= serverSocket.accept();

                //status.append("A new Client is connected > " +socket.getRemoteSocketAddress());

                Thread t = new ClientHandler(socket,lockGui);

                // Invoking the start()  method
                t.start();





            }catch (Exception e1){}
        }




    }
}





