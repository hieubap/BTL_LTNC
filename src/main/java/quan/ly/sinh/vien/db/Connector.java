package quan.ly.sinh.vien.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
  public static final Connection connection;

  static{
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_hoc_sinh", "quanlm", "admin@123");
      System.out.println("Connect DB Success !!!");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void test(){
    add(1,2,3);
  }
  public int add(int a,int b){
    return a + b;
  }

  public int add(int a,int b,int c){
    return a + b+c;
  }

}
