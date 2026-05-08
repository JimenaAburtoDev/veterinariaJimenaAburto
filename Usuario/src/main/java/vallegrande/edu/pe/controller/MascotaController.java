package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Mascota;
import vallegrande.edu.pe.model.MascotaDAO;
import vallegrande.edu.pe.view.InicioView;
import vallegrande.edu.pe.view.MascotaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MascotaController {

    MascotaDAO dao = new MascotaDAO();
    MascotaView vista;

    public MascotaController(MascotaView vista) {

        this.vista = vista;

        vista.btnGuardar.addActionListener(e -> insertar());
        vista.btnActualizar.addActionListener(e -> actualizar());
        vista.btnEliminar.addActionListener(e -> eliminar());
        vista.btnVolver.addActionListener(e -> volverInicio());

        vista.tabla.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                int fila = vista.tabla.getSelectedRow();

                vista.txtNombre.setText(
                        vista.tabla.getValueAt(fila, 1).toString()
                );

                vista.txtEspecie.setText(
                        vista.tabla.getValueAt(fila, 2).toString()
                );

                vista.txtRaza.setText(
                        vista.tabla.getValueAt(fila, 3).toString()
                );

                vista.txtEdad.setText(
                        vista.tabla.getValueAt(fila, 4).toString()
                );
            }
        });

        listar();
    }


    public void listar() {

        List<Mascota> lista = dao.listar();

        DefaultTableModel modelo =
                (DefaultTableModel) vista.tabla.getModel();

        modelo.setRowCount(0);

        for (Mascota m : lista) {

            modelo.addRow(new Object[]{
                    m.getId(),
                    m.getNombre(),
                    m.getEspecie(),
                    m.getRaza(),
                    m.getEdad(),
                    m.getDueno()
            });
        }
    }


    public void insertar() {

        if (
                vista.txtNombre.getText().isEmpty() ||
                        vista.txtEspecie.getText().isEmpty() ||
                        vista.txtRaza.getText().isEmpty() ||
                        vista.txtEdad.getText().isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    null,
                    "Complete todos los campos"
            );

            return;
        }

        try {

            Mascota m = new Mascota();

            m.setNombre(vista.txtNombre.getText());
            m.setEspecie(vista.txtEspecie.getText());
            m.setRaza(vista.txtRaza.getText());

            m.setEdad(
                    Integer.parseInt(vista.txtEdad.getText())
            );

            dao.insertar(m);

            JOptionPane.showMessageDialog(
                    null,
                    "Mascota registrada"
            );

            listar();
            limpiar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al registrar"
            );
        }
    }


    public void actualizar() {

        int fila = vista.tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una fila"
            );

            return;
        }

        try {

            Mascota m = new Mascota();

            m.setId(
                    (int) vista.tabla.getValueAt(fila, 0)
            );

            m.setNombre(vista.txtNombre.getText());
            m.setEspecie(vista.txtEspecie.getText());
            m.setRaza(vista.txtRaza.getText());

            m.setEdad(
                    Integer.parseInt(vista.txtEdad.getText())
            );

            dao.actualizar(m);

            JOptionPane.showMessageDialog(
                    null,
                    "Mascota actualizada"
            );

            listar();
            limpiar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al actualizar"
            );
        }
    }



    public void eliminar() {

        int fila = vista.tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una fila"
            );

            return;
        }

        int id = (int) vista.tabla.getValueAt(fila, 0);

        dao.eliminar(id);

        JOptionPane.showMessageDialog(
                null,
                "Mascota eliminada"
        );

        listar();
        limpiar();
    }


    public void limpiar() {

        vista.txtNombre.setText("");
        vista.txtEspecie.setText("");
        vista.txtRaza.setText("");
        vista.txtEdad.setText("");
    }


    public void volverInicio() {

        vista.dispose();

        InicioView inicio = new InicioView();

        inicio.setVisible(true);
    }
}