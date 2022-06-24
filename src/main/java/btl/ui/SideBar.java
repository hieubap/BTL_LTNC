package btl.ui;

import btl.Global;
import btl.component.ButtonSidebar;
import btl.component.MyButton;
import btl.ui.layout.AdminLayout;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JComponent {
    public static int WIDTH_SIDEBAR = 150;

    public static String[] sidebar = {"Danh sách khách hàng", "Danh sách phòng", "Danh sách phim", "Xếp lịch", "Lịch sử"};

    private AdminLayout adminLayout;
    public SideBar(AdminLayout adminLayout) {
        this.adminLayout = adminLayout;
        for (int i = 0; i < sidebar.length; i++) {
            add(new ButtonSidebar(sidebar[i], 0, i * 70, SideBar.WIDTH_SIDEBAR, 70, adminLayout,i));
        }

        setBounds(0, Header.HEIGHT_HEADER, WIDTH_SIDEBAR, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER);
        setLayout(null);
    }
}
