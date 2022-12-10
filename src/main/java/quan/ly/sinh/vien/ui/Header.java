package quan.ly.sinh.vien.ui;

import quan.ly.sinh.vien.MainApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Header extends JComponent {
  private JButton logoutBtn;

  public Header(WindowFrame windowFrame) {
    setSize(MainApplication.Global.WIDTH_SCREEN, MainApplication.Global.HEIGHT_HEADER);

    logoutBtn = new JButton("Logout");
    logoutBtn.setBounds(MainApplication.Global.WIDTH_SCREEN - 150, 10,
        100, 40);
    logoutBtn.addActionListener(e -> windowFrame.logout());

    add(logoutBtn);
    setLayout(null);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(0xef4444));
    g.fillRect(0, 0, MainApplication.Global.WIDTH_SCREEN, MainApplication.Global.HEIGHT_HEADER);

    g.setColor(Color.white);
    g.setFont(new Font("Serif", Font.BOLD, MainApplication.Global.HEADER_TITLE_SIZE));
    g.drawString("Quản lý sinh viên", MainApplication.Global.HEADER_TITLE_X, MainApplication.Global.HEADER_TITLE_Y);
  }
}