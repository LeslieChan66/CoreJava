package com.CoreJava.Chapter10.NotHelloWorld;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 1:02 2018/6/27
 */

public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that contains a message panel
 */
class NotHelloWorldFrame extends JFrame
{
    public NotHelloWorldFrame()
    {
        add(new NotHelloWorldComponent());
        pack();
    }
}

/**
 * A component that displays a message
 */
class NotHelloWorldComponent extends JComponent
{
    public static final int Message_X = 75;
    public static final int Message_Y = 100;
    
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
    
    /**
    * @Description:
    * @param: [graphics]
    * @return: void
    */ 
    
    public void paintComponent(Graphics graphics)
    {
        graphics.drawString("Not a Hello World pragram", Message_X, Message_Y);
    }
    
    /**
    * @Description:
    * @param: []
    * @return: java.awt.Dimension
    */ 
    
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}