package quan.ly.hoc.sinh.db.parent;

import quan.ly.hoc.sinh.db.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateInitData {
    public static String[] arrHo = {"Ngô", "Phạm", "Trần", "Lê", "Hồ", "Tạ", "Nguyễn", "Võ"};
    public static String[] arrTen = {"An", "Bình", "Cường", "Dương", "Hiếu", "Kiên", "Trung", "Yến"};

    List<QueryMonHoc> queryMonHocs;

    public CreateInitData() {
        queryMonHocs = new ArrayList<>();
        queryMonHocs.add(new QueryToan());
        queryMonHocs.add(new QueryVan());
        queryMonHocs.add(new QueryAnh());
        queryMonHocs.add(new QuerySu());

    }

    public void initData() throws SQLException, ClassNotFoundException {
        QueryUser queryUser = new QueryUser();

        // xóa toàn bộ dữ liệu hiện tại
        queryUser.deleteAll();
        for (QueryMonHoc q : queryMonHocs){
            q.deleteAll();
        }

        Random random = new Random();
        // tạo random sinh vin
        List<String> randomNames = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            randomNames.add(arrHo[(int) (random.nextDouble() * 7)] + " " +
                    arrTen[(int) (random.nextDouble() * 7)]);
        }
        for (int i = 0; i < randomNames.size(); i++) {
            int j = i;
            queryUser.create(
                    new ArrayList<String>(){{
                        add("user"+j);
                        add("123");
                        add(randomNames.get(j));
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

        for(QueryMonHoc q : queryMonHocs){
            for (int j = 0; j < randomNames.size(); j++) {
                int k = j;
                q.create(new ArrayList<String>(){{
                            add(randomNames.get(k));
                            add("" + (int)(Math.random()*10));
                            add("" + (int)(Math.random()*10));
                            add("" + (int)(Math.random()*10));
                        }});
            }

        }


    }

    public void initTable() throws SQLException, ClassNotFoundException {
        Connection connection = Connector.connection;
        Statement statement = connection.createStatement();
        for (QueryMonHoc q : queryMonHocs){
            String createPhong = "create table if not exists " + q.getTableName() +
                    "( id  int auto_increment" +
                    "        primary key," +
                    "    full_name varchar(50) charset utf8mb3 null," +
                    "    giua_ky varchar(5) charset utf8mb3 null," +
                    "    cuoi_ky varchar(5) charset utf8mb3 null," +
                    "    vang varchar(5) charset utf8mb3 null," +
                    "    constraint "+q.getTableName()+"_id_uindex" +
                    "        unique (id));";
            statement.executeUpdate(createPhong);
        }

        String createUser = "create table if not exists tb_user" +
                "(id        int auto_increment" +
                "        primary key," +
                "    user_name varchar(50) charset utf8mb3  null," +
                "    pass_word varchar(100) charset utf8mb3 null," +
                "    full_name varchar(50) charset utf8mb3  null," +
                "    gender    varchar(50) charset utf8mb3  null," +
                "    type     int                     null," +
                "    constraint table_name_id_uindex" +
                "        unique (id));";
        statement.executeUpdate(createUser);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dat_cho_xem_phim", "root", "123456");
        CreateInitData createInitData = new CreateInitData();
        createInitData.initTable();
        createInitData.initData();
        System.out.println("success !!!");
    }
}
