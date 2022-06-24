package btl.ui.table;

import btl.component.MyTable;
import btl.db.manager.UserEntity;
import btl.db.manager.UserManager;
import btl.ui.modal.ModalUser;

import java.util.ArrayList;
import java.util.List;

public class TableUser extends MyTable<UserEntity, UserManager, ModalUser> {
    @Override
    public String[] getColumn() {
        return new String[]{"ID", "Username", "Password", "Họ tên", "Giới tính", "Ngày sinh", "Action"};
    }

    @Override
    public Integer[] getWidthCol() {
        int x = 90 / 5;
        return new Integer[]{5, x, x, x, x, x, 5};
    }

    @Override
    public List<?> mapToRow(UserEntity e) {
        List<Object> list = new ArrayList<>();
        list.add(e.getId());
        list.add(e.getUsername());
        list.add(e.getPassword());
        list.add(e.getFullName());
        list.add(e.getGender() == 1 ? "Nam" : "Nữ");
        list.add(e.getBirth());
        return list;
    }
}
