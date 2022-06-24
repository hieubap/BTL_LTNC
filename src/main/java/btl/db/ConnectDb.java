package btl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
    public static final Connection connection;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dat_cho_xem_phim", "root", "123456");
            System.out.println("Connect DB Success !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ConnectDb() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dat_cho_xem_phim", "root", "123456");
//        this.connection = connect;
    }

    public Connection getConnection() {
        return connection;
    }

//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
}
