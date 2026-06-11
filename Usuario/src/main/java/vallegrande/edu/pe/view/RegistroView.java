package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class RegistroView extends JFrame {

    public JTextField txtUsuario;
    public JPasswordField txtPassword;

    public JButton btnGuardar;
    public JButton btnVolver;

    public RegistroView() {

        setTitle("Registro de Usuario");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color fondo = new Color(245,235,220);
        Color marron = new Color(139,94,60);

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBackground(fondo);

        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        btnGuardar = new JButton("Registrar");
        btnVolver = new JButton("Volver");

        btnGuardar.setBackground(marron);
        btnGuardar.setForeground(Color.WHITE);

        btnVolver.setBackground(marron);
        btnVolver.setForeground(Color.WHITE);

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);

        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);

        panel.add(btnGuardar);
        panel.add(btnVolver);

        add(panel);
    }
}