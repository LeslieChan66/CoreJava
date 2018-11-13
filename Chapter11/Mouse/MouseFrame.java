package com.CoreJava.Chapter11.Mouse;

import javax.swing.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 2:43 2018/6/27
 */

public class MouseFrame extends JFrame {
    public MouseFrame()
    {
        add(new MouseComponent());
        pack();
    }
}
