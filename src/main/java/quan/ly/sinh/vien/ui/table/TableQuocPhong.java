package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryQuocPhong;
import quan.ly.sinh.vien.ui.table.parent.TableMonHoc;

public class TableQuocPhong extends TableMonHoc {
  public TableQuocPhong() {
    super(new QueryQuocPhong());
  }
}
