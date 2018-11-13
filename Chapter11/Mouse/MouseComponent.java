package com.CoreJava.Chapter11.Mouse;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 2:11 2018/6/27
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * A component with mouse operations for adding and removing squares
 */
public class MouseComponent extends JComponent
{
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public static final int SIDELENGTH = 50;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; //the square containing the mouse cursor

    public MouseComponent()
    {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        // draw all squares
        for (Rectangle2D rectangle2D : squares)
            graphics2D.draw(rectangle2D);
    }

    /**
    * @Description:
    * @param: [point2D]
    * @return: java.awt.geom.Rectangle2D
    */

    public Rectangle2D find(Point2D point2D)
    {
        for (Rectangle2D rectangle2D : squares)
        {
            if (rectangle2D.contains(point2D))
                return rectangle2D;
        }
        return null;
    }

    /**
    * @Description:
    * @param: [point2D]
    * @return: void
    */

    public void add(Point2D point2D)
    {
        double x = point2D.getX();
        double y = point2D.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s)
    {
        if (s == null)
            return;
        if (s == current)
            current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e) {
            // add a new square if the cursor isn't inside a square
            current = find(e.getPoint());
            if (current == null)
                add(e.getPoint());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // remove the current square if double clicked
            current = find(e.getPoint());
            if (current != null && e.getClickCount() >= 2)
                remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener
    {
        @Override
        public void mouseMoved(MouseEvent e) {
            // set the mouse cursor to cross hairs if it is inside
            // a rectangle

            if (find(e.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (current != null)
            {
                int x = e.getX();
                int y = e.getY();

                // drag the current rectangle to center it at (x, y)
                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }
}
