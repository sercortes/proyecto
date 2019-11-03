/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;
 
import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Empresa;
import co.edu.sena.savpro.persist.dto.Tamano;
import co.edu.sena.savpro.persist.dto.TipoEntidad;
import co.edu.sena.savpro.persist.dto.Usuario;
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
public class EmpresaDAO {

    private Conexion conn;
    private String error;

    public EmpresaDAO(Conexion conn) {
        this.conn = conn;
    }

    public int insert(Empresa empresa) {

        int idEmpresa = 0;
        
        String sql = "INSERT INTO empresa (razon_social, nit, direccion, telefono, sector_economico, "
                + "descripcion, idtipo_Entidad, idtamano, paginaWeb, nombreEmpresa)  VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empresa.getRazonSocial());
            ps.setString(2, empresa.getNitEmpresa());
            ps.setString(3, empresa.getDirreccion());
            ps.setString(4, empresa.getTelefono());
            ps.setString(5, empresa.getSectorEconomico());
            ps.setString(6, empresa.getDescripcion());
            ps.setInt(7, empresa.getTipoEntidad().getTipoEntidad());
            ps.setInt(8, empresa.getTamano().getIdTamano());
            ps.setString(9, empresa.getPaginaWeb());
            ps.setString(10, empresa.getNombreEmpresa());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                idEmpresa = rs.getInt(1);
            }
            return idEmpresa;

        } catch (SQLException ex) {
            this.error = ex.getMessage();
            return 0;
        }
    }

    public int updateEmpresa(Empresa empresa) throws Exception {

        try {
            String sql = "UPDATE empresa set nombreEmpresa = ?, nit = ?, "
                    + "direccion  = ?, razon_social = ?, sector_economico = ?, "
                    + "telefono = ?, paginaWeb = ?, descripcion = ?, idtipo_Entidad = ?, idtamano = ? "
                    + " WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, empresa.getNombreEmpresa());
            ps.setString(2, empresa.getNitEmpresa());
            ps.setString(3, empresa.getDirreccion());
            ps.setString(4, empresa.getRazonSocial());
            ps.setString(5, empresa.getSectorEconomico());
            ps.setString(6, empresa.getTelefono());
            ps.setString(7, empresa.getPaginaWeb());
            ps.setString(8, empresa.getDescripcion());
            ps.setInt(9, empresa.getTipoEntidad().getTipoEntidad());
            ps.setInt(10, empresa.getTamano().getIdTamano());
            ps.setInt(11, empresa.getIdEmpresa());
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
            return 0;
        }

    }

    public Empresa getById(int idEmpresa) {
        try {
            String sql = "SELECT * FROM EmpresaUsuario eu \n"
                    + "INNER JOIN Usuario u ON eu.codUsuario = u.id \n"
                    + "INNER JOIN empresa e ON eu.codEmpresa = e.id \n"
                    + "INNER JOIN tamano t ON e.idtamano = t.idtamano \n"
                    + "INNER JOIN tipo_Entidad te ON e.idtipo_Entidad = te.idtipo_Entidad \n"
                    + "WHERE e.id = ? limit 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idEmpresa);
            ResultSet rs = ps.executeQuery();
            Empresa empresa = new Empresa();

            while (rs.next()) {
                empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
                empresa.setIdEmpresa(rs.getInt("e.id"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setNitEmpresa(rs.getString("nit"));
                empresa.setDirreccion(rs.getString("direccion"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setSectorEconomico(rs.getString("sector_economico"));
                empresa.setDescripcion(rs.getString("descripcion"));
                empresa.setPaginaWeb(rs.getString("paginaWeb"));
                empresa.setTamano(new Tamano(rs.getInt("idtamano"), rs.getString("nombreTamano")));
                empresa.setTipoEntidad(new TipoEntidad(rs.getInt("idtipo_Entidad"), rs.getString("nombreEntidad")));
                empresa.setUsuario(new Usuario(rs.getInt("u.id"), rs.getString("email")));
            }
            return empresa;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        }
    }

    public List<Empresa> getByID(int id) {
        try {
            String sql = "SELECT * FROM EmpresaUsuario eu \n"
                    + "INNER JOIN Usuario u ON eu.codUsuario=u.id \n"
                    + "INNER JOIN empresa e ON eu.codEmpresa=e.id \n"
                    + "INNER JOIN tamano t ON e.idtamano=t.idtamano \n"
                    + "INNER JOIN tipo_Entidad te ON e.idtipo_Entidad=te.idtipo_Entidad \n"
                    + "WHERE u.id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Empresa> list = new ArrayList<>();
            Empresa empresa;
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
                empresa.setIdEmpresa(rs.getInt("e.id"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setNitEmpresa(rs.getString("nit"));
                empresa.setDirreccion(rs.getString("direccion"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setSectorEconomico(rs.getString("sector_economico"));
                empresa.setDescripcion(rs.getString("descripcion"));
                empresa.setPaginaWeb(rs.getString("paginaWeb"));
                empresa.setTamano(new Tamano(rs.getInt("idtamano"), rs.getString("nombreTamano")));
                empresa.setTipoEntidad(new TipoEntidad(rs.getInt("idtipo_Entidad"), rs.getString("nombreEntidad")));

                list.add(empresa);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<Empresa> getAll() {
        try {
            String sql = "SELECT * FROM empresa e  INNER JOIN tamano t ON e.idtamano=t.idtamano \n"
                    + "                         INNER JOIN tipo_Entidad te ON e.idtipo_Entidad=te.idtipo_Entidad\n"
                    + "						 ORDER BY id desc limit 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Empresa> list = new ArrayList<>();
            Empresa empresa;
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
                empresa.setIdEmpresa(rs.getInt("id"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setNitEmpresa(rs.getString("nit"));
                empresa.setDirreccion(rs.getString("direccion"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setSectorEconomico(rs.getString("sector_economico"));
                empresa.setDescripcion(rs.getString("descripcion"));
                empresa.setPaginaWeb(rs.getString("paginaWeb"));
                empresa.setTamano(new Tamano(rs.getInt("idtamano"), rs.getString("nombreTamano")));
                empresa.setTipoEntidad(new TipoEntidad(rs.getInt("idtipo_Entidad"), rs.getString("nombreEntidad")));

                list.add(empresa);
            }
            return list;
        } catch (Exception e) {
            System.out.println("error getAll vacanteDao " + e.getMessage());
            return null;
        }
    }

    public int delete(int idEmpresa) {
        try {
            String sql = "DELETE FROM empresa WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idEmpresa);
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception ex) {
            System.out.println("Error VacanteDao.delete " + ex.getMessage());
            return 0;
        }
    }

    public List<Empresa> getByQuery(String query) {
        try {
            String sql = "SELECT * FROM empresa e INNER JOIN tamano t ON e.idtamano=t.idtamano"
                    + " INNER JOIN tipo_Entidad te ON e.idtipo_Entidad=te.idtipo_Entidad"
                    + " WHERE (descripcion like ? OR sector_economico like ? OR "
                    + "nombreEmpresa like ?) ORDER BY id desc;";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, "%" + query + "%");
            ps.setString(2, "%" + query + "%");
            ps.setString(3, "%" + query + "%");
            ResultSet rs = ps.executeQuery();
            List<Empresa> list = new ArrayList<>();
            Empresa empresa;
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
                empresa.setIdEmpresa(rs.getInt("id"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setNitEmpresa(rs.getString("nit"));
                empresa.setDirreccion(rs.getString("direccion"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setSectorEconomico(rs.getString("sector_economico"));
                empresa.setDescripcion(rs.getString("descripcion"));
                empresa.setPaginaWeb(rs.getString("paginaWeb"));
                empresa.setTamano(new Tamano(rs.getInt("idtamano"), rs.getString("nombreTamano")));
                empresa.setTipoEntidad(new TipoEntidad(rs.getInt("idtipo_Entidad"), rs.getString("nombreEntidad")));

                list.add(empresa);
            }

            return list;
        } catch (Exception ex) {
            System.out.println("Error VacanteDao.getByQuery " + ex.getMessage());
            error = ex.getMessage();
            return null;
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
