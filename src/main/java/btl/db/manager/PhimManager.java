package btl.db.manager;

import btl.db.base.BaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhimManager extends BaseManager<PhimEntity> {
    public PhimManager() throws ClassNotFoundException, SQLException {
        super("tb_phim");
    }

    @Override
    public PhimEntity convertToEntity(ResultSet resultSet) throws SQLException {
        PhimEntity phimEntity = new PhimEntity();
        phimEntity.setId(resultSet.getInt(1));
        phimEntity.setTen(resultSet.getString(2));
        phimEntity.setThoiHan(resultSet.getInt(3));
        return phimEntity;
    }

    public void createWithId(Integer id, String ten, String thoiHan) throws SQLException {
        getStatement().executeUpdate("Insert into tb_phim"
                + "(id, ten, thoi_han)"
                + "values(" + id + ",'" + ten + "','" + thoiHan + "')");
    }

    /**
     * public List<PhimEntity> search(PhimEntity entity) throws SQLException {
     *         String s = "select * from " + tableName + " where ten like '%" + entity.textSearch + "%'";
     *         return convertToEntities(statement.executeQuery(s));
     *     }
     */

    @Override
    public String querySearch(PhimEntity entity) {
        return "select * from " + tableName + " where ten like '%" + entity.textSearch + "%'";
    }

    @Override
    public String queryCreate(PhimEntity entity) {
        return "Insert into tb_phim"
                + "(ten, thoi_han)"
                + "values('" + entity.getTen() + "'," + entity.getThoiHan() + ")";
    }

    @Override
    public String queryUpdate(PhimEntity entity) {
        return "update tb_phim" +
                " set ten='" + entity.getTen()
                + "',thoi_han=" + entity.getThoiHan()
                + " where id=" + entity.getId();
    }
}
