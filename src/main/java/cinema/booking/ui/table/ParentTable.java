package cinema.booking.ui.table;

import cinema.booking.MainApplication.Global;
import cinema.booking.db.SqlQuery;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public abstract class ParentTable extends JPanel {
  private SqlQuery sqlQuery;
  private Object[][] dataTable;

  public ParentTable(SqlQuery sqlQuery) {
    this.sqlQuery = sqlQuery;
    setLayout(null);
    setBounds(Global.WIDTH_SIDEBAR, Global.HEIGHT_HEADER,
        Global.WIDTH_SCREEN - Global.WIDTH_SIDEBAR,
        Global.HEIGHT_SCREEN - Global.HEIGHT_HEADER);
    setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
    loadTable("");
    initForm();
    drawForm();
  }

  // table
  public abstract String[] getColumn();
  public abstract Integer[] getWidthCol();
  void loadTable(String text){
    dataTable = convertToDataTable(sqlQuery.search(text));
    JTable jTable = new JTable(dataTable, getColumn());
    jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    jTable.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 20));
    jTable.setRowHeight(50);
    jTable.getColumn("Edit").setCellEditor(new ButtonEditor(true,this));
    jTable.getColumn("Edit").setCellRenderer(new ButtonRender("Sửa"));
    jTable.getColumn("Delete").setCellEditor(new ButtonEditor(false,this));
    jTable.getColumn("Delete").setCellRenderer(new ButtonRender("Xóa"));

    if (getComponentCount() > 0) {
      remove(0);
    }
    for (int i = 0; i < getWidthCol().length; i++) {
      jTable
          .getColumnModel()
          .getColumn(i)
          .setPreferredWidth(getWidthCol()[i]);
    }
    JScrollPane sp = new JScrollPane(jTable);
    sp.setBounds(Global.TABLE_PADDING, Global.HEIGHT_HEADER,
        Global.TABLE_WIDTH,
        Global.HEIGHT_SCREEN - Global.HEIGHT_HEADER - Global.TABLE_PADDING*2 - Global.TABLE_HEIGHT_HEAD);

    add(sp, 0);
  }

  // form
  protected JButton createButton, saveButton, buttonSearch;
  protected JTextField inputTimKiem;
  protected List<JTextField> listJTextField = new ArrayList<>();
  protected int numberInput = 0, idEdit = -1;
  protected boolean isCreate = true;

  private void initForm(){
    inputTimKiem = new JTextField("");
    inputTimKiem.setBounds(120, 10, 500, 30);

    buttonSearch = new JButton("Tìm");
    buttonSearch.setBounds(620, 10, 100, 30);
    buttonSearch.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          loadTable(inputTimKiem.getText());
      }
    });
    createButton = new JButton("Thêm mới");
    createButton.setBounds(10, 10, 100, 30);
    createButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onCreate();
      }
    });
    saveButton = new JButton("Lưu");
    saveButton.setBounds(Global.TABLE_WIDTH + Global.TABLE_PADDING*2 + 10, 550, 100, 30);
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onSave();
      }
    });
    add(buttonSearch);
    add(createButton);
    add(saveButton);
    add(inputTimKiem);
  }

  public abstract void drawForm();

  public void addTitle(String title) {
    numberInput++;
    JLabel jLabel = new JLabel(title);
//    jLabel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
    jLabel.setBounds(Global.X_FORM, numberInput*Global.FORM_HEIGHT_INPUT, Global.WIDTH_INPUT, Global.HEIGHT_INPUT);
    add(jLabel);

    JTextField input = new JTextField();
    input.setBounds(Global.X_FORM, Global.HEIGHT_LABEL + numberInput*Global.FORM_HEIGHT_INPUT, Global.WIDTH_INPUT, Global.HEIGHT_INPUT);
    add(input);
    listJTextField.add(input);
  }
  public void onCreate(){
    isCreate = true;
    idEdit = -1;
    for(JTextField field : listJTextField){
      field.setText("");
    }
  }
  public void onSave(){
    List<String> data = new ArrayList<>();
    for(JTextField f : listJTextField){
      data.add(f.getText());
    }
    if(idEdit == -1){
      sqlQuery.create(data);
    }else{
      sqlQuery.update(data,idEdit);
    }
    loadTable("");
  }
  public void clickEdit(int row){
    isCreate = false;
    idEdit = Integer.parseInt((String) dataTable[row][2]);
    for(int i=0;i< numberInput;i++){
      listJTextField.get(i).setText((String)dataTable[row][i+3]);
    }
    System.out.println("edit...");
  }

  public void clickDelete(int row){
    sqlQuery.delete(Integer.parseInt(dataTable[row][2].toString()));
    loadTable("");
    System.out.println("delete...");
  }
  public Object[][] convertToDataTable(List<String> lists) {
    if (lists == null || lists.size() == 0) return new Object[][]{};
    int w = getWidthCol().length - 2;
    int h = lists.size()/w;
    Object[][] output = new Object[h][w+2];
    for (int i = 0; i < h; i++) {
      output[i][0] = false;
      output[i][1] = false;
      for (int j = 0; j < w; j++) {
        System.out.println(lists.get(i*w + j));
        output[i][j+2] = lists.get(i*w + j);
      }
    }
    return output;
  }

}
