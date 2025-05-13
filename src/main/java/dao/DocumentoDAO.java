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
import modelo.Documento;

/**
 *
 * @author mabel
 */
public class DocumentoDAO {

    public void insertar(Documento d) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "INSERT INTO Documento (id_documento, tipo_documento, titulo, autor, editorial, anio_publicacion, descripcion, categoria, ubicacion_fisica, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, d.getIdDocumento());
        stmt.setString(2, d.getTipoDocumento());
        stmt.setString(3, d.getTitulo());
        stmt.setString(4, d.getAutor());
        stmt.setString(5, d.getEditorial());
        stmt.setDate(6, Date.valueOf(d.getAnioPublicacion()));
        stmt.setString(7, d.getDescripcion());
        stmt.setString(8, d.getCategoria());
        stmt.setString(9, d.getUbicacionFisica());
        stmt.setString(10, d.getEstado());
        stmt.executeUpdate();
        stmt.close();
    }

    public void actualizar(Documento d) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "UPDATE Documento SET tipo_documento = ?, titulo = ?, autor = ?, editorial = ?, anio_publicacion = ?, descripcion = ?, categoria = ?, ubicacion_fisica = ?, estado = ? WHERE id_documento = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, d.getTipoDocumento());
        stmt.setString(2, d.getTitulo());
        stmt.setString(3, d.getAutor());
        stmt.setString(4, d.getEditorial());
        stmt.setDate(5, Date.valueOf(d.getAnioPublicacion()));
        stmt.setString(6, d.getDescripcion());
        stmt.setString(7, d.getCategoria());
        stmt.setString(8, d.getUbicacionFisica());
        stmt.setString(9, d.getEstado());
        stmt.setString(10, d.getIdDocumento());
        stmt.executeUpdate();
        stmt.close();
    }

    public void eliminar(String idDocumento) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "DELETE FROM Documento WHERE id_documento = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, idDocumento);
        stmt.executeUpdate();
        stmt.close();
    }

    public Documento obtenerPorId(String idDocumento) throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Documento WHERE id_documento = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, idDocumento);
        ResultSet rs = stmt.executeQuery();
        Documento d = null;
        if (rs.next()) {
            d = new Documento(
                rs.getString("id_documento"),
                rs.getString("tipo_documento"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("editorial"),
                rs.getDate("anio_publicacion").toLocalDate(),
                rs.getString("descripcion"),
                rs.getString("categoria"),
                rs.getString("ubicacion_fisica"),
                rs.getString("estado")
            );
        }
        rs.close();
        stmt.close();
        return d;
    }

    public List<Documento> obtenerTodos() throws SQLException {
        Connection conn = TestConnection.conectar();
        String sql = "SELECT * FROM Documento";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Documento> lista = new ArrayList<>();
        while (rs.next()) {
            Documento d = new Documento(
                rs.getString("id_documento"),
                rs.getString("tipo_documento"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("editorial"),
                rs.getDate("anio_publicacion").toLocalDate(),
                rs.getString("descripcion"),
                rs.getString("categoria"),
                rs.getString("ubicacion_fisica"),
                rs.getString("estado")
            );
            lista.add(d);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
