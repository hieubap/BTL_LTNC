package btl.db.manager;

import btl.db.base.BaseEntity;

import java.sql.Date;

public class LichEntity extends BaseEntity {
    private Integer id;

    private Integer phongId;

    private String tenPhong;
    private Integer phimId;

    private String tenPhim;
    private Integer khungGio;

    private Integer thu;

    private Date ngay;

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    private Integer conSlot;

    public Integer getThu() {
        return thu;
    }

    public void setThu(Integer thu) {
        this.thu = thu;
    }

    public Integer getConSlot() {
        return conSlot;
    }

    public void setConSlot(Integer conSlot) {
        this.conSlot = conSlot;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhongId() {
        return phongId;
    }

    public void setPhongId(Integer phongId) {
        this.phongId = phongId;
    }

    public Integer getPhimId() {
        return phimId;
    }

    public void setPhimId(Integer phimId) {
        this.phimId = phimId;
    }

    public Integer getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(Integer khungGio) {
        this.khungGio = khungGio;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

}
