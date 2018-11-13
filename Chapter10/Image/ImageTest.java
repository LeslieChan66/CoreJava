package com.CoreJava.Chapter10.Image;

import javax.swing.*;
import java.awt.*;

/**
* @Description:
* @param:
* @return:
* @author: Leslie Chan
* @Date: 2018-06-25
*/
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/*
A frame with an image component
 */
class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent
{
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    private Image image;

    public ImageComponent()
    {
        image = new ImageIcon("Images/blue-ball.gif").getImage();
    }

    public void paintComponent(Graphics graphics)
    {
        if (image == null)
            return;

        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        //draw the image in the upper-left corner

        graphics.drawImage(image, 0, 0, null);
        //tile the image across the component

        for (int i = 0; i * imageWidth <= getWidth(); i++)
            for (int j = 0; j * imageHeight <= getHeight(); j++)
                if (i + j > 0)
                    graphics.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
