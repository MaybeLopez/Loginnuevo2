/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mabel
 */
public class Configuracion {
    private String idConfiguracion;
    private int maxPrestamosAlumnos;
    private int maxPrestamosProfesor;
    private int diasPrestamoAlumno;
    private int diasPrestamoProfesor;
    private float moraDiaria;

    public Configuracion() {}

    public Configuracion(String idConfiguracion, int maxPrestamosAlumnos, int maxPrestamosProfesor,
                          int diasPrestamoAlumno, int diasPrestamoProfesor, float moraDiaria) {
        this.idConfiguracion = idConfiguracion;
        this.maxPrestamosAlumnos = maxPrestamosAlumnos;
        this.maxPrestamosProfesor = maxPrestamosProfesor;
        this.diasPrestamoAlumno = diasPrestamoAlumno;
        this.diasPrestamoProfesor = diasPrestamoProfesor;
        this.moraDiaria = moraDiaria;
    }

    public String getIdConfiguracion() { return idConfiguracion; }
    public void setIdConfiguracion(String idConfiguracion) { this.idConfiguracion = idConfiguracion; }

    public int getMaxPrestamosAlumnos() { return maxPrestamosAlumnos; }
    public void setMaxPrestamosAlumnos(int maxPrestamosAlumnos) { this.maxPrestamosAlumnos = maxPrestamosAlumnos; }

    public int getMaxPrestamosProfesor() { return maxPrestamosProfesor; }
    public void setMaxPrestamosProfesor(int maxPrestamosProfesor) { this.maxPrestamosProfesor = maxPrestamosProfesor; }

    public int getDiasPrestamoAlumno() { return diasPrestamoAlumno; }
    public void setDiasPrestamoAlumno(int diasPrestamoAlumno) { this.diasPrestamoAlumno = diasPrestamoAlumno; }

    public int getDiasPrestamoProfesor() { return diasPrestamoProfesor; }
    public void setDiasPrestamoProfesor(int diasPrestamoProfesor) { this.diasPrestamoProfesor = diasPrestamoProfesor; }

    public float getMoraDiaria() { return moraDiaria; }
    public void setMoraDiaria(float moraDiaria) { this.moraDiaria = moraDiaria; }
}