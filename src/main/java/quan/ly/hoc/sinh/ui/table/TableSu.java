package quan.ly.hoc.sinh.ui.table;

import quan.ly.hoc.sinh.db.QuerySu;
import quan.ly.hoc.sinh.ui.table.parent.TableMonHoc;

public class TableSu extends TableMonHoc {
  public TableSu() {
    super(new QuerySu());
  }

}
