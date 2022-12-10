package quan.ly.sinh.vien.ui;

import quan.ly.sinh.vien.db.QueryUser;
import quan.ly.sinh.vien.MainApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JPanel implements ActionListener {
    private JTextField usernameInput;
    private JPasswordField passwordInput;

    private JLabel errorLabel;

    private JButton buttonLogin;

    private WindowFrame windowFrame;

    private QueryUser queryUser;

    public LoginScreen(WindowFrame windowFrame) {
      this.windowFrame = windowFrame;
      queryUser = new QueryUser();
      int left = MainApplication.Global.WIDTH_SCREEN/2 - MainApplication.Global.WIDTH_CONTENT/2;
      int top = 180;

      JLabel jLabel = new JLabel("Username");
      jLabel.setBounds(left, top, 200, 60);
      add(jLabel);

      usernameInput = new JTextField();
      usernameInput.setBounds(left,top+40, MainApplication.Global.WIDTH_CONTENT, MainApplication.Global.HEIGHT_CONTENT);

      JLabel jLabel2 = new JLabel("Password");
      jLabel2.setBounds(left, top + 100, 200, 60);
      add(jLabel2);

      passwordInput = new JPasswordField();
      passwordInput.setBounds(left,  top + 140, MainApplication.Global.WIDTH_CONTENT, MainApplication.Global.HEIGHT_CONTENT);


      errorLabel = new JLabel("Thông tin đăng nhập không chính xác");
      errorLabel.setBounds(left - 50, top + 190, 500, 60);
      errorLabel.setVisible(false);
      errorLabel.setForeground(Color.RED);
      errorLabel.setFont(new Font("Serif", Font.BOLD, 16));

      add(errorLabel);
      add(usernameInput);
      add(passwordInput);

      buttonLogin = new JButton("Login");
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
      List<String> type = queryUser.search(username,true);
      if (type != null) {
        if (type.get(1).equals(String.valueOf(passwordInput.getPassword()))) {
          usernameInput.setText("");
          passwordInput.setText("");
          errorLabel.setText("Thông tin đăng nhập không chính xác");
          errorLabel.setVisible(false);
          if (type.get(0).equals("1")) {
            windowFrame.showAdmin();
          }else{
            errorLabel.setText("Bạn không phải là admin");
            errorLabel.setVisible(true);
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
      g.fillRect(0, 0, MainApplication.Global.WIDTH_SCREEN, MainApplication.Global.HEIGHT_SCREEN / 2);
      g.setColor(new Color(0xffffff));
      g.fillRect(MainApplication.Global.WIDTH_SCREEN/2 - MainApplication.Global.WIDTH_LOGIN/2,
          MainApplication.Global.HEIGHT_SCREEN/2 - MainApplication.Global.HEIGHT_LOGIN/2,
          MainApplication.Global.WIDTH_LOGIN,
          MainApplication.Global.HEIGHT_LOGIN);

      g.setFont(new Font("Serif", Font.BOLD, MainApplication.Global.SIZE_NAME));
      g.drawString("QUẢN LÝ SINH VIÊN", MainApplication.Global.POS_NAME_X, MainApplication.Global.POS_NAME_Y);
    }
}
