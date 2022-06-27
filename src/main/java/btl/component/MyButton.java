package btl.component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {
    public MyButton(String text) {
        Border line = new LineBorder(Color.BLUE);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);

//        setBorder(new RoundedBorder(15));
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}
