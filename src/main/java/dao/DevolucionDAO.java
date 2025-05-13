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
import modelo.Devolucion;

/**
 *
 * @author mabel
 */
public class DevolucionDAO {

    public void insertar(Devolucion devolucion) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Devolucion (id_devolucion, id_prestamo, fecha_devolucion, mora_pagada) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, devolucion.getIdDevolucion());
            stmt.setString(2, devolucion.getIdPrestamo());
            stmt.setDate(3, Date.valueOf(devolucion.getFechaDevolucion()));
            stmt.setFloat(4, devolucion.getMoraPagada());
            stmt.executeUpdate();
        }
    }

    public void actualizar(Devolucion devolucion) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "UPDATE Devolucion SET id_prestamo = ?, fecha_devolucion = ?, mora_pagada = ? WHERE id_devolucion = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, devolucion.getIdPrestamo());
        stmt.setDate(2, Date.valueOf(devolucion.getFechaDevolucion()));
        stmt.setFloat(3, devolucion.getMoraPagada());
        stmt.setInt(4, devolucion.getIdDevolucion());
        stmt.executeUpdate();
        stmt.close();
    }

    public void eliminar(int idDevolucion) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "DELETE FROM Devolucion WHERE id_devolucion = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idDevolucion);
        stmt.executeUpdate();
        stmt.close();
    }

    public Devolucion obtenerPorId(int idDevolucion) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Devolucion WHERE id_devolucion = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idDevolucion);
        ResultSet rs = stmt.executeQuery();
        Devolucion devolucion = null;
        if (rs.next()) {
            devolucion = new Devolucion(
                rs.getInt("id_devolucion"),
                rs.getString("id_prestamo"),
                rs.getDate("fecha_devolucion").toLocalDate(),
                rs.getFloat("mora_pagada")
            );
        }
        rs.close();
        stmt.close();
        return devolucion;
    }

    public List<Devolucion> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Devolucion";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Devolucion> lista = new ArrayList<>();
        while (rs.next()) {
            Devolucion devolucion = new Devolucion(
                rs.getInt("id_devolucion"),
                rs.getString("id_prestamo"),
                rs.getDate("fecha_devolucion").toLocalDate(),
                rs.getFloat("mora_pagada")
            );
            lista.add(devolucion);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
