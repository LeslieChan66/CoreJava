package com.CoreJava.Chapter10.Fill;

/**
* @Description:
* @param:
* @return:
* @author: Leslie Chan
* @Date: 0:32 2018/6/27
*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class FillTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new FillFrame();
            frame.setTitle("FillTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that contains a component with drawings
 */
class FillFrame extends JFrame
{
    public FillFrame()
    {
        add(new FillComponent());
        pack();
    }
}

/**
 * A component that displays filled rectangles and ellipses
 */
class FillComponent extends JComponent
{
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        // draw a rectangle

        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rectangle2D = new Rectangle2D.Double(leftX, topY, width, height);
        graphics2D.setPaint(Color.black);
        graphics2D.draw(rectangle2D);
        graphics2D.setPaint(Color.red);
        graphics2D.fill(rectangle2D); // Note that the right and bottom edge are not painted over

        // draw the enclosed ellipse

        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(rectangle2D);
        graphics2D.setPaint(new Color(0, 128, 128));
        graphics2D.fill(ellipse2D);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}