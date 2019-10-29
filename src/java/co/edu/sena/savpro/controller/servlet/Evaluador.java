/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.EvaluadorDAO;
import co.edu.sena.savpro.persist.dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author smart
 */
public class Evaluador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("USER") == null ){
            admin.checkSession(request, response);
        }else{
            String direccion = request.getRequestURI();
            switch(direccion){
                case "/SavPro/Evaluators":
                    mostrarUsers(request, response);
                    break;
            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        if (request.getSession().getAttribute("USER") == null) {
            admin.checkSession(request, response);
        }else{
            admin.setContentType(request);
            String direccion = request.getRequestURI();
            switch(direccion){
                case "/SavPro/Evaluatordetails":
                    evaluatorDetails(request, response);
                    break;
            }
        }
        
    }
    
    public void mostrarUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Conexion conn = new Conexion();
        EvaluadorDAO evaluadordao = new EvaluadorDAO(conn);
        Usuario user = (Usuario) request.getSession().getAttribute("USER");
        
        List<?> evaluadores;
        
        if (user.getPerfil() == 1) {
            evaluadores = evaluadordao.getAll();
        }else{ 
            evaluadores = evaluadordao.getSomeByID(String.valueOf(user.getIdUsuario()));
        }
        
        request.setAttribute("EVALUADORES", evaluadores);
        
        RequestDispatcher dis = request.getRequestDispatcher("/views/evaluador/evaluators.jsp");
        
        conn.disconnectDb();
        dis.forward(request, response);
        
    }

   
     public void evaluatorDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        
        String id = request.getParameter("idEvaluador");

        Conexion conn = new Conexion();
         EvaluadorDAO evaluadordao = new EvaluadorDAO(conn);
         Object eva = evaluadordao.getByID(id);

         
        request.setAttribute("EVALUADOR", eva);

        rd = request.getRequestDispatcher("/views/evaluador/seeEvaluador.jsp");
        rd.forward(request, response);

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
