package quan.ly.sinh.vien.ui;

import quan.ly.sinh.vien.MainApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Sidebar extends JComponent {
  public static String[] sidebar = {"Sinh viên", "Chủ nghĩa Mac-Lê nin", "Đại số","Giải tích","Kỹ năng mềm","Lập trình Java","Quốc phòng - An ninh"};

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
