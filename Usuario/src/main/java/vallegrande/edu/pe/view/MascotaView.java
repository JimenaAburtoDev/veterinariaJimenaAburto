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
    public JTextField txtBuscar;

    public JLabel lblTotal;

    public JButton btnGuardar;
    public JButton btnActualizar;
    public JButton btnEliminar;
    public JButton btnVolver;

    public MascotaView() {

        setTitle("Gestión de Mascotas");

        setSize(900, 550);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //  ÍCONO
        Image iconoApp = Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/icono.png")
        );

        setIconImage(iconoApp);
        //  Colores veterinaria
        Color fondo = new Color(245, 235, 220);

        Color marron = new Color(139, 94, 60);

        Color marronOscuro = new Color(92, 64, 51);

        getContentPane().setBackground(fondo);

        // ====================================
        // LOGO
        // ====================================

        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource("/img/perrito.png")
        );

//  REDIMENSIONAR IMAGEN
        Image imagen = iconoOriginal.getImage().getScaledInstance(
                120, // ancho
                120, // alto
                Image.SCALE_SMOOTH
        );

        ImageIcon iconoPequeno = new ImageIcon(imagen);

        JLabel logo = new JLabel(iconoPequeno);

        logo.setHorizontalAlignment(JLabel.CENTER);

        // ====================================
        // TABLA
        // ====================================

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

        tabla.setSelectionBackground(
                new Color(139, 85, 41)
        );

        tabla.setSelectionForeground(Color.WHITE);

        tabla.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );

        tabla.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        tabla.getTableHeader().setBackground(marronOscuro);

        tabla.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(tabla);

        // ====================================
        // CAMPOS
        // ====================================

        txtNombre = new JTextField();

        txtEspecie = new JTextField();

        txtRaza = new JTextField();

        txtEdad = new JTextField();

        txtBuscar = new JTextField();

        JPanel formulario = new JPanel(
                new GridLayout(5, 2, 10, 10)
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

        formulario.add(new JLabel("Buscar:"));
        formulario.add(txtBuscar);

        // ====================================
        // BOTONES
        // ====================================

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

        // ====================================
        // CONTADOR
        // ====================================

        lblTotal = new JLabel("Total mascotas: 0");

        lblTotal.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        lblTotal.setForeground(marronOscuro);

        JPanel inferior = new JPanel(
                new BorderLayout()
        );

        inferior.setBackground(fondo);

        inferior.add(botones, BorderLayout.CENTER);

        inferior.add(lblTotal, BorderLayout.SOUTH);

        // ====================================
        // PANEL SUPERIOR
        // ====================================

        JPanel superior = new JPanel(
                new BorderLayout()
        );

        superior.setBackground(fondo);

        superior.add(logo, BorderLayout.NORTH);

        superior.add(formulario, BorderLayout.SOUTH);

        // ====================================
        // AGREGAR COMPONENTES
        // ====================================

        JMenuBar barra = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem itemSalir = new JMenuItem("Salir");

        itemSalir.addActionListener(e -> System.exit(0));

        menuArchivo.add(itemSalir);

        barra.add(menuArchivo);

        setJMenuBar(barra);

        add(superior, BorderLayout.NORTH);

        add(scroll, BorderLayout.CENTER);

        add(inferior, BorderLayout.SOUTH);
    }
}