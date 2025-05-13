/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author mabel
 */
public class Documento {
    private String idDocumento;
    private String tipoDocumento;
    private String titulo;
    private String autor;
    private String editorial;
    private Date anioPublicacion;
    private String descripcion;
    private String categoria;
    private String ubicacionFisica;
    private String estado;

    public Documento() {}

    public Documento(String idDocumento, String tipoDocumento, String titulo, String autor, String editorial,
                     Date anioPublicacion, String descripcion, String categoria, String ubicacionFisica, String estado) {
        this.idDocumento = idDocumento;
        this.tipoDocumento = tipoDocumento;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacionFisica = ubicacionFisica;
        this.estado = estado;
    }

    public String getIdDocumento() { return idDocumento; }
    public void setIdDocumento(String idDocumento) { this.idDocumento = idDocumento; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public Date getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Date anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getUbicacionFisica() { return ubicacionFisica; }
    public void setUbicacionFisica(String ubicacionFisica) { this.ubicacionFisica = ubicacionFisica; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
