package com.CoreJava.Chapter12.dataExchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 19:21 2018/8/9
 */

public class DataExchangeFrame extends JFrame{
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame()
    {
        // construct a File menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // add Connect and Exit menu items

        JMenuItem connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        // The Exit item exits the program

        JMenuItem exitItem = new JMenuItem();
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    private class ConnectAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // if first time, construct dialog

            if (dialog == null)
                dialog = new PasswordChooser();

            // set default values
            dialog.setUser(new User("yourname", null));

            //pop up dialog
            if (dialog.showDialog(DataExchangeFrame.this, "Connect"));
            {
                // if accepted, retrieve user input
                User user = dialog.getUser();
                textArea.append("user name = " + user.getName() + "password = " + (new String(user.getPassword())) + "\n");

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new DataExchangeFrame();
        frame.setVisible(true);
    }
}
