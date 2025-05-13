/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mabel
 */
public class Ejemplar {

    private String idEjemplar;
    private String idDocumento = null;
    private int codigoEjemplar;
    private String estado;
    
public Ejemplar (){
}
    
public Ejemplar(String idEjemplar, String idDocumento, int codigoEjemplar, String estado) {
        this.idEjemplar = idEjemplar;
        this.idDocumento = idDocumento;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
    }
public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getCodigoEjemplar() {
        return codigoEjemplar;
    }

    public void setCodigoEjemplar(int codigoEjemplar) {
        this.codigoEjemplar = codigoEjemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
