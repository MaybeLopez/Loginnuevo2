/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author mabel
 */    
public class Prestamo {
    private String idPrestamo;
    private String idUsuario;
    private String idEjemplar;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;
    private float moraGenerada;

    public Prestamo() {}

    public Prestamo(String idPrestamo, String idUsuario, String idEjemplar,
                    LocalDate fechaPrestamo, LocalDate fechaLimite, LocalDate fechaDevolucion, float moraGenerada) {
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

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public float getMoraGenerada() { return moraGenerada; }
    public void setMoraGenerada(float moraGenerada) { this.moraGenerada = moraGenerada; }
}



