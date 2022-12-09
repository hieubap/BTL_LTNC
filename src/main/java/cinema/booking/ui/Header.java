package cinema.booking.ui;

import cinema.booking.MainApplication.Global;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Header extends JComponent {
  private JButton logoutBtn;

  public Header(WindowFrame windowFrame) {
    setSize(Global.WIDTH_SCREEN, Global.HEIGHT_HEADER);

    logoutBtn = new JButton("Logout");
    logoutBtn.setBounds(Global.WIDTH_SCREEN - 150, 10,
        100, 40);
    logoutBtn.addActionListener(e -> windowFrame.logout());

    add(logoutBtn);
    setLayout(null);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(0xef4444));
    g.fillRect(0, 0, Global.WIDTH_SCREEN, Global.HEIGHT_HEADER);

    g.setColor(Color.white);
    g.setFont(new Font("Serif", Font.BOLD, Global.HEADER_TITLE_SIZE));
    g.drawString("Quản lý rạp chiếu phim", Global.HEADER_TITLE_X, Global.HEADER_TITLE_Y);
  }
}