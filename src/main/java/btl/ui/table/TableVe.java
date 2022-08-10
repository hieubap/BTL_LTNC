package btl.ui.table;

import btl.Global;
import btl.component.ActionRouter;
import btl.component.MyTable;
import btl.db.manager.VeEntity;
import btl.db.manager.VeManager;
import btl.ui.modal.ModalVe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class TableVe extends MyTable<VeEntity, VeManager, ModalVe> {
    private ActionRouter actionRouter;

    public TableVe() {
        super();
    }

    public TableVe(int x, int y, int id, ActionRouter actionRouter) {
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
        return new String[]{"ID", "Phòng", "Phim", "Thứ", "Thời gian", "Vị trí", "Action"};
    }

    @Override
    public Integer[] getWidthCol() {
        return new Integer[]{10, 15, 15, 15, 15, 15, 15};
    }

    @Override
    public List<?> mapToRow(VeEntity e) {
        List<Object> list = new ArrayList<>();
        list.add(e.getId());
        list.add(e.getLichEntity().getTenPhong());
        list.add(e.getLichEntity().getTenPhim());

        if (e.getLichEntity().getThu() != null && 0 < e.getLichEntity().getThu() && e.getLichEntity().getThu() <= 7) {
            list.add(Global.enumThu[e.getLichEntity().getThu() - 1].label);
        } else {
            list.add("");
        }

        if (0 < e.getLichEntity().getKhungGio() && e.getLichEntity().getKhungGio() <= Global.sizeKhungGio) {
            list.add(Global.enumKhungGio[e.getLichEntity().getKhungGio() - 1].label);
        } else {
            list.add("");
        }

        list.add(('A' + e.getHang()) + "" + ('0' + e.getCot()));
        return list;
    }


    @Override
    public void loadData() throws SQLException {
        if (id == 0) {
            super.loadData();
        } else {
            afterLoadData(myManager.findByUserId(id));
        }
    }

    @Override
    public int clickRowBtn(int row) {
        if (id == 0)
            return super.clickRowBtn(row);
        else {
//            actionRouter.showChonGhe(listData.get(row));
            return 0;
        }
    }
}
