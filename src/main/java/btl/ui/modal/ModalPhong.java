package btl.ui.modal;

import btl.component.MyModal;
import btl.db.manager.PhongEntity;
import btl.db.manager.PhongManager;

import java.sql.SQLException;

public class ModalPhong extends MyModal<PhongEntity, PhongManager> {

//    public ModalPhong(JFrame frame, PhongManager manager, MyTable<PhongEntity,PhongManager,ModalPhong> myTable) {
//        super(frame, manager,myTable);
//    }

    public void setup(){
        setSize(300,200);

        addInputText(40,0,"Tên phòng");

        super.setup();
    }

    @Override
    public void onOk() throws SQLException {
        data.setTen(listInput.get(0).getText());
        super.onOk();
    }

    @Override
    public void show(PhongEntity entity) {
        listInput.get(0).setText(entity.getTen());
        super.show(entity);
    }
}
