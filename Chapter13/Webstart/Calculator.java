package com.CoreJava.Chapter13.Webstart;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 2:06 2018/6/28
 */

import java.awt.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->             {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
