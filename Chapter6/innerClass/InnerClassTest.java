package com.CoreJava.Chapter6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

/**
* @Description:内部类，内部类可以访问所在类的实例域
* @param:
* @return:
* @author: Leslie Chan
* @Date: 2018-06-13
*/

public class InnerClassTest {
    public static void main(String[] args) {
        TalkClock clock = new TalkClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

class TalkClock
{
    private int interval;
    private boolean beep;

    public TalkClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
