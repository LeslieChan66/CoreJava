package com.CoreJava.Chapter12.dataExchange;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 19:21 2018/8/9
 */

public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser()
    {
        setLayout(new BorderLayout());

        // construct a panel with user name and password fields

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Username:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("password:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        //create Ok and Cancel buttons thats terminate the dialog

        okButton = new JButton("Ok");
        okButton.addActionListener(event ->
        {
            ok = true;
            dialog.setVisible(false);
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dialog.setVisible(false));

        //add buttons to southern border

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setUser(User u)
    {
        username.setText(u.getName());
    }

    public User getUser()
    {
        return new User(username.getText(), password.getPassword());
    }

    public boolean showDialog(Component parent, String title)
    {
        ok = false;

        // locate the owner frame
        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        //if first time, or if owner has changed, make new dialog
        if (dialog == null || dialog.getOwner() != owner)
        {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        //set title and show dialog

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}
