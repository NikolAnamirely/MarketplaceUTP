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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import modelo.DaoCliente;
import modelo.DaoDetalle;
import modelo.DaoSeleccionar;
import modelo.DaoTienda;
import modelo.DaoUsuario;
import modelo.Seleccionar;
import modelo.Tienda;

/**
 *
 * @author Sketcher
 */
@WebServlet(name = "ControladorListarTiendas", urlPatterns = {"/ControladorListarTiendas"})
public class ControladorListarTiendas extends HttpServlet {

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
            out.println("<title>Servlet ControladorListarTiendas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorListarTiendas at " + request.getContextPath() + "</h1>");
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

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idnom,idus;
        idnom = request.getParameter("txtUsuario");
        String tt = null;
        tt = request.getParameter("pruebilla");
        String id_distrito;
        idus = request.getParameter("iduser");
    //DAOS
        DaoCliente cli = new DaoCliente();
        DaoSeleccionar dao = new DaoSeleccionar();
        DaoTienda daotienda = new DaoTienda();
        DaoDetalle daodet = new DaoDetalle();
    //OBTENER DISTRITO
        id_distrito = cli.ObtenerDistrito(idnom);
        ArrayList<Tienda> tiendas = daotienda.listarTiendasMapa(id_distrito);
        List<Seleccionar> list = dao.Cargar("distrito");

        
        request.setAttribute("listaDistritos", list);

       
        String codPed = daodet.generarIdPedido(idnom);
        HttpSession session = request.getSession(true);
        session.setAttribute("codpedido", codPed);

        session.setAttribute("ubicaciones", tiendas);
        session.setAttribute("iduser", idus);
        System.out.println("ID: "+codPed);

        //3 Se reenvia el request al formulario 
        request.getRequestDispatcher("/vistaUbicaciones.jsp").
                forward(request, response);
    }
}
