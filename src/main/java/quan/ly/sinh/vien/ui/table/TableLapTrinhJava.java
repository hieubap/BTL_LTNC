package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryLapTrinhJava;
import quan.ly.sinh.vien.ui.table.parent.TableMonHoc;

public class TableLapTrinhJava extends TableMonHoc {
  public TableLapTrinhJava() {
    super(new QueryLapTrinhJava());
  }
}
