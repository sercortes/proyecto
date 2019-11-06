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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author smart
 */
public class EmpresaUsuarioDAO {

    private Conexion conn;
    private String error;

    public EmpresaUsuarioDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(int idEmpresa, int idUsuario) {

        
        String sql = "INSERT INTO EmpresaUsuario (codEmpresa, codUsuario)  VALUES(?, ?)";

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idEmpresa);
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
            
            return true;

        } catch (SQLException ex) {
            this.error = ex.getMessage();
            return false;
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
