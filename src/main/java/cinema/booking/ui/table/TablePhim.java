package cinema.booking.ui.table;

import cinema.booking.db.QueryPhim;

public class TablePhim extends ParentTable{

  public TablePhim() {
    super(new QueryPhim());
  }

  @Override
  public String[] getColumn() {
    return new String[]{"Edit","Delete","ID","Tên phim","Thể loại","Thời lượng","Tác giả"};
  }

  @Override
  public Integer[] getWidthCol() {
    return new Integer[]{60,60,50,350,100,80,200};
  }

  @Override
  public void drawForm() {
    addTitle("Tên phim");
    addTitle("Thể loại");
    addTitle("Thời lượng (phút)");
    addTitle("Tác giả");
  }
}
