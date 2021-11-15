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
import modelo.Seleccionar;
import modelo.Tienda;

/**
 *
 * @author Sketcher
 */
@WebServlet(name = "ControladorListarPorDistrito", urlPatterns = {"/ControladorListarPorDistrito"})
public class ControladorListarPorDistrito extends HttpServlet {

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
            out.println("<title>Servlet ControladorListarPorDistrito</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorListarPorDistrito at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {

        String id = request.getParameter("id_distrito");
       
        String  iniciolat, iniciolong;
        float aculat = 0, aculong = 0;
        DaoCliente cli = new DaoCliente();
        DaoSeleccionar dao = new DaoSeleccionar();
       
        DaoTienda daotienda = new DaoTienda();
        

        ArrayList<Tienda> tiendas = daotienda.listarTiendasMapa(id);
        for (int i = 0; i < tiendas.size(); i++) {
            aculat = aculat + Float.parseFloat(tiendas.get(i).getLatitud());
            aculong = aculong + Float.parseFloat(tiendas.get(i).getLongitud());
        }
        iniciolat = String.valueOf(aculat / (float) tiendas.size());
        iniciolong = String.valueOf(aculong / (float) tiendas.size());
        
        List<Seleccionar> list = dao.Cargar("distrito");
        
        
        request.setAttribute("inicioLatitud", iniciolat);
        request.setAttribute("inicioLongitud", iniciolong);
        request.setAttribute("listaDistritos", list);
        

        request.setAttribute("tiendas", tiendas);

        //3 Se reenvia el request al formulario 
        request.getRequestDispatcher("/vistaPorDistrito.jsp").
                forward(request, response);
    }

}
