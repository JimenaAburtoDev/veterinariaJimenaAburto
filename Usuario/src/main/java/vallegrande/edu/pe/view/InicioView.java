package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class InicioView extends JFrame {

    public InicioView() {

        setTitle("Sistema Veterinaria");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color fondo = new Color(245, 235, 220);
        Color marron = new Color(139, 94, 60);
        Color marronOscuro = new Color(92, 64, 51);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(fondo);

        JLabel titulo = new JLabel(
                "SISTEMA VETERINARIA",
                JLabel.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );

        titulo.setForeground(marronOscuro);

        JLabel descripcion = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Sistema desarrollado con Java MVC<br>"
                        + "</div></html>",
                JLabel.CENTER
        );

        descripcion.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        JButton btnIngresar = new JButton(
                "Ingresar al Sistema"
        );

        btnIngresar.setBackground(marron);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);

        btnIngresar.addActionListener(e -> {

            MascotaView vista = new MascotaView();

            new vallegrande.edu.pe.controller.MascotaController(vista);

            vista.setVisible(true);

            dispose();
        });

        JPanel centro = new JPanel(
                new GridLayout(2, 1, 10, 10)
        );

        centro.setBackground(fondo);

        centro.add(descripcion);
        centro.add(btnIngresar);

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(centro, BorderLayout.CENTER);

        add(panel);
    }
}