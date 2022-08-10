package btl.ui.layout;

import btl.Global;
import btl.component.ActionRouter;
import btl.db.manager.LichEntity;
import btl.ui.Header;
import btl.ui.WindowFrame;
import btl.ui.screen.ChonGhe;
import btl.ui.screen.DanhSachLich;
import btl.ui.screen.DanhSachPhim;

import java.awt.*;

public class UserLayout extends ActionRouter {
    private DanhSachPhim danhSachPhim;
    private DanhSachLich danhSachLich;
    private ChonGhe chonGhe;


    public UserLayout(WindowFrame windowFrame) {
        this.windowFrame = windowFrame;
//        listScreen.add(new TablePhong());
        danhSachPhim = new DanhSachPhim(this);
        add(new Header(this));
        add(danhSachPhim, 0);

        setSize(Global.WIDTH_SCREEN, Global.HEIGHT_SCREEN);
        setLayout(null);
    }

    @Override
    public void showDanhSachPhim() {
        remove(0);
        add(danhSachPhim, 0);
        repaint();
    }

    @Override
    public void showDanhSachLich(int index) {
        if (index < DanhSachPhim.listPhim.size()) {
            remove(0);
            danhSachLich = new DanhSachLich(
                    DanhSachPhim.listPhim.get(index).getId(), this);
            add(danhSachLich, 0);
            repaint();
        }
    }

    @Override
    public void showChonGhe(LichEntity lichEntity) {
        remove(0);
        chonGhe = new ChonGhe(this, lichEntity);
        add(chonGhe, 0);
        repaint();
    }

    @Override
    public void logout() {
        showDanhSachPhim();
        windowFrame.showLogin();
    }

    @Override
    public void goHome() {
        showDanhSachPhim();
    }
}
