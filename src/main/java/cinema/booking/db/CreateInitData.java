package cinema.booking.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class CreateInitData {
    public static String[] arrHo = {"Ngô", "Phạm", "Trần", "Lê", "Hồ", "Tạ", "Nguyễn", "Võ"};
    public static String[] arrTen = {"An", "Bình", "Cường", "Dương", "Hiếu", "Kiên", "Trung", "Yến"};
    public static String[] dataPhim = {
        "Vua sư tử - Lion King",
        "Seri Nữ hoàng băng giá - Series Frozen",
        "Seri Câu chuyện đồ chơi - Series Toy Story",
        "Raya và Rồng thần cuối cùng - Raya and the Last Dragon",
        "Công chúa tóc mây - Tangled",
        "Đi tìm Dory - Finding Dory",
        "Chuột đầu bếp - Ratatouille",
        "Vút bay - Up",
        "Hành trình của Moana - Moana",
        "Biệt đội Big Hero 6 - Big Hero 6",
        "Ráp-phờ đập phá - Wreck it Ralph",
        "Cuộc sống nhiệm màu - Soul",
        "Rô-bốt biết yêu - WALL-E",
        "Gia đình siêu nhân - The Incredibles",
        "Cậu bé rừng xanh Tarzan - Tarzan",
        "Laputa: Lâu đài trên không - Laputa: Castle In The Sky",
        "Mộ Đom Đóm - Grave of the Fireflies",
        "Hàng xóm tôi là Totoro - Totoro",
        "Công Chúa Sói Mononoke - Princess Mononoke",
        "Sen và Chihiro ở thế giới thần bí - Spirited Away",
        "Lâu đài Di động của Pháp sư Howl - Howl's Moving Castle",
        "Lời thì thầm của trái tim - Whisper of the heart",
        "Lạc vào khu rừng đom đóm - Into the Forest of Fireflies Light",
        "5 Centimet trên giây - 5 centimeters per second",
        "Tên của cậu là gì - Your name",
        "Học viện anh hùng: Anh hùng trỗi dậy - My Hero Academia: Heroes Rising",
        "Seri Thanh gươm diệt quỷ - TV Series Demon Slayer",
        "Seri Naruto - TV Series Naruto",
        "Seri Đại chiến Người và Thần - TV series Record Of Ragnarok",
        "Seri Đảo Hải Tặc - TV Series One Piece",
        "Seri Khuyển Dọa Xoa - TV series Inuyasha",
        "Huyền thoại La Tiểu Hắc - The Legend of Hei",
        "Kung Fu Gấu Trúc 3 - Kung Fu Panda 3",
        "Tiểu Môn Thần - Little Door Gods",
        "Tây Du Ký: Đại Thánh trở về - Monkey King: Hero is back",
        "Bạch Xà: Duyên Khởi - White Snake",
        "Na Tra: Ma đồng giáng thế - Nezha",
        "Khương Tử Nha - Legend of Deification",
        "Seri Đấu Phá Thương Khung - TV Series Battle through the heavens (2017)",
        "Seri Nhật ký thường ngày của Tiên Vương - TV series The Daily Life Of The Immortal King"
};

    public static void initData() throws SQLException, ClassNotFoundException {
        QueryUser queryUser = new QueryUser();
        QueryPhim queryPhim = new QueryPhim();
        QueryPhong queryPhong = new QueryPhong();

        // xóa toàn bộ dữ liệu hiện tại
        queryUser.deleteAll();
        queryPhong.deleteAll();
        queryPhim.deleteAll();
        Random random = new Random();
        // tạo dữ liệu người dùng
        // vì xóa hết dữ liệu bảng nên hoàn toàn có thể tạo student với id tự set mà ko sợ trùng
        for (int i = 0; i < 50; i++) {
            int ii = i;
            queryUser.create(
                new ArrayList<String>(){{
                    add("user"+ii);
                    add("123");
                    add(arrHo[(int) (random.nextDouble() * 7)] + " " +
                            arrTen[(int) (random.nextDouble() * 7)]);
                    add("Nam");
                    add("2");
                }});
        }
        queryUser.create(
            new ArrayList<String>(){{
                add("admin");
                add("123");
                add("Khánh");
                add("Nam");
                add("1");
            }});
//                userManager.createWithId(1,
//                "admin",
//                "123",
//                "Ngô Quang Hiếu",
//                (short) 1,
//                "2000-01-01",
//                1);

        int[] randoms = new int[]{80,85,90,95,100};

        for (int i = 0; i < 20; i++) {
            int i2 = i;
            queryPhong.create(new ArrayList<String>(){{
                    add("Phòng " + (char) ('A' + i2));
                    add(String.valueOf(randoms[(int)(Math.random()*5)]));
                }});
        }
        for (int i = 0; i < 15; i++) {
            int i2 = i;
            queryPhim.create(new ArrayList<String>(){{
                add(dataPhim[i2]);
                add("Hoạt hình");
                add(String.valueOf(randoms[(int)(Math.random()*5)]));
                add("Gene Deitch");
            }});
        }
    }

    public static void initTable() throws SQLException, ClassNotFoundException {
        Connection connection = Connector.connection;
        Statement statement = connection.createStatement();
        String createPhong = "create table if not exists tb_phong" +
                "( id  int auto_increment" +
                "        primary key," +
                "    ten varchar(50) charset utf8mb3 null," +
                "    so_ghe int," +
                "    constraint tb_phong_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createPhong);

        String createPhim = "create table if not exists tb_phim" +
                "( id  int auto_increment" +
                "        primary key," +
                "    ten varchar(100) charset utf8mb3 null," +
                "    the_loai varchar(50) charset utf8mb3 null," +
                "    thoi_luong int," +
                "    tac_gia varchar(50) charset utf8mb3 null," +
                "    constraint tb_phim_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createPhim);

        String createUser = "create table if not exists tb_user" +
                "(id        int auto_increment" +
                "        primary key," +
                "    user_name varchar(50) charset utf8mb3  null," +
                "    pass_word varchar(100) charset utf8mb3 null," +
                "    full_name varchar(50) charset utf8mb3  null," +
                "    gender    smallint                     null," +
                "    type     int                     null," +
                "    constraint table_name_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createUser);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dat_cho_xem_phim", "root", "123456");
        initTable();
        initData();
        System.out.println("success !!!");
    }
}
