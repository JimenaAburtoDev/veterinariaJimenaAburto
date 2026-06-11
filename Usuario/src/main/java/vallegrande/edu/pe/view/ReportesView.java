package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class ReportesView extends JFrame {

    public JButton btnVerReporte;
    public JButton btnExportarPDF;
    public JButton btnCerrar;

    public ReportesView() {

        setTitle("Reportes de Mascotas");
        setSize(500,300);
        setLocationRelativeTo(null);

        Color fondo = new Color(245,235,220);
        Color marron = new Color(139,94,60);

        JPanel panel = new JPanel(
                new GridLayout(4,1,10,10));

        panel.setBackground(fondo);

        JLabel titulo =
                new JLabel(
                        "REPORTES DE MASCOTAS",
                        SwingConstants.CENTER);

        titulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20));

        btnVerReporte =
                new JButton("Ver Reporte");

        btnExportarPDF =
                new JButton("Exportar PDF");

        btnCerrar =
                new JButton("Cerrar");

        btnVerReporte.setBackground(marron);
        btnVerReporte.setForeground(Color.WHITE);

        btnExportarPDF.setBackground(marron);
        btnExportarPDF.setForeground(Color.WHITE);

        btnCerrar.setBackground(marron);
        btnCerrar.setForeground(Color.WHITE);

        panel.add(titulo);
        panel.add(btnVerReporte);
        panel.add(btnExportarPDF);
        panel.add(btnCerrar);

        add(panel);
    }
}