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
public class Evaluador {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String programaForma;
    private String email;
    private int codTipo;
    private int codUsuario;
    
    private TipoEvaluador tipo;

    public Evaluador() {
    }
    
    public Evaluador(String nombres, String apellidos, String programaForma, String email, int codTipo, int codUsuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.programaForma = programaForma;
        this.email = email;
        this.codTipo = codTipo;
        this.codUsuario = codUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getProgramaForma() {
        return programaForma;
    }

    public void setProgramaForma(String programaForma) {
        this.programaForma = programaForma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public String toString() {
        return "Evaluador{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", programaForma=" + programaForma + ", email=" + email + ", codTipo=" + codTipo + ", codUsuario=" + codUsuario + '}';
    }

    public TipoEvaluador getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvaluador tipo) {
        this.tipo = tipo;
    }
    
    
    
}
