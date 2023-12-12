import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla4 {

    private JFrame frame;
    private JComboBox<String> deporteComboBox;
    private JComboBox<String> localidadComboBox;
    private JComboBox<String> turnoComboBox;

    public Pantalla4() {
        initialize();
    }

    public void mostrarPantalla() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(255, 0, 0));
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

        JLabel lblDeporte = new JLabel("Deporte:");
        lblDeporte.setForeground(new Color(255, 255, 0));
        lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDeporte.setBounds(65, 80, 150, 20);
        backgroundPanel.add(lblDeporte);

        deporteComboBox = new JComboBox<>(new String[]{"Futbol", "Futbol Sala", "Tenis", "Padel", "Basket"});
        deporteComboBox.setBackground(new Color(255, 255, 255));
        deporteComboBox.setForeground(new Color(255, 0, 0));
        deporteComboBox.setBounds(220, 80, 200, 20);
        backgroundPanel.add(deporteComboBox);

        JLabel lblLocalidad = new JLabel("Localidad:");
        lblLocalidad.setForeground(new Color(255, 255, 0));
        lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLocalidad.setBounds(65, 130, 150, 20);
        backgroundPanel.add(lblLocalidad);

        localidadComboBox = new JComboBox<>(new String[]{"Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao"});
        localidadComboBox.setForeground(new Color(255, 0, 0));
        localidadComboBox.setBounds(220, 130, 200, 20);
        backgroundPanel.add(localidadComboBox);

        JLabel lblTurno = new JLabel("Turno:");
        lblTurno.setForeground(new Color(255, 255, 0));
        lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTurno.setBounds(65, 180, 150, 20);
        backgroundPanel.add(lblTurno);

        turnoComboBox = new JComboBox<>(new String[]{"Mañana", "Tarde"});
        turnoComboBox.setForeground(new Color(255, 0, 0));
        turnoComboBox.setBounds(220, 180, 200, 20);
        backgroundPanel.add(turnoComboBox);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setForeground(new Color(255, 0, 0));
        btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCalcular.setBounds(65, 234, 120, 40);
        backgroundPanel.add(btnCalcular);

        JButton btnBorrarPreferencias = new JButton("Borrar Preferencias");
        btnBorrarPreferencias.setForeground(new Color(255, 0, 0));
        btnBorrarPreferencias.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBorrarPreferencias.setBounds(200, 234, 220, 40);
        backgroundPanel.add(btnBorrarPreferencias);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.setForeground(new Color(255, 0, 0));
        btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnReservar.setBounds(65, 289, 355, 52);
        backgroundPanel.add(btnReservar);

        // Agregar acción al botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcular precio aleatorio entre 3 y 20 euros
                double precio = Math.random() * (20 - 3) + 3;

                // Mostrar mensaje con el precio de la reserva
                JOptionPane.showMessageDialog(frame, "Precio de la reserva: " + String.format("%.2f", precio) + " euros");
            }
        });

        // Agregar acción al botón Borrar Preferencias
        btnBorrarPreferencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para borrar preferencias
                JOptionPane.showMessageDialog(frame, "Preferencias borradas");
            }
        });

        // Agregar acción al botón Reservar
        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores seleccionados
                String deporte = (String) deporteComboBox.getSelectedItem();
                String localidad = (String) localidadComboBox.getSelectedItem();
                String turno = (String) turnoComboBox.getSelectedItem();

                // Calcular precio aleatorio entre 3 y 20 euros
                double precio = Math.random() * (20 - 3) + 3;

                // Crear la reserva
                Reserva reserva = new Reserva(deporte, localidad, turno, precio);

                // Almacenar la reserva como activa en segundo plano
                GestionReservas.agregarReserva(reserva);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(frame, "Reserva realizada correctamente");

                // Avanzar a la pantalla 5
                Pantalla5 pantalla5 = new Pantalla5();
                pantalla5.mostrarPantalla();

                // Cerrar la pantalla actual (Pantalla4)
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        // Crear una instancia de Pantalla4 y mostrarla
        Pantalla4 pantalla4 = new Pantalla4();
        pantalla4.mostrarPantalla();
    }
}

