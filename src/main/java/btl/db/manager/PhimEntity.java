package btl.db.manager;

import btl.db.base.BaseEntity;

public class PhimEntity extends BaseEntity {
    private Integer id;

    private String ten;

    // phút
    private Integer thoiHan = 0;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Integer thoiHan) {
        this.thoiHan = thoiHan;
    }
}
