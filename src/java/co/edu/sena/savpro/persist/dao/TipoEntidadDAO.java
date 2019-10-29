/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.TipoEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class TipoEntidadDAO {
    
    private Conexion conn;
    private String error;
    
    public TipoEntidadDAO(Conexion conn){
       this.conn = conn; 
    }
    
    public List<TipoEntidad> getAll(){
        try{
            String sql = "SELECT * FROM tipo_Entidad limit 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<TipoEntidad> list = new ArrayList<>();
            TipoEntidad tipoEntidad;
            while(rs.next()){
                tipoEntidad = new TipoEntidad();
                tipoEntidad.setNombre(rs.getString("nombreEntidad"));
                tipoEntidad.setTipoEntidad(rs.getInt("idtipo_Entidad"));
                
                list.add(tipoEntidad);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
    
}
