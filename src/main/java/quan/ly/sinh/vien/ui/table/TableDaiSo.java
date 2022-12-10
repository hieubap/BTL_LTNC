package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryDaiSo;
import quan.ly.sinh.vien.ui.table.parent.TableMonHoc;

public class TableDaiSo extends TableMonHoc {
  public TableDaiSo() {
    super(new QueryDaiSo());
  }

}
