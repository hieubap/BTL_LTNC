package btl.ui.layout;

import btl.Global;
import btl.component.InputText;
import btl.component.MyButton;
import btl.db.manager.UserEntity;
import btl.db.manager.UserManager;
import btl.ui.Header;
import btl.ui.WindowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginScreen extends JPanel implements ActionListener {
    private InputText usernameInput;
    private InputText passwordInput;

    private JLabel errorLabel;

    private MyButton buttonLogin;

    private WindowFrame windowFrame;

    private UserManager userManager;
    public LoginScreen(WindowFrame windowFrame) {
        this.windowFrame = windowFrame;
        try {
            userManager = new UserManager();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        JLabel jLabel = new JLabel("Username");
        jLabel.setBounds(700, 200, 200, 60);
        add(jLabel);

        usernameInput = new InputText();
        usernameInput.setBounds(700,250,200, 60);

        JLabel jLabel2 = new JLabel("Password");
        jLabel2.setBounds(700, 350, 200, 60);
        add(jLabel2);

        passwordInput = new InputText();
        passwordInput.setBounds(700,400,200, 60);

        errorLabel = new JLabel("Thông tin đăng nhập không chính xác");
        errorLabel.setBounds(650, 500, 500, 60);
        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Serif", Font.BOLD, 20));

        add(errorLabel);
        add(usernameInput);
        add(passwordInput);

        buttonLogin = new MyButton("Login");
        buttonLogin.setBounds(700,550,200, 60);
        buttonLogin.addActionListener(this);
        add(buttonLogin);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameInput.getText();
        if(username == null || username.equals("")){
            errorLabel.setText("Vui lòng nhập username và password");
            errorLabel.setVisible(true);
            return;
        }
        UserEntity userEntity = userManager.findByUsername(username);
        if(userEntity != null){
            if(userEntity.getPassword().equals(passwordInput.getText())){
                usernameInput.setText("");
                passwordInput.setText("");
                errorLabel.setText("Thông tin đăng nhập không chính xác");
                errorLabel.setVisible(false);
                if (userEntity.getType() == 1){
                    windowFrame.showAdmin(userEntity);
                }else{
                    windowFrame.showUser(userEntity);
                }
            }else{
                errorLabel.setText("Thông tin đăng nhập không chính xác");
                errorLabel.setVisible(true);
            }
        }
        repaint();
    }
}
