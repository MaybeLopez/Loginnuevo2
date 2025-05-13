/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.TestConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Prestamo;

/**
 *
 * @author mabel
 */
public class PrestamoDAO {

    public void insertar(Prestamo prestamo) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Prestamo (id_prestamo, id_usuario, id_ejemplar, fecha_prestamo, fecha_limite, fecha_devolucion, mora_generada) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prestamo.getIdPrestamo());
            stmt.setString(2, prestamo.getIdUsuario());
            stmt.setString(3, prestamo.getIdEjemplar());
            stmt.setDate(4, Date.valueOf(prestamo.getFechaPrestamo()));
            stmt.setDate(5, Date.valueOf(prestamo.getFechaLimite()));
            stmt.setDate(6, Date.valueOf(prestamo.getFechaDevolucion()));
            stmt.setFloat(7, prestamo.getMoraGenerada());
            stmt.executeUpdate();
        }
    }

    public void actualizar(Prestamo prestamo) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "UPDATE Prestamo SET id_usuario = ?, id_ejemplar = ?, fecha_prestamo = ?, fecha_limite = ?, fecha_devolucion = ?, mora_generada = ? WHERE id_prestamo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prestamo.getIdUsuario());
            stmt.setString(2, prestamo.getIdEjemplar());
            stmt.setDate(3, Date.valueOf(prestamo.getFechaPrestamo()));
            stmt.setDate(4, Date.valueOf(prestamo.getFechaLimite()));
            stmt.setDate(5, Date.valueOf(prestamo.getFechaDevolucion()));
            stmt.setFloat(6, prestamo.getMoraGenerada());
            stmt.setString(7, prestamo.getIdPrestamo());
            stmt.executeUpdate();
        }
    }

    public void eliminar(String idPrestamo) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "DELETE FROM Prestamo WHERE id_prestamo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPrestamo);
            stmt.executeUpdate();
        }
    }

    public Prestamo obtenerPorId(String idPrestamo) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Prestamo WHERE id_prestamo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPrestamo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Prestamo(
                    rs.getString("id_prestamo"),
                    rs.getString("id_usuario"),
                    rs.getString("id_ejemplar"),
                    rs.getDate("fecha_prestamo").toLocalDate(),
                    rs.getDate("fecha_limite").toLocalDate(),
                    rs.getDate("fecha_devolucion").toLocalDate(),
                    rs.getFloat("mora_generada")
                );
            }
            rs.close();
        }
        return null;
    }

    public List<Prestamo> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Prestamo";
        List<Prestamo> lista = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                    rs.getString("id_prestamo"),
                    rs.getString("id_usuario"),
                    rs.getString("id_ejemplar"),
                    rs.getDate("fecha_prestamo").toLocalDate(),
                    rs.getDate("fecha_limite").toLocalDate(),
                    rs.getDate("fecha_devolucion").toLocalDate(),
                    rs.getFloat("mora_generada")
                );
                lista.add(prestamo);
            }
        }
        return lista;
    }
}
