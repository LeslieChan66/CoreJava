package com.CoreJava.Chapter11.Plaf;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 10:43 2018/6/27
 */

public class PlafFrame extends JFrame {
    private JPanel buttonpanel;

    public PlafFrame()
    {
        buttonpanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());

        add(buttonpanel);
        pack();
    }

    private void makeButton(String name, String className)
    {
        // add button to panel

        JButton button = new JButton(name);
        buttonpanel.add(button);

        // set button action
        button.addActionListener(event ->
        {
            // button action: switch to the new look-and-feel
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}
