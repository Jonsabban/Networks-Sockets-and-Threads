/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanox.httpday1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sanox
 */
@WebServlet(name = "getRequestHeader", urlPatterns = {"/getRequestHeader"})
public class getRequestHeader extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getRequestHeader</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getRequestHeader at " + request.getContextPath() + "</h1>");
            String host = request.getHeader("host");
            String connection = request.getHeader("connection");
            String cache = request.getHeader("cache-control");
            String accept = request.getHeader("accept");
            String useragent = request.getHeader("user-agent");
            String acceptEncoding = request.getHeader("accept-encoding");
            String acceptLanguage = request.getHeader("accept-Language");
            
            
            
            out.println("<p> host: " + host + "</p>");
            out.println("<p> connection: " + connection + "</p>");
            out.println("<p> cache: " + cache + "</p>");
            out.println("<p> accept: " + accept + "</p>");
            out.println("<p> useragent: " + useragent + "</p>");
            out.println("<p> accept-encoding: " + acceptEncoding + "</p>");
            out.println("<p> accept-language: " + acceptLanguage + "</p>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
