package com.sacredcoder.cryptoremote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LockGui extends JFrame {
    JFrame frame = new JFrame ("MyPanel");
    JFrame frame2=null;
    LockGui () {
        //JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getContentPane().add (new lockGuiPanel());

        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        frame.setSize(size);
        frame.setLocation(0,0);
        frame.pack();
        frame.setAlwaysOnTop(true);

        frame.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){

                    frame.setVisible(false);
                    frame = new JFrame();
                    frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
                    frame.setUndecorated(true);
                    frame.getContentPane().add (new lockGuiPanel());

                    Toolkit toolkit=getToolkit();
                    Dimension size=toolkit.getScreenSize();
                    frame.setSize(size);
                    frame.setLocation(0,0);
                    frame.pack();
                    frame.setAlwaysOnTop(true);
                    frame.setVisible(true);


                }
            }
        });




    }


    public void lock()
    {
        frame.setVisible (true);
    }
    public void unlock()
    {
        frame.setVisible(false);

    }
}
