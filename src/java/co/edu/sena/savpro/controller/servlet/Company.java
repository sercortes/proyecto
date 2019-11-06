/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import co.edu.sena.savpro.persist.conection.Conexion;
import co.edu.sena.savpro.persist.dao.EmpresaDAO;
import co.edu.sena.savpro.persist.dao.EmpresaUsuarioDAO;
import co.edu.sena.savpro.persist.dao.TamanoDAO;
import co.edu.sena.savpro.persist.dao.TipoEntidadDAO;
import co.edu.sena.savpro.persist.dao.UsuarioDAO;
import co.edu.sena.savpro.persist.dto.Empresa;
import co.edu.sena.savpro.persist.dto.Tamano;
import co.edu.sena.savpro.persist.dto.TipoEntidad;
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
public class Company extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String direccion = request.getRequestURI();

        if (request.getSession().getAttribute("USER") == null) {

            admin.checkSession(request, response);

        } else {

            switch (direccion) {
                case "/SavPro/Companys":

                    Usuario usuario = (Usuario) request.getSession().getAttribute("USER");

                    if (usuario.getPerfil() == 1) {
                        mostrarCompany(request, response);
                    } else {
                        mostrarCompanyByID(request, response, usuario.getIdUsuario());
                    }

                    break;
                case "/SavPro/Company":
                    loadCompany(request, response, 1);
                    break;
                case "/SavPro/AddCompany":
                    createCompany(request, response);
                    break;
                case "/SavPro/DelCompany":
                    deleteCompany(request, response);
                    break;
                case "/SavPro/EditCompany":
                    loadCompany(request, response, 2);
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
                case "/SavPro/AddCompany":
                    newCompany(request, response);
                    break;
                case "/SavPro/EditCompany":
                    editCompany(request, response);
                    break;
                case "/SavPro/SearchCompany":
                    mostrarCompanyByQuery(request, response);
                    break;
            }

        }

    }

    public void newCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        String nombre = request.getParameter("nombre");
        String nit = request.getParameter("nit");
        String dire = request.getParameter("direccion");
        String tele = request.getParameter("telefono");
        String descripcion = request.getParameter("descripcion");
        String tama = request.getParameter("tamano");
        Tamano tamano = new Tamano(Integer.parseInt(tama));
        String tipo = request.getParameter("tipoEntidad");
        TipoEntidad tipoEntidad = new TipoEntidad(Integer.parseInt(tipo));

        String sector = request.getParameter("sector");
        String page = request.getParameter("page");
        String razon = request.getParameter("razon");
        int idUsuario = Integer.parseInt(request.getParameter("usuario"));
        Usuario usuario1 = new Usuario(idUsuario);
        Empresa empresa = new Empresa
        (nombre, razon, nit, dire, tele, sector, 
         descripcion, page, tamano, tipoEntidad, usuario1);

        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        
        int idEmpresa = empresadao.insert(empresa);
        
        EmpresaUsuarioDAO empresaUsuDao = new EmpresaUsuarioDAO(conn);
        
        int operacion = 0;
        
        if (empresaUsuDao.insert(idEmpresa, idUsuario)) {
            operacion = 1;
        }else{
            operacion = 0;
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Companys");
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");

    }

    public void editCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        admin.setContentType(request);
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String nit = request.getParameter("nit");
        String dire = request.getParameter("direccion");
        String razon = request.getParameter("razon");
        String sector = request.getParameter("sector");
        String tele = request.getParameter("telefono");
        String page = request.getParameter("page");
        String descripcion = request.getParameter("descripcion");
        String tama = request.getParameter("tamano");
        Tamano tamano = new Tamano(Integer.parseInt(tama));
        String tipo = request.getParameter("tipoEntidad");
        TipoEntidad tipoEntidad = new TipoEntidad(Integer.parseInt(tipo));
        String idUsu = request.getParameter("usuario");

        System.out.println("Sergio");
        
        int idUsuario = 0;

        if (idUsu == null) {
            
            Usuario usuario = (Usuario) request.getSession().getAttribute("USER");
            idUsuario = usuario.getIdUsuario();
        } else {
            idUsuario = Integer.parseInt(idUsu);
        }

        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(id);
        empresa.setNombreEmpresa(nombre);
        empresa.setNitEmpresa(nit);
        empresa.setDirreccion(dire);
        empresa.setRazonSocial(razon);
        empresa.setSectorEconomico(sector);
        empresa.setTelefono(tele);
        empresa.setPaginaWeb(page);
        empresa.setDescripcion(descripcion);
        empresa.setTamano(tamano);
        empresa.setTipoEntidad(tipoEntidad);
        empresa.setUsuario(new Usuario(idUsuario));

        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);

        
        
        int operacion = 0;
        try {
            if (empresadao.updateEmpresa(empresa) > 0) {
                operacion = 1;
            }else{
                operacion = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Companys");
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");

    }

    public void mostrarCompanyByID(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        List<Empresa> empresas = empresadao.getByID(id);

        request.setAttribute("EMPRESAS", empresas);

        RequestDispatcher dis = request.getRequestDispatcher("/views/company/empresas.jsp");

        conn.disconnectDb();
        dis.forward(request, response);

    }

    public void mostrarCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        List<Empresa> empresas = empresadao.getAll();

        request.setAttribute("EMPRESAS", empresas);

        RequestDispatcher dis = request.getRequestDispatcher("/views/company/empresas.jsp");

        conn.disconnectDb();
        dis.forward(request, response);

    }

    public void mostrarCompanyByQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String query = request.getParameter("query");

        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        List<Empresa> empresas = empresadao.getByQuery(query);

        request.setAttribute("EMPRESAS", empresas);

        RequestDispatcher dis = request.getRequestDispatcher("/views/company/empresas.jsp");

        conn.disconnectDb();
        dis.forward(request, response);

    }

    public void createCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        Conexion conn = new Conexion();

        TamanoDAO tamanoDAO = new TamanoDAO(conn);
        List<Tamano> tamanos = tamanoDAO.getAll();

        TipoEntidadDAO tipoEntidadDAO = new TipoEntidadDAO(conn);
        List<TipoEntidad> tipoEntidades = tipoEntidadDAO.getAll();

        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<?> usuarios = usuarioDAO.getAll();

        request.setAttribute("TAMANOS", tamanos);
        request.setAttribute("TIPOENTIDADES", tipoEntidades);
        request.setAttribute("USUARIOS", usuarios);

        rd = request.getRequestDispatcher("/views/company/addEmpresa.jsp");
        conn.disconnectDb();
        rd.forward(request, response);

    }

    public void deleteCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        int control = empresadao.delete(Integer.parseInt(id));
        
         int operacion = 0;
        if (control > 0) {
            operacion = 1;
        }else{
            operacion = 0;
        }
        
        request.getSession().setAttribute("MSG", operacion);
        request.getSession().setAttribute("URL", "/SavPro/Companys");
        conn.disconnectDb();
        
        response.sendRedirect("/SavPro/Message");

    }

    public void loadCompany(HttpServletRequest request, HttpServletResponse response, int page)
            throws ServletException, IOException {

        int idEmpresa = Integer.parseInt(request.getParameter("id"));
        Conexion conn = new Conexion();
        EmpresaDAO empresadao = new EmpresaDAO(conn);
        Empresa empresa = empresadao.getById(idEmpresa);

        request.setAttribute("EMPRESA", empresa);
        RequestDispatcher rd;

        TamanoDAO tamanoDAO = new TamanoDAO(conn);
        List<Tamano> tamanos = tamanoDAO.getAll();
        TipoEntidadDAO tipoEntidadDAO = new TipoEntidadDAO(conn);
        List<TipoEntidad> tipoEntidades = tipoEntidadDAO.getAll();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<?> usuarios = usuarioDAO.getAll();

        request.setAttribute("TAMANOS", tamanos);
        request.setAttribute("TIPOENTIDADES", tipoEntidades);
        request.setAttribute("USUARIOS", usuarios);

        if (page == 1) {
            rd = request.getRequestDispatcher("/views/company/seeEmpresa.jsp");
        } else {

            rd = request.getRequestDispatcher("/views/company/editEmpresa.jsp");
        }
        conn.disconnectDb();
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
