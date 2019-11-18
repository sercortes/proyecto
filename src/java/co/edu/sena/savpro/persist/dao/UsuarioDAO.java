/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.persist.dao;

import org.apache.commons.lang3.RandomStringUtils;
import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dto.Empresa;
import co.edu.sena.savpro.persist.dto.Perfil;
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
public class UsuarioDAO implements InterfaceCRUD {

    private Conexion conn;
    private String error;

    public UsuarioDAO(Conexion conn) {
        this.conn = conn;
    }

    public Usuario login(String user, String pass) {

        try {
            String sql = "SELECT * FROM Usuario WHERE email = ? AND password"
                    + " = md5(?) limit 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            Usuario usuario = new Usuario();
            while (rs.next()) {

                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setPerfil(rs.getInt("perfil"));
                usuario.setEstado(rs.getString("estatus"));

            }
            return usuario;
        } catch (Exception e) {
            error = e.getMessage();
            return null;
        }

    }

    @Override
    public Usuario getByID(String id) {
        try {
            String sql = "SELECT * FROM Usuario u INNER JOIN perfil p ON u.perfil=p.idPerfil WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Usuario usuario = new Usuario();
            while (rs.next()) {

                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setPassword(rs.getString("password"));
                usuario.setPerfil(rs.getInt("perfil"));
                usuario.setEstado(rs.getString("estatus"));

                usuario.setPerfilUsuario(new Perfil(rs.getInt("p.idPerfil"), rs.getString("p.nombre")));

            }
            return usuario;
        } catch (Exception e) {
            error = e.getMessage();
            return null;
        }
    }

    public String getEmail(int id) {
        try {
            String sql = "SELECT email FROM Usuario WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Usuario usuario = new Usuario();
            while (rs.next()) {

                usuario.setEmail(rs.getString("email"));

            }
            return usuario.getEmail();
        } catch (Exception e) {
            error = e.getMessage();
            return null;
        }
    }
    
    @Override
    public ArrayList<?> getSomeByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getByWord(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getAll() {
        try {
            String sql = "SELECT * FROM Usuario u INNER JOIN perfil p ON u.perfil = p.idPerfil";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<>();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("u.nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEstado(rs.getString("estatus"));
                usuario.setPerfilUsuario(new Perfil(rs.getInt("idPerfil"), rs.getString("p.nombre")));
                list.add(usuario);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            error = e.getMessage();
            return null;
        }
    }

    public ArrayList<?> getEvaluadores(int idProyecto) {
        try {
            String sql = "SELECT * FROM EmpresaUsuario eu "
                    + "INNER JOIN Usuario u ON eu.codUsuario = u.id "
                    + "INNER JOIN empresa e ON eu.codEmpresa = e.id "
                    + "INNER JOIN perfil pe ON u.perfil = pe.idPerfil "
                    + "WHERE e.id = ? AND u.perfil = 3";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<>();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("u.nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEstado(rs.getString("estatus"));
                usuario.setPerfilUsuario(new Perfil(rs.getInt("idPerfil"), rs.getString("pe.nombre")));
                list.add(usuario);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<?> getEvaluadoresAll() {
        try {
            String sql = "SELECT * FROM EmpresaUsuario eu "
                    + "INNER JOIN Usuario u ON eu.codUsuario = u.id "
                    + "INNER JOIN empresa e ON eu.codEmpresa = e.id "
                    + "INNER JOIN perfil pe ON u.perfil = pe.idPerfil "
                    + "WHERE u.perfil = 3 ";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<>();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("u.nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEstado(rs.getString("estatus"));
                usuario.setPerfilUsuario(new Perfil(rs.getInt("idPerfil"), rs.getString("pe.nombre")));
                list.add(usuario);
            }
            return (ArrayList<?>) list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean insert(Object t) {

        Usuario user = (Usuario) t;
        String sql = "INSERT INTO Usuario (nombre, apellido, email, password, perfil, estatus)"
                + "VALUES (?, ?, ?, md5(?), ?, ?);";

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getPerfil());
            ps.setString(6, user.getEstado());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public int insert1(Object t) {

        int idUsuario = 0;
        Usuario user = (Usuario) t;
        String sql = "INSERT INTO Usuario (nombre, apellido, email, password, perfil, estatus)"
                + "VALUES (?, ?, ?, md5(?), ?, ?)";

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getPerfil());
            ps.setString(6, user.getEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }
            return idUsuario;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            String sql = "DELETE FROM Usuario WHERE id = ?";
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

    @Override
    public boolean update(Object t) {

        try {
            Usuario user = null;
            user = (Usuario) t;

            String sql = "UPDATE Usuario set nombre = ?, email = ?, "
                    + "apellido  = ?, perfil = ?, estatus = ?"
                    + " WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getApellido());
            ps.setInt(4, user.getPerfil());
            ps.setString(5, user.getEstado());
            ps.setInt(6, user.getIdUsuario());

            int rows = ps.executeUpdate();
            boolean estado = rows > 0;
            return estado;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
            return false;
        }
    }

    public boolean updateEvaluador(Object t) {

        try {
            Usuario user = null;
            user = (Usuario) t;

            String sql = "UPDATE Usuario set "
                    + "password  = md5(?), estatus = ? "
                    + " WHERE id = ?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEstado());
            ps.setInt(3, user.getIdUsuario());

            int rows = ps.executeUpdate();
            boolean estado = rows > 0;
            return estado;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
            return false;
        }
    }
    
    public String generatePassword() {
        return RandomStringUtils.random(10, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
    }

}
