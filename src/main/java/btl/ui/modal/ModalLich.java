package btl.ui.modal;

import btl.Global;
import btl.component.MyModal;
import btl.component.OptionSelect;
import btl.db.manager.LichEntity;
import btl.db.manager.LichManager;
import btl.db.manager.PhimManager;
import btl.db.manager.PhongManager;

import java.sql.Date;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class ModalLich extends MyModal<LichEntity, LichManager> {
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
//        addInputSelect(40, 210, "Thứ", Global.enumThu);
        addInputText(40, 210, "Ngày");

        setSize(300, 400);
        super.setup();
    }

    @Override
    public void onOk() throws SQLException {
        data.setPhongId(listInput.get(0).getInt());
        data.setPhimId(listInput.get(1).getInt());
        data.setKhungGio(listInput.get(2).getInt());
//        data.setThu(listInput.get(3).getInt());
        try {
            data.setNgay(Date.valueOf(listInput.get(3).getText()));
        } catch (IllegalArgumentException e) {
            showError("Vui lòng nhập ngày đúng dạng YYYY-MM-DD");
            return;
        }
        if(manager.findByPhimId(data)){
            showError("Lịch bị trùng");
            return;
        }
//        data.setPassword(listInput.get(1).getText());
//        data.setFullName(listInput.get(2).getText());
//        data.setBirth(listInput.get(4).getText());
//        try {
//            data.setGender(Short.parseShort(listInput.get(3).getText()));
//        } catch (NumberFormatException e) {
//            return;
//        }
        super.onOk();
        System.out.println("debugger");
    }

    @Override
    public void show(LichEntity entity) {
//        listInput.get(0).setText(entity.getTenPhong());
//        listInput.get(1).setText(entity.getTenPhim());
//        if (entity.getKhungGio() != null && 0 < entity.getKhungGio() && entity.getKhungGio() <= Global.sizeKhungGio) {
//            listInput.get(2).setText(Global.enumKhungGio[entity.getKhungGio() - 1].label);
//        }
//        listInput.get(3).setText(entity.getGender() != null
//                ? entity.getGender() == 1 ? "Nam" : "Nữ"
//                : "");
//        listInput.get(4).setText(entity.getBirth());
        super.show(entity);
    }
}
