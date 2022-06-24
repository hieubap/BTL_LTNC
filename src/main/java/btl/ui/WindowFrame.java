package btl.ui;

import btl.Global;
import btl.db.manager.UserEntity;
import btl.ui.layout.AdminLayout;
import btl.ui.layout.UserLayout;
import btl.ui.layout.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WindowFrame extends JFrame {
    private UserEntity currentUser;

    private List<JComponent> listRoute;
    private AdminLayout adminLayout;

    private UserLayout userLayout;

    private LoginScreen loginScreen;

    public WindowFrame() throws HeadlessException {
        adminLayout = new AdminLayout(this);
        adminLayout.setVisible(false);
        userLayout = new UserLayout(this);
        userLayout.setVisible(false);
        loginScreen = new LoginScreen(this);
        add(adminLayout);
        add(userLayout);
        add(loginScreen);

        setTitle("Quản lý đặt vé xem phim");
        setSize(Global.WIDTH_SCREEN, Global.HEIGHT_SCREEN);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }

    public void showLogin(){
        currentUser = null;
        loginScreen.setVisible(true);
        userLayout.setVisible(false);
        adminLayout.setVisible(false);
        repaint();
    }

    public void showAdmin(UserEntity entity){
        currentUser = entity;
        loginScreen.setVisible(false);
        userLayout.setVisible(false);
        adminLayout.setVisible(true);
        repaint();
    }

    public void showUser(UserEntity entity){
        currentUser = entity;
        loginScreen.setVisible(false);
        userLayout.setVisible(true);
        adminLayout.setVisible(false);
        repaint();
    }
}
