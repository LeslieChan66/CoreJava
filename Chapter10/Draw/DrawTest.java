package com.CoreJava.Chapter10.Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
* @Description:
* @param:
* @return:
* @author: Leslie Chan
* @Date: 2018-06-25
*/

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame
{
    public DrawFrame()
    {
        add(new DrawComponent());
        pack();
    }
}

/**
 * A component that displays rectangles and ellipses
 */
class DrawComponent extends JComponent
{
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        // 画一个矩形

        double leftX = 50;
        double topY = 50;
        double width = 200;
        double height = 300;

        Rectangle2D rectangle2D = new Rectangle2D.Double(leftX, topY, width, height);
        graphics2D.draw(rectangle2D);

        //画一个椭圆

        Ellipse2D ellipse2D = new Ellipse2D.Double();

        //设置椭圆的外接矩形
        ellipse2D.setFrame(rectangle2D);

        graphics2D.draw(ellipse2D);

        // 画一条对角线,传入参数(x1, y1, x2, y2)

        graphics2D.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        // 画一个同心圆

        double centerX = rectangle2D.getCenterX();
        double centerY = rectangle2D.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        graphics2D.draw(circle);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
