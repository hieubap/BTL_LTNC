package btl.component;

import btl.Global;
import btl.ui.Header;
import btl.ui.SideBar;

import javax.swing.*;
import java.util.List;

public class MyTable extends JPanel {
    public MyTable() {
        setLayout(null);
    }

    public void setup(JTable jTable){
        // Initializing the JTable
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBounds(SideBar.WIDTH_SIDEBAR, Header.HEIGHT_HEADER,
                Global.WIDTH_SCREEN - SideBar.WIDTH_SIDEBAR, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER);

        setBounds(SideBar.WIDTH_SIDEBAR, Header.HEIGHT_HEADER,
                Global.WIDTH_SCREEN - SideBar.WIDTH_SIDEBAR, Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER);
        add(sp);
    }

    public Object[][] convertToArr(List<List<?>> lists){
        if(lists.size() == 0) return null;
        int w = lists.get(0).size();
        int h = lists.size();
        Object[][] output = new Object[h][w];
        for (int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                output[i][j] = lists.get(i).get(j);
            }
        }
        return output;
    }

}
