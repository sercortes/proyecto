/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.ActividadFormacionAprendizDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.ActividadFormacionAprendiz;
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
public class ActivityAprendiz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String direccion = request.getRequestURI();
        if (request.getSession().getAttribute("USER") == null) {
            admin.checkSession(request, response);
        } else {
            switch (direccion) {
                case "/SavPro/ActivityAprendiz":
                    mostrarEvaluador(request, response);
                    break;
                case "/SavPro/GradeActivitys":
                    mostrarAdmin(request, response);
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
                case "/SavPro/GradeActivity":
                    loadForm(request, response);
                    break;
                case "/SavPro/AddActivityE":
                    insert(request, response);
                    break;
            }
        }
    }

    public void loadForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        String idAc = request.getParameter("idActividad");
        String idEv = request.getParameter("idEvaluador");

        ActividadFormacionAprendiz ac = new ActividadFormacionAprendiz(
                Integer.parseInt(idAc),
                Integer.parseInt(idEv));

        request.setAttribute("ACTIVIDAD", ac);

        rd = request.getRequestDispatcher("/views/ActivityEvaluador/testActivity.jsp");
        rd.forward(request, response);

    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);

        Conexion conn = new Conexion();

        String idAc = request.getParameter("idAc");
        String idEv = request.getParameter("idEv");
        String nota = request.getParameter("nota");
        String descripcion = request.getParameter("descripcion");

        ActividadFormacionAprendiz actividad =
                                     new ActividadFormacionAprendiz(Integer.parseInt(idAc),
                                            Integer.parseInt(idEv),
                                            nota,
                                            descripcion);
        ActividadFormacionAprendizDAO actividadDAO =
                new ActividadFormacionAprendizDAO(conn);
        
            Usuario usuario = (Usuario) request.getSession().getAttribute("USER");
            usuario.setEstado("ok");
            request.getSession().setAttribute("USER", usuario);
            UsuarioDAO userdao = new UsuarioDAO(conn);
       
        int operacion = 0;
        if (actividadDAO.update(actividad) && userdao.update(usuario)) {
            operacion = 1; 
        } else {
            operacion = 0;
        }

        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Home");
        conn.disconnectDb();

        response.sendRedirect("/SavPro/Message");

    }

    public void mostrarEvaluador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        Conexion conn = new Conexion();
        ActividadFormacionAprendizDAO actividadformacionDAO = new ActividadFormacionAprendizDAO(conn);

        List<?> actividades = actividadformacionDAO.getSomeByID(id);

        request.setAttribute("ACTIVIDADES", actividades);

        RequestDispatcher dis = request.getRequestDispatcher("/views/ActivityEvaluador/activity.jsp");

        conn.disconnectDb();
        dis.forward(request, response);

    }
    
     public void mostrarAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        Conexion conn = new Conexion();
        ActividadFormacionAprendizDAO actividadformacionDAO = new ActividadFormacionAprendizDAO(conn);

        List<?> actividades = actividadformacionDAO.getSomeByIDOne(id);
       
        request.setAttribute("ACTIVIDADES", actividades);
        
        RequestDispatcher dis = request.getRequestDispatcher("/views/ActivityEvaluador/activitys.jsp");
        
        request.getSession().setAttribute("URL", request.getRequestURI()+"?id="+id);
        
        conn.disconnectDb();
        dis.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
