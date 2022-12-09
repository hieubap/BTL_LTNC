package cinema.booking.ui.table;

import cinema.booking.db.QueryPhong;

public class TablePhong extends ParentTable{
  public TablePhong() {
    super(new QueryPhong());
  }

  @Override
  public String[] getColumn() {
    return new String[]{"Edit","Delete","ID","Tên phòng","Số ghế"};
  }

  @Override
  public Integer[] getWidthCol() {
    return new Integer[]{40,40,80,100,100};
  }

  @Override
  public void drawForm() {
    addTitle("Tên phòng");
    addTitle("Số ghế");
  }
}
