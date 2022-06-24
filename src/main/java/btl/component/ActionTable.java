package btl.component;

import java.sql.SQLException;

public interface ActionTable {
    // xử lý show popup tại mỗi dòng khi ấn update
    int event(int row);

    // reload sau khi submit
    void loadData() throws SQLException;
}
