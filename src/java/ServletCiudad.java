/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Ciudad;

/**
 *
 * @author emanuel
 */
@WebServlet(urlPatterns = {"/ServletCiudad"})
public class ServletCiudad extends HttpServlet {

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
            if (request.getParameter("eliminar") != null) {
                int id = Integer.parseInt(request.getParameter("eliminar"));
                out.println("Eliminar ID:" + id);
                Ciudad ciu = new Ciudad();
                ciu.setCiudad_id(id);
                ciu.BorrarHabilidad();
                response.sendRedirect("Ciudades/index.jsp");

            } else if (request.getParameter("guardar5") != null) {
                String nombre = request.getParameter("Nombre");
                int pais_id = Integer.parseInt(request.getParameter("Pais_id"));
                String creado_por = request.getParameter("Creado_por");
                Ciudad ciu = new Ciudad();
                ciu.setNombre(nombre);
                ciu.setPais_id(pais_id);
                ciu.setCreado_por(creado_por);
                
                ciu.GuardarHabilidad();
                response.sendRedirect("Ciudades/index.jsp");

            } else if (request.getParameter("editar5") != null) {
                int ciudad_id = Integer.parseInt(request.getParameter("id"));
                String Nombre = request.getParameter("nombre");
                String Creado_por = request.getParameter("creado_por");
                int pais_id = Integer.parseInt(request.getParameter("pais_id"));
                Ciudad ciu = new Ciudad();
                ciu.setCiudad_id(ciudad_id);
                ciu.setNombre(Nombre);
                ciu.setCreado_por(Creado_por);
                ciu.setPais_id(pais_id);
                ciu.ActualizarHabilidad();
                response.sendRedirect("Ciudades/index.jsp");

            }
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
