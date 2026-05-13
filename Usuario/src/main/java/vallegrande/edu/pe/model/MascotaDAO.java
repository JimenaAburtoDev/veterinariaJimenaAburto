package vallegrande.edu.pe.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    // LISTAR
    public List<Mascota> listar() {

        List<Mascota> lista = new ArrayList<>();

        String sql =
                "SELECT m.id, m.nombre, m.especie, " +
                        "m.raza, m.edad, c.nombre AS dueno " +
                        "FROM mascota m " +
                        "INNER JOIN cliente c ON m.id_cliente = c.id";

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

            System.out.println(
                    "Error al listar mascotas"
            );

            e.printStackTrace();
        }

        return lista;
    }

    // BUSCAR
    public List<Mascota> buscar(String texto) {

        List<Mascota> lista = new ArrayList<>();

        String sql =
                "SELECT m.id, m.nombre, m.especie, " +
                        "m.raza, m.edad, c.nombre AS dueno " +
                        "FROM mascota m " +
                        "INNER JOIN cliente c ON m.id_cliente = c.id " +
                        "WHERE m.nombre LIKE ?";

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, "%" + texto + "%");

            ResultSet rs = ps.executeQuery();

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

            System.out.println(
                    "Error al buscar mascotas"
            );

            e.printStackTrace();
        }

        return lista;
    }

    // INSERTAR
    public void insertar(Mascota m) {

        String sql =
                "INSERT INTO mascota(nombre, especie, raza, edad, id_cliente) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, 1);

            ps.executeUpdate();

            System.out.println(
                    "Mascota registrada"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error al registrar mascota"
            );

            e.printStackTrace();
        }
    }

    //  ACTUALIZAR
    public void actualizar(Mascota m) {

        String sql =
                "UPDATE mascota SET " +
                        "nombre=?, especie=?, raza=?, edad=? " +
                        "WHERE id=?";

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

            System.out.println(
                    "Mascota actualizada"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error al actualizar mascota"
            );

            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(int id) {

        String sql =
                "DELETE FROM mascota WHERE id=?";

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println(
                    "Mascota eliminada"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar mascota"
            );

            e.printStackTrace();
        }
    }
}