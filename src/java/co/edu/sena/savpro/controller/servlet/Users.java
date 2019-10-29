/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.EmpresaDAO;
import co.edu.sena.savpro.persist.dao.PerfilDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.Empresa;
import co.edu.sena.savpro.persist.dto.Perfil;
import co.edu.sena.savpro.persist.dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Users extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String direccion = request.getRequestURI();
        
        if (session.getAttribute("USER") == null) {
            
            admin.checkSession(request, response);
            
        } else {
            switch (direccion) {
                case "/SavPro/Users":
                    
                    Usuario usuario = (Usuario) session.getAttribute("USER");
                    
                    if (usuario.getPerfil() == 1) {
                        mostrarUsers(request, response);
                    } else {
                        response.sendRedirect("/SavPro/Home");
                    }
                    
                    break;
                case "/SavPro/AddUser":
                    loadForm(request, response);
                    break;
                case "/SavPro/DelUser":
                    delete(request, response);
                    break;
                case "/SavPro/loadUser":
                    load(request, response);
                    break;
            }
        }
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String direccion = request.getRequestURI();
        
        if (session.getAttribute("USER") == null) {
            
            admin.checkSession(request, response);
            
        } else {
            switch (direccion) {
               
                case "/SavPro/NewUser":
                    insert(request, response);
                    break;
                case "/SavPro/SaveUser":
                    update(request, response);
                    break;
            }
        }
    }
    
    public void load(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Conexion conn = new Conexion();
        
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        Usuario user = usuariodao.getByID(id);
        
        String idPerfil = String.valueOf(user.getPerfil());
        
        PerfilDAO perfildao = new PerfilDAO(conn);
        Object perfil = perfildao.getByID(idPerfil);
        
        List<?> perfiles = perfildao.getAll();
        conn.disconnectDb();
        
        
        request.setAttribute("PERFILES", perfiles);
        
        request.setAttribute("USUARIO", user);
        request.setAttribute("PERFIL", perfil);
        RequestDispatcher rd;


        if (user != null) {
            rd = request.getRequestDispatcher("/views/users/editUser.jsp");
        } else {
            request.getSession().setAttribute("MSG", 0);
            request.getSession().setAttribute("URL", "/SavPro/Users");
            rd = request.getRequestDispatcher("/views/company/message.jsp");
        }
       
        rd.forward(request, response);

    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

      
        Conexion conn = new Conexion();
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        
        int operacion = 0;
        if (usuariodao.delete(id)) {
            operacion = 1;
        } else {
            operacion = 0;
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Users");
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");

    }
    
    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        Conexion conn = new Conexion();
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String nameuser = request.getParameter("nameuser");
        String pass = request.getParameter("pass");
        String perfil = request.getParameter("perfil");
        String estado = request.getParameter("estado");
        
        Usuario usuario = new Usuario(nombre, email, estado, pass, Integer.parseInt(perfil), estado);
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        int operacion = 0;
        if (usuariodao.insert(usuario)) {
            operacion = 1;
        }else{
            operacion = 0;
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Users");
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");

    }
    
    public void loadForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        Conexion conn = new Conexion();

        PerfilDAO perfildao = new PerfilDAO(conn);
        List<?> perfiles = perfildao.getAll();
        conn.disconnectDb();
        
        request.setAttribute("PERFILES", perfiles);

        rd = request.getRequestDispatcher("/views/users/addUser.jsp");
        rd.forward(request, response);

    }
    
    public void mostrarUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Conexion conn = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<?> usuarios = usuarioDAO.getAll();
        
        request.setAttribute("USUARIOS", usuarios);
        
        RequestDispatcher dis = request.getRequestDispatcher("/views/users/Users.jsp");
        
        conn.disconnectDb();
        dis.forward(request, response);
        
    }
    
    
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String estado = request.getParameter("estado");
        String perfil = request.getParameter("perfil");
    
        Object user = new Usuario(id, nombre, email, username, Integer.parseInt(perfil), estado);
        
        Conexion conn = new Conexion();
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        
        int operacion = 0;
        if (usuariodao.update(user)) {
            operacion = 1;
        }else{
            operacion = 0;
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Users");
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
