import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla3 {

    private JFrame frame;
    private JComboBox<String> deporteComboBox;
    private JComboBox<String> nivelComboBox;
    private JComboBox<String> ubicacionComboBox;

    public Pantalla3() {
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

        JLabel lblTitulo = new JLabel("Mis Preferencias");
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
        deporteComboBox.setForeground(new Color(255, 0, 0));
        deporteComboBox.setBounds(220, 80, 200, 20);
        backgroundPanel.add(deporteComboBox);

        JLabel lblNivel = new JLabel("Nivel:");
        lblNivel.setForeground(new Color(255, 255, 0));
        lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNivel.setBounds(65, 130, 150, 20);
        backgroundPanel.add(lblNivel);

        nivelComboBox = new JComboBox<>(new String[]{"Principiante", "Intermedio", "Profesional"});
        nivelComboBox.setForeground(new Color(255, 0, 0));
        nivelComboBox.setBounds(220, 130, 200, 20);
        backgroundPanel.add(nivelComboBox);

        JLabel lblUbicacion = new JLabel("Ubicación:");
        lblUbicacion.setForeground(new Color(255, 255, 0));
        lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUbicacion.setBounds(65, 180, 150, 20);
        backgroundPanel.add(lblUbicacion);

        ubicacionComboBox = new JComboBox<>(new String[]{"Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao"});
        ubicacionComboBox.setForeground(new Color(255, 0, 0));
        ubicacionComboBox.setBounds(220, 180, 200, 20);
        backgroundPanel.add(ubicacionComboBox);

        JButton btnBorrarPreferencias = new JButton("Borrar Preferencias");
        btnBorrarPreferencias.setForeground(new Color(255, 0, 0));
        btnBorrarPreferencias.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBorrarPreferencias.setBounds(65, 250, 200, 40);
        backgroundPanel.add(btnBorrarPreferencias);

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setForeground(new Color(255, 0, 0));
        btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSiguiente.setBounds(300, 250, 120, 40);
        backgroundPanel.add(btnSiguiente);

        // Agregar acción al botón Borrar Preferencias
        btnBorrarPreferencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para borrar preferencias y resetear valores
                deporteComboBox.setSelectedIndex(0);
                nivelComboBox.setSelectedIndex(0);
                ubicacionComboBox.setSelectedIndex(0);
                
                JOptionPane.showMessageDialog(frame, "Preferencias borradas");
            }
        });

        // Agregar acción al botón Siguiente
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pasar a la pantalla 4
                Pantalla4 pantalla4 = new Pantalla4();
                pantalla4.mostrarPantalla();

                // Cerrar la pantalla actual (Pantalla3)
                frame.dispose();
            }
        });
    }
}



