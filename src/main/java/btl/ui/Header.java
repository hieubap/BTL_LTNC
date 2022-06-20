package btl.ui;

import btl.Global;

import javax.swing.*;
import java.awt.*;

public class Header extends JComponent {
    public static int HEIGHT_HEADER = 60;
    public Header() {
        setSize(Global.WIDTH_SCREEN, HEIGHT_HEADER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,Global.WIDTH_SCREEN, HEIGHT_HEADER);

        g.setColor(Color.RED);
        g.fillOval(10,5,50,50);
    }
}
