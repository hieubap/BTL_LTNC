package btl.ui.screen;

import btl.Global;
import btl.db.manager.PhimEntity;
import btl.db.manager.PhimManager;
import btl.ui.Header;
import btl.ui.layout.UserLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSachPhim extends JScrollPane {
    public static List<PhimEntity> listPhim = new ArrayList<>();
    private List<JButton> list;

    private PhimManager phimManager;

    private JPanel jPanel;

    public DanhSachPhim(UserLayout userLayout) {
        jPanel = new JPanel();
        jPanel.setSize(Global.WIDTH_SCREEN - 50, Global.HEIGHT_SCREEN);
        jPanel.setLayout(null);
        try {
            phimManager = new PhimManager();
            list = new ArrayList<>();
            listPhim = phimManager.findAll();
            for (int i = 0; i < listPhim.size(); i++) {
                JButton jButton = new JButton(listPhim.get(i).getTen());
                jButton.setFont(new Font("Serif", Font.BOLD, 20));
                jButton.setBounds(70 + (i % 4) * 400, (i / 4) * 400, 350, 350);
                jButton.addActionListener(new ActionSelectPhim(i, userLayout));
                add(jButton);
                jPanel.add(jButton);
            }


            jPanel.setPreferredSize(new Dimension(Global.WIDTH_SCREEN, (listPhim.size() / 4 + 1) * 400));
            jPanel.revalidate();

            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        setViewportView(jPanel);


        setSize(Global.WIDTH_SCREEN - 150, Global.HEIGHT_SCREEN);
        getVerticalScrollBar().setUnitIncrement(30);
        setBounds(0, Header.HEIGHT_HEADER + 10, Global.WIDTH_SCREEN - 15, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER - 50);
        repaint();
    }

    public static class ActionSelectPhim implements ActionListener{
        private int index = -1;
        private final UserLayout userLayout;
        public ActionSelectPhim(int i,UserLayout userLayout) {
            this.index = i;
            this.userLayout = userLayout;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            userLayout.showDanhSachLich(index);
        }
    }
}
