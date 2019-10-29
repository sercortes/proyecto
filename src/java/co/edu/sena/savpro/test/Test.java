/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.test;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.EmpresaDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smart
 */
public class Test {
    
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        System.out.println(conexion);
       // conexion.disconnectDb();
        
        EmpresaDAO empresaDAO = new EmpresaDAO(conexion);
        
        List<Empresa> lista = empresaDAO.getByQuery("ddd");
        
        for (Empresa empresa : lista) {
            System.out.println(empresa.toString());
        }
        
//        Empresa empresa = empresaDAO.getById(2);
//        
//        System.out.println("\n :D "+empresa.toString());
//        
//        
//        UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//        
//        System.out.println(usuarioDAO.getEmpresaID(6));
    }
    
}
