/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.InterventorDAO;
import com.google.gson.Gson;
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
