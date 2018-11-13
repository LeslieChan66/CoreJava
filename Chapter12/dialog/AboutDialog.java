package com.CoreJava.Chapter12.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 19:01 2018/8/9
 */

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner)
    {
        super(owner, "About DialogTest", true);

        //add HTML label to center
        add(new JLabel("<html><h1><i>Core Java</i><hr>By Leslie Chan</html>"), BorderLayout.CENTER);

        //OK button closes the dialog
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));

        //add OK button to southern border
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();
    }
}
