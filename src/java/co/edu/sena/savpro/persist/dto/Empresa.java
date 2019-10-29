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
public class Empresa {
    
    private int idEmpresa;
    private String nombreEmpresa;
    private String razonSocial;
    private String nitEmpresa;
    private String dirreccion;
    private String telefono;
    private String sectorEconomico;
    private String descripcion;
    private String paginaWeb;
    
    private Tamano tamano;
    private TipoEntidad tipoEntidad;
    private Usuario usuario;

    public Empresa() {
        
    }

    public Empresa(int idEmpresa, String nombreEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
    }

    
    
    public Empresa(String nombreEmpresa, String razonSocial, String nitEmpresa, String dirreccion, String telefono, String sectorEconomico, String descripcion, String paginaWeb, Tamano tamano, TipoEntidad tipoEntidad, Usuario usuario) {
        this.nombreEmpresa = nombreEmpresa;
        this.razonSocial = razonSocial;
        this.nitEmpresa = nitEmpresa;
        this.dirreccion = dirreccion;
        this.telefono = telefono;
        this.sectorEconomico = sectorEconomico;
        this.descripcion = descripcion;
        this.paginaWeb = paginaWeb;
        this.tamano = tamano;
        this.tipoEntidad = tipoEntidad;
        this.usuario = usuario;
    }
    

    public Empresa(String nombreEmpresa, String razonSocial, String nitEmpresa, String dirreccion, 
            String telefono, String sectorEconomico, String descripcion, String paginaWeb, Tamano tamano, TipoEntidad tipoEntidad) {
        this.nombreEmpresa = nombreEmpresa;
        this.razonSocial = razonSocial;
        this.nitEmpresa = nitEmpresa;
        this.dirreccion = dirreccion;
        this.telefono = telefono;
        this.sectorEconomico = sectorEconomico;
        this.descripcion = descripcion;
        this.paginaWeb = paginaWeb;
        this.tamano = tamano;
        this.tipoEntidad = tipoEntidad;
    }

    
    
    public Empresa(int idEmpresa, String nombreEmpresa, String razonSocial, String nitEmpresa, String dirreccion, String telefono, String sectorEconomico, String descripcion, String paginaWeb, Tamano tamano, TipoEntidad tipoEntidad) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.razonSocial = razonSocial;
        this.nitEmpresa = nitEmpresa;
        this.dirreccion = dirreccion;
        this.telefono = telefono;
        this.sectorEconomico = sectorEconomico;
        this.descripcion = descripcion;
        this.paginaWeb = paginaWeb;
        this.tamano = tamano;
        this.tipoEntidad = tipoEntidad;
    }

    

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSectorEconomico() {
        return sectorEconomico;
    }

    public void setSectorEconomico(String sectorEconomico) {
        this.sectorEconomico = sectorEconomico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", razonSocial=" + razonSocial + ", nitEmpresa=" + nitEmpresa + ", dirreccion=" + dirreccion + ", telefono=" + telefono + ", sectorEconomico=" + sectorEconomico + ", descripcion=" + descripcion + ", paginaWeb=" + paginaWeb + ", tamano=" + tamano + ", tipoEntidad=" + tipoEntidad + ", usuario=" + usuario + '}';
    }

  

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
