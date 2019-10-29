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
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String email;
    private String userName;
    private String password;
    private int perfil;
    private String estado;
    
    private int idEmpresa;
    private Empresa empresa;

    private Perfil perfilUsuario;
    
    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(int idUsuario, String email) {
        this.idUsuario = idUsuario;
        this.email = email;
    }
    

    public Usuario(int idUsuario, String nombre, String email, String userName, String password, int perfil, String estado, int idEmpresa, Empresa empresa, Perfil perfilUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.perfil = perfil;
        this.estado = estado;
        this.idEmpresa = idEmpresa;
        this.empresa = empresa;
        this.perfilUsuario = perfilUsuario;
    }

    public Usuario(String nombre, String email, String userName, String password, int perfil, String estado) {
        this.nombre = nombre;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.perfil = perfil;
        this.estado = estado;
    }

    
   
    

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Usuario(int idUsuario, String nombre, String email, String userName, int perfil, String estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.userName = userName;
        this.perfil = perfil;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", userName=" + userName + ", password=" + password + ", perfil=" + perfil + ", estado=" + estado + '}';
    }

    
    

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Perfil getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(Perfil perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
   
    
}
