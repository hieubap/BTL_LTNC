package btl.ui.table;

import btl.Global;
import btl.component.ActionRouter;
import btl.component.MyTable;
import btl.db.manager.LichEntity;
import btl.db.manager.LichManager;
import btl.ui.modal.ModalLich;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class TableLich extends MyTable<LichEntity, LichManager, ModalLich> {
    private ActionRouter actionRouter;

    public TableLich() {
        super();
    }

    public TableLich(int x, int y, int id, ActionRouter actionRouter) {
        super(x, y, id);
        this.actionRouter = actionRouter;
    }

    @Override
    public void setup() throws SQLException {
        if (id == 0)
            super.setup();
        else {
            myManager = getInstantManager();
            try {
                loadData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String[] getColumn() {
        return new String[]{"ID", "Phòng", "Phim", "Thời gian", "Ngày", "Action"};
    }

    @Override
    public Integer[] getWidthCol() {
        return new Integer[]{10, 20, 20, 20, 20, 10};
    }

    @Override
    public List<?> mapToRow(LichEntity e) {
        List<Object> list = new ArrayList<>();
        list.add(e.getId());
        list.add(e.getTenPhong());
        list.add(e.getTenPhim());
        if (e.getKhungGio() != null && 0 < e.getKhungGio() && e.getKhungGio() <= Global.sizeKhungGio) {
            list.add(Global.enumKhungGio[e.getKhungGio() - 1].label);
        } else {
            list.add("");
        }
        if (e.getNgay() != null) {
            list.add(e.getNgay());
        } else {
            list.add("");
        }
        return list;
    }


    @Override
    public void loadData() throws SQLException {
        if (id == 0) {
            super.loadData();
        } else {
            afterLoadData(myManager.findByPhimId(id));
        }
    }

    @Override
    public int event(int row) {
        if (id == 0)
            return super.event(row);
        else {
            actionRouter.showChonGhe(listData.get(row));
            return 0;
        }
    }
}
