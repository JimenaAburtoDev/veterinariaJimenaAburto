package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class InicioView extends JFrame {

    public InicioView() {

        setTitle("Sistema - Veterinaria");

        setSize(500, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ICONO
        Image icono = Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/icono.png")
        );

        setIconImage(icono);

        // COLORES
        Color fondo = new Color(245,235,220);

        Color marron = new Color(139,94,60);

        Color marronOscuro = new Color(92,64,51);

        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(fondo);

        // TITULO
        JLabel titulo = new JLabel(
                "SISTEMA VETERINARIA",
                JLabel.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 24)
        );

        titulo.setForeground(marronOscuro);

        // IMAGEN
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource("/img/perrito.png")
        );

        Image imagen = iconoOriginal.getImage()
                .getScaledInstance(
                        120,
                        120,
                        Image.SCALE_SMOOTH
                );

        JLabel logo = new JLabel(
                new ImageIcon(imagen)
        );

        logo.setHorizontalAlignment(JLabel.CENTER);

        // DESCRIPCIÓN
        JLabel descripcion = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Sistema desarrollado con Java MVC<br>"
                        + "Gestión de mascotas y veterinaria"
                        + "</div></html>",
                JLabel.CENTER
        );

        descripcion.setFont(
                new Font("Segoe UI", Font.PLAIN, 15)
        );

        // BOTON
        JButton btnIngresar = new JButton(
                "Ingresar al Sistema"
        );

        btnIngresar.setBackground(marron);

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusPainted(false);

        btnIngresar.addActionListener(e -> {

            MascotaView vista = new MascotaView();

            new vallegrande.edu.pe.controller
                    .MascotaController(vista);

            vista.setVisible(true);

            dispose();
        });

        // CENTRO
        JPanel centro = new JPanel(
                new GridLayout(3,1,10,10)
        );

        centro.setBackground(fondo);

        centro.add(logo);

        centro.add(descripcion);

        centro.add(btnIngresar);

        // FOOTER
        JLabel footer = new JLabel(
                "Desarrollado con Java MVC",
                JLabel.CENTER
        );

        footer.setForeground(marronOscuro);

        panel.add(titulo, BorderLayout.NORTH);

        panel.add(centro, BorderLayout.CENTER);

        panel.add(footer, BorderLayout.SOUTH);

        add(panel);
    }
}