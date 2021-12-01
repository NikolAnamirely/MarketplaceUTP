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
import modelo.DaoPedido;
import modelo.Pedido;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorMostrarPedidosAten", urlPatterns = {"/ControladorMostrarPedidosAten"})
public class ControladorMostrarPedidosAten extends HttpServlet {

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
            out.println("<title>Servlet ControladorMostrarPedidosAten</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorMostrarPedidosAten at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException 
    {

            String prmtienda,busqueda,termino,criterio;
            prmtienda = request.getParameter("txtTienda");
            busqueda = request.getParameter("busqueda");
            
            List<Pedido> lista=null;
            DaoPedido daoPed=new DaoPedido();
            
            if(busqueda==null){
                lista = daoPed.ConsultarPedidosTienda(prmtienda);
            }else{
                criterio = request.getParameter("criterio");
                termino = request.getParameter("termino");
                lista = daoPed.BusquedaPedidosTienda(prmtienda, criterio, termino);
            }

            request.setAttribute("listPed", lista);
            
            String prmusuario = request.getParameter("txtUsuario");
            request.setAttribute("txtUsuario", prmusuario);
            request.setAttribute("txtTienda", prmtienda);
            
            System.out.println("U:"+prmusuario);
            System.out.println("T:"+prmtienda);
            
            request.getRequestDispatcher("/PedidoAdmAten.jsp").
                                            forward(request, response);
    }
}
