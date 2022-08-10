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
import btl.Global;

public class LoginScreen extends JPanel implements ActionListener {
    private InputText usernameInput;
    private JPasswordField passwordInput;

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
        int left = Global.WIDTH_SCREEN/2 - Global.WIDTH_CONTENT/2;
        int top = 280;

        JLabel jLabel = new JLabel("Username");
        jLabel.setBounds(left, top, 200, 60);
        add(jLabel);

        usernameInput = new InputText();
        usernameInput.setBounds(left,top+40, Global.WIDTH_CONTENT, Global.HEIGHT_CONTENT);

        JLabel jLabel2 = new JLabel("Password");
        jLabel2.setBounds(left, top + 100, 200, 60);
        add(jLabel2);

        passwordInput = new JPasswordField();
        passwordInput.setBounds(left,  top + 140, Global.WIDTH_CONTENT, Global.HEIGHT_CONTENT);


        errorLabel = new JLabel("Thông tin đăng nhập không chính xác");
        errorLabel.setBounds(left - 50, top + 190, 500, 60);
        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Serif", Font.BOLD, 18));

        add(errorLabel);
        add(usernameInput);
        add(passwordInput);

        buttonLogin = new MyButton("Login");
        buttonLogin.setBounds(left, top + 250, 200, 60);
        buttonLogin.addActionListener(this);
        add(buttonLogin);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameInput.getText();
        if (username == null || username.equals("")) {
            errorLabel.setText("Vui lòng nhập username và password");
            errorLabel.setVisible(true);
            return;
        }
        UserEntity userEntity = userManager.findByUsername(username);
        if (userEntity != null) {
            if (userEntity.getPassword().equals(String.valueOf(passwordInput.getPassword()))) {
                usernameInput.setText("");
                passwordInput.setText("");
                errorLabel.setText("Thông tin đăng nhập không chính xác");
                errorLabel.setVisible(false);
                if (userEntity.getType() == 1) {
                    windowFrame.showAdmin(userEntity);
                } else {
                    windowFrame.showUser(userEntity);
                }
            } else {
                errorLabel.setText("Thông tin đăng nhập không chính xác");
                errorLabel.setVisible(true);
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0xef4444));
        g.fillRect(0, 0, Global.WIDTH_SCREEN, Global.HEIGHT_SCREEN / 2);
        g.setColor(new Color(0xffffff));
        g.fillRect(Global.WIDTH_SCREEN/2 - Global.WIDTH_LOGIN/2,
                Global.HEIGHT_SCREEN/2 - Global.HEIGHT_LOGIN/2,
                Global.WIDTH_LOGIN,
                Global.HEIGHT_LOGIN);

        g.setFont(new Font("Serif", Font.BOLD, Global.SIZE_NAME));
        g.drawString("QUẢN LÝ RẠP CHIẾU PHIM",Global.POS_NAME_X,Global.POS_NAME_Y);
    }
}
