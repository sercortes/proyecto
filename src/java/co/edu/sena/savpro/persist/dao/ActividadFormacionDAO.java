/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.ActividadesFormacion;
import co.edu.sena.savpro.persist.dto.Proyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class ActividadFormacionDAO implements InterfaceCRUD{
    
    private Conexion conn;
    private String error;
    
    public ActividadFormacionDAO(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Object t){
        
        ActividadesFormacion actividades = (ActividadesFormacion) t;
        
            String sql = "INSERT INTO actividad_formacion "
                    + "(nombre, fecha_inicio, fecha_fin, numero_sesiones, proyecto_id)"
                    + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, actividades.getNombreActividad());
            
            ps.setDate(2, actividades.getFechaInicio());
            ps.setDate(3, actividades.getFechaFin());
            
            ps.setInt(4, actividades.getNumeroSesiones());
            ps.setInt(5, actividades.getProyecto().getIdProyecto());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.error = ex.getMessage();
            return false;
        }
    }
    
     public int insert1(Object t){
        
         int idActividad = 0;
        ActividadesFormacion actividades = (ActividadesFormacion) t;
        
            String sql = "INSERT INTO actividad_formacion "
                    + "(nombre, fecha_inicio, fecha_fin, numero_sesiones, proyecto_id)"
                    + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement ps = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, actividades.getNombreActividad());
            
            ps.setDate(2, actividades.getFechaInicio());
            ps.setDate(3, actividades.getFechaFin());
            
            ps.setInt(4, actividades.getNumeroSesiones());
            ps.setInt(5, actividades.getProyecto().getIdProyecto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idActividad = rs.getInt(1);
            }
            return idActividad;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.error = ex.getMessage();
            return 0;
                }
    }
    
    public List<ActividadesFormacion> getByID(int id){
        try{
            String sql = "SELECT * FROM actividad_formacion ac INNER JOIN proyecto p ON ac.proyecto_id=p.idProyecto\n" +
                         "WHERE p.idProyecto = ? ORDER BY id DESC";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ActividadesFormacion> list = new ArrayList<>();
            ActividadesFormacion actividad;
            while(rs.next()){
                actividad = new ActividadesFormacion();  
                
                actividad.setIdActividad(rs.getInt("ac.id"));
                actividad.setNombreActividad(rs.getString("ac.nombre"));
                actividad.setFechaInicio(rs.getDate("fecha_inicio"));
                actividad.setFechaFin(rs.getDate("fecha_fin"));
                actividad.setNumeroSesiones(rs.getInt("numero_sesiones"));
                actividad.setProyecto(new Proyecto(rs.getInt("p.idProyecto"), rs.getString("p.nombre")));
                
                list.add(actividad);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }

    public boolean delete(int idActividad){
          try{
              String sql = "DELETE FROM actividad_formacion WHERE id = ?";
              PreparedStatement ps = conn.getConnection().prepareStatement(sql);
              ps.setInt(1, idActividad);
              boolean esta = ps.executeUpdate() > 0;
              return esta;
          }catch(Exception ex){
              System.out.println("Error "+ex.getMessage());
              return false;
          }
      }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

  

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object t) {
            try {
            ActividadesFormacion actividad = null;
            actividad = (ActividadesFormacion) t;
           
            String sql = "UPDATE actividad_formacion set nombre = ?, fecha_inicio = ?, "
                    + "fecha_fin  = ?, numero_sesiones = ? "
                    + " WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, actividad.getNombreActividad());
            ps.setDate(2, actividad.getFechaInicio());
            ps.setDate(3, actividad.getFechaFin());
            ps.setInt(4, actividad.getNumeroSesiones());
            ps.setInt(5, actividad.getIdActividad());
            
            int rows = ps.executeUpdate();
            boolean estado = rows > 0;
            return estado;
        } catch (Exception ex) {
            System.out.println("Error edit " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Object getByID(String id) {
        try{
            String sql = "SELECT * FROM actividad_formacion WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            ActividadesFormacion actividad = null;
            while(rs.next()){
                actividad = new ActividadesFormacion();  
                
                actividad.setIdActividad(rs.getInt("id"));
                actividad.setNombreActividad(rs.getString("nombre"));
                actividad.setFechaInicio(rs.getDate("fecha_inicio"));
                actividad.setFechaFin(rs.getDate("fecha_fin"));
                actividad.setNumeroSesiones(rs.getInt("numero_sesiones"));
            }
            return actividad;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<?> getSomeByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
