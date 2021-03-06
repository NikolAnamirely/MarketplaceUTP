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
import java.util.List;
import modelo.DaoSeleccionar;
import modelo.DaoVendedor;
import modelo.Seleccionar;
import modelo.Vendedor;


/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorVendedorId", urlPatterns = {"/ControladorVendedorId"})
public class ControladorVendedorId extends HttpServlet {

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
            out.println("<title>Servlet ControladorVendedorId</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVendedorId at " + request.getContextPath() + "</h1>");
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

            DaoSeleccionar dao= new DaoSeleccionar();
            
            //OBTENER DATOS DE DISTRITO
            List<Seleccionar> list= dao.Cargar("distrito");
            request.setAttribute("cmbdistritos", list);
            
            //OBTENER DATOS DE DISTRITO
            List<Seleccionar> list2= dao.Cargar("tipo_direccion");
            request.setAttribute("cmbtipodireccion", list2);
            
            String prmVendedor;
            //OBTENER ID PEDIDO
            prmVendedor = request.getParameter("idven");
            //DECLARAR DAOS
            DaoVendedor daoven = new DaoVendedor();
            //OBTNENER OBJETO CON DATOS DEL PED SELECCIONADO
            Vendedor obVendedor = daoven.ConsultarVendedoresId(prmVendedor);
            //ENVIAR OBJETO
            request.setAttribute("edit", obVendedor);

            //DEVOLVER A EDITAR
            request.getRequestDispatcher("editarVendedor.jsp").forward(request, response);
    }
}
