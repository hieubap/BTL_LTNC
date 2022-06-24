package btl.component;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonTable extends JButton implements MouseListener {
    private int index = -1;

    private ActionTable actionTable;

    public ButtonTable(String text, int index, ActionTable actionTable) {
        super(text);
        this.index = index;
        this.actionTable = actionTable;
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        actionTable.event(index);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
