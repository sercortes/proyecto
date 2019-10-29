/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Empresa;
import co.edu.sena.savpro.persist.dto.Interventor;
import co.edu.sena.savpro.persist.dto.Proyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class ProyectoDAO {

    private Conexion conn;
    private String error;

    public ProyectoDAO(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insert(Proyecto proyecto){
        
            String sql = "INSERT INTO proyecto (nombre, copartida_sena, empresa_id, interventor_id, descripcion, objetivos) \n" +
"             VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getCopartidaSena());
            ps.setInt(3, proyecto.getEmpresa().getIdEmpresa());
            ps.setInt(4, proyecto.getInterventor().getIdInterventor());
            ps.setString(5, proyecto.getDescripcion());
            ps.setString(6, proyecto.getObjetivos());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.error = ex.getMessage();
            return false;
        }
    }
    
    public int updateEmpresa(Proyecto proyecto) throws Exception {
		
		
         try{
              String sql = "UPDATE proyecto set nombre = ?, copartida_sena = ?, empresa_id = ?,"
                      + "interventor_id = ?, descripcion = ?, objetivos = ? WHERE idProyecto = ?";
              PreparedStatement ps = conn.getConnection().prepareStatement(sql);
              
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getCopartidaSena());
            ps.setInt(3, proyecto.getEmpresa().getIdEmpresa());
            ps.setInt(4, proyecto.getInterventor().getIdInterventor());
            ps.setString(5, proyecto.getDescripcion());
            ps.setString(6, proyecto.getObjetivos());
            ps.setInt(7, proyecto.getIdProyecto());
            
              int rows = ps.executeUpdate();
              return rows;
          }catch(Exception ex){
              System.out.println("Error EmpresaDAO.edit "+ex.getMessage());
              return 0;
          }
	
	}
    
    public Proyecto getById(int idProject){
        try{
            String sql = "SELECT * FROM proyecto p INNER JOIN empresa e ON p.empresa_id = e.id\n" +
"                         INNER JOIN interventor i ON p.interventor_id = i.idInterventor\n" +
"						 WHERE p.idProyecto = ? LIMIT 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idProject);
            ResultSet rs = ps.executeQuery();
            Proyecto proyecto = new Proyecto();
            
            while(rs.next()){
                proyecto = new Proyecto();
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyecto.setCopartidaSena(rs.getString("copartida_sena"));
                proyecto.setEmpresa(new Empresa(rs.getInt("empresa_id"), rs.getString("nombreEmpresa")));
                proyecto.setInterventor(new Interventor(rs.getInt("interventor_id"), rs.getString("nombres")));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setObjetivos(rs.getString("objetivos"));    
            }
            return proyecto;
        }catch(SQLException e){
            System.out.println("error getById "+e.getMessage());
            return null;
        }
    }
    
    public List<Proyecto> getByID(int id){
        try{
            String sql = "SELECT * FROM proyecto p " +
                         "INNER JOIN empresa e ON p.empresa_id = e.id " +
                         "INNER JOIN interventor i ON p.interventor_id = i.idInterventor " +
                         "WHERE e.idUsuario = ? LIMIT 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Proyecto> list = new ArrayList<>();
            Proyecto proyecto;
            while(rs.next()){
                proyecto = new Proyecto();
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyecto.setCopartidaSena(rs.getString("copartida_sena"));
                proyecto.setEmpresa(new Empresa(rs.getInt("empresa_id"), rs.getString("nombreEmpresa")));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setObjetivos(rs.getString("objetivos"));   
                proyecto.setInterventor(new Interventor(rs.getInt("interventor_id"), rs.getString("nombres")));
                
                list.add(proyecto);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
    
    public List<Proyecto> getAll(){
        try{
            String sql = "SELECT * FROM proyecto p INNER JOIN empresa e ON p.empresa_id = e.id\n" +
"                         INNER JOIN interventor i ON p.interventor_id = i.idInterventor\n" +
"						 LIMIT 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Proyecto> list = new ArrayList<>();
            Proyecto proyecto;
            while(rs.next()){
                proyecto = new Proyecto();
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyecto.setCopartidaSena(rs.getString("copartida_sena"));
                proyecto.setEmpresa(new Empresa(rs.getInt("empresa_id"), rs.getString("nombreEmpresa")));
                proyecto.setInterventor(new Interventor(rs.getInt("interventor_id"), rs.getString("nombres")));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setObjetivos(rs.getString("objetivos"));    
                
                list.add(proyecto);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
    
    public int delete(int idEmpresa){
          try{
              String sql = "DELETE FROM proyecto WHERE idProyecto = ?";
              PreparedStatement ps = conn.getConnection().prepareStatement(sql);
              ps.setInt(1, idEmpresa);
              int rows = ps.executeUpdate();
              return rows;
          }catch(Exception ex){
              System.out.println("Error "+ex.getMessage());
              return 0;
          }
      }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
