/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dto;

/**
 *
 * @author smart
 */
public class Tamano {
    
    private int idTamano;
    private String nombre;

    public Tamano() {
    }

    public Tamano(String nombre) {
        this.nombre = nombre;
    }

    public Tamano(int idTamano) {
        this.idTamano = idTamano;
    }
    
    

    public Tamano(int idTamano, String nombre) {
        this.idTamano = idTamano;
        this.nombre = nombre;
    }

    public int getIdTamano() {
        return idTamano;
    }

    public void setIdTamano(int idTamano) {
        this.idTamano = idTamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tamano{" + "idTamano=" + idTamano + ", nombre=" + nombre + '}';
    }
    
    
    
}
