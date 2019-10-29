/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Tamano;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class TamanoDAO {
    
    private Conexion conn;
    private String error;

    public TamanoDAO(Conexion conn) {
        this.conn = conn;
    }
    
     public List<Tamano> getAll(){
        try{
            String sql = "SELECT * FROM tamano limit 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tamano> list = new ArrayList<>();
            Tamano tamano;
            while(rs.next()){
                tamano = new Tamano();
                tamano.setNombre(rs.getString("nombreTamano"));
                tamano.setIdTamano(rs.getInt("idtamano"));
                
                list.add(tamano);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }

    
    
}
