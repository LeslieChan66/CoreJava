package com.CoreJava.Chapter10.ListFonts;

import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 1:16 2018/6/27
 */

public class ListFonts {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String fontName : fontNames)
            System.out.println(fontName);
    }
}
