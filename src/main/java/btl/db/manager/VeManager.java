package btl.db.manager;

import btl.db.base.BaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VeManager extends BaseManager<VeEntity> {

    private LichManager lichManager;

    public VeManager() throws SQLException, ClassNotFoundException {
        super("tb_ve");
        lichManager = new LichManager();
    }

    @Override
    public VeEntity convertToEntity(ResultSet resultSet) throws SQLException {
        VeEntity veEntity = new VeEntity();
        veEntity.setId(resultSet.getInt(1));
        int idLich = resultSet.getInt(2);
        veEntity.setLichId(idLich);
        veEntity.setUserId(resultSet.getInt(3));
        veEntity.setHang(resultSet.getInt(4));
        veEntity.setCot(resultSet.getInt(5));
        veEntity.setLichEntity(lichManager.getById(idLich));
        return veEntity;
    }

    public List<VeEntity> findByLichId(Integer lichId) throws SQLException {
        return convertToEntities(
                getStatement().executeQuery(
                        "select * from tb_ve" +
                                " where lich_id=" + lichId));
    }

    public List<VeEntity> findByUserId(Integer userId) throws SQLException {
        return convertToEntities(
                getStatement().executeQuery(
                        "select * from tb_ve" +
                                " where user_id=" + userId));
    }

    @Override
    public String queryCreate(VeEntity entity) {
        return "Insert into tb_ve"
                + "(lich_id, user_id, hang, cot)"
                + "values(" + entity.getLichId()
                + "," + entity.getUserId()
                + "," + entity.getHang()
                + "," + entity.getCot() + ")";
    }
}
