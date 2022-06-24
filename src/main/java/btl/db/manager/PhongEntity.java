package btl.db.manager;

import btl.db.base.BaseEntity;

public class PhongEntity extends BaseEntity {
    private Integer id;

    private String ten;

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


}
