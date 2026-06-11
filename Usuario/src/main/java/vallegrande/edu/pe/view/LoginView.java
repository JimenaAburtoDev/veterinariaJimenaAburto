package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField txtUsuario;
    public JPasswordField txtPassword;

    public JButton btnIngresar;
    public JButton btnRegistrar;

    public LoginView() {

        setTitle("Login - Veterinaria");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color fondo = new Color(245,235,220);
        Color marron = new Color(139,94,60);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));
        panel.setBackground(fondo);

        JLabel titulo = new JLabel("INICIO DE SESIÓN");
        titulo.setHorizontalAlignment(JLabel.CENTER);

        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        btnIngresar = new JButton("Ingresar");
        btnRegistrar = new JButton("Registrarse");

        btnIngresar.setBackground(marron);
        btnIngresar.setForeground(Color.WHITE);

        btnRegistrar.setBackground(marron);
        btnRegistrar.setForeground(Color.WHITE);

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);

        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);

        panel.add(btnIngresar);
        panel.add(btnRegistrar);

        add(titulo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}