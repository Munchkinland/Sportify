import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Pantalla5 {

    private JFrame frame;

    public Pantalla5() {
        initialize();
    }

    public void mostrarPantalla() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
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
        frame.setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Mis Reservas");
        lblTitulo.setForeground(new Color(255, 255, 0));
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTitulo.setBounds(150, 30, 200, 30);
        backgroundPanel.add(lblTitulo);

        JLabel lblActivas = new JLabel("Activas:");
        lblActivas.setForeground(new Color(255, 255, 0));
        lblActivas.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblActivas.setBounds(65, 80, 150, 20);
        backgroundPanel.add(lblActivas);

        JComboBox<String> activasComboBox = new JComboBox<>();
        activasComboBox.setBackground(new Color(255, 255, 255));
        activasComboBox.setForeground(new Color(255, 0, 0));
        activasComboBox.setBounds(220, 80, 200, 20);
        backgroundPanel.add(activasComboBox);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setForeground(new Color(255, 0, 0));
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnModificar.setBounds(65, 150, 150, 40);
        backgroundPanel.add(btnModificar);

        JButton btnAnular = new JButton("Anular");
        btnAnular.setForeground(new Color(255, 0, 0));
        btnAnular.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAnular.setBounds(65, 219, 355, 40);
        backgroundPanel.add(btnAnular);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setForeground(new Color(255, 0, 0));
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalir.setBounds(253, 150, 167, 40);
        backgroundPanel.add(btnSalir);

        // Cargar las reservas activas al iniciar la pantalla
        cargarReservasActivas(activasComboBox);

        // Agregar acción al botón Modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la descripción de la reserva seleccionada
                String descripcionReserva = (String) activasComboBox.getSelectedItem();

                // Abre la pantalla 4 con los detalles de la reserva seleccionada
                Pantalla4 pantalla4 = new Pantalla4();
                pantalla4.mostrarPantalla();

                // Cerrar la pantalla actual (Pantalla5)
                frame.dispose();
            }
        });

        // Agregar acción al botón Anular
        btnAnular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la descripción de la reserva seleccionada
                String descripcionReserva = (String) activasComboBox.getSelectedItem();

                // Anular la reserva
                GestionReservas.anularReserva(descripcionReserva);

                // Actualizar la lista de reservas activas
                cargarReservasActivas(activasComboBox);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(frame, "Reserva anulada correctamente");
            }
        });

        // Agregar acción al botón Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la aplicación
                System.exit(0);
            }
        });
    }

    // Método para cargar las reservas activas en el JComboBox
    private void cargarReservasActivas(JComboBox<String> comboBox) {
        // Limpiar el ComboBox
        comboBox.removeAllItems();

        // Obtener las reservas activas
        List<Reserva> reservasActivas = GestionReservas.obtenerReservasActivas();

        // Agregar las reservas activas al ComboBox
        for (Reserva reserva : reservasActivas) {
            comboBox.addItem(reserva.toString());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pantalla5 window = new Pantalla5();
                    window.mostrarPantalla();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

