package cinema.booking.db;

import java.util.List;

public class QueryPhong extends SqlQuery{

  @Override
  public String getTableName() {
    return "tb_phong";
  }

  @Override
  public int getSize() {
    return 3;
  }

  @Override
  public String searchQuery(String textSearch) {
    return "select * from tb_phong where ten like '%" + textSearch + "%' order by id desc";
  }
  @Override
  public String createQuery(List<String> data) {
    return "Insert into tb_phong"
        + "(ten, so_ghe)"
        + "values('" + data.get(0)
        + "'," + data.get(1) + ")";
  }

  @Override
  public String updateQuery(List<String> data, int id) {
    return "update tb_phong" +
        " set ten='" + data.get(0)
        + "',so_ghe=" + data.get(1)
        + " where id=" + id;
  }
}
