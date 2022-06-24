package btl.component;

import javax.swing.*;

public abstract class InputScript extends JComponent {
    public abstract String getText();

    public Integer getInt(){
        return -1;
    };
    public abstract void setText(String text);
}
