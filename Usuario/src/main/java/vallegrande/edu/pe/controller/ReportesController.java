package vallegrande.edu.pe.controller;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vallegrande.edu.pe.model.ConexionBD;

import javax.swing.*;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

public class ReportesController {

    public void verReporte() {

        try {

            Connection cn = ConexionBD.getConexion();

            if (cn == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "No se pudo conectar a la base de datos."
                );
                return;
            }

            // Verificar si encuentra el archivo
            System.out.println(
                    getClass().getResource("/reportes/mascostas.jrxml")
            );

            InputStream reporteStream =
                    getClass().getResourceAsStream(
                            "/reportes/mascostas.jrxml"
                    );

            if (reporteStream == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "No se encontró el archivo:\n" +
                                "/reportes/mascostas.jrxml\n\n" +
                                "Verifica que esté dentro de:\n" +
                                "src/main/resources/reportes/"
                );

                return;
            }

            JasperReport reporte =
                    JasperCompileManager.compileReport(
                            reporteStream
                    );

            JasperPrint print =
                    JasperFillManager.fillReport(
                            reporte,
                            new HashMap<>(),
                            cn
                    );

            JasperViewer viewer =
                    new JasperViewer(print, false);

            viewer.setTitle("Reporte de Mascotas");
            viewer.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al generar reporte:\n" +
                            e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }
}