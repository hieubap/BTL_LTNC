package btl.component;

import btl.ui.layout.AdminLayout;

import java.awt.event.ActionEvent;

public class ButtonSidebar extends MyButton {
    private AdminLayout adminLayout;
    private int index;

    public ButtonSidebar(String text, int x, int y, int w, int h,AdminLayout adminLayout,int index) {
        super(text, x, y, w,h);
        this.adminLayout = adminLayout;
        this.index = index;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adminLayout.setScreen(index);
        System.out.println("click button sidebar " + index);
    }
}
