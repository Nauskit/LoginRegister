import GUIs.LoginGUI;
import GUIs.PageGuis;
import GUIs.RegisterGUI;
import db.MyJDBC;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
//                System.out.println(MyJDBC.checkUser("username12"));
            }
        });
    }
}
