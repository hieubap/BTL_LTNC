package btl.db.base;

import java.sql.ResultSet;

public abstract class BaseEntity {
    public abstract Integer getId();
    public String textSearch = "";

    public BaseEntity() {
    }
    public void setTextSearch(String text){
        this.textSearch = text;
    }
}
