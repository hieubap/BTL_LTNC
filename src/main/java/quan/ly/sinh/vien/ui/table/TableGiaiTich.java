package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryGiaiTich;
import quan.ly.sinh.vien.ui.table.parent.TableMonHoc;

public class TableGiaiTich extends TableMonHoc {
  public TableGiaiTich() {
    super(new QueryGiaiTich());
  }
}
