package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.LoginController;
import vallegrande.edu.pe.controller.MascotaController;
import vallegrande.edu.pe.controller.ReportesController;

import javax.swing.*;
import java.awt.*;

public class InicioView extends JFrame {

    public InicioView() {

        setTitle("Sistema Veterinaria");
        setSize(500, 350);
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

        titulo.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                22
        ));

        titulo.setForeground(marronOscuro);

        JLabel descripcion = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Sistema desarrollado con Java MVC<br>"
                        + "Gestión de Mascotas y Reportes"
                        + "</div></html>",
                JLabel.CENTER
        );

        descripcion.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        JButton btnIngresar =
                new JButton("Ingresar al Sistema");

        btnIngresar.setBackground(marron);
        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.addActionListener(e -> {

            MascotaView vista =
                    new MascotaView();

            new MascotaController(vista);

            vista.setVisible(true);

            dispose();
        });

        JButton btnReporte =
                new JButton("Ver Reporte Mascotas");

        btnReporte.setBackground(marron);
        btnReporte.setForeground(Color.WHITE);

        btnReporte.addActionListener(e -> {

            try {

                ReportesController reporte =
                        new ReportesController();

                reporte.verReporte();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Error al generar reporte:\n"
                                + ex.getMessage()
                );

                ex.printStackTrace();
            }

        });

        JButton btnCerrarSesion =
                new JButton("Cerrar Sesión");

        btnCerrarSesion.setBackground(marronOscuro);
        btnCerrarSesion.setForeground(Color.WHITE);

        btnCerrarSesion.addActionListener(e -> {

            LoginView login =
                    new LoginView();

            new LoginController(login);

            login.setVisible(true);

            dispose();
        });

        JPanel centro =
                new JPanel(
                        new GridLayout(
                                4,
                                1,
                                10,
                                10
                        )
                );

        centro.setBackground(fondo);

        centro.add(descripcion);
        centro.add(btnIngresar);
        centro.add(btnReporte);
        centro.add(btnCerrarSesion);

        panel.add(
                titulo,
                BorderLayout.NORTH
        );

        panel.add(
                centro,
                BorderLayout.CENTER
        );

        add(panel);
    }
}