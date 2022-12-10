package quan.ly.hoc.sinh.db.parent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// lớp trừu tượng
public abstract class SqlQuery{
  protected final Statement statement;
  public SqlQuery() {
    try {
      this.statement = Connector.connection.createStatement();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public abstract String getTableName();
  public abstract int getSize();

  public String searchQuery(String textSearch){
    return "select * from " + getTableName();
  }

  public abstract String createQuery(List<String> data);

  public abstract String updateQuery(List<String> data, int id);

  public List<String> search(String text){
    try {
      List<String> output = new ArrayList<>();

      ResultSet resultSet = statement.executeQuery(searchQuery(text));

      while (resultSet.next()) {
        int i = 0;
        while(i < getSize()){
          i++;
          output.add(resultSet.getString(i));
        }
      }
      return output;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void create(List<String> data){
    String queryString = createQuery(data);
    System.out.println(queryString);
    try {
      statement.executeUpdate(queryString);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int update(List<String> data, int id){
    String queryString = updateQuery(data,id);
    try {
      return statement.executeUpdate(queryString);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public void delete(Integer id){
    String queryString = "delete from " + getTableName() + " where id=" + id;
    try {
      statement.executeUpdate(queryString);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void deleteAll(){
    String queryString = "delete from " + getTableName();
    try {
      statement.executeUpdate(queryString);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
