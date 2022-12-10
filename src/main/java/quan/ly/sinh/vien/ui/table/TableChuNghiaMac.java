package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryChuNghiaMac;
import quan.ly.sinh.vien.ui.table.parent.TableMonHoc;

public class TableChuNghiaMac extends TableMonHoc {
  public TableChuNghiaMac() {
    super(new QueryChuNghiaMac());
  }
}
