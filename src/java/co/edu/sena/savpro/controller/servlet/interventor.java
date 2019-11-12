/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.InterventorDAO;
import co.edu.sena.savpro.persist.dto.CargoInterventor;
import co.edu.sena.savpro.persist.dto.CentroFormacion;
import co.edu.sena.savpro.persist.dto.Interventor;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class interventor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String direccion = request.getRequestURI();

        if (request.getSession().getAttribute("USER") == null) {
            admin.checkSession(request, response);
        } else {

            switch (direccion) {
                case "/SavPro/interventors":
                    showInterventors(request, response);
                    break;
                case "/SavPro/listIntervertors":
                    getList(request, response);
                    break;
                case "/SavPro/searchInterventor":
                    getQuery(request, response);
                    break;
                case "/SavPro/deleteInterventor":
                    delete(request, response);
                    break;
                case "/SavPro/formInterventor":
                    getCargoCentro(request, response);
                    break;
               case "/SavPro/formEditInterventor":
                    getFormEdit(request, response);
                    break;
               case "/SavPro/updateInterventor":
                   updateInterventor(request, response);
                    break;
              case "/SavPro/addInterventor":
                   addInterventor(request, response);
                    break;
                    
                    
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void getList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        InterventorDAO usuarioDAO = new InterventorDAO(conn);
        List<?> interventor = usuarioDAO.getAll();
        conn.disconnectDb();

        response.setContentType("application/json");
        new Gson().toJson(interventor, response.getWriter());
    }

    protected void showInterventors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dis = request.getRequestDispatcher("/views/interventor/Users.jsp");

        dis.forward(request, response);
    }

    protected void getQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        Conexion conn = new Conexion();
        InterventorDAO usuarioDAO = new InterventorDAO(conn);
        List<?> interventor = usuarioDAO.getByID(id);
        conn.disconnectDb();

        response.setContentType("application/json");
        new Gson().toJson(interventor, response.getWriter());

    }

    protected void getCargoCentro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        InterventorDAO usuarioDAO = new InterventorDAO(conn);
        List<?> cargo = usuarioDAO.getCargo();
        List<?> centro = usuarioDAO.getCentro();
        conn.disconnectDb();
        
        Interventor interventor = new Interventor();
        interventor.setListaCargo((ArrayList<CargoInterventor>) cargo);
        interventor.setListacentro((ArrayList<CentroFormacion>) centro);

        response.setContentType("application/json");
        new Gson().toJson(interventor, response.getWriter());

    }
    
    protected void getFormEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Conexion conn = new Conexion();
        InterventorDAO usuarioDAO = new InterventorDAO(conn);
        Interventor interventor = new Interventor();
        interventor = usuarioDAO.getInterventor(id);
        List<?> cargo = usuarioDAO.getCargo();
        List<?> centro = usuarioDAO.getCentro();
         interventor.setListaCargo((ArrayList<CargoInterventor>) cargo);
        interventor.setListacentro((ArrayList<CentroFormacion>) centro);
        
        conn.disconnectDb();
        

        response.setContentType("application/json");
        new Gson().toJson(interventor, response.getWriter());

    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        Conexion conn = new Conexion();
        InterventorDAO usuarioDAO = new InterventorDAO(conn);

        response.setContentType("application/json");

        if (usuarioDAO.delete(id)) {
            new Gson().toJson("ok", response.getWriter());
        } else {
            new Gson().toJson("no", response.getWriter());
        }
        conn.disconnectDb();

    }
    
     protected void updateInterventor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        String cargo = request.getParameter("cargo");
        String centro = request.getParameter("centro");
        
       
        Interventor interventor = new Interventor(
                Integer.parseInt(id), 
                nombre, 
                apellido, 
                Integer.parseInt(cargo), 
                telefono, 
                correo, 
                direccion, 
                celular, 
                Integer.parseInt(centro));

        
        Conexion conn = new Conexion();
        InterventorDAO interventorDAO = new InterventorDAO(conn);


        if (interventorDAO.update(interventor)) {
            new Gson().toJson("ok", response.getWriter());
        } else {
            new Gson().toJson("no", response.getWriter());
        }
        conn.disconnectDb();

    }
     
       protected void addInterventor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        String cargo = request.getParameter("cargo");
        String centro = request.getParameter("centro");
        
       
        Interventor interventor = new Interventor(
                nombre, 
                apellido, 
                Integer.parseInt(cargo), 
                telefono, 
                correo, 
                direccion, 
                celular, 
                Integer.parseInt(centro));

        
        Conexion conn = new Conexion();
        InterventorDAO interventorDAO = new InterventorDAO(conn);


        if (interventorDAO.insert1(interventor)) {
            new Gson().toJson("ok", response.getWriter());
        } else {
            new Gson().toJson("no", response.getWriter());
        }
        conn.disconnectDb();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
