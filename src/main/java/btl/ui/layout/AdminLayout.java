package btl.ui.layout;

import btl.Global;
import btl.component.ActionRouter;
import btl.ui.Header;
import btl.ui.SideBar;
import btl.ui.WindowFrame;
import btl.ui.table.TableLich;
import btl.ui.table.TablePhim;
import btl.ui.table.TablePhong;
import btl.ui.table.TableUser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AdminLayout extends ActionRouter {
    List<JComponent> listScreen;
    private Header header;
    private SideBar sidebar;

    public AdminLayout(WindowFrame windowFrame){
        this.windowFrame = windowFrame;
        listScreen = new ArrayList<>();
        listScreen.add(new TableUser());
        listScreen.add(new TablePhong());
        listScreen.add(new TablePhim());
        listScreen.add(new TableLich());

        header = new Header(this);
        sidebar = new SideBar(this);
        add(header);
        add(sidebar);
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

    @Override
    public void logout() {
        windowFrame.showLogin();
    }
}
