package vallegrande.edu.pe;

import vallegrande.edu.pe.view.InicioView;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            InicioView inicio = new InicioView();
            inicio.setVisible(true);

        });

    }
}