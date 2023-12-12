import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pantalla2 {

    private JFrame frame;

    public Pantalla2() {
        initialize();
    }

    public void mostrarPantalla() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Panel con imagen de fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\Rubén\\eclipse-workspace\\Sportify\\src\\sportify.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setForeground(new Color(255, 255, 0));
        frame.setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);

        JLabel lblNombre = crearLabel("Nombre:", 65, 82);
        JLabel lblEmail = crearLabel("Email:", 65, 127);
        JLabel lblGenero = crearLabel("Género:", 65, 172);
        JLabel lblPassword = crearLabel("Password:", 65, 217);
        JLabel lblEdad = crearLabel("Edad:", 65, 262);

        JTextField nombreField = crearTextField(220, 82);
        JTextField emailField = crearTextField(220, 127);
        JComboBox<String> generoComboBox = crearGeneroComboBox(220, 172);
        JPasswordField passwordField = crearPasswordField(220, 217);
        JSlider edadSlider = crearEdadSlider(220, 262);

        JCheckBox aceptoCheckbox = new JCheckBox("Acepto los términos y condiciones");
        aceptoCheckbox.setForeground(new Color(255, 0, 0));
        aceptoCheckbox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        aceptoCheckbox.setBounds(65, 337, 250, 20);
        backgroundPanel.add(aceptoCheckbox);

        JButton registroButton = new JButton("Registro");
        registroButton.setForeground(new Color(255, 0, 0));
        registroButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registroButton.setBounds(65, 392, 150, 40);
        backgroundPanel.add(registroButton);

        JLabel lblUsername = new JLabel("Regístrate");
        lblUsername.setForeground(new Color(255, 255, 0));
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblUsername.setBounds(159, 11, 134, 40);
        backgroundPanel.add(lblUsername);

        // Etiqueta para mostrar el valor del slider
        JLabel lblEdadValor = new JLabel("40"); // Inicializado en 40 para reflejar el cambio en el slider
        lblEdadValor.setForeground(new Color(255, 0, 0));
        lblEdadValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEdadValor.setBounds(450, 262, 40, 20);
        backgroundPanel.add(lblEdadValor);

        // Agrega un ChangeListener al slider para actualizar la etiqueta
        edadSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblEdadValor.setText(String.valueOf(edadSlider.getValue()));
            }
        });

        // Agregar acción al botón de registro
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar si todos los campos están llenos antes de procesar el registro
                if (nombreField.getText().isEmpty() || emailField.getText().isEmpty() ||
                    generoComboBox.getSelectedItem() == null || 
                    new String(passwordField.getPassword()).isEmpty()) {
                    
                    // Mostrar mensaje de error en un popup
                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar rellenos", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Aquí puedes agregar la lógica para procesar el registro

                    // Después de procesar el registro, pasamos a la pantalla 3
                    Pantalla3 pantalla3 = new Pantalla3();
                    pantalla3.mostrarPantalla();

                    // Cerramos la pantalla actual (Pantalla2)
                    frame.dispose();
                }
            }
        });
    }

    private JLabel crearLabel(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setForeground(new Color(255, 255, 0));
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl.setBounds(x, y, 122, 20);
        frame.getContentPane().add(lbl);
        return lbl;
    }

    private JTextField crearTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 220, 20);
        frame.getContentPane().add(textField);
        return textField;
    }

    private JComboBox<String> crearGeneroComboBox(int x, int y) {
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Hombre", "Mujer"});
        comboBox.setForeground(new Color(255, 0, 0));
        comboBox.setBounds(x, y, 220, 20);
        frame.getContentPane().add(comboBox);
        return comboBox;
    }

    private JPasswordField crearPasswordField(int x, int y) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, 220, 20);
        frame.getContentPane().add(passwordField);
        return passwordField;
    }

    private JSlider crearEdadSlider(int x, int y) {
        JSlider edadSlider = new JSlider(40, 99); // Modificado para que comience en 40
        edadSlider.setBounds(x, y, 220, 20);
        frame.getContentPane().add(edadSlider);
        return edadSlider;
    }
}


    
