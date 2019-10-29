/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Interventor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class InterventorDAO {
    
    
    private Conexion conn;
    private String error;

    public InterventorDAO(Conexion conn) {
        this.conn = conn;
    }
    
    public List<Interventor> getAll(){
        try{
            String sql = "SELECT * FROM interventor LIMIT 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Interventor> list = new ArrayList<>();
            Interventor interventor;
            while(rs.next()){
                interventor = new Interventor();
                interventor.setIdInterventor(rs.getInt("idInterventor"));
                interventor.setNombres(rs.getString("nombres"));
                interventor.setApellidos(rs.getString("apellidos"));
                interventor.setCargo(rs.getInt("cargo_idcargo"));
                interventor.setTelefono(rs.getString("telefono"));
                interventor.setCorreo(rs.getString("correo"));
                interventor.setDireccion(rs.getString("direccion"));
                interventor.setTelefonoCelular(rs.getString("telefono_celular"));
                interventor.setCentro(rs.getInt("centro_idcentro"));
                
                list.add(interventor);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
}
