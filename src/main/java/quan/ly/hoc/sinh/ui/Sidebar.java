package quan.ly.hoc.sinh.ui;

import quan.ly.hoc.sinh.MainApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Sidebar extends JComponent {
  public static String[] sidebar = {"Danh sách học sinh", "Toán", "Ngữ Văn","Lịch Sử","Tiếng Anh"};

  public Sidebar(AdminScreen adminLayout) {
    for (int i = 0; i < sidebar.length; i++) {
      int j = i;
      JButton btn = new JButton(sidebar[i]);
      btn.setBounds(0, i * 70, MainApplication.Global.WIDTH_SIDEBAR, 70);
      btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          adminLayout.setScreen(j);
        }
      });
      add(btn);
    }

    setBounds(0, MainApplication.Global.HEIGHT_HEADER, MainApplication.Global.WIDTH_SIDEBAR, MainApplication.Global.HEIGHT_SCREEN - MainApplication.Global.HEIGHT_HEADER);
    setLayout(null);
  }
}
