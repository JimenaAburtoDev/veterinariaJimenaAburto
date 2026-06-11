package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Usuario;
import vallegrande.edu.pe.model.UsuarioDAO;
import vallegrande.edu.pe.view.LoginView;
import vallegrande.edu.pe.view.RegistroView;

import javax.swing.*;

public class RegistroController {

    RegistroView vista;

    UsuarioDAO dao =
            new UsuarioDAO();

    public RegistroController(
            RegistroView vista
    ) {

        this.vista = vista;

        vista.btnGuardar.addActionListener(
                e -> registrar()
        );

        vista.btnVolver.addActionListener(
                e -> volver()
        );
    }

    private void registrar() {

        String usuario =
                vista.txtUsuario.getText();

        String password =
                String.valueOf(
                        vista.txtPassword.getPassword()
                );

        if(usuario.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Complete todos los campos"
            );

            return;
        }

        if(dao.existeUsuario(usuario)) {

            JOptionPane.showMessageDialog(
                    null,
                    "El usuario ya existe"
            );

            return;
        }

        Usuario u = new Usuario();

        u.setUsuario(usuario);
        u.setPassword(password);

        dao.registrar(u);

        JOptionPane.showMessageDialog(
                null,
                "Usuario registrado correctamente"
        );

        volver();
    }

    private void volver() {

        LoginView login =
                new LoginView();

        new LoginController(login);

        login.setVisible(true);

        vista.dispose();
    }
}