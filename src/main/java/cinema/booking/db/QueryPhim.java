package cinema.booking.db;

import java.util.List;

public class QueryPhim extends SqlQuery{

  @Override
  public String getTableName() {
    return "tb_phim";
  }

  @Override
  public int getSize() {
    return 5;
  }
  @Override
  public String searchQuery(String textSearch) {
    return "select * from tb_phim where ten like '%" + textSearch + "%' order by id desc";
  }
  @Override
  public String createQuery(List<String> data) {
    return "Insert into tb_phim"
        + "(ten, the_loai, thoi_luong, tac_gia)"
        + "values('" + data.get(0)
        + "','" + data.get(1)
        + "','" + data.get(2)
        + "','" + data.get(3) + "')";
  }

  @Override
  public String updateQuery(List<String> data, int id) {
    return "update tb_phim" +
        " set ten='" + data.get(0)
        + "',the_loai='" + data.get(1)
        + "',thoi_luong='" + data.get(2)
        + "',tac_gia='" + data.get(3)
        + "' where id=" + id;
  }


}
