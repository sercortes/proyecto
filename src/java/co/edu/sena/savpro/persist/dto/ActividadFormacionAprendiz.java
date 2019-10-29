package co.edu.sena.savpro.persist.dto;

import java.sql.Date;

public class ActividadFormacionAprendiz {
    
    private int ActividadFormacionId;
    private int EvaluadorId;
    private String nota;
    private String descripcion;
    private Date fechaEvaluacion;
    
    private java.util.Date date=new java.util.Date();
    
    private ActividadesFormacion actividadf;
    
    public ActividadFormacionAprendiz() {
    }

    public ActividadFormacionAprendiz(int ActividadFormacionId, int EvaluadorId) {
        this.ActividadFormacionId = ActividadFormacionId;
        this.EvaluadorId = EvaluadorId;
    }

    public ActividadFormacionAprendiz(String nota, String descripcion) {
        this.nota = nota;
        this.descripcion = descripcion;
        this.fechaEvaluacion = new java.sql.Date(date.getTime());
    }

    public ActividadFormacionAprendiz(int ActividadFormacionId, int EvaluadorId, String nota, String descripcion) {
        this.ActividadFormacionId = ActividadFormacionId;
        this.EvaluadorId = EvaluadorId;
        this.nota = nota;
        this.descripcion = descripcion;
        this.fechaEvaluacion = new java.sql.Date(date.getTime());
    }
    
    
    

    public int getActividadFormacionId() {
        return ActividadFormacionId;
    }

    public void setActividadFormacionId(int ActividadFormacionId) {
        this.ActividadFormacionId = ActividadFormacionId;
    }

    public int getEvaluadorId() {
        return EvaluadorId;
    }

    public void setEvaluadorId(int EvaluadorId) {
        this.EvaluadorId = EvaluadorId;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    @Override
    public String toString() {
        return "ActividadFormacionAprendiz{" + "ActividadFormacionId=" + ActividadFormacionId + ", EvaluadorId=" + EvaluadorId + ", nota=" + nota + ", descripcion=" + descripcion + ", fechaEvaluacion=" + fechaEvaluacion + ", date=" + date + '}';
    }

    public ActividadesFormacion getActividadf() {
        return actividadf;
    }

    public void setActividadf(ActividadesFormacion actividadf) {
        this.actividadf = actividadf;
    }
    
    
    
}
