package btl.ui;

import btl.db.ConnectDb;
import btl.ui.layout.AdminLayout;
import btl.ui.table.TableUser;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class WindowFrame extends JFrame {
    private ConnectDb connectDb;
    private List<JComponent> listRoute;
    private AdminLayout adminLayout;

    public WindowFrame() throws HeadlessException, SQLException, ClassNotFoundException {
//        adminLayout = new AdminLayout();

        connectDb = new ConnectDb();
        // Data to be displayed in the JTable
        add(new Header());
        add(new SideBar());
        add(new TableUser(connectDb.getConnection()));

        setTitle("JTable Example");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showLogin(){

    }

    public void showAdmin(){

    }
}
