package cinema.booking.ui;

import cinema.booking.MainApplication.Global;
import cinema.booking.ui.table.TablePhim;
import cinema.booking.ui.table.TablePhong;
import cinema.booking.ui.table.TableUser;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class AdminScreen extends JPanel {
  List<JComponent> listScreen;
  private Header header;
  private Sidebar sidebar;

  public AdminScreen(WindowFrame windowFrame){
    header = new Header(windowFrame);
    sidebar = new Sidebar(this);
    add(header);
    add(sidebar);

    listScreen = new ArrayList<>();
    listScreen.add(new TableUser());
    listScreen.add(new TablePhong());
    listScreen.add(new TablePhim());
    add(listScreen.get(0), 0);

    setSize(Global.WIDTH_SCREEN, Global.HEIGHT_SCREEN);
    setLayout(null);
  }

  public void setScreen(int index) {
    if (index < listScreen.size()) {
      System.out.println("setScreen " + index);
      remove(0);
      add(listScreen.get(index), 0);
      repaint();
    }
  }
}
