package btl.ui.screen;

import btl.Global;
import btl.component.ActionRouter;
import btl.db.manager.LichEntity;
import btl.db.manager.VeManager;
import btl.ui.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChonGhe extends JPanel {
    int focus = -1;

    private final VeManager veManager;

    private final JButton button;

    public ChonGhe(ActionRouter actionRouter, LichEntity phimEntity) {
        try {
            this.veManager = new VeManager();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        setSize(Global.WIDTH_SCREEN - 50, Global.HEIGHT_SCREEN);
        setLayout(null);
        button = new JButton("Đặt vé");
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setBounds(1100,330,200,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(focus != -1){
                    System.out.println("action");
                }
            }
        });
        add(button);
        for (int i = 0; i < 80; i++) {
            char t1 = (char) ('H' - (i / 10));
            char t2 = (char) ('0' + (i % 10));
            ButtonGhe jButton = new ButtonGhe(button.getBackground(), t1 + "" + t2);
            jButton.setFont(new Font("Serif", Font.BOLD, 20));
            jButton.setBounds(70 + (i % 10) * 95, (i / 10) * 95, 80, 80);
            jButton.addActionListener(new ActionSelectGhe(i, actionRouter, this));
            add(jButton, i);
        }
        setSize(Global.WIDTH_SCREEN - 150, Global.HEIGHT_SCREEN);
        setBounds(0, Header.HEIGHT_HEADER + 10, Global.WIDTH_SCREEN - 15, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER - 50);

        addLabel(1100, 200, phimEntity.getTenPhim());
        addLabel(1100, 240, phimEntity.getTenPhong());
        addLabel(1100, 280, "Còn " + phimEntity.getTenPhong() + " chỗ");
        addLabel(1100, 480, "Vui lòng chọn ghế");
        addLabel(500, 750, "Màn hình");


        JButton buttonBack = new JButton("Trở về");
        buttonBack.setFont(new Font("Serif", Font.BOLD, 20));
        buttonBack.setBounds(1100,400,200,50);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionRouter.showDanhSachPhim();
            }
        });
        add(buttonBack);
    }

    public void addLabel(int x, int y, String text) {
        JLabel jLabel = new JLabel(text);
        jLabel.setFont(new Font("Serif", Font.BOLD, 20));
        jLabel.setBounds(x, y, 400, 50);
        add(jLabel);
    }

    public void setFocus(int focus){
        this.focus = focus;
    }

    public static class ActionSelectGhe implements ActionListener {
        private int index = -1;
        private final ActionRouter userLayout;

        private ChonGhe chonGhe;

        public ActionSelectGhe(int i, ActionRouter userLayout, ChonGhe chonGhe) {
            this.index = i;
            this.userLayout = userLayout;
            this.chonGhe = chonGhe;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 80; i++) {
                if(chonGhe.getComponent(i) instanceof ButtonGhe){
                    ((ButtonGhe) chonGhe.getComponent(i)).resetColor();
                }
            }
            chonGhe.getComponent(index).setBackground(Color.ORANGE);
            chonGhe.setFocus(index);
            chonGhe.repaint();
//            userLayout.showDanhSachLich(index);
        }
    }

    static class ButtonGhe extends JButton {
        private final Color defaultColor;

        public ButtonGhe(Color defaultColor, String text) {
            super(text);
            this.defaultColor = defaultColor;
        }

        public void resetColor() {
            setBackground(defaultColor);
        }
    }
}
