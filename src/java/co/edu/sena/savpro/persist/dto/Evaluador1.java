/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dto;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smart
 */
public class Evaluador1 {
    
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;

    public Evaluador1() {
    }
    
    

    public Evaluador1(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Evaluador1{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
