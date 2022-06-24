package btl.component;

import javax.swing.*;

public class InputText extends InputScript {
    private final JTextField jTextField;

    public InputText() {
        jTextField = new JTextField();
        add(jTextField);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        jTextField.setBounds(0, 0, width, height);
        repaint();
    }

    @Override
    public String getText() {
        return jTextField.getText();
    }

    @Override
    public void setText(String text) {
        jTextField.setText(text);
    }

}
