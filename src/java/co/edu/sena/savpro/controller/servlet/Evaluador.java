/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.EvaluadorDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class Evaluador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("USER") == null) {
            admin.checkSession(request, response);
        } else {
            String direccion = request.getRequestURI();
            switch (direccion) {
                case "/SavPro/Evaluators":
                    mostrarUsers(request, response);     
                    break;
                case "/SavPro/EvaluatorProject":
                    redirectUsers(request, response);
                    break;
                case "/SavPro/EvaluatorAlls":
                    responseQuery(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        if (request.getSession().getAttribute("USER") == null) {
            admin.checkSession(request, response);
        } else {
            admin.setContentType(request);
            String direccion = request.getRequestURI();
            switch (direccion) {
                case "/SavPro/Evaluatordetails":

                 
                        evaluatorDetails(request, response);
                   
                    break;
            }
        }

    }
    
      public void redirectUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          String id = request.getParameter("id");
        Conexion conn = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<?> usuarios = usuarioDAO.getEvaluadores(Integer.parseInt(id));
        conn.disconnectDb();
        
        
       response.setContentType("application/json");
      new Gson().toJson(usuarios, response.getWriter());
           
      
    }

    public void mostrarUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        
        request.setAttribute("ID", id);
        
        RequestDispatcher dis = request.getRequestDispatcher("/views/evaluador/evaluators.jsp");

        dis.forward(request, response);

    }
    
   

    public void evaluatorDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;

        String id = request.getParameter("id");

        Conexion conn = new Conexion();
        EvaluadorDAO evaluadordao = new EvaluadorDAO(conn);
        Object eva = evaluadordao.getByID(id);
        
      response.setContentType("application/json");
      new Gson().toJson(eva, response.getWriter());
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

      public void responseQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<?> usuarios = usuarioDAO.getEvaluadoresAll();
        conn.disconnectDb();
        
        
       response.setContentType("application/json");
      new Gson().toJson(usuarios, response.getWriter());
    }

}
