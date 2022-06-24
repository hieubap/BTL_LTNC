package btl.ui.screen;

import btl.Global;
import btl.component.ActionRouter;
import btl.db.manager.LichEntity;
import btl.db.manager.VeEntity;
import btl.db.manager.VeManager;
import btl.ui.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChonGhe extends JPanel {
    int focus = -1;

    private final VeManager veManager;

    private final JButton button;

    private List<VeEntity> listVe;

    private LichEntity lich;

    private int currentUserId;

    private ActionRouter actionRouter;

    private List<ButtonGhe> listButtonSlot;

    public ChonGhe(ActionRouter actionRouter, LichEntity lich) {
        this.currentUserId = actionRouter.windowFrame.currentUser.getId();
        this.lich = lich;
        this.actionRouter = actionRouter;
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
        button.setBounds(1100, 330, 200, 50);
        button.addActionListener(e -> {
            if (focus != -1) {
                System.out.println("Đặt ghế");
                VeEntity ve = new VeEntity();
                ve.setUserId(currentUserId);
                ve.setLichId(lich.getId());
                ve.setHang(focus / 10);
                ve.setCot(focus % 10);
                try {
                    veManager.create(ve);

                    JDialog d = new JDialog(actionRouter.windowFrame, "Đặt thành công");
                    d.setSize(300, 200);
                    d.setLayout(new BorderLayout());
                    d.setLocationRelativeTo(null);
                    JLabel l = new JLabel("Đặt vé thành công");
                    l.setSize(300, 100);
                    JButton b = new JButton("Xong");
                    b.addActionListener(e1 -> {
                        loadMap();
                        ((ButtonGhe) getComponent(focus)).removeAction();
                        focus = -1;
                        d.setVisible(false);
                    });
                    b.setSize(300, 50);
                    d.add(l, BorderLayout.NORTH);
                    d.add(b, BorderLayout.SOUTH);
                    d.setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(button);
        listButtonSlot = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            char t1 = (char) ('H' - (i / 10));
            char t2 = (char) ('0' + (i % 10));
            ButtonGhe jButton = new ButtonGhe(button.getBackground(), t1 + "" + t2);
            jButton.setFont(new Font("Serif", Font.BOLD, 20));
            jButton.setBounds(70 + (i % 10) * 95, (i / 10) * 95, 80, 80);
            add(jButton, i);
            listButtonSlot.add(jButton);
        }

        loadMap();

        setSize(Global.WIDTH_SCREEN - 150, Global.HEIGHT_SCREEN);
        setBounds(0, Header.HEIGHT_HEADER + 10, Global.WIDTH_SCREEN - 15, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER - 50);

        addLabel(1100, 200, lich.getTenPhim());
        addLabel(1100, 240, lich.getTenPhong());
        addLabel(1100, 280, "Còn " + lich.getTenPhong() + " chỗ");
        addLabel(1100, 480, "Vui lòng chọn ghế");
        addLabel(500, 750, "Màn hình");


        JButton buttonBack = new JButton("Trở về");
        buttonBack.setFont(new Font("Serif", Font.BOLD, 20));
        buttonBack.setBounds(1100, 400, 200, 50);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionRouter.showDanhSachPhim();
            }
        });
        add(buttonBack);
    }

    public void loadMap() {
        try {
            this.listVe = veManager.findByLichId(lich.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 80; i++) {
            ButtonGhe jButton = listButtonSlot.get(i);
            jButton.removeAction();
            if (listVe.size() > 0) {
                boolean exist = false;
                for (int j = 0; j < listVe.size(); j++) {
                    if (i / 10 == listVe.get(j).getHang() && i % 10 == listVe.get(j).getCot()) {
                        exist = true;
                        if (listVe.get(j).getUserId() == currentUserId) {
                            jButton.setBackground(new Color(0x3CB371));
                            jButton.setDefaultColor(new Color(0x3CB371));
                        } else {
                            jButton.setBackground(new Color(0xef4444));
                            jButton.setDefaultColor(new Color(0xef4444));
                        }
                        break;
                    }
                }
                if (!exist) {
                    jButton.addActionListener(new ActionSelectGhe(i, actionRouter, this));
                }
            } else {
                jButton.addActionListener(new ActionSelectGhe(i, actionRouter, this));
            }
            repaint();
        }
    }

    public void addLabel(int x, int y, String text) {
        JLabel jLabel = new JLabel(text);
        jLabel.setFont(new Font("Serif", Font.BOLD, 20));
        jLabel.setBounds(x, y, 400, 50);
        add(jLabel);
    }

    public void setFocus(int focus) {
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
                if (chonGhe.getComponent(i) instanceof ButtonGhe) {
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
        private Color defaultColor;

        private ActionListener actionListener;

        public ButtonGhe(Color defaultColor, String text) {
            super(text);
            this.defaultColor = defaultColor;
        }

        public void setDefaultColor(Color defaultColor) {
            this.defaultColor = defaultColor;
            setBackground(defaultColor);
        }

        @Override
        public void addActionListener(ActionListener l) {
            super.addActionListener(l);
            actionListener = l;
        }

        public void removeAction() {
            removeActionListener(actionListener);
        }

        public void resetColor() {
            setBackground(defaultColor);
        }
    }
}
