package com.CoreJava.Chapter13.Chart;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 0:36 2018/6/28
 */

public class Chart extends JApplet {
    public void init()
    {
        EventQueue.invokeLater(() ->
        {
            String v = getParameter("values");
            if (v == null)
                return;
            int n = Integer.parseInt(v);
            double[] values = new double[n];
            String[] names = new String[n];
            for (int i = 0; i < n; i++)
            {
                values[i] = Double.parseDouble(getParameter("value." + (i + 1)));
                names[i] = getParameter("name." + (i + 1));
            }

            add(new ChartComponent(values, names, getParameter("title")));
        });
    }
}

/**
 * A component that draws a bar chart
 */

class ChartComponent extends JComponent
{
    private double[] values;
    private String[] names;
    private String title;

    public ChartComponent(double[] values, String[] names, String title)
    {
        this.values = values;
        this.names = names;
        this.title = title;
    }

    public void paintComponent(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        //compute the minimum and maximum values
        if (values == null)
            return;
        double minValue = 0;
        double maxValue = 0;
        for (double v : values)
        {
            if (maxValue > v)
                minValue = v;
            if (maxValue < v)
                maxValue = v;
        }
        if (maxValue == minValue)
            return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);

        // compute the extent of the title
        FontRenderContext context = graphics2D.getFontRenderContext();
        Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
        double titleWidth = titleBounds.getWidth();
        double top = titleBounds.getHeight();

        // draw the title
        double y = -titleBounds.getY(); // ascent
        double x = (panelWidth - titleWidth) / 2;
        graphics2D.setFont(titleFont);
        graphics2D.drawString(title, (float) x, (float) y);

        // compute the extent of the bar labels
        LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
        double bottom = labelMetrics.getHeight();

        y = panelHeight - labelMetrics.getDescent();
        graphics2D.setFont(labelFont);

        // get the scale factor and width for the bars
        double scale = (panelHeight - top - bottom) / (maxValue - minValue);
        int barWidth = panelWidth / values.length;

        // draw the bars
        for (int i = 0; i < values.length; i++)
        {
            // get the coordinates of the bar rectanle
            double x1 = i * barWidth + 1;
            double y1 = top;
            double height = values[i] * scale;
            if (values[i] >= 0)
            y1 += (maxValue - values[i]) * scale;
            else
            {
                y1 += maxValue * scale;
                height = -height;
            }

            // fill the bar and draw the bar outline
            Rectangle2D rectangle2D = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
            graphics2D.setPaint(Color.red);
            graphics2D.fill(rectangle2D);
            graphics2D.setPaint(Color.black);
            graphics2D.draw(rectangle2D);

            // draw the centered label below the bar
            Rectangle2D labelBounds = labelFont.getStringBounds(names[i], context);
            double labelWidth = labelBounds.getWidth();
            x = x1 + (barWidth - labelWidth) / 2;
            graphics2D.drawString(names[i], (float) x, (float) y);
        }
    }

}
