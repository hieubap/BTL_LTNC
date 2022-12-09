package cinema.booking.ui;

import cinema.booking.MainApplication.Global;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class WindowFrame extends JFrame {
    private AdminScreen adminScreen;
    private LoginScreen loginScreen;

    public WindowFrame() throws HeadlessException {
        adminScreen = new AdminScreen(this);
        adminScreen.setVisible(false);
        loginScreen = new LoginScreen(this);
        loginScreen.setVisible(true);

        add(adminScreen);
        add(loginScreen);

        setTitle("Quản lý đặt vé xem phim");
        setSize(Global.WIDTH_SCREEN, Global.HEIGHT_SCREEN);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void logout(){
        loginScreen.setVisible(true);
        adminScreen.setVisible(false);
        repaint();
    }

    public void showAdmin(){
        loginScreen.setVisible(false);
        adminScreen.setVisible(true);
        repaint();
    }
}
