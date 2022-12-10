package quan.ly.hoc.sinh.ui;

import quan.ly.hoc.sinh.MainApplication;
import quan.ly.hoc.sinh.ui.table.*;

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
    listScreen.add(new TableToan());
    listScreen.add(new TableVan());
    listScreen.add(new TableAnh());
    listScreen.add(new TableSu());
    add(listScreen.get(0), 0);

    setSize(MainApplication.Global.WIDTH_SCREEN, MainApplication.Global.HEIGHT_SCREEN);
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
