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
import com.google.gson.Gson;
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
                case "/SavPro/ListUsers":
                    redirectUsers(request, response);
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
       
        PerfilDAO perfildao = new PerfilDAO(conn);
        
        user.setLista(perfildao.getAll());
        conn.disconnectDb();
        
        response.setContentType("application/json");
      new Gson().toJson(user, response.getWriter());
        
        
//        request.setAttribute("PERFILES", perfiles);
//        
//        request.setAttribute("USUARIO", user);
//        request.setAttribute("PERFIL", perfil);
        
//        RequestDispatcher rd;


//        if (user != null) {
//            rd = request.getRequestDispatcher("/views/users/editUser.jsp");
//        } else {
//            request.getSession().setAttribute("MSG", 0);
//            request.getSession().setAttribute("URL", "/SavPro/Users");
//            rd = request.getRequestDispatcher("/views/company/message.jsp");
//        }
//       
//        rd.forward(request, response);

    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        
        Conexion conn = new Conexion();
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        
         String json = "";
        if (usuariodao.delete(id)) {
            json = new Gson().toJson("ok");
            response.getWriter().write(json);      
        } else {
            json = new Gson().toJson("no");
            response.getWriter().write(json);
        }
        
        

    }
    
    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        Conexion conn = new Conexion();
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("ape");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String perfil = request.getParameter("perfil");
        String estado = request.getParameter("estado");
        
        Usuario usuario = new Usuario(nombre, email, apellido, pass, Integer.parseInt(perfil), estado);
       
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        
        String json = "";
        if (usuariodao.insert(usuario)) {
            json = new Gson().toJson("ok");
            response.getWriter().write(json);      
        } else {
            json = new Gson().toJson("no");
            response.getWriter().write(json);     

        }
        


    }
    
    public void loadForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        Conexion conn = new Conexion();

        PerfilDAO perfildao = new PerfilDAO(conn);
        List<?> perfiles = perfildao.getAll();
        conn.disconnectDb();
        
      response.setContentType("application/json");
      new Gson().toJson(perfiles, response.getWriter());
      

    }
    
    public void redirectUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Conexion conn = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<?> usuarios = usuarioDAO.getAll();
        conn.disconnectDb();
        
        
       response.setContentType("application/json");
      new Gson().toJson(usuarios, response.getWriter());
           
      
    }
    
    
    
    public void mostrarUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         RequestDispatcher dis = request.getRequestDispatcher("/views/users/Users.jsp");
        
        
        dis.forward(request, response);
      
        
        
      
      
    }
    
    
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("ape");
        String email = request.getParameter("email");
        String perfil = request.getParameter("perfil");
        String estado = request.getParameter("estado");
        Object user = new Usuario(id, nombre, email, apellido, Integer.parseInt(perfil), estado);
        
        Conexion conn = new Conexion();
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        
        
        String json = "";
        if (usuariodao.update(user)) {
            json = new Gson().toJson("ok");
            response.getWriter().write(json);      
        } else {
            json = new Gson().toJson("no");
            response.getWriter().write(json);
        }

        conn.disconnectDb();
        
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
