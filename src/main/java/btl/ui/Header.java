package btl.ui;

import btl.Global;
import btl.component.ActionRouter;
import btl.component.MyButton;
import btl.ui.layout.UserLayout;

import javax.swing.*;
import java.awt.*;

public class Header extends JComponent {
    public static int HEIGHT_HEADER = Global.HEIGHT_HEADER;
    private MyButton logoutBtn;
    private MyButton homeBtn;

    public Header(ActionRouter actionRouter) {
        setSize(Global.WIDTH_SCREEN, HEIGHT_HEADER);

        logoutBtn = new MyButton("Logout");
        logoutBtn.setBounds(Global.WIDTH_SCREEN - 150, 10,
                100, 40);
        logoutBtn.addActionListener(e -> actionRouter.logout());

        if (actionRouter instanceof UserLayout) {
            homeBtn = new MyButton("Home");
            homeBtn.setBounds(Global.WIDTH_SCREEN - 270, 10,
                    100, 40);
            homeBtn.addActionListener(e -> actionRouter.goHome());
            add(homeBtn);
        }
        add(logoutBtn);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0xef4444));
        g.fillRect(0, 0, Global.WIDTH_SCREEN, HEIGHT_HEADER);

        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, Global.HEADER_TITLE_SIZE));
        g.drawString("Quản lý rạp chiếu phim", Global.HEADER_TITLE_X, Global.HEADER_TITLE_Y);

    }
}
