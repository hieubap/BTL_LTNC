package cinema.booking.db;

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
      connection = DriverManager.getConnection("jdbc:mysql://192.168.1.6:3306/cinema", "quanlm", "admin@123");
      System.out.println("Connect DB Success !!!");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
