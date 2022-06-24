package btl.ui;

import btl.Global;
import btl.component.ActionRouter;
import btl.component.MyButton;
import btl.ui.layout.UserLayout;

import javax.swing.*;
import java.awt.*;

public class Header extends JComponent {
    public static int HEIGHT_HEADER = 60;
    public Header(ActionRouter actionRouter) {
        setSize(Global.WIDTH_SCREEN, HEIGHT_HEADER);

        MyButton logout = new MyButton("Logout");
        logout.setBounds(Global.WIDTH_SCREEN - 150, 10,
                100, 40);
        logout.addActionListener(e -> actionRouter.logout());

        if(actionRouter instanceof UserLayout){
            MyButton home = new MyButton("Home");
            home.setBounds(Global.WIDTH_SCREEN - 270, 10,
                    100, 40);
            home.addActionListener(e -> actionRouter.goHome());
            add(home);
        }
        add(logout);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0xef4444));
        g.fillRect(0,0,Global.WIDTH_SCREEN, HEIGHT_HEADER);

        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Quản lý rạp chiếu phim",10,40);

    }
}
