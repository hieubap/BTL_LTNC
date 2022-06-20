package btl.data;

import btl.db.manager.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

public class CreateInitData {
    public static String[] arrHo = {"Ngô", "Phạm", "Trần", "Lê", "Hồ", "Tạ", "Nguyễn", "Võ"};
    public static String[] arrTen = {"An", "Bình", "Cường", "Dương", "Hiếu", "Kiên", "Trung", "Yến"};

    public static void initData(Connection connection) throws SQLException {
        UserManager userManager = new UserManager(connection);

        // xóa toàn bộ dữ liệu hiện tại
        userManager.deleteAll();
        Random random = new Random();
        // tạo dữ liệu người dùng
        // vì xóa hết dữ liệu bảng nên hoàn toàn có thể tạo student với id tự set mà ko sợ trùng
        for (int i = 0; i < 100; i++) {
            userManager.createWithId(i + 1,
                    "user" + (i + 1),
                    "123456",
                    arrHo[(int) (random.nextDouble() * 7)] + " " +
                            arrTen[(int) (random.nextDouble() * 7)],
                    (short) (Math.random() * 2 + 1),
                    "2000-01-01");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dat_cho_xem_phim", "root", "123456");
        initData(connect);

    }
}
