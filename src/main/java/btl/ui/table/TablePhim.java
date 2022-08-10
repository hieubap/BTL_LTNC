package btl.ui.table;

import btl.component.MyTable;
import btl.db.manager.PhimEntity;
import btl.db.manager.PhimManager;
import btl.ui.modal.ModalPhim;

import java.util.ArrayList;
import java.util.List;

public class TablePhim extends MyTable<PhimEntity, PhimManager, ModalPhim> {
    @Override
    public String placeholder() {
        return "Tìm kiếm tên phim";
    }

    @Override
    public String[] getColumn() {
        return new String[]{"ID", "Tên phim", "Thời hạn","Action"};
    }

    @Override
    public List<?> mapToRow(PhimEntity e) {
        List<Object> list = new ArrayList<>();
        list.add(e.getId());
        list.add(e.getTen());
        list.add(e.getThoiHan());
        return list;
    }

    @Override
    public Integer[] getWidthCol() {
        int x = 90 / 2;
        return new Integer[]{5, x, x, 5};
    }

//    @Override
//    public PhimEntity getInstantEntity() {
//        return new PhimEntity();
//    }

//    @Override
//    public ModalPhim getInstantModal() {
//        return new ModalPhim(myManager, this);
//    }

//    @Override
//    public PhimManager getInstantManager() throws SQLException, ClassNotFoundException {
//        return new PhimManager(connection);
//    }
}
