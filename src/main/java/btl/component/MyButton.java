package btl.component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String text) {
        Border line = new LineBorder(Color.BLUE);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);

        setBorder(compound);
        setText(text);

    }

    public MyButton(String text, int x, int y) {
        this(text);
        setLocation(x, y);
    }

    public MyButton(String text, int x, int y, int w, int h) {
        this(text);
        setBounds(x, y, w, h);
    }
}
