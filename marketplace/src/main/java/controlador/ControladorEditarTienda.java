/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DaoTienda;
import modelo.Tienda;


/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorEditarTienda", urlPatterns = {"/ControladorEditarTienda"})
public class ControladorEditarTienda extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEditarTienda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEditarTienda at " + request.getContextPath() + "</h1>");
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

    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {

           
           //OBTENER DATOS
           String id = request.getParameter("id_tienda");
           String nombre = request.getParameter("nombre");
           String direccion = request.getParameter("direccion");
           String activo = request.getParameter("activo");
           String latitud = request.getParameter("latitud");
           String longitud = request.getParameter("longitud");
           String calificacion = request.getParameter("calificacion");
           String id_distrito = request.getParameter("id_distrito");
           String id_tipodir = request.getParameter("id_tipodireccion");
           String id_persona = request.getParameter("id_persona");

                    
           Tienda tien=new Tienda();
           DaoTienda daoTienda = new DaoTienda();
           
           tien.setId(Integer.parseInt(id));
           tien.setNombre(nombre);
           tien.setDireccion(direccion);
           tien.setActivo(Integer.parseInt(activo));
           tien.setLatitud(latitud);
           tien.setLongitud(longitud);
           tien.setCalificacion(Integer.parseInt(calificacion));
           tien.setId_distrito(Integer.parseInt(id_distrito));
           tien.setId_tipodir(Integer.parseInt(id_tipodir));
           tien.setId_persona(Integer.parseInt(id_persona));
           
           
            //ENVIO AL DAO
           daoTienda.editar(tien);
           
           
            
           
           

           request.getRequestDispatcher("ControladorMostrarTiendasAdmi").
                                           forward(request, response);
    }
}
