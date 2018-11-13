package com.CoreJava.Chapter11.Mouse;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 2:44 2018/6/27
 */

public class MouseTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
