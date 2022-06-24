package btl.db.manager;

import btl.db.base.BaseEntity;

public class VeEntity extends BaseEntity {
    private Integer id;

    private Integer lichId;

    private Integer userId;

    private int hang;

    private int cot;

    private LichEntity lichEntity;

    public LichEntity getLichEntity() {
        return lichEntity;
    }

    public void setLichEntity(LichEntity lichEntity) {
        this.lichEntity = lichEntity;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLichId() {
        return lichId;
    }

    public void setLichId(Integer lichId) {
        this.lichId = lichId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public int getCot() {
        return cot;
    }

    public void setCot(int cot) {
        this.cot = cot;
    }
}
