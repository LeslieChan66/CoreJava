package com.CoreJava.Chapter12.dataExchange;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 19:50 2018/8/9
 */

public class User {
    private String name;
    private char[] password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public User(String aname, char[] apassword)
    {
        name = aname;
        password = apassword;
    }
}
