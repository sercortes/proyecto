/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dto;

import java.sql.Date;

/**
 *
 * @author smart
 */
public class ActividadesFormacion {
    private int idActividad;
    private String nombreActividad;
    private Date fechaInicio;
    private Date fechaFin;
    private int numeroSesiones;
    private int proyectoId;
    private Proyecto proyecto;

    public ActividadesFormacion() {
    }

    public ActividadesFormacion(int idActividad, String nombreActividad, String fechaInicio, String fechaFin, int numeroSesiones) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.fechaInicio = Date.valueOf(fechaInicio);
        this.fechaFin = Date.valueOf(fechaFin);
        this.numeroSesiones = numeroSesiones;
    }

    
    
    public ActividadesFormacion(String nombreActividad, Date fechaInicio, Date fechaFin, int numeroSesiones) {
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroSesiones = numeroSesiones;
    }

    
    
    public ActividadesFormacion(String nombreActividad, String fechaInicio, String fechaFin, int numeroSesiones, int proyectoId) {
        this.nombreActividad = nombreActividad;
        this.fechaInicio = Date.valueOf(fechaInicio);
        this.fechaFin = Date.valueOf(fechaFin);
        this.numeroSesiones = numeroSesiones;
        this.proyectoId = proyectoId;
    }
    
    public ActividadesFormacion(String nombreActividad, Date fechaInicio, Date fechaFin, int numeroSesiones, int proyectoId) {
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroSesiones = numeroSesiones;
        this.proyectoId = proyectoId;
    }

    public ActividadesFormacion(int idActividad, String nombreActividad, Date fechaInicio, Date fechaFin, int numeroSesiones, int proyectoId, Proyecto proyecto) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroSesiones = numeroSesiones;
        this.proyectoId = proyectoId;
        this.proyecto = proyecto;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNumeroSesiones() {
        return numeroSesiones;
    }

    public void setNumeroSesiones(int numeroSesiones) {
        this.numeroSesiones = numeroSesiones;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "ActividadesFormacion{" + "idActividad=" + idActividad + ", nombreActividad=" + nombreActividad + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", numeroSesiones=" + numeroSesiones + ", proyectoId=" + proyectoId + ", proyecto=" + proyecto + '}';
    }
    
    
}
