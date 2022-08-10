package btl.component;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InputText extends InputScript {
    private final JTextField jTextField;
    private String placeholder;

    public InputText() {
        jTextField = new JTextField();
        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(jTextField.getText().equals(placeholder)){
                    jTextField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jTextField.getText().equals("")){
                    jTextField.setText(placeholder);
                }
            }
        });
        add(jTextField);
    }

    public InputText(String placeholder) {
        this();
        this.placeholder = placeholder;
        jTextField.setText(placeholder);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        jTextField.setBounds(0, 0, width, height);
        repaint();
    }

    @Override
    public String getText() {
        if(jTextField.getText().equals(placeholder)){
            return "";
        }
        return jTextField.getText();
    }

    @Override
    public void setText(String text) {
        jTextField.setText(text);
    }
    public void setPlaceholder(String text){
        this.placeholder = text;
    }
}
