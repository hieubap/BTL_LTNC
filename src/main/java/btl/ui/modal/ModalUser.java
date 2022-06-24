package btl.ui.modal;

import btl.component.MyModal;
import btl.db.manager.UserEntity;
import btl.db.manager.UserManager;

import java.sql.Date;
import java.sql.SQLException;

public class ModalUser extends MyModal<UserEntity, UserManager> {

    public void setup() {
        setSize(300, 450);

        addInputText(40, 0, "Username");
        addInputText(40, 70, "Password");
        addInputText(40, 140, "Fullname");
        addInputText(40, 210, "Gender");
        addInputText(40, 280, "Birth (YYYY-MM-DD HH:mm:ss)");

        super.setup();
    }

    @Override
    public void onOk() throws SQLException {
        data.setUsername(listInput.get(0).getText());
        data.setPassword(listInput.get(1).getText());
        data.setFullName(listInput.get(2).getText());
        try {
            data.setGender(Short.parseShort(listInput.get(3).getText()));
        } catch (NumberFormatException e) {
            showError("Nhập giới tính là 1(nam) hoặc 2(nữ)");
            return;
        }

        String dateString = listInput.get(4).getText();
        super.onOk();
    }

    @Override
    public void show(UserEntity entity) {
        listInput.get(0).setText(entity.getUsername());
        listInput.get(1).setText(entity.getPassword());
        listInput.get(2).setText(entity.getFullName());
        listInput.get(3).setText(entity.getGender() != null
                ? entity.getGender() == 1 ? "Nam" : "Nữ"
                : "");
        listInput.get(4).setText(entity.getBirth());
        super.show(entity);
    }
}
