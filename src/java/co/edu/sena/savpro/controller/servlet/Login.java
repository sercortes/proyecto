/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author smart
 */
public class Login extends HttpServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         admin.setContentType(request);
         
         String direccion = request.getRequestURI();
         
            switch(direccion){
                case "/SavPro/Start":
                    showLogin(request, response);
                    break;
            }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        String userParam = request.getParameter("user");
        String passParam = request.getParameter("pass");

        String msg = "";

        HttpSession session = request.getSession();
        
        Conexion conn = new Conexion();
        UsuarioDAO userdao = new UsuarioDAO(conn);

        Usuario usuario = userdao.login(userParam, passParam);
    
        conn.disconnectDb();
        
        if (usuario.getIdUsuario() > 0) {
            
            session.setAttribute("USER", usuario);
            response.sendRedirect("/SavPro/Home");
        
        } else {
            
            msg = "Usuario o password incorrectos";
            session.setAttribute("MESSAGE", msg);
            response.sendRedirect("/SavPro/Start");
            
        }
    }
    
    
    public static void showLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);

    }

}
