package quan.ly.sinh.vien.ui.table.parent;

import quan.ly.sinh.vien.db.parent.SqlQuery;

public abstract class TableMonHoc extends ParentTable {

    public TableMonHoc(SqlQuery sqlQuery) {
        super(sqlQuery);
    }

    @Override
    public String[] getColumn() {
        return new String[]{"Edit","Delete","ID","Sinh viên","Giữa kỳ","Cuối kỳ","Vắng"};
    }

    @Override
    public Integer[] getWidthCol() {
        return new Integer[]{60,60,80,100,80,80,80};
    }

    @Override
    public void drawForm() {
        addTitle("Sinh viên");
        addTitle("Giữa kỳ");
        addTitle("Cuối kỳ");
        addTitle("Vắng");
    }
}
