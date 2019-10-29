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
public class TipoEvaluador {
    
    private int idTipoEvaluador;
    private String nombreTipoEvaluador;

    public TipoEvaluador() {
    }

    public TipoEvaluador(int idTipoEvaluador, String nombreTipoEvaluador) {
        this.idTipoEvaluador = idTipoEvaluador;
        this.nombreTipoEvaluador = nombreTipoEvaluador;
    }

    public int getIdTipoEvaluador() {
        return idTipoEvaluador;
    }

    public void setIdTipoEvaluador(int idTipoEvaluador) {
        this.idTipoEvaluador = idTipoEvaluador;
    }

    public String getNombreTipoEvaluador() {
        return nombreTipoEvaluador;
    }

    public void setNombreTipoEvaluador(String nombreTipoEvaluador) {
        this.nombreTipoEvaluador = nombreTipoEvaluador;
    }
    
}
