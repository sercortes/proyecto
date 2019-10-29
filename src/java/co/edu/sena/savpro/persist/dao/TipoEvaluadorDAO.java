/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Perfil;
import co.edu.sena.savpro.persist.dto.TipoEvaluador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class TipoEvaluadorDAO implements InterfaceCRUD{

    private Conexion conn;
    private String error;

    public TipoEvaluadorDAO(Conexion conn) {
        this.conn = conn;
    }

    

    @Override
    public Object getByID(String id) {
        try{
            String sql = "SELECT * FROM perfil WHERE idPerfil = ? limit 1";
            
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Perfil perfil = new Perfil();
            while(rs.next()){
            
                perfil.setIdPerfil(rs.getInt("idPerfil"));
                perfil.setNombre(rs.getString("nombre"));
               
                
            }
            return perfil;
        }catch(Exception e){
            error = e.getMessage();
            return null;
        }
    }

    @Override
    public ArrayList<?> getSomeByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getAll() {
        try{
            String sql = "SELECT * FROM TipoEvaluador limit 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<TipoEvaluador> list = new ArrayList<>();
            TipoEvaluador tipoEvaluador;
            while(rs.next()){
                tipoEvaluador = new TipoEvaluador();
                tipoEvaluador.setNombreTipoEvaluador(rs.getString("Nombre"));
                tipoEvaluador.setIdTipoEvaluador(rs.getInt("idTipoEvaluador"));
                list.add(tipoEvaluador);
            }
            return (ArrayList<?>) list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<?> getByWord(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
