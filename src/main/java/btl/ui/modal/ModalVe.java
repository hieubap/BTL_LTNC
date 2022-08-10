package btl.ui.modal;

import btl.Global;
import btl.component.MyModal;
import btl.component.OptionSelect;
import btl.db.manager.*;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class ModalVe extends MyModal<VeEntity, VeManager> {
    private PhongManager phongManager;
    private PhimManager phimManager;

    public void setup() {
        try {
            phongManager = new PhongManager();

            addInputEnum(40, 0, "Phòng",
                    phongManager.findAll()
                            .stream().map(
                                    i -> new OptionSelect(i.getId(), i.getTen()))
                            .collect(Collectors.toList()));

            phimManager = new PhimManager();

            addInputEnum(40, 70, "Phim",
                    phimManager.findAll()
                            .stream().map(
                                    i -> new OptionSelect(i.getId(), i.getTen()))
                            .collect(Collectors.toList()));

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        addInputEnum(40, 140, "Khung giờ", Global.enumKhungGio);

        setSize(300, 300);
        super.setup();
    }
}
