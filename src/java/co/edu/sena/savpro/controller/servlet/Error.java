/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.controller.servlet;

import java.io.IOException;
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
public class Error extends HttpServlet {
    
    private static String error;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String direccion = request.getRequestURI();

        if (request.getSession().getAttribute("USER") == null) {
           admin.checkSession(request, response);
        } else {

                    RequestDispatcher rd;
                    
            switch (direccion) {
                
                case "/SavPro/Error500":
                    rd = request.getRequestDispatcher("/views/error/error500.jsp");
                    rd.forward(request, response);
                    break;
                case "/SavPro/Error404":
                    rd = request.getRequestDispatcher("/views/error/error404.jsp");
                    rd.forward(request, response);
                    break;
                case "/SavPro/Error":
                    // request.setAttribute("ERROR", error);
                    rd = request.getRequestDispatcher("/views/error/error.jsp");
                    rd.forward(request, response);
                    break;
            }

        }

    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
