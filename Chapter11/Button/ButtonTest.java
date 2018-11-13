package com.CoreJava.Chapter11.Button;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 2:02 2018/6/27
 */

public class ButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
