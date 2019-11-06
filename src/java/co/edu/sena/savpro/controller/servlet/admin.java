/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
public class admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String direccion = request.getRequestURI();

        if (request.getSession().getAttribute("USER") == null) {
            admin.checkSession(request, response);
        } else {

            switch (direccion) {
                case "/SavPro/logout":
                    request.getSession().removeAttribute("MESSAGE");
                    request.getSession().invalidate();
                    response.sendRedirect("/SavPro/Start");
                    break;
                case "/SavPro/Home":
                    showHome(request, response);
                    break;
               case "/SavPro/Message":
                    showMessage(request, response);
                    break;
            }

        }
    }


    public void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/home/home.jsp");
        rd.forward(request, response);

    }
    
     public void showMessage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/home/message.jsp");
        rd.forward(request, response);

    }

    public static void checkSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String msg = "acceso denegado";
        request.setAttribute("MESSAGE", msg);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    public static void showError(HttpServletRequest request, HttpServletResponse response, String error)
            throws ServletException, IOException {
        response.sendRedirect("/SavPro/Error");
    }

    public static void setContentType(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
