package btl.db.manager;

import btl.db.base.BaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserManager extends BaseManager<UserEntity> {
    public UserManager() throws SQLException, ClassNotFoundException {
        super("tb_user");
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
        return Collections.singletonList(convertToEntities(getStatement().executeQuery(queryString)));
    }

    public void create(String firstName, String lastName, Short gender, String dob, Integer classId) throws SQLException {
        getStatement().executeUpdate("Insert into tb_user"
                + "(first_name, last_name, gender, DoB, classID)"
                + "values('" + firstName + "','" + lastName + "'," + gender + ",'" + dob + "', " + classId + ")");
    }

    public void createWithId(Integer id, String userName, String password, String fullName, Short gender, String birth, Integer type) throws SQLException {
        getStatement().executeUpdate("Insert into tb_user"
                + "(id, user_name, pass_word, full_name, gender, birth, type)"
                + "values(" + id + ",'" + userName + "','" + password + "','" + fullName + "'," + gender + ",'" + birth + "'," + type + ")");
    }

    @Override
    public String queryUpdate(UserEntity entity) {
        return "update tb_user" +
                " set user_name='" + entity.getUsername()
                + "',pass_word='" + entity.getPassword()
                + "',full_name='" + entity.getFullName()
                + "',gender=" + entity.getGender()
                + ",birth='" + entity.getBirth()
                + "',type=" + (entity.getUsername().equals("admin") ? 1 : 2)
                + " where id=" + entity.getId();
    }

    @Override
    public UserEntity convertToEntity(ResultSet resultSet) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getInt(1));
        userEntity.setUsername(resultSet.getString(2));
        userEntity.setPassword(resultSet.getString(3));
        userEntity.setFullName(resultSet.getString(4));
        userEntity.setGender(resultSet.getShort(5));
        userEntity.setBirth(resultSet.getString(6));
        userEntity.setType(resultSet.getInt(7));

        return userEntity;
    }

    public UserEntity findByUsername(String username) {
        try {
            return convertToEntityNext(
                    getStatement()
                            .executeQuery("select * from tb_user" +
                                    " where user_name='" + username + "'"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public List<List<?>> convertToList(ResultSet resultSet) throws SQLException {
//        List<List<?>> o = new ArrayList<>();
//        while (resultSet.next()) {
//            List<Object> output = new ArrayList<>();
//            output.add(resultSet.getInt(1));
//            output.add(resultSet.getString(2));
//            output.add(resultSet.getString(3));
//            output.add(resultSet.getString(4));
//            output.add(resultSet.getInt(5) == 1 ? "Nam" : "Nữ");
//            output.add(resultSet.getString(6));
//            o.add(output);
//        }
//        return o;
//    }


}
