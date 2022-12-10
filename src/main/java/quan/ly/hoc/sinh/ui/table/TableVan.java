package quan.ly.hoc.sinh.ui.table;

import quan.ly.hoc.sinh.db.QueryVan;
import quan.ly.hoc.sinh.ui.table.parent.TableMonHoc;

public class TableVan extends TableMonHoc {
  public TableVan() {
    super(new QueryVan());
  }

}
