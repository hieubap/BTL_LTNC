package btl.component;

import btl.db.base.BaseEntity;
import btl.db.base.BaseManager;
import btl.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MyModal<Entity extends BaseEntity,
        Manager extends BaseManager<Entity>> extends JDialog {
    protected Entity data = null;

    public int width = 300;
    public int height = 200;

    public Manager manager;

    public ActionTable actionTable;

//    public MyTable<Entity,Manager, MyModal<Entity,Manager>> myTable;

    protected JLabel errorLabel;

    public List<JLabel> listLabel = new ArrayList<>();
    public List<InputScript> listInput = new ArrayList<>();

    public MyModal() {
        super();
        setSize(width, height);
        setTitle("Thêm mới");

        setup();

        Container dialogContainer = getContentPane();
        dialogContainer.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JButton okButton = new JButton("Ok");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onOk();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        errorLabel = new JLabel("Lỗi",SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        panel1.add(errorLabel,BorderLayout.NORTH);
        panel1.add(okButton,BorderLayout.SOUTH);
        dialogContainer.add(panel1, BorderLayout.SOUTH);
    }

//    public MyModal(Manager manager, ActionTable myTable) {
////        super(frame, "Thêm mới", Dialog.ModalityType.DOCUMENT_MODAL);
//        this.manager = manager;
//        this.myTable = myTable;
////        setBounds(132, 132, 300, 200);
//    }

    public void setup() {
        setLocationRelativeTo(null);
        setLayout(null);
        for (JLabel label : listLabel) {
            add(label);
        }
        for (InputScript textField : listInput) {
            add(textField);
        }
    }

    public void show(Entity entity){
        data = entity;
        setVisible(true);
    }
    public void showError(String text){
        errorLabel.setText(text);
        errorLabel.setVisible(true);
    }

    public void onOk() throws SQLException {
        if(data.getId() == null){
            manager.create(data);
        }else{
            manager.update(data);
        }
        resetData();
        actionTable.loadData();
    }

    public void resetData() {
        for (InputScript textField : listInput) {
            textField.setText("");
        }


        errorLabel.setVisible(false);
        setVisible(false);
    }

    public void addTitle(int x, int y, String title, InputScript input) {
        JLabel jLabel = new JLabel(title);
        jLabel.setBounds(x, y, Global.WIDTH_INPUT, Global.HEIGHT_INPUT);
        listLabel.add(jLabel);

        input.setBounds(x, y + Global.HEIGHT_LABEL, Global.WIDTH_INPUT, Global.HEIGHT_INPUT);
        listInput.add(input);
    }

    public void addInputText(int x, int y, String title) {
        addTitle(x, y, title,new InputText());
    }

    public void addInputEnum(int x, int y, String title, List<OptionSelect> list) {
        addTitle(x, y, title,new InputSelect(list));
    }

    public void addInputEnum(int x, int y, String title, OptionSelect[] list) {
        addTitle(x, y, title,new InputSelect(list));
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ActionTable getActionTable() {
        return actionTable;
    }

    public void setActionTable(ActionTable actionTable) {
        this.actionTable = actionTable;
    }
}
