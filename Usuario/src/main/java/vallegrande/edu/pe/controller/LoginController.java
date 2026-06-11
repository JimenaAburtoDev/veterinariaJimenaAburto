package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.UsuarioDAO;
import vallegrande.edu.pe.view.InicioView;
import vallegrande.edu.pe.view.LoginView;
import vallegrande.edu.pe.view.RegistroView;

import javax.swing.*;

public class LoginController {

    LoginView vista;
    UsuarioDAO dao = new UsuarioDAO();

    public LoginController(LoginView vista) {

        this.vista = vista;

        vista.btnIngresar.addActionListener(e -> login());

        vista.btnRegistrar.addActionListener(e -> abrirRegistro());
    }

    private void login() {

        String usuario =
                vista.txtUsuario.getText();

        String password =
                String.valueOf(
                        vista.txtPassword.getPassword()
                );

        if(dao.validarLogin(usuario,password)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Bienvenido " + usuario
            );

            InicioView inicio =
                    new InicioView();

            inicio.setVisible(true);

            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Usuario o contraseña incorrectos"
            );
        }
    }

    private void abrirRegistro() {

        RegistroView registro =
                new RegistroView();

        new RegistroController(registro);

        registro.setVisible(true);

        vista.dispose();
    }
}