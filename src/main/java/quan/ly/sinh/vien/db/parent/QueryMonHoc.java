package quan.ly.sinh.vien.db.parent;

import java.util.List;

public abstract class QueryMonHoc extends SqlQuery{
    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public String searchQuery(String textSearch) {
        return "select * from "+getTableName()+" where full_name like '%" + textSearch + "%' order by id desc";
    }

    @Override
    public String createQuery(List<String> data) {
        return "Insert into " + getTableName()
                + "(full_name, giua_ky, cuoi_ky, vang)"
                + "values('" + data.get(0)
                + "','" + data.get(1)
                + "','" + data.get(2)
                + "','" + data.get(3) + "')";
    }

    @Override
    public String updateQuery(List<String> data, int id) {
        return "update " + getTableName()
                + " set full_name='" + data.get(0)
                + "',giua_ky='" + data.get(1)
                + "',cuoi_ky='" + data.get(2)
                + "',vang='" + data.get(3)
                + "' where id=" + id;
    }
}
