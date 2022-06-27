package btl.data;

import btl.db.ConnectDb;
import btl.db.manager.PhimManager;
import btl.db.manager.PhongManager;
import btl.db.manager.UserManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateInitData {
    public static String[] arrHo = {"Ngô", "Phạm", "Trần", "Lê", "Hồ", "Tạ", "Nguyễn", "Võ"};
    public static String[] arrTen = {"An", "Bình", "Cường", "Dương", "Hiếu", "Kiên", "Trung", "Yến"};

    public static void initData() throws SQLException, ClassNotFoundException {
        UserManager userManager = new UserManager();
        PhongManager phongManager = new PhongManager();
        PhimManager phimManager = new PhimManager();

        // xóa toàn bộ dữ liệu hiện tại
        userManager.deleteAll();
        phongManager.deleteAll();
        phimManager.deleteAll();
        Random random = new Random();
        // tạo dữ liệu người dùng
        // vì xóa hết dữ liệu bảng nên hoàn toàn có thể tạo student với id tự set mà ko sợ trùng
        for (int i = 0; i < 50; i++) {
            userManager.createWithId(i + 2,
                    "user" + (i + 1),
                    "123",
                    arrHo[(int) (random.nextDouble() * 7)] + " " +
                            arrTen[(int) (random.nextDouble() * 7)],
                    (short) (Math.random() * 2 + 1),
                    "2000-01-01", 2);
        }

        userManager.createWithId(1,
                "admin",
                "123",
                "Ngô Quang Hiếu",
                (short) 1,
                "2000-01-01",
                1);

        for (int i = 0; i < 20; i++) {
            phongManager.createWithId(i + 1,
                    "Phòng " + (char) ('A' + i));
        }

        for (int i = 0; i < 20; i++) {
            phimManager.createWithId(i + 1,
                    "Tom and Jerry " + (i + 1),
                    "120");
        }
    }

    public static void initTable() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDb.connection;
        Statement statement = connection.createStatement();
        String createPhong = "create table if not exists tb_phong" +
                "( id  int auto_increment" +
                "        primary key," +
                "    ten varchar(50) charset utf8mb3 null," +
                "    constraint tb_phong_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createPhong);

        String createPhim = "create table if not exists tb_phim" +
                "( id  int auto_increment" +
                "        primary key," +
                "    ten varchar(100) charset utf8mb3 null," +
                "    thoi_han int null," +
                "    constraint tb_phim_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createPhim);

        String createLich = "create table if not exists tb_lich" +
                "( id  int auto_increment" +
                "        primary key," +
                "    phong_id int," +
                "    phim_id int," +
                "    khung_gio int," +
                "    ngay date null);";
        statement.executeUpdate(createLich);

        String createVe = "create table if not exists tb_ve" +
                "( id  int auto_increment" +
                "        primary key," +
                "    lich_id int," +
                "    user_id int," +
                "    hang int," +
                "    cot int);";
        statement.executeUpdate(createVe);

        String createUser = "create table if not exists tb_user" +
                "(id        int auto_increment" +
                "        primary key," +
                "    user_name varchar(50) charset utf8mb3  null," +
                "    pass_word varchar(100) charset utf8mb3 null," +
                "    full_name varchar(50) charset utf8mb3  null," +
                "    gender    smallint                     null," +
                "    birth     datetime                     null," +
                "    type     int                     null," +
                "    constraint table_name_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createUser);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dat_cho_xem_phim", "root", "123456");
        initTable();
//        initData();
        System.out.println("success !!!");
    }
}
