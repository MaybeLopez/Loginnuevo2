/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.TestConnection;
import modelo.Configuracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabel
 */
public class ConfiguracionDAO {

    public void insertar(Configuracion c) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Configuracion (id_configuracion, max_prestamos_alumnos, max_prestamos_profesor, dias_prestamo_alumno, dias_prestamo_profesor, mora_diaria) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getIdConfiguracion());
            stmt.setInt(2, c.getMaxPrestamosAlumnos());
            stmt.setInt(3, c.getMaxPrestamosProfesor());
            stmt.setInt(4, c.getDiasPrestamoAlumno());
            stmt.setInt(5, c.getDiasPrestamoProfesor());
            stmt.setFloat(6, c.getMoraDiaria());
            stmt.executeUpdate();
        }
    }

    public void actualizar(Configuracion c) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "UPDATE Configuracion SET max_prestamos_alumnos = ?, max_prestamos_profesor = ?, dias_prestamo_alumno = ?, dias_prestamo_profesor = ?, mora_diaria = ? WHERE id_configuracion = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, c.getMaxPrestamosAlumnos());
        stmt.setInt(2, c.getMaxPrestamosProfesor());
        stmt.setInt(3, c.getDiasPrestamoAlumno());
        stmt.setInt(4, c.getDiasPrestamoProfesor());
        stmt.setFloat(5, c.getMoraDiaria());
        stmt.setString(6, c.getIdConfiguracion());
        stmt.executeUpdate();
        stmt.close();
    }

    public void eliminar(String idConfiguracion) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "DELETE FROM Configuracion WHERE id_configuracion = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idConfiguracion);
            stmt.executeUpdate();
        }
    }

    public Configuracion obtenerPorId(String idConfiguracion) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Configuracion WHERE id_configuracion = ?";
        Configuracion c;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idConfiguracion);
            ResultSet rs = stmt.executeQuery();
            c = null;
            if (rs.next()) {
                c = new Configuracion(
                        rs.getString("id_configuracion"),
                        rs.getInt("max_prestamos_alumnos"),
                        rs.getInt("max_prestamos_profesor"),
                        rs.getInt("dias_prestamo_alumno"),
                        rs.getInt("dias_prestamo_profesor"),
                        rs.getFloat("mora_diaria")
                );
            }   rs.close();
        }
        return c;
    }

    public List<Configuracion> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Configuracion";
        List<Configuracion> lista;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Configuracion c = new Configuracion(
                        rs.getString("id_configuracion"),
                        rs.getInt("max_prestamos_alumnos"),
                        rs.getInt("max_prestamos_profesor"),
                        rs.getInt("dias_prestamo_alumno"),
                        rs.getInt("dias_prestamo_profesor"),
                        rs.getFloat("mora_diaria")
                );
                lista.add(c);
            }          }
        return lista;
    }
}
