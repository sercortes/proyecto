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
public class Interventor {
    
    private int idInterventor;
    private String nombres;
    private String apellidos;
    private int cargo;
    private String telefono;
    private String correo;
    private String direccion;
    private String telefonoCelular;
    private int centro;
    
    private CargoInterventor cargoInterventor;
    private CentroFormacion centroFormacion;

    public Interventor() {
    }

    public Interventor(int idInterventor, String nombres) {
        this.idInterventor = idInterventor;
        this.nombres = nombres;
    }
    
    public Interventor(int idInterventor, String nombres, String apellidos, int cargo, String telefono, String correo, String direccion, String telefonoCelular, int centro) {
        this.idInterventor = idInterventor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.telefonoCelular = telefonoCelular;
        this.centro = centro;
    }

    public Interventor(String nombres, String apellidos, int cargo, String telefono, String correo, String direccion, String telefonoCelular, int centro) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.telefonoCelular = telefonoCelular;
        this.centro = centro;
    }

    public CargoInterventor getCargoInterventor() {
        return cargoInterventor;
    }

    public void setCargoInterventor(CargoInterventor cargoInterventor) {
        this.cargoInterventor = cargoInterventor;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    
    
    public int getIdInterventor() {
        return idInterventor;
    }

    public void setIdInterventor(int idInterventor) {
        this.idInterventor = idInterventor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public int getCentro() {
        return centro;
    }

    public void setCentro(int centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return "Interventor{" + "idInterventor=" + idInterventor + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cargo=" + cargo + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", telefonoCelular=" + telefonoCelular + ", centro=" + centro + '}';
    }
    
}
