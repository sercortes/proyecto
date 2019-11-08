/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Evaluador;
import co.edu.sena.savpro.persist.dto.TipoEvaluador;
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
public class EvaluadorDAO implements InterfaceCRUD {
    
    private Conexion conn;
    private String error;
    
    public EvaluadorDAO(Conexion conn) {
        this.conn = conn;
    }
    
    public int insert1(Object t) {
        int idEvaluador = 0;
        Evaluador evaluador = (Evaluador) t;
        String sql = "INSERT INTO evaluador (nombre, apellidos, programa_formacion, correoEvaluador, CodTipo, codUsuario)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        
        try {
            
            PreparedStatement ps = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, evaluador.getNombres());
            ps.setString(2, evaluador.getApellidos());
            ps.setString(3, evaluador.getProgramaForma());
            ps.setString(4, evaluador.getEmail());
            ps.setInt(5, evaluador.getCodTipo());
            ps.setInt(6, evaluador.getCodUsuario());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idEvaluador = rs.getInt(1);
            }
            return idEvaluador;
            
        } catch (SQLException ex) {
            this.error = ex.getMessage();
            return 0;
        }
    }
    
    @Override
    public boolean insert(Object t) {
        
        Evaluador evaluador = (Evaluador) t;
        String sql = "INSERT INTO evaluador (nombre, apellidos, programa_formacion, correoEvaluador, CodTipo, codUsuario)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        
        try {
            
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, evaluador.getNombres());
            ps.setString(2, evaluador.getApellidos());
            ps.setString(3, evaluador.getProgramaForma());
            ps.setString(4, evaluador.getEmail());
            ps.setInt(5, evaluador.getCodTipo());
            ps.setInt(6, evaluador.getCodUsuario());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object getByID(String id) {
try {
            String sql = "SELECT * FROM Usuario WHERE "
                    + " id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Evaluador evaluador = null;
            while (rs.next()) {
                evaluador = new Evaluador();
                
                evaluador.setId(rs.getInt("id"));
                evaluador.setNombres(rs.getString("nombre"));
                evaluador.setApellidos(rs.getString("apellido"));
                evaluador.setEmail(rs.getString("email"));
                
            }
            return evaluador;
        } catch (Exception e) {
            System.out.println("error getAll vacanteDao " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public ArrayList<?> getSomeByID(String id) {
        try {
            String sql = "SELECT * FROM evaluador e "
                    + "INNER JOIN TipoEvaluador t ON e.CodTipo = t.idTipoEvaluador "
                    + "WHERE e.codUsuario = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            List<Evaluador> list = new ArrayList<>();
            Evaluador evaluador;
            while (rs.next()) {
                evaluador = new Evaluador();
                
                evaluador.setId(rs.getInt("id"));
                evaluador.setNombres(rs.getString("nombre"));
                evaluador.setApellidos(rs.getString("apellidos"));
                evaluador.setProgramaForma(rs.getString("programa_formacion"));
                evaluador.setEmail(rs.getString("CorreoEvaluador"));
                evaluador.setCodTipo(rs.getInt("CodTipo"));
                evaluador.setCodUsuario(rs.getInt("codUsuario"));
                evaluador.setTipo( new TipoEvaluador(0, rs.getString("t.Nombre")));
                
                list.add(evaluador);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            System.out.println("error getAll vacanteDao " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public ArrayList<?> getAll() {
         try {
            String sql = "SELECT * FROM evaluador e "
                    + "INNER JOIN TipoEvaluador t ON e.CodTipo = t.idTipoEvaluador "
                    + "limit 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Evaluador> list = new ArrayList<>();
            Evaluador evaluador;
            while (rs.next()) {
                evaluador = new Evaluador();
                
                evaluador.setId(rs.getInt("id"));
                evaluador.setNombres(rs.getString("nombre"));
                evaluador.setApellidos(rs.getString("apellidos"));
                evaluador.setProgramaForma(rs.getString("programa_formacion"));
                evaluador.setEmail(rs.getString("CorreoEvaluador"));
                evaluador.setCodTipo(rs.getInt("CodTipo"));
                evaluador.setCodUsuario(rs.getInt("codUsuario"));
                evaluador.setTipo( new TipoEvaluador(0, rs.getString("t.Nombre")));
                
                list.add(evaluador);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            System.out.println("error getAll vacanteDao " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public ArrayList<?> getByWord(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
