package btl.component;

import javax.swing.*;
import javax.swing.text.Keymap;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class InputNumber extends JFormattedTextField {
    public InputNumber() {
        super(NumberFormat.getInstance());
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent ke) {
//                String value = getText();
//                System.out.println((value + ke.getKeyChar()) + ",... " + ke.getKeyCode());
//                ke.consume();
//                if ((ke.getKeyChar() == 8 && isNumber(value)) || isNumber(value + ke.getKeyChar())) {
////                    setText(value + ke.getKeyChar());
//                } else {
//                    if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyCode() == 8) {
//                        setText("" + ke.getKeyChar());
//                    } else {
//                        setText("Vui lòng nhập số (0-9)");
//                    }
//                }
//            }
//        });
    }

    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public void setKeymap(Keymap map) {
        super.setKeymap(map);
        System.out.println(map);
    }
}
