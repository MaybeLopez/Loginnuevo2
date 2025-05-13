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

    public void insertar(Prestamo p) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Prestamo (id_prestamo, id_usuario, id_ejemplar, fecha_prestamo, fecha_limite, fecha_devolucion, mora_generada) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getIdPrestamo());
        stmt.setString(2, p.getIdUsuario());
        stmt.setString(3, p.getIdEjemplar());
        stmt.setDate(4, Date.valueOf(p.getFechaPrestamo()));
        stmt.setDate(5, Date.valueOf(p.getFechaLimite()));
        stmt.setDate(6, Date.valueOf(p.getFechaDevolucion()));
        stmt.setFloat(7, p.getMoraGenerada());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Prestamo> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Prestamo";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Prestamo> lista = new ArrayList<>();
        while (rs.next()) {
            Prestamo p = new Prestamo(
                rs.getString("id_prestamo"),
                rs.getString("id_usuario"),
                rs.getString("id_ejemplar"),
                rs.getDate("fecha_prestamo").toLocalDate(),
                rs.getDate("fecha_limite").toLocalDate(),
                rs.getDate("fecha_devolucion").toLocalDate(),
                rs.getFloat("mora_generada")
            );
            lista.add(p);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
