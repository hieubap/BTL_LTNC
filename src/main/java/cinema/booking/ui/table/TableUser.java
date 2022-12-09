package cinema.booking.ui.table;

import cinema.booking.db.QueryUser;

public class TableUser extends ParentTable{
  public TableUser() {
    super(new QueryUser());
  }
  @Override
  public String[] getColumn() {
    return new String[]{"Edit","Delete","ID","Username","Họ Tên","Giới tính"};
  }

  @Override
  public Integer[] getWidthCol() {
    return new Integer[]{40,40,60,100,180,80};
  }

  @Override
  public void drawForm() {
    addTitle("Username");
    addTitle("Họ tên");
    addTitle("Giới tính");
  }
}
