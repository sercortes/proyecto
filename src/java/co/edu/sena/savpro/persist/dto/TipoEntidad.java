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
public class TipoEntidad {
    
    private int tipoEntidad;
    private String nombre;

    public TipoEntidad() {
    }

    public TipoEntidad(int tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    
    
    public TipoEntidad(String nombre) {
        this.nombre = nombre;
    }

    public TipoEntidad(int tipoEntidad, String nombre) {
        this.tipoEntidad = tipoEntidad;
        this.nombre = nombre;
    }

    public int getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(int tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoEntidad{" + "tipoEntidad=" + tipoEntidad + ", nombre=" + nombre + '}';
    }
    
    
    
}
