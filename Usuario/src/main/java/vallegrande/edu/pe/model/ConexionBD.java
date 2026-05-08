package vallegrande.edu.pe.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public static Connection getConexion() {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veterinariaDB",
                    "jimena",
                    "12345"
            );

            System.out.println("Conexión exitosa");
            return con;

        } catch (Exception e) {

            System.out.println("No se pudo establecer la conexión");
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}