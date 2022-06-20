package btl.ui;

import btl.Global;
import btl.component.MyButton;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JComponent {
    public static int WIDTH_SIDEBAR = 150;

    public static String[] sidebar = {"Danh sách khách hàng", "Danh sách phòng", "Danh sách phim", "Xếp lịch", "Lịch sử"};

    public SideBar() {
        for (int i = 0; i < sidebar.length; i++) {
            add(new MyButton(sidebar[i], 0, i * 70, SideBar.WIDTH_SIDEBAR, 70));
        }
//        add(new MyButton("Danh sách phòng",0,100,SideBar.WIDTH_SIDEBAR,100));
//        add(new MyButton("Xếp lịch",0,200,SideBar.WIDTH_SIDEBAR,100));
//        add(new MyButton("Đặt chỗ",0,300,SideBar.WIDTH_SIDEBAR,100));
        setBounds(0, Header.HEIGHT_HEADER, WIDTH_SIDEBAR, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER);
        setLayout(null);
//        add(new MyButton("Danh sách phòng"));

    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(Color.GREEN);
//        g.fillRect(0, 0, WIDTH_SIDEBAR, 400);
//    }
}
