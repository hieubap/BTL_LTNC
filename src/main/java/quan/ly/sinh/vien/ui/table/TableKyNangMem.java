package quan.ly.sinh.vien.ui.table;

import quan.ly.sinh.vien.db.QueryKyNangMem;
import quan.ly.sinh.vien.ui.table.parent.TableMonHoc;

public class TableKyNangMem extends TableMonHoc {
  public TableKyNangMem() {
    super(new QueryKyNangMem());
  }

}
