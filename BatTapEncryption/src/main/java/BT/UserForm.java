package BT;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm {
    private UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {
        new UserForm().createGUI();
    }

    public void createGUI() {
        JFrame frame = new JFrame("User Registration and Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 100, 25);
        frame.add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 50, 150, 25);
        frame.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 100, 25);
        frame.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 100, 150, 25);
        frame.add(txtPassword);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(50, 150, 100, 25);
        frame.add(btnRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 150, 100, 25);
        frame.add(btnLogin);

        JLabel lblMessage = new JLabel("");
        lblMessage.setBounds(50, 200, 300, 25);
        frame.add(lblMessage);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if (userDAO.register(username, password)) {
                    lblMessage.setText("Registration successful!");
                } else {
                    lblMessage.setText("Registration failed!");
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if (userDAO.login(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login successful! Welcome!");
                } else {
                    lblMessage.setText("Login failed!");
                }
            }
        });

        frame.setVisible(true);
    }
}
