package com.CoreJava.Chapter13.NotHelloWorld;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 0:31 2018/6/28
 */

public class NotHelloWorld extends JApplet {
    public void init()
    {
        EventQueue.invokeLater(() ->
        {
            JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
            add(label);

        });
    }
}
