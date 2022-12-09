package cinema.booking.ui;

import cinema.booking.MainApplication.Global;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Sidebar extends JComponent {
  public static String[] sidebar = {"Danh sách khách hàng", "Danh sách phòng", "Danh sách phim"};

  public Sidebar(AdminScreen adminLayout) {
    for (int i = 0; i < sidebar.length; i++) {
      int j = i;
      JButton btn = new JButton(sidebar[i]);
      btn.setBounds(0, i * 70, Global.WIDTH_SIDEBAR, 70);
      btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          adminLayout.setScreen(j);
        }
      });
      add(btn);
    }

    setBounds(0, Global.HEIGHT_HEADER, Global.WIDTH_SIDEBAR, Global.HEIGHT_SCREEN - Global.HEIGHT_HEADER);
    setLayout(null);
  }
}
