package btl.component;

import btl.Global;
import btl.db.base.BaseEntity;
import btl.db.base.BaseManager;
import btl.ui.Header;
import btl.ui.SideBar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MyTable<Entity extends BaseEntity,
        Manager extends BaseManager<Entity>,
        Modal extends MyModal<Entity, Manager>> extends JPanel
        implements ActionTable {
    protected MyButton buttonCreate;

    protected MyButton buttonSearch;

    protected InputText inputTimKiem;

    protected Modal myModal;

    protected Manager myManager;

    protected List<Entity> listData;

    protected boolean ignoreCreate = false;

    protected int id;

    protected int
            x = SideBar.WIDTH_SIDEBAR,
            y = Header.HEIGHT_HEADER;

    public MyTable() {
        try {
            setup();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MyTable(int x, int y, int id) {
        this.id = id;
        this.ignoreCreate = true;
        this.x = x;
        this.y = y;
        try {
            setup();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setup() throws SQLException {
        myManager = getInstantManager();
        myModal = getInstantModal();
        myModal.setManager(myManager);
        myModal.setActionTable(this);

        loadData();
        if (!this.ignoreCreate) {
            renderComponent();
        }
    }

    public <T> T getInstantGeneric(int index) {
        Class<?> c = null;
        try {
            c = Class.forName(
                    ((ParameterizedType) this.getClass().getGenericSuperclass())
                            .getActualTypeArguments()[index].getTypeName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return (T) c.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                 | NoSuchMethodException ex) {
        }
//        try {
//            return (T) c.getConstructor(Connection.class).newInstance(connection);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
//                 | NoSuchMethodException ex) {
//        }
        return null;
    }

    public Entity getInstantEntity() {
        return getInstantGeneric(0);
    }

    public Manager getInstantManager() {
        return getInstantGeneric(1);
    }

    public Modal getInstantModal() {
        return getInstantGeneric(2);
    }

    public abstract String[] getColumn();

    public abstract List<?> mapToRow(Entity list);

    public abstract Integer[] getWidthCol();


    public void renderComponent() {
        inputTimKiem = new InputText(placeholder());
        inputTimKiem.setBounds(120, 10, 500, 30);

        buttonSearch = new MyButton("Tìm");
        buttonSearch.setBounds(620, 10, 100, 30);
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    search(inputTimKiem.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        buttonCreate = new MyButton("Thêm mới");
        buttonCreate.setBounds(10, 10, 100, 30);
        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myModal.show(getInstantEntity());
            }
        });
        add(inputTimKiem);
        add(buttonSearch);
        add(buttonCreate);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {

        private boolean ignoreCreate;

        public ButtonRenderer(boolean ignoreCreate) {
            this.ignoreCreate = ignoreCreate;
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText(this.ignoreCreate ? "Chọn" : "Sửa");
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {

        private ActionTable actionTable;

        private boolean ignoreCreate;

        public ButtonEditor(boolean ignoreCreate, JCheckBox checkBox, ActionTable actionTable) {
            super(checkBox);
            this.actionTable = actionTable;
            this.ignoreCreate = ignoreCreate;
            System.out.println(ignoreCreate);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            return new ButtonTable(this.ignoreCreate ? "Chọn" : "Sửa", row, actionTable);
        }

    }

    public static class MyJTable extends JTable {

        public MyJTable(Object[][] convertToArr, String[] column) {
            super(convertToArr, column);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return getColumnCount() == column + 1;
        }

    }

    @Override
    public int clickRowBtn(int row) {
        System.out.println("action edit on " + row);
        myModal.show(listData.get(row));
        return 0;
    }

    public void loadData() throws SQLException {
        afterLoadData(myManager.findAll());
    }

    public void search(String text) throws SQLException {
        Entity e = getInstantEntity();
        e.setTextSearch(text);
        afterLoadData(myManager.search(e));
    }

    public void afterLoadData(List<Entity> list) {
        this.listData = list;
        List<List<?>> data = list.stream()
                .map(this::mapToRow)
                .collect(Collectors.toList());
        DefaultTableModel model = new DefaultTableModel(Global.convertToListArr(data), getColumn());
        JTable jTable = new MyJTable(Global.convertToListArr(data), getColumn());
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setModel(model);
        jTable.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        jTable.setRowHeight(50);
        jTable.getColumn("Action").setCellRenderer(new ButtonRenderer(this.ignoreCreate));
        jTable.getColumn("Action").setCellEditor(new ButtonEditor(this.ignoreCreate, new JCheckBox(), this));

        if (getComponentCount() > 0) {
            remove(0);
        }
        setup(jTable);
        setLayout(null);
    }

    public void setup(JTable jTable) {
        // Initializing the JTable
        double perW = (double) (Global.WIDTH_SCREEN - SideBar.WIDTH_SIDEBAR - Global.TABLE_PADDING*2 - 35) / 100;
        for (int i = 0; i < getWidthCol().length; i++) {
            jTable
                    .getColumnModel()
                    .getColumn(i)
                    .setPreferredWidth((int) (getWidthCol()[i] * perW));
        }
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBounds(Global.TABLE_PADDING, y,
                Global.WIDTH_SCREEN - SideBar.WIDTH_SIDEBAR - Global.TABLE_PADDING*2 - 20,
                Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER - Global.TABLE_PADDING*2 - Global.TABLE_HEIGHT_HEAD);

        setBounds(x, y,
                Global.WIDTH_SCREEN - SideBar.WIDTH_SIDEBAR,
                Global.HEIGHT_SCREEN - Header.HEIGHT_HEADER);
        add(sp, 0);
    }

    public String placeholder(){
        return "Tìm kiếm";
    }
}
