package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryUser;
import quan.ly.sinh.vien.ui.table.parent.ParentTable;

public class TableUser extends ParentTable {
  public TableUser() {
    super(new QueryUser());
  }
  @Override
  public String[] getColumn() {
    return new String[]{"Edit","Delete","ID","Username","Họ Tên","Giới tính"};
  }

  @Override
  public Integer[] getWidthCol() {
    return new Integer[]{60,60,60,100,180,80};
  }

  @Override
  public void drawForm() {
    addTitle("Username");
    addTitle("Họ tên");
    addTitle("Giới tính");
  }
}
