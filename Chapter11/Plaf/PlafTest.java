package com.CoreJava.Chapter11.Plaf;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 10:51 2018/6/27
 */

public class PlafTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new PlafFrame();
            frame.setTitle("PlafTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
