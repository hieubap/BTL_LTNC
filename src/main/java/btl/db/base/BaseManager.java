package btl.db.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BaseManager<Entity extends BaseEntity> implements BaseQueryScript {
    private final Statement statement;
    private String tableName;

    public BaseManager(String tableName, Statement statement) {
        this.statement = statement;
        this.tableName = tableName;
    }

    @Override
    public List<List<?>> convertToList(ResultSet resultSet) throws SQLException {
        return null;
    }

    public void deleteAll() throws SQLException {
        statement.executeUpdate("delete FROM " + tableName + " where 1=1");
    }

    @Override
    public void delete(Integer id) throws SQLException {
        statement.executeUpdate("delete FROM " + tableName + " where id=" + id);
    }
}
