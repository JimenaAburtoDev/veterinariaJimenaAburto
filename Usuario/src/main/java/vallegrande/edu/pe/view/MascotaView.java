package vallegrande.edu.pe.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MascotaView extends JFrame {

    public JTable tabla;

    public JTextField txtNombre;
    public JTextField txtEspecie;
    public JTextField txtRaza;
    public JTextField txtEdad;

    public JButton btnGuardar;
    public JButton btnActualizar;
    public JButton btnEliminar;
    public JButton btnVolver;

    public MascotaView() {

        setTitle("Gestión de Mascotas");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 🎨 Colores veterinaria
        Color fondo = new Color(245, 235, 220);
        Color marron = new Color(139, 94, 60);
        Color marronOscuro = new Color(92, 64, 51);

        getContentPane().setBackground(fondo);



        tabla = new JTable(
                new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                                "ID",
                                "Nombre",
                                "Especie",
                                "Raza",
                                "Edad",
                                "Dueño"
                        }
                )
        );

        tabla.setRowHeight(25);

        tabla.getTableHeader().setBackground(marronOscuro);
        tabla.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(tabla);


        txtNombre = new JTextField();
        txtEspecie = new JTextField();
        txtRaza = new JTextField();
        txtEdad = new JTextField();

        JPanel formulario = new JPanel(
                new GridLayout(4, 2, 10, 10)
        );

        formulario.setBackground(fondo);

        formulario.add(new JLabel("Nombre:"));
        formulario.add(txtNombre);

        formulario.add(new JLabel("Especie:"));
        formulario.add(txtEspecie);

        formulario.add(new JLabel("Raza:"));
        formulario.add(txtRaza);

        formulario.add(new JLabel("Edad:"));
        formulario.add(txtEdad);


        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnVolver = new JButton("Volver");

        btnGuardar.setBackground(marron);
        btnGuardar.setForeground(Color.WHITE);

        btnActualizar.setBackground(marron);
        btnActualizar.setForeground(Color.WHITE);

        btnEliminar.setBackground(marron);
        btnEliminar.setForeground(Color.WHITE);

        btnVolver.setBackground(marronOscuro);
        btnVolver.setForeground(Color.WHITE);

        JPanel botones = new JPanel();

        botones.setBackground(fondo);

        botones.add(btnGuardar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);
        botones.add(btnVolver);


        add(formulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }
}