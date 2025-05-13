/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.TestConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Prestado;

/**
 *
 * @author mabel
 */
public class PrestadoDAO {

    public void insertar(Prestado p) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Prestado (id_ejemplar, id_prestamo) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getIdEjemplar());
            stmt.setString(2, p.getIdPrestamo());
            stmt.executeUpdate();
        }
    }

    public List<Prestado> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Prestado";
        List<Prestado> lista;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Prestado p = new Prestado(rs.getString("id_ejemplar"), rs.getString("id_prestamo"));
                lista.add(p);
            }          }
        return lista;
    }
}