package btl.ui.table;

import btl.component.MyTable;
import btl.db.manager.UserManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TableUser extends MyTable {
    private UserManager studentManager;

    public TableUser(Connection connection) throws SQLException {
        this.studentManager = new UserManager(connection);
        List<List<?>> data = studentManager.findAll();
        // Column Names
        String[] columnNames = {"ID", "Họ", "Tên", "Giới Tính", "Ngày sinh", "Lớp"};

        JTable jTable = new JTable(convertToArr(data), columnNames);
        setup(jTable);
    }
}
