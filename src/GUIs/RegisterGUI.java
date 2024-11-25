package GUIs;

import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterGUI extends PageGuis{
    public RegisterGUI() {
        super("Register");
        GuiComponent();
    }
    private void GuiComponent(){

        //Registerlabel
        JLabel regsiterLabel = new JLabel("Register");
        regsiterLabel.setBounds(0,20,540,100);
        regsiterLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        regsiterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(regsiterLabel);

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
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20,260,getWidth()-50,100);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN,28));
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(passwordLabel);

        //passwordField
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20,340,getWidth()-50,50);
        passwordField.setFont(new Font("Dialog", Font.PLAIN,22));
        add(passwordField);

        //passwordLabel
        JLabel rePasswordLabel = new JLabel("Re-Password");
        rePasswordLabel.setBounds(20,380,getWidth()-50,100);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN,28));
        rePasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(rePasswordLabel);

        //passwordField
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(20,460,getWidth()-50,50);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN,22));
        add(rePasswordField);

        //RegisterButton
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20,560,getWidth()-50,50);
        registerButton.setFont(new Font("Dialog", Font.BOLD,28));
        registerButton.setHorizontalAlignment(SwingConstants.CENTER);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String rePassword = new String(rePasswordField.getPassword());

                if(validateUserInput(username,password,rePassword)){
                    if(MyJDBC.register(username,password)){
                        RegisterGUI.this.dispose();
                        LoginGUI loginGui = new LoginGUI();
                        loginGui.setVisible(true);

                        JOptionPane.showMessageDialog(loginGui, " Registereed Success!");
                    }else{
                        JOptionPane.showMessageDialog(RegisterGUI.this, "Error: Username already taken");
                    }
                }else{
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Error username at least 6 char \n and/or password not match" );
                }
            }
        });
        add(registerButton);

        JLabel registerLabel = new JLabel("Have a user? Login Here");
        registerLabel.setBounds(135,610,250,30);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RegisterGUI.this.dispose();
                new LoginGUI().setVisible(true);
            }
        });
        add(registerLabel);
    }

    private boolean validateUserInput(String username, String password, String rePassword){
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;

        if(username.length() <6) return false;

        if(!password.equals(rePassword)) return false;

        return true;
    }
}
