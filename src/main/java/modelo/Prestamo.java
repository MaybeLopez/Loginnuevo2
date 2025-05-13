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
public class Prestamo {
    private String idPrestamo;
    private String idUsuario;
    private String idEjemplar;
    private Date fechaPrestamo;
    private Date fechaLimite;
    private Date fechaDevolucion;
    private float moraGenerada;

    public Prestamo() {}

    public Prestamo(String idPrestamo, String idUsuario, String idEjemplar,
                    Date fechaPrestamo, Date fechaLimite, Date fechaDevolucion, float moraGenerada) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idEjemplar = idEjemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = fechaDevolucion;
        this.moraGenerada = moraGenerada;
    }

    public String getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(String idPrestamo) { this.idPrestamo = idPrestamo; }

    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }

    public String getIdEjemplar() { return idEjemplar; }
    public void setIdEjemplar(String idEjemplar) { this.idEjemplar = idEjemplar; }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Date getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(Date fechaLimite) { this.fechaLimite = fechaLimite; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public float getMoraGenerada() { return moraGenerada; }
    public void setMoraGenerada(float moraGenerada) { this.moraGenerada = moraGenerada; }
}



