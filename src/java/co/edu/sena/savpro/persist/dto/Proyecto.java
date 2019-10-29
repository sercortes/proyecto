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
public class Proyecto {
    
    private int idProyecto;
    private String nombre;
    private String copartidaSena;
    private int empresaId;
    private int interventorId;
    private String descripcion;
    private String objetivos;
    
    private Empresa empresa;
    private Interventor interventor;

    public Proyecto() {
    }

    public Proyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(int idProyecto, String nombre) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
    }

    public Proyecto(String nombre, String copartidaSena, int empresaId, int interventorId, String descripcion, String objetivos, Empresa empresa, Interventor interventor) {
        this.nombre = nombre;
        this.copartidaSena = copartidaSena;
        this.empresaId = empresaId;
        this.interventorId = interventorId;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.empresa = empresa;
        this.interventor = interventor;
    }

    public Proyecto(int idProyecto, String nombre, String copartidaSena, int empresaId, int interventorId, String descripcion, String objetivos, Empresa empresa, Interventor interventor) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.copartidaSena = copartidaSena;
        this.empresaId = empresaId;
        this.interventorId = interventorId;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.empresa = empresa;
        this.interventor = interventor;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCopartidaSena() {
        return copartidaSena;
    }

    public void setCopartidaSena(String copartidaSena) {
        this.copartidaSena = copartidaSena;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getInterventorId() {
        return interventorId;
    }

    public void setInterventorId(int interventorId) {
        this.interventorId = interventorId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Interventor getInterventor() {
        return interventor;
    }

    public void setInterventor(Interventor interventor) {
        this.interventor = interventor;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", copartidaSena=" + copartidaSena + ", empresaId=" + empresaId + ", interventorId=" + interventorId + ", descripcion=" + descripcion + ", objetivos=" + objetivos + ", empresa=" + empresa + ", interventor=" + interventor + '}';
    }
    
}
