package btl.ui.modal;

import btl.component.MyModal;
import btl.db.manager.PhimEntity;
import btl.db.manager.PhimManager;

import java.sql.SQLException;

public class ModalPhim extends MyModal<PhimEntity, PhimManager> {
//    public ModalPhim(PhimManager manager, MyTable<PhimEntity, PhimManager, ModalPhim> myTable) {
//        super(manager, myTable);
//    }

    public void setup() {
        setSize(300, 250);

        addInputText(40, 0, "Tên phim");
        addInputText(40, 70, "Thời hạn");

        super.setup();
    }

    @Override
    public void onOk() throws SQLException {
        data.setTen(listInput.get(0).getText());
        try {
            data.setThoiHan(Integer.parseInt(listInput.get(1).getText()));
        } catch (NumberFormatException e) {
            showError("Vui lòng nhập thời hạn đúng dạng số");
            return;
        }
        super.onOk();
    }

    @Override
    public void show(PhimEntity entity) {
        listInput.get(0).setText(entity.getTen());
        listInput.get(1).setText(entity.getThoiHan() + "");
        super.show(entity);
    }
}
