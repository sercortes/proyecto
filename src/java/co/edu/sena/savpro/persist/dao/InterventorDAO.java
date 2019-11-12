/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.CargoInterventor;
import co.edu.sena.savpro.persist.dto.CentroFormacion;
import co.edu.sena.savpro.persist.dto.Interventor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String sql = "SELECT * FROM interventor i "
                    + "INNER JOIN cargo c ON i.cargo_idcargo = c.idCargo "
                    + "INNER JOIN centro ce ON i.centro_idcentro = ce.idCentro ORDER BY idInterventor desc";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Interventor> list = new ArrayList<>();
            Interventor interventor;
            while(rs.next()){
                interventor = new Interventor();
                interventor.setIdInterventor(rs.getInt("idInterventor"));
                interventor.setNombres(rs.getString("nombres"));
                interventor.setApellidos(rs.getString("apellidos"));
                interventor.setCargoInterventor(new CargoInterventor(rs.getString("c.idCargo"),
                        rs.getString("c.nombre")));
                
                interventor.setTelefono(rs.getString("telefono"));
                interventor.setCorreo(rs.getString("correo"));
                interventor.setDireccion(rs.getString("direccion"));
                interventor.setTelefonoCelular(rs.getString("telefono_celular"));
                
                interventor.setCentroFormacion(new CentroFormacion(rs.getString("ce.idCentro"),
                        rs.getString("ce.nombre")));
                
                list.add(interventor);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
    
    
    public List<?> getCargo(){
        try{
            String sql = "SELECT * FROM cargo c";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CargoInterventor> list = new ArrayList<>();
            CargoInterventor cargoInterventor;
            while(rs.next()){
                cargoInterventor = new CargoInterventor();
                cargoInterventor.setId(rs.getString("c.idCargo"));
                cargoInterventor.setNombre(rs.getString("c.nombre"));
                
                list.add(cargoInterventor);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
    
     public List<?> getCentro(){
        try{
            String sql = "SELECT * FROM centro c";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CentroFormacion> list = new ArrayList<>();
            CentroFormacion centroFormacion;
            while(rs.next()){
                centroFormacion = new CentroFormacion();
                centroFormacion.setId(rs.getString("c.idCentro"));
                centroFormacion.setNombre(rs.getString("c.nombre"));
                
                list.add(centroFormacion);
            }
            return list;
        }catch(Exception e){
            System.out.println("error getAll vacanteDao "+e.getMessage());
            return null;
        }
    }
    
    public boolean delete(String id) {
        try {
            String sql = "DELETE FROM interventor WHERE idInterventor = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            int rows = ps.executeUpdate();
            boolean estado = rows > 0;
            return estado;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public List<?> getByID(String query) {
        try {
            String sql = "SELECT * FROM interventor i "
                    + "INNER JOIN cargo c ON i.cargo_idcargo = c.idCargo "
                    + "INNER JOIN centro ce ON i.centro_idcentro = ce.idCentro "
                    + "WHERE (c.nombre like ? OR ce.nombre like ? OR "
                    + "i.nombres like ? OR i.apellidos like ?)";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, "%" + query + "%");
            ps.setString(2, "%" + query + "%");
            ps.setString(3, "%" + query + "%");
            ps.setString(4, "%" + query + "%");
            ResultSet rs = ps.executeQuery();
            List<Interventor> list = new ArrayList<>();
            Interventor interventor;
            while (rs.next()) {
                interventor = new Interventor();
                interventor.setIdInterventor(rs.getInt("idInterventor"));
                interventor.setNombres(rs.getString("nombres"));
                interventor.setApellidos(rs.getString("apellidos"));
                interventor.setCargoInterventor(new CargoInterventor(rs.getString("c.idCargo"),
                        rs.getString("c.nombre")));
                
                interventor.setTelefono(rs.getString("telefono"));
                interventor.setCorreo(rs.getString("correo"));
                interventor.setDireccion(rs.getString("direccion"));
                interventor.setTelefonoCelular(rs.getString("telefono_celular"));
                
                interventor.setCentroFormacion(new CentroFormacion(rs.getString("ce.idCentro"),
                        rs.getString("ce.nombre")));
                
               list.add(interventor);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
     public Interventor getInterventor(String id) {
        try {
            String sql = "SELECT * FROM interventor i " +
                    " INNER JOIN cargo c ON i.cargo_idcargo = c.idCargo " +
                    " INNER JOIN centro ce ON i.centro_idcentro = ce.idCentro WHERE i.idInterventor = ? LIMIT 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Interventor interventor = new Interventor();
            while (rs.next()) {
                interventor = new Interventor();
                interventor.setIdInterventor(rs.getInt("idInterventor"));
                interventor.setNombres(rs.getString("nombres"));
                interventor.setApellidos(rs.getString("apellidos"));
                interventor.setCargoInterventor(new CargoInterventor(rs.getString("c.idCargo"),
                        rs.getString("c.nombre")));
                
                interventor.setTelefono(rs.getString("telefono"));
                interventor.setCorreo(rs.getString("correo"));
                interventor.setDireccion(rs.getString("direccion"));
                interventor.setTelefonoCelular(rs.getString("telefono_celular"));
                
                interventor.setCentroFormacion(new CentroFormacion(rs.getString("ce.idCentro"),
                        rs.getString("ce.nombre")));
                
            }
            return interventor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
     
    public boolean update(Object t) {

        try {
            Interventor interventor = null;
            interventor = (Interventor) t;

            String sql = "UPDATE interventor set nombres = ?, apellidos = ?, "
                    + "telefono  = ?, correo = ?, direccion = ?"
                    + " WHERE idInterventor = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, interventor.getNombres());
            ps.setString(2, interventor.getApellidos());
            ps.setString(3, interventor.getTelefono());
            ps.setString(4, interventor.getCorreo());
            ps.setString(5, interventor.getDireccion());
            ps.setInt(6, interventor.getIdInterventor());

            int rows = ps.executeUpdate();
            boolean estado = rows > 0;
            return estado;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
            return false;
        }
    }
    
       public boolean insert1(Object t) {

        Interventor interventor = (Interventor) t;
        String sql = "INSERT INTO interventor (nombres, apellidos, telefono, correo, direccion, "
                + "telefono_celular, cargo_idcargo, centro_idcentro)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, interventor.getNombres());
            ps.setString(2, interventor.getApellidos());
            ps.setString(3, interventor.getTelefono());
            ps.setString(4, interventor.getCorreo());
            ps.setString(5, interventor.getDireccion());
            ps.setString(6, interventor.getTelefonoCelular());
            ps.setInt(7, interventor.getCargo());
            ps.setInt(8, interventor.getCentro());

            ps.executeUpdate();
           
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
