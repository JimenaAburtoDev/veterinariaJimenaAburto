package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.*;
import vallegrande.edu.pe.view.InicioView;
import vallegrande.edu.pe.view.MascotaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class MascotaController {

    MascotaDAO dao = new MascotaDAO();

    MascotaView vista;

    public MascotaController(MascotaView vista) {

        this.vista = vista;

        vista.btnGuardar.addActionListener(
                e -> insertar()
        );

        vista.btnEliminar.addActionListener(
                e -> eliminar()
        );

        vista.btnActualizar.addActionListener(
                e -> actualizar()
        );

        vista.btnVolver.addActionListener(
                e -> volverInicio()
        );

        // BUSCADOR
        vista.txtBuscar.addKeyListener(
                new KeyAdapter() {

                    @Override
                    public void keyReleased(KeyEvent e) {

                        buscar(
                                vista.txtBuscar.getText()
                        );
                    }
                }
        );

        // CLICK TABLA
        vista.tabla.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    public void mouseClicked(
                            java.awt.event.MouseEvent evt
                    ) {

                        int fila =
                                vista.tabla.getSelectedRow();

                        vista.txtNombre.setText(
                                vista.tabla.getValueAt(fila,1)
                                        .toString());

                        vista.txtEspecie.setText(
                                vista.tabla.getValueAt(fila,2)
                                        .toString());

                        vista.txtRaza.setText(
                                vista.tabla.getValueAt(fila,3)
                                        .toString());

                        vista.txtEdad.setText(
                                vista.tabla.getValueAt(fila,4)
                                        .toString());
                    }
                }
        );

        listar();
    }

    // LISTAR
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

        // CONTADOR
        vista.lblTotal.setText(
                "Total mascotas: " + lista.size()
        );
    }

    // BUSCAR
    public void buscar(String texto) {

        List<Mascota> lista = dao.buscar(texto);

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

        vista.lblTotal.setText(
                "Total mascotas: " + lista.size()
        );
    }

    // INSERTAR
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

            int edad =
                    Integer.parseInt(
                            vista.txtEdad.getText()
                    );

            Mascota m = new Mascota();

            m.setNombre(
                    vista.txtNombre.getText()
            );

            m.setEspecie(
                    vista.txtEspecie.getText()
            );

            m.setRaza(
                    vista.txtRaza.getText()
            );

            m.setEdad(edad);

            dao.insertar(m);

            JOptionPane.showMessageDialog(
                    null,
                    "Mascota registrada correctamente"
            );

            listar();

            limpiar();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "La edad debe ser numérica"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al registrar mascota"
            );
        }
    }

    // ACTUALIZAR
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

            int edad =
                    Integer.parseInt(
                            vista.txtEdad.getText()
                    );

            Mascota m = new Mascota();

            m.setId(
                    (int) vista.tabla.getValueAt(fila,0)
            );

            m.setNombre(
                    vista.txtNombre.getText()
            );

            m.setEspecie(
                    vista.txtEspecie.getText()
            );

            m.setRaza(
                    vista.txtRaza.getText()
            );

            m.setEdad(edad);

            dao.actualizar(m);

            JOptionPane.showMessageDialog(
                    null,
                    "Mascota actualizada"
            );

            listar();

            limpiar();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "La edad debe ser numérica"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al actualizar mascota"
            );
        }
    }

    //  ELIMINAR
    public void eliminar() {

        int fila = vista.tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una fila"
            );

            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar esta mascota?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmar == 0) {

            int id =
                    (int) vista.tabla.getValueAt(fila,0);

            dao.eliminar(id);

            JOptionPane.showMessageDialog(
                    null,
                    "Mascota eliminada"
            );

            listar();

            limpiar();
        }
    }

    // LIMPIAR
    public void limpiar() {

        vista.txtNombre.setText("");

        vista.txtEspecie.setText("");

        vista.txtRaza.setText("");

        vista.txtEdad.setText("");
    }

    // VOLVER
    public void volverInicio() {

        InicioView inicio = new InicioView();

        inicio.setVisible(true);

        vista.dispose();
    }
}