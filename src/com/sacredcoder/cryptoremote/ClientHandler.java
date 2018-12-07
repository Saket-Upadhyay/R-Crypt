package com.sacredcoder.cryptoremote;

import javafx.scene.media.MediaPlayer;
import javazoom.jl.player.*;
import javax.sound.sampled.*;
import javax.print.attribute.standard.Media;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Path;

import static javax.swing.JOptionPane.showMessageDialog;

public
class ClientHandler extends Thread {


    Socket socket;
    LockGui lockGui;

    public ClientHandler(Socket s,LockGui lg){

        this.socket=s;
        this.lockGui=lg;
    }

    @Override

    public void run()
    {
        try
        {


            //Reading the message from the client
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String number = br.readLine();

            switch(number)
            {

                case "opend":
                    System.err.println("OPEN KEY CODE ");
                lockGui.unlock();

                    //UNLOCK Sound

                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File("data\\unlock.wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch (Exception e){e.printStackTrace();}

                    //////////////////


                    break;

                case "lockd":
                    System.err.println("LOCK KEY CODE");

lockGui.lock();
                    //LOCK Sound

                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File("data\\lock.wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch (Exception e){e.printStackTrace();}

                    //////////////////



                    break;

                case "beep":
                    Toolkit.getDefaultToolkit().beep();
                    break;




                case "warning":

                  //  showMessageDialog(null, "ALERT MESSAGE", "TITLE", WARNING_MESSAGE);
                    showMessageDialog(null, "WARNING :: DONT TOUCH THIS PC");

                    break;


                case "EXIT":
                    Process child2 = Runtime.getRuntime().exec("TASKKILL /F /IM java.exe");

                    break;





                case "TC":

                    showMessageDialog(null, "Connection Working Properly : Key Connected");
                    break;

                case "realLockD":
                    Process child6 = Runtime.getRuntime().exec("rundll32.exe user32.dll, LockWorkStation");
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File("data\\winlock.wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch (Exception e){e.printStackTrace();}
                    break;


                case "ShutDownExeFinalForce":

                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File("data\\shutdown_male.wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch (Exception e){e.printStackTrace();}
                    Process child8 = Runtime.getRuntime().exec("shutdown.exe /s /f /t 6");

                    break;


                case "SA":

                    Process child91 = Runtime.getRuntime().exec("shutdown.exe /a");
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File("data\\shutdown_ABORT_male.wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch (Exception e){e.printStackTrace();}
                    Process child9 = Runtime.getRuntime().exec("shutdown.exe /a");

                    break;

                default:
                  //  System.out.println(">> "+number);
                   // System.out.println("\n>> " + number);
                    showMessageDialog(null, "\n>> " + number);
                    Process child = Runtime.getRuntime().exec(number);



            }




        }
        catch (Exception e)
        {
            // e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
                System.out.println("....");
            }
            catch(Exception e){}
        }
    }




}


