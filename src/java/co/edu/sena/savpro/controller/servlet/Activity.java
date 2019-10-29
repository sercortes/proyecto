/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.ActividadFormacionAprendizDAO;
import co.edu.sena.savpro.persist.dao.ActividadFormacionDAO;
import co.edu.sena.savpro.persist.dao.EvaluadorDAO;
import co.edu.sena.savpro.persist.dao.TipoEvaluadorDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.ActividadFormacionAprendiz;
import co.edu.sena.savpro.persist.dto.ActividadesFormacion;
import co.edu.sena.savpro.persist.dto.Evaluador;
import co.edu.sena.savpro.persist.dto.Proyecto;
import co.edu.sena.savpro.persist.dto.Usuario;
import co.edu.sena.savpro.utils.Email;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Activity extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String direccion = request.getRequestURI();

        if (request.getSession().getAttribute("USER") == null) {

            admin.checkSession(request, response);

        } else {
            switch (direccion) {
                case "/SavPro/Activitys":
                    mostrar(request, response);
                    break;
                case "/SavPro/AddActivity":
                    formAdd(request, response);
                    break;
                case "/SavPro/DelActivity":
                    deleteActivity(request, response);
                    break;
                case "/SavPro/EditActivity":
                    loadEdit(request, response);
                    break;

            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String direccion = request.getRequestURI();

        if (request.getSession().getAttribute("USER") == null) {

            admin.checkSession(request, response);

        } else {
            switch (direccion) {
                case "/SavPro/NewActivity":
                    newActivity(request, response);
                    break;
                case "/SavPro/UpdateActivity":
                    update(request, response);
                    break;

            }

        }
    }

    public void loadEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Conexion conn = new Conexion();
        
        ActividadFormacionDAO actividadDao = new ActividadFormacionDAO(conn);
        Object actividad = actividadDao.getByID(id);
   
        
        
        request.setAttribute("ACTIVIDAD", actividad);
        RequestDispatcher rd;

        if (actividad != null) {
            rd = request.getRequestDispatcher("/views/Activity/editActivity.jsp");
        } else {
            request.getSession().setAttribute("MSG", 0);
            request.getSession().setAttribute("URL", "/SavPro/Users");
            rd = request.getRequestDispatcher("/views/home/message.jsp");
        }
       
        rd.forward(request, response);

    }
    
    public void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int ID = Integer.parseInt(id);

        HttpSession session = request.getSession();
        Proyecto proyecto = new Proyecto(ID);
        session.setAttribute("PROYECTO", proyecto);

        Conexion conn = new Conexion();
        ActividadFormacionDAO actividadformacionDAO = new ActividadFormacionDAO(conn);
        List<ActividadesFormacion> actividades = actividadformacionDAO.getByID(ID);

        request.setAttribute("ACTIVIDADES", actividades);

        RequestDispatcher dis = request.getRequestDispatcher("/views/Activity/activity.jsp");

        request.getSession().setAttribute("URL", request.getRequestURI()+"?id="+id);
        
        conn.disconnectDb();
        dis.forward(request, response);

    }
    
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String sesiones = request.getParameter("sesiones");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        
        ActividadesFormacion actividad = new ActividadesFormacion(
                Integer.parseInt(id),
                nombre,
                fechaInicio,
                fechaFin,
                Integer.parseInt(sesiones)
        );
        
       Conexion conn = new Conexion();
       ActividadFormacionDAO actividadDAO = new ActividadFormacionDAO(conn);
        int operacion = 0;
        if (actividadDAO.update(actividad)) {
            operacion = 1;
        } else {
            operacion = 0;
        }
        request.getSession().setAttribute("MSG", operacion);
        response.sendRedirect("/SavPro/Message");
        conn.disconnectDb();
        
        
    }

    public void newActivity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String sesiones = request.getParameter("sesiones");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        ActividadesFormacion actividad = new ActividadesFormacion
        (nombre, fechaInicio, fechaFin, 
         Integer.parseInt(sesiones), 
                Integer.parseInt(id));
        actividad.setProyecto(new Proyecto(Integer.parseInt(id)));

        Conexion conn = new Conexion();
        ActividadFormacionDAO actividadDAO = new ActividadFormacionDAO(conn);
        int idActividadFormacion = actividadDAO.insert1(actividad);  
        
        String nameEvaluador = request.getParameter("nameEvaluador");
        String correoEvaluador = request.getParameter("correoEvaluador");
        String estadoEva = "no";
        UsuarioDAO usuariodao = new UsuarioDAO(conn);
        String password = usuariodao.generatePassword();
        Usuario user =  new Usuario(nameEvaluador, correoEvaluador, nameEvaluador, password, 3, estadoEva);
        
        Email email = new Email();
        String mensaje = email.mensajeCorreo(nameEvaluador, correoEvaluador, password);
        email.sendEmail(correoEvaluador, mensaje);
        
        String prograEvaluador = request.getParameter("prograEvaluador");
        String tipoEvaluador = request.getParameter("tipoEvaluador");
        String apeEvaluador = request.getParameter("apeEvaluador");
        
       int idUsuario = usuariodao.insert1(user);
        
        Evaluador evaluador = new Evaluador(nameEvaluador, apeEvaluador, 
                prograEvaluador, correoEvaluador, 
                Integer.parseInt(tipoEvaluador), 
                idUsuario); 
        EvaluadorDAO evaluadordao = new EvaluadorDAO(conn);
        int idEvaluador = evaluadordao.insert1(evaluador);
        
        ActividadFormacionAprendizDAO actividadadao = new ActividadFormacionAprendizDAO(conn);
        ActividadFormacionAprendiz aprendizac = new ActividadFormacionAprendiz(idActividadFormacion, idEvaluador);
        boolean ope = actividadadao.insert(aprendizac);
        
        int operacion = 0;
        
        if (idUsuario != 0 && idEvaluador != 0 && idActividadFormacion !=0 && ope!=false) {
            operacion = 1;
        }else{
            operacion = 0;
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Activitys?id=" + id);
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");
        

    }

    public void formAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TipoEvaluadorDAO tipodao = new TipoEvaluadorDAO(conn);
        ArrayList<?> lista  = tipodao.getAll();
        
        request.setAttribute("TIPO", lista);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/Activity/addActivity.jsp");
        rd.forward(request, response);
    }

    public void deleteActivity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Proyecto proyecto = (Proyecto) request.getSession().getAttribute("PROYECTO");

        int ids = proyecto.getIdProyecto();

        String id = request.getParameter("id");
        Conexion conn = new Conexion();
        ActividadFormacionDAO actividadDAO = new ActividadFormacionDAO(conn);
      
        int operacion = 0;
        if (actividadDAO.delete(Integer.parseInt(id))) {
            operacion = 1;
        } else {
            operacion = 0;
        }
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Activitys?id="+ids);
        response.sendRedirect("/SavPro/Message");
        conn.disconnectDb();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
