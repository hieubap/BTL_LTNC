package quan.ly.hoc.sinh.ui.table;

import quan.ly.hoc.sinh.db.QueryToan;
import quan.ly.hoc.sinh.ui.table.parent.TableMonHoc;

public class TableToan extends TableMonHoc {
  public TableToan() {
    super(new QueryToan());
  }
}
