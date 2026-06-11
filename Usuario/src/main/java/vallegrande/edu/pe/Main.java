package vallegrande.edu.pe;

import vallegrande.edu.pe.controller.LoginController;
import vallegrande.edu.pe.view.LoginView;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            LoginView login =
                    new LoginView();

            new LoginController(login);

            login.setVisible(true);

        });
    }
}