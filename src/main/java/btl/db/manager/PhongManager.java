package btl.db.manager;

import btl.db.base.BaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongManager extends BaseManager<PhongEntity> {

    public PhongManager() throws ClassNotFoundException, SQLException {
        super("tb_phong");
    }

    @Override
    public PhongEntity convertToEntity(ResultSet resultSet) throws SQLException {
        PhongEntity phongEntity = new PhongEntity();
        phongEntity.setId(resultSet.getInt(1));
        phongEntity.setTen(resultSet.getString(2));
        return phongEntity;
    }


    public void createWithId(Integer id, String ten) throws SQLException {
        getStatement().executeUpdate("Insert into tb_phong"
                + "(id, ten)"
                + "values(" + id + ",'" + ten + "')");
    }

    @Override
    public String queryCreate(PhongEntity entity) {
        return "Insert into tb_phong"
                + "(ten)"
                + "values('" + entity.getTen() + "')";
    }

    @Override
    public String queryUpdate(PhongEntity entity) {
        return "update tb_phong" +
                " set ten='" + entity.getTen()
                + "' where id=" + entity.getId();
    }
}
