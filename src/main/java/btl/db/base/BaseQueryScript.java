package btl.db.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BaseQueryScript {
    List<List<?>> convertToList(ResultSet resultSet) throws SQLException;


    void deleteAll() throws SQLException;

    void delete(Integer id) throws SQLException;
}
