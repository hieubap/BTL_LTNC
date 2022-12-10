package quan.ly.sinh.vien.ui.table.parent;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {
  private Boolean isEdit;
  private ParentTable parentTable;
  public ButtonEditor(Boolean string, ParentTable parentTable) {
    super(new JCheckBox());
    this.isEdit = string;
    this.parentTable = parentTable;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    JButton button =new JButton(isEdit ? "Sửa":"Xóa");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(isEdit){
          parentTable.clickEdit(row);
        }else{
          parentTable.clickDelete(row);
        }
      }
    });
    return button;
  }
}