import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla1 {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton forgotPasswordButton;
    private JButton signUpButton;
    private JButton loginButton;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pantalla1 window = new Pantalla1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pantalla1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un JPanel con la imagen de fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\Rubén\\eclipse-workspace\\Sportify\\src\\sportify.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        frame.setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);

        // Crear componentes
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        forgotPasswordButton = new JButton("Olvidé mi contraseña");
        forgotPasswordButton.setForeground(new Color(255, 0, 0));
        forgotPasswordButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        signUpButton = new JButton("Sign Up");
        signUpButton.setForeground(new Color(255, 0, 0));
        signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        loginButton = new JButton("Login");
        loginButton.setForeground(new Color(255, 0, 0));
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

        // Agregar etiquetas al formulario
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(new Color(255, 255, 0));
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(65, 128, 122, 20);
        backgroundPanel.add(lblUsername);

        JLabel lblPassword_1 = new JLabel("Password:");
        lblPassword_1.setForeground(new Color(255, 255, 0));
        lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword_1.setBounds(65, 161, 101, 20);
        backgroundPanel.add(lblPassword_1);

        JLabel lblUsername_1 = new JLabel("!Bienvenid@!");
        lblUsername_1.setForeground(new Color(255, 255, 0));
        lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblUsername_1.setBounds(162, 30, 197, 40);
        backgroundPanel.add(lblUsername_1);

        // Agregar componentes al formulario
        usernameField.setBounds(220, 128, 220, 20);
        backgroundPanel.add(usernameField);

        passwordField.setBounds(220, 165, 220, 20);
        backgroundPanel.add(passwordField);

        forgotPasswordButton.setBounds(290, 235, 150, 20);
        backgroundPanel.add(forgotPasswordButton);

        signUpButton.setBounds(65, 300, 150, 40);
        backgroundPanel.add(signUpButton);

        loginButton.setBounds(290, 300, 150, 40);
        backgroundPanel.add(loginButton);

        // Agregar acción a los botones
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Funcionalidad de recuperación de contraseña no implementada");
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la Pantalla2 al hacer clic en el botón "Sign Up"
                Pantalla2 pantalla2 = new Pantalla2();
                pantalla2.mostrarPantalla(); // Muestra la Pantalla2

                // También puedes ocultar la Pantalla1 si lo deseas
                frame.setVisible(false);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí podrías agregar la lógica de autenticación
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Agrega aquí la lógica de autenticación según tus necesidades
                JOptionPane.showMessageDialog(frame, "Funcionalidad de inicio de sesión no implementada");
            }
        });
    }
}


