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
public class Devolucion {
    
private int idDevolucion;
    private String idPrestamo;
    private Date fechaDevolucion;
    private float moraPagada;

    public Devolucion() {}

    public Devolucion(int idDevolucion, String idPrestamo, Date fechaDevolucion, float moraPagada) {
        this.idDevolucion = idDevolucion;
        this.idPrestamo = idPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.moraPagada = moraPagada;
    }

    public int getIdDevolucion() { return idDevolucion; }
    public void setIdDevolucion(int idDevolucion) { this.idDevolucion = idDevolucion; }

    public String getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(String idPrestamo) { this.idPrestamo = idPrestamo; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public float getMoraPagada() { return moraPagada; }
    public void setMoraPagada(float moraPagada) { this.moraPagada = moraPagada; }
}


