package btl.ui.table;

import btl.component.MyTable;
import btl.db.manager.PhongEntity;
import btl.db.manager.PhongManager;
import btl.ui.WindowFrame;
import btl.ui.modal.ModalPhong;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablePhong extends MyTable<PhongEntity, PhongManager, ModalPhong> {

    @Override
    public String[] getColumn() {
        return new String[]{"ID", "Tên phòng","Action"};
    }

    @Override
    public Integer[] getWidthCol() {
        return new Integer[]{10, 80, 10};
    }
    @Override
    public List<?> mapToRow(PhongEntity e) {
        List<Object> list = new ArrayList<>();
        list.add(e.getId());
        list.add(e.getTen());
        return list;
    }
}
