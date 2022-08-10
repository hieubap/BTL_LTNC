package btl.db.base;

import btl.db.ConnectDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseManager<Entity extends BaseEntity> implements BaseQueryScript<Entity> {
    protected final Statement statement;
    protected String tableName;

    public BaseManager(String tableName) throws ClassNotFoundException, SQLException {
        this.statement = ConnectDb.connection.createStatement();
        this.tableName = tableName;
    }

    public Statement getStatement() {
        return statement;
    }

    public String querySearch(Entity entity) {
        return "select * from " + tableName;
    }

    public String queryUpdate(Entity entity) {
        return "delete * from " + tableName + " where 1=2";
    }

    public String queryCreate(Entity entity) {
        return "delete * from " + tableName + " where 1=2";
    }

    @Override
    public List<Entity> search(Entity entity) throws SQLException {
        String s = querySearch(entity);
        System.out.println(s);
        return convertToEntities(statement.executeQuery(s));
    }

    @Override
    public int create(Entity entity) throws SQLException {
        String s = queryCreate(entity);
        System.out.println(s);
        return getStatement().executeUpdate(s);
    }

    @Override
    public int update(Entity entity) throws SQLException {
        String s = queryUpdate(entity);
        System.out.println(s);
        return getStatement().executeUpdate(s);
    }

    @Override
    public List<Entity> findAll() throws SQLException {
        return convertToEntities(statement.executeQuery("select * from " + tableName));
    }

    @Override
    public Entity getById(Integer id) throws SQLException {
        return convertToEntityNext(statement.executeQuery("select * from " + tableName + " where id=" + id));
    }

    public void deleteAll() throws SQLException {
        statement.executeUpdate("delete FROM " + tableName + " where 1=1");
    }

    @Override
    public void delete(Integer id) throws SQLException {
        statement.executeUpdate("delete FROM " + tableName + " where id=" + id);
    }


    public abstract Entity convertToEntity(ResultSet resultSet) throws SQLException;

    public Entity convertToEntityNext(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) return null;
        return convertToEntity(resultSet);
    }
    public List<Entity> convertToEntities(ResultSet resultSet) throws SQLException {
        List<Entity> entities = new ArrayList<>();
        while (resultSet.next()) {
            entities.add(convertToEntity(resultSet));
        }
        return entities;
    }
}
