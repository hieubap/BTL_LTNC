package btl.ui.screen;

import btl.Global;
import btl.component.ActionRouter;
import btl.ui.Header;
import btl.ui.table.TableLich;

import javax.swing.*;

public class DanhSachLich extends JPanel {
    public DanhSachLich(int phimId, ActionRouter actionRouter) {
        TableLich tableLichUser = new TableLich(100, 0, phimId,actionRouter);
        add(tableLichUser);
        setBounds(0,
                Header.HEIGHT_HEADER,
                Global.WIDTH_SCREEN,
                Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER);
        setLayout(null);
    }
}
