package vallegrande.edu.pe.model;

import java.sql.*;

public class UsuarioDAO {

    public boolean validarLogin(
            String usuario,
            String password
    ) {

        String sql =
                "SELECT * FROM usuario " +
                        "WHERE usuario=? AND password=?";

        try (
                Connection con =
                        ConexionBD.getConexion();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean existeUsuario(
            String usuario
    ) {

        String sql =
                "SELECT * FROM usuario WHERE usuario=?";

        try (
                Connection con =
                        ConexionBD.getConexion();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, usuario);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void registrar(
            Usuario usuario
    ) {

        String sql =
                "INSERT INTO usuario(usuario,password) " +
                        "VALUES(?,?)";

        try (
                Connection con =
                        ConexionBD.getConexion();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1,
                    usuario.getUsuario());

            ps.setString(2,
                    usuario.getPassword());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}