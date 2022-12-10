package quan.ly.hoc.sinh.ui.table.parent;

import quan.ly.hoc.sinh.db.parent.SqlQuery;

public abstract class TableMonHoc extends ParentTable {

    public TableMonHoc(SqlQuery sqlQuery) {
        super(sqlQuery);
    }

    @Override
    public String[] getColumn() {
        return new String[]{"Edit","Delete","ID","Học sinh","Giữa kỳ","Cuối kỳ","Vắng"};
    }

    @Override
    public Integer[] getWidthCol() {
        return new Integer[]{60,60,80,100,80,80,80};
    }

    @Override
    public void drawForm() {
        addTitle("Học sinh");
        addTitle("Giữa kỳ");
        addTitle("Cuối kỳ");
        addTitle("Vắng");
    }
}
