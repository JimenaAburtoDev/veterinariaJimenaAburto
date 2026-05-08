package vallegrande.edu.pe.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    public List<Mascota> listar() {

        List<Mascota> lista = new ArrayList<>();

        String sql = """
                SELECT m.id,
                       m.nombre,
                       m.especie,
                       m.raza,
                       m.edad,
                       c.nombre AS dueno
                FROM mascota m
                INNER JOIN cliente c
                ON m.id_cliente = c.id
                """;

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Mascota m = new Mascota();

                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setDueno(rs.getString("dueno"));

                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void insertar(Mascota m) {

        String sql = """
                INSERT INTO mascota
                (nombre, especie, raza, edad, id_cliente)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());

            // Cliente por defecto
            ps.setInt(5, 1);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Mascota m) {

        String sql = """
                UPDATE mascota
                SET nombre = ?,
                    especie = ?,
                    raza = ?,
                    edad = ?
                WHERE id = ?
                """;

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, m.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM mascota WHERE id = ?";

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}