package btl.db.base;

import java.sql.SQLException;
import java.util.List;

public interface BaseQueryScript<Entity extends BaseEntity> {

    List<Entity> search(Entity entity) throws SQLException;

    int create(Entity entity) throws SQLException;

    int update(Entity entity) throws SQLException;

    List<Entity> findAll() throws SQLException;

    Entity getById(Integer id) throws SQLException;

    void deleteAll() throws SQLException;

    void delete(Integer id) throws SQLException;
}
