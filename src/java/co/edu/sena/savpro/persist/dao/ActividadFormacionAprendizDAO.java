/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.ActividadFormacionAprendiz;
import co.edu.sena.savpro.persist.dto.ActividadesFormacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class ActividadFormacionAprendizDAO implements InterfaceCRUD {

    private Conexion conn;
    private String error;

    public ActividadFormacionAprendizDAO(Conexion conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(Object t) {
        ActividadFormacionAprendiz actividades = (ActividadFormacionAprendiz) t;

        String sql = "INSERT INTO actividad_formacion_has_aprendiz "
                + "(actividadFormacionId, EvaluadorId)"
                + "VALUES (?, ?)";

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            ps.setInt(1, actividades.getActividadFormacionId());
            ps.setInt(2, actividades.getEvaluadorId());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.error = ex.getMessage();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object t) {

        try {
            ActividadFormacionAprendiz actividad = null;
            actividad = (ActividadFormacionAprendiz) t;
            System.out.println(actividad.toString());

            String sql = "UPDATE actividad_formacion_has_aprendiz "
                    + "SET nota = ?, fecha_evaluacion = ?,  "
                    + "descripcion = ? WHERE EvaluadorId = ? "
                    + "AND actividadFormacionId = ?;";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            
            ps.setString(1, actividad.getNota());
            ps.setDate(2, actividad.getFechaEvaluacion());
            ps.setString(3, actividad.getDescripcion());
            ps.setInt(4, actividad.getEvaluadorId());
            ps.setInt(5, actividad.getActividadFormacionId());

            int rows = ps.executeUpdate();
            boolean estado = rows > 0;
            return estado;
        } catch (Exception ex) {
            System.out.println("Error EmpresaDAO.edit " + ex.getMessage());
            return false;
        }

    }

    @Override
    public Object getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getSomeByID(String id) {
        try {
            String sql = "SELECT * FROM actividad_formacion_has_aprendiz afa"
                    + "	INNER JOIN Usuario u ON afa.EvaluadorId = u.id"
                    + " INNER JOIN actividad_formacion a ON afa.actividadFormacionId = a.id"
                    + " WHERE u.id = ? AND date(a.fecha_fin) <= now()";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            List<ActividadFormacionAprendiz> list = new ArrayList<>();
            ActividadFormacionAprendiz actividadf;
            while (rs.next()) {
                actividadf = new ActividadFormacionAprendiz();

                actividadf.setActividadFormacionId(rs.getInt("afa.actividadFormacionId"));
                actividadf.setEvaluadorId(rs.getInt("afa.EvaluadorId"));

                actividadf.setActividadf(new ActividadesFormacion(rs.getString("a.nombre"),
                        rs.getDate("a.fecha_inicio"),
                        rs.getDate("a.fecha_fin"),
                        rs.getInt("a.numero_sesiones")));

                list.add(actividadf);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            System.out.println("error getAll vacanteDao " + e.getMessage());
            return null;
        }

    }
   
    public ArrayList<?> getSomeByIDOne(String id) {
        try {
            String sql = "SELECT * FROM actividad_formacion_has_aprendiz WHERE "
                    + " actividadFormacionId = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            List<ActividadFormacionAprendiz> list = new ArrayList<>();
            ActividadFormacionAprendiz actividadf;
            while (rs.next()) {
                actividadf = new ActividadFormacionAprendiz();

                actividadf.setActividadFormacionId(rs.getInt("actividadFormacionId"));
                actividadf.setEvaluadorId(rs.getInt("EvaluadorId"));
                actividadf.setNota(rs.getString("nota"));
                actividadf.setFechaEvaluacion(rs.getDate("fecha_evaluacion"));
                actividadf.setDescripcion(rs.getString("descripcion"));

                
                list.add(actividadf);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            System.out.println("error getAll vacanteDao " + e.getMessage());
            return null;
        }

    }

    @Override
    public ArrayList<?> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getByWord(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
