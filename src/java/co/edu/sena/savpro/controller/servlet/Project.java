/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.EmpresaDAO;
import co.edu.sena.savpro.persist.dao.InterventorDAO;
import co.edu.sena.savpro.persist.dao.ProyectoDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.Empresa;
import co.edu.sena.savpro.persist.dto.Interventor;
import co.edu.sena.savpro.persist.dto.Proyecto;
import co.edu.sena.savpro.persist.dto.Usuario;
import java.io.IOException;
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
public class Project extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String direccion = request.getRequestURI();

        if (session.getAttribute("USER") == null) {

            admin.checkSession(request, response);

        } else {
            switch (direccion) {
                case "/SavPro/Projects":

                    Usuario usuario = (Usuario) session.getAttribute("USER");

                    if (usuario.getPerfil() == 1) {
                        showProject(request, response);
                    } else {
                        showProjectByID(request, response, usuario.getIdUsuario());
                    }

                    break;
                case "/SavPro/SeeProject":
                    seeCompany(request, response);
                    break;
                case "/SavPro/NewProject":
                    loadFormProject(request, response);
                    break;
                case "/SavPro/DeleteProject":
                    deleteProject(request, response);
                    break;
                case "/SavPro/edithProject":
                    loadProject(request, response);
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
                case "/SavPro/AddProject": {
                    try {
                        newProject(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/SavPro/SaveProject":
                    editProject(request, response);
                    break;
            }

        }

    }

    public void newProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        admin.setContentType(request);

        String nombre = request.getParameter("nombre");
        String coSena = request.getParameter("sena");
        Empresa empresa;

        Conexion conn = new Conexion();

        int empresaID = Integer.parseInt(request.getParameter("empresa"));
        empresa = new Empresa(empresaID, "");

        int interventorID = Integer.parseInt(request.getParameter("interventor"));
        Interventor interventor = new Interventor(interventorID, "");
        String descr = request.getParameter("descripcion");
        String obje = request.getParameter("objetivos");

        Proyecto proyecto = new Proyecto(nombre, coSena, empresa.getIdEmpresa(), interventor.getIdInterventor(),
                descr, obje, empresa, interventor);
        
        System.out.println(proyecto.toString());

        ProyectoDAO proyectoDAO = new ProyectoDAO(conn);

        int operacion = 0;
        if (proyectoDAO.insert(proyecto)) {
            operacion = 1;
        } else {
            operacion = 0;
        }

        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Projects");
        conn.disconnectDb();

        response.sendRedirect("/SavPro/Message");

    }

    public void editProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("USER");

        int id = Integer.parseInt(request.getParameter("id"));

        String nombre = request.getParameter("nombre");
        String coSena = request.getParameter("sena");

        Empresa empresa;

        int empresaID = Integer.parseInt(request.getParameter("empresa"));
        empresa = new Empresa(empresaID, "");

        int interventorID = Integer.parseInt(request.getParameter("interventor"));
        Interventor interventor = new Interventor(interventorID, "");
        String descr = request.getParameter("descripcion");
        String obje = request.getParameter("objetivos");

        Proyecto proyecto = new Proyecto(id, nombre, coSena, empresa.getIdEmpresa(), interventor.getIdInterventor(),
                descr, obje, empresa, interventor);

        Conexion conn = new Conexion();
        ProyectoDAO proyectoDAO = new ProyectoDAO(conn);

        int estado = 0;
        try {
            estado = proyectoDAO.updateEmpresa(proyecto);
        } catch (Exception ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }

        int operacion = 0;
        if (estado > 0) {
            operacion = 1;
        } else {
            operacion = 0;
        }

        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Projects");
        conn.disconnectDb();

        response.sendRedirect("/SavPro/Message");

    }

    public void showProjectByID(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        ProyectoDAO proyectodao = new ProyectoDAO(conn);
        List<Proyecto> proyectos = proyectodao.getByID(id);

        request.setAttribute("PROYECTOS", proyectos);

        RequestDispatcher dis = request.getRequestDispatcher("/views/projects/projects.jsp");

        conn.disconnectDb();
        dis.forward(request, response);

    }

    public void showProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        ProyectoDAO proyectodao = new ProyectoDAO(conn);
        List<Proyecto> proyectos = proyectodao.getAll();

        request.setAttribute("PROYECTOS", proyectos);

        RequestDispatcher dis = request.getRequestDispatcher("/views/projects/projects.jsp");

        conn.disconnectDb();
        dis.forward(request, response);

    }

    public void seeCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCompany = Integer.parseInt(request.getParameter("id"));
        Conexion conn = new Conexion();
        ProyectoDAO proyectoDAO = new ProyectoDAO(conn);
        Proyecto proyecto = proyectoDAO.getById(idCompany);

        request.setAttribute("PROYECTO", proyecto);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/projects/seeProject.jsp");
        conn.disconnectDb();
        rd.forward(request, response);

    }

    public void loadFormProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        Conexion conn = new Conexion();
        Usuario usuario = (Usuario) request.getSession().getAttribute("USER");
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        List<Empresa> empresas;

        if (usuario.getPerfil() == 1) {
            empresas = empresadao.getAll();
        } else {
            empresas = empresadao.getByID(usuario.getIdUsuario());
        }

        InterventorDAO interventorDAO = new InterventorDAO(conn);
        List<Interventor> interventores = interventorDAO.getAll();

        request.setAttribute("EMPRESAS", empresas);
        request.setAttribute("INTERVENTORES", interventores);

        rd = request.getRequestDispatcher("/views/projects/addProject.jsp");
        conn.disconnectDb();
        rd.forward(request, response);

    }

    public void deleteProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Conexion conn = new Conexion();
        ProyectoDAO proyectoDAO = new ProyectoDAO(conn);
        int control = proyectoDAO.delete(Integer.parseInt(id));
        conn.disconnectDb();
        int operacion = 0;
        if (control > 0) {
            operacion = 1;
        } else {
            operacion = 0;
        }

        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Projects");
        conn.disconnectDb();

        response.sendRedirect("/SavPro/Message");

    }

    public void loadProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idProyecto = Integer.parseInt(request.getParameter("id"));
        Conexion conn = new Conexion();
        ProyectoDAO ProyectoDAO = new ProyectoDAO(conn);
        Proyecto proyecto = ProyectoDAO.getById(idProyecto);

        InterventorDAO interventorDAO = new InterventorDAO(conn);
        List<Interventor> interventores = interventorDAO.getAll();

        Usuario usuario = (Usuario) request.getSession().getAttribute("USER");
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        List<Empresa> empresas;
        
         if (usuario.getPerfil() == 1) {
            empresas = empresadao.getAll();
        } else {
            empresas = empresadao.getByID(usuario.getIdUsuario());
        }

        request.setAttribute("EMPRESAS", empresas);

        request.setAttribute("INTERVENTORES", interventores);

        request.setAttribute("PROYECTO", proyecto);
        RequestDispatcher rd;

        rd = request.getRequestDispatcher("/views/projects/editProyect.jsp");
        conn.disconnectDb();
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
