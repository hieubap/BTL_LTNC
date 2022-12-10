package quan.ly.sinh.vien.db;

import quan.ly.sinh.vien.db.parent.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryUser extends SqlQuery {

  @Override
  public String getTableName() {
    return "tb_user";
  }

  @Override
  public int getSize() {
    return 4;
  }
  @Override
  public String searchQuery(String textSearch) {
    return "select id,user_name,full_name,gender from tb_user where full_name like '%" + textSearch + "%' order by id desc";
  }

  @Override
  public String createQuery(List<String> data) {
    return "Insert into tb_user"
        + "(user_name, pass_word, full_name, gender, type)"
        + "values('" + data.get(0)
        + "','" + data.get(1)
        + "','" + data.get(2)
        + "','" + data.get(3)
        + "','" + data.get(4) + "')";
  }

  @Override
  public String updateQuery(List<String> data, int id) {
    return "update tb_user" +
        " set user_name='" + data.get(0)
        + "',full_name='" + data.get(1)
        + "',gender='" + data.get(2)
        + "' where id=" + id;
  }

  public List<String> search(String username, boolean findUser) {
    String sql = "select type,pass_word from tb_user where user_name='" + username + "'";
    try {
      System.out.println(sql);
      List<String> list = new ArrayList<>();
      ResultSet resultSet = statement.executeQuery(sql);
      if(!resultSet.next()) return null;
      list.add(resultSet.getString(1));
      list.add(resultSet.getString(2));

      return list;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
