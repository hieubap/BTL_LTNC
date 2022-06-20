package btl.db.manager;

import btl.db.base.BaseQueryScript;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements BaseQueryScript {

    private Connection connection;
    private final Statement statement;

    public UserManager(Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }

    public List<List<?>> search(String className, Integer subjectId, String semesterCode, Boolean truot) throws SQLException {
        String queryString = "select *" +
                "from tb_user s" +
                "         join class c on s.classID = c.classID" +
                " where 1=1" +
                (className == null ? "" : " and c.class_name like '%" + className + "%'") +
                (subjectId != null ? "    and exists(select *" +
                        "             from mark m" +
                        "             where m.subjectID = " + subjectId +
                        "               and s.tb_userID = m.tb_userID" +
                        (truot == null ? "" : " and m.mark < 4") +
                        "               and m.semesterCode = '" + semesterCode + "')" : "");
        return convertToList(statement.executeQuery(queryString));
    }

    public List<List<?>> findAll() throws SQLException {
        return convertToList(statement.executeQuery("select * from tb_user"));
    }

    public void create(String firstName, String lastName, Short gender, String dob, Integer classId) throws SQLException {
        statement.executeUpdate("Insert into tb_user"
                + "(first_name, last_name, gender, DoB, classID)"
                + "values('" + firstName + "','" + lastName + "'," + gender + ",'" + dob + "', " + classId + ")");
    }

    public void createWithId(Integer id, String userName, String password, String fullName, Short gender, String birth) throws SQLException {
        statement.executeUpdate("Insert into tb_user"
                + "(id, user_name, pass_word, full_name, gender, birth)"
                + "values(" + id + ",'" + userName + "','" + password + "','" + fullName + "'," + gender + ",'" + birth + "')");
    }

    public void update(Integer tb_userId, String firstName, String lastName, Short gender, String dob, Integer classId) throws SQLException {
        statement.executeUpdate("update tb_user" +
                " set first_name='" + firstName
                + "',last_name='" + lastName
                + "',gender=" + gender
                + ",dob='" + dob
                + "',classID=" + classId
                + " where tb_userID=" + tb_userId);
    }

    public void delete(Integer id) throws SQLException {
        statement.executeUpdate("delete FROM tb_user where tb_userID=" + id);
    }

    public void deleteAll() throws SQLException {
        statement.executeUpdate("delete FROM tb_user where 1=1");
    }

    @Override
    public List<List<?>> convertToList(ResultSet resultSet) throws SQLException {
        List<List<?>> o = new ArrayList<>();
        while (resultSet.next()) {
            List<Object> output = new ArrayList<>();
            output.add(resultSet.getInt(1));
            output.add(resultSet.getString(2));
            output.add(resultSet.getString(3));
            output.add(resultSet.getString(4));
            output.add(resultSet.getInt(5) == 1 ? "Nam" : "Nữ");
            output.add(resultSet.getString(6));
            o.add(output);
        }
        return o;
    }
}
