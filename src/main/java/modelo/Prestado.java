/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mabel
 */

public class Prestado {
    private String idEjemplar;
    private String idPrestamo;
    
    public Prestado() {
    }
    
    public Prestado(String idEjemplar, String idPrestamo) {
        this.idEjemplar = idEjemplar;
        this.idPrestamo = idPrestamo;
    }
    
    public String getIdEjemplar(){
        return idEjemplar;
    }
    
     public void getidEjemplar(String idEjemplar){
        this.idEjemplar = idEjemplar;
    }
     
      public String getidPrestamo(){
        return idPrestamo;
    }
      
       public void getidPrestamo(String idPrestamo){
        this.idPrestamo = idPrestamo;
    }

    public String getIdPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}