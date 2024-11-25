package GUIs;

import com.mysql.cj.log.Log;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI extends PageGuis{
    public LoginGUI() {
        super("Login");
        GuiComponent();
    }
    private void GuiComponent(){

        //Loginlabel
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(0,20,540,100);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        //usernameLabel
        JLabel usernameLabel = new JLabel("username");
        usernameLabel.setBounds(20,140,getWidth()-50,100);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN,28));
        usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(usernameLabel);

        //usernameField
        JTextField usernameField = new JTextField();
        usernameField.setBounds(20,220,getWidth()-50,50);
        usernameField.setFont(new Font("Dialog", Font.PLAIN,22));
        add(usernameField);

        //passwordLabel
        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setBounds(20,300,getWidth()-50,100);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN,28));
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(passwordLabel);

        //passwordField
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20,380,getWidth()-50,50);
        passwordField.setFont(new Font("Dialog", Font.PLAIN,22));
        add(passwordField);

        //loginButton
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20,540,getWidth()-50,50);
        loginButton.setFont(new Font("Dialog", Font.BOLD,28));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if(MyJDBC.validateLogin(username, password)){
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login Success!");
                }else{
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login Failed!");
                }
            }
        });
        add(loginButton);

        //registerLabel
        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setBounds(135,600,250,30);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LoginGUI.this.dispose();
                new RegisterGUI().setVisible(true);
            }
        });
        add(registerLabel);
    }
}
