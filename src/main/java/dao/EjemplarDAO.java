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
import modelo.Ejemplar;

/**
 *
 * @author mabel
 */
public class EjemplarDAO {

    public void insertar(Ejemplar e) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Ejemplar (id_ejemplar, id_documento, codigo_ejemplar, estado) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getIdEjemplar());
        stmt.setString(2, e.getIdDocumento());
        stmt.setInt(3, e.getCodigoEjemplar());
        stmt.setString(4, e.getEstado());
        stmt.executeUpdate();
        stmt.close();
    }

    public void actualizar(Ejemplar e) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "UPDATE Ejemplar SET id_documento = ?, codigo_ejemplar = ?, estado = ? WHERE id_ejemplar = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getIdDocumento());
        stmt.setInt(2, e.getCodigoEjemplar());
        stmt.setString(3, e.getEstado());
        stmt.setString(4, e.getIdEjemplar());
        stmt.executeUpdate();
        stmt.close();
    }

    public void eliminar(String idEjemplar) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "DELETE FROM Ejemplar WHERE id_ejemplar = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, idEjemplar);
        stmt.executeUpdate();
        stmt.close();
    }

    public Ejemplar obtenerPorId(String idEjemplar) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Ejemplar WHERE id_ejemplar = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, idEjemplar);
        ResultSet rs = stmt.executeQuery();
        Ejemplar e = null;
        if (rs.next()) {
            e = new Ejemplar(
                rs.getString("id_ejemplar"),
                rs.getString("id_documento"),
                rs.getInt("codigo_ejemplar"),
                rs.getString("estado")
            );
        }
        rs.close();
        stmt.close();
        return e;
    }

    public List<Ejemplar> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Ejemplar";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Ejemplar> lista = new ArrayList<>();
        while (rs.next()) {
            Ejemplar e = new Ejemplar(
                rs.getString("id_ejemplar"),
                rs.getString("id_documento"),
                rs.getInt("codigo_ejemplar"),
                rs.getString("estado")
            );
            lista.add(e);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
