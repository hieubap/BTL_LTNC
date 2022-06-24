package btl.db.manager;

import btl.db.base.BaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LichManager extends BaseManager<LichEntity> {
    private PhongManager phongManager;
    private PhimManager phimManager;

    public LichManager() throws ClassNotFoundException, SQLException {
        super("tb_lich");
        phongManager = new PhongManager();
        phimManager = new PhimManager();
    }

    @Override
    public LichEntity convertToEntity(ResultSet resultSet) throws SQLException {
        LichEntity entity = new LichEntity();
        entity.setId(resultSet.getInt(1));
        int idPhong = resultSet.getInt(2);
        entity.setPhongId(idPhong);
        int idPhim = resultSet.getInt(3);
        entity.setPhimId(idPhim);
        entity.setKhungGio(resultSet.getInt(4));
        entity.setThu(resultSet.getInt(5));
        PhongEntity phongEntity = phongManager.getById(idPhong);
        if(phongEntity != null){
            entity.setTenPhong(phongEntity.getTen());
        }
        PhimEntity phimEntity = phimManager.getById(idPhim);
        if(phimEntity != null){
            entity.setTenPhim(phimEntity.getTen());
        }
        return entity;
    }

    @Override
    public String queryCreate(LichEntity entity) {
        return "Insert into tb_lich"
                + "(phong_id, phim_id, khung_gio, thu)"
                + "values(" + entity.getPhongId()
                + "," + entity.getPhimId()
                + "," + entity.getKhungGio()
                + "," + entity.getThu() + ")";
    }

    @Override
    public String queryUpdate(LichEntity entity) {
        return "update tb_lich" +
                " set phong_id=" + entity.getPhongId()
                + ",phim_id=" + entity.getPhimId()
                + ",khung_gio=" + entity.getKhungGio()
                + ",thu=" + entity.getThu()
                + " where id=" + entity.getId();
    }

    public List<LichEntity> findByPhimId(Integer phimId) throws SQLException {
        return convertToEntities(
                getStatement().executeQuery(
                        "select * from tb_lich" +
                                " where phim_id=" + phimId));
    }
}
