package com.CoreJava.Chapter12.dialog;

import javax.swing.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 19:01 2018/8/9
 */

public class DialogFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;

    public DialogFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Construct a File menu.
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        //Add About and Exit menu items

        //The About item shows the About dialog

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(event -> {
            if (dialog == null)
                //first time
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true);
        });
        fileMenu.add(aboutItem);

        //The Exit item exits the pragram

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }

    public static void main(String[] args) {
        JFrame frame = new DialogFrame();
        frame.setVisible(true);
    }

}
