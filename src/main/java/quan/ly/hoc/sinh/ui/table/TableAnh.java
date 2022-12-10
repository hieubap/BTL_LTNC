package quan.ly.hoc.sinh.ui.table;

import quan.ly.hoc.sinh.db.QueryAnh;
import quan.ly.hoc.sinh.ui.table.parent.TableMonHoc;

public class TableAnh extends TableMonHoc {
  public TableAnh() {
    super(new QueryAnh());
  }
}
