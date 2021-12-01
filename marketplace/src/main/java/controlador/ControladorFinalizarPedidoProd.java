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
import modelo.DaoPedido;
import modelo.Pedido;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorFinalizarPedidoProd", urlPatterns = {"/ControladorFinalizarPedidoProd"})
public class ControladorFinalizarPedidoProd extends HttpServlet {

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
            out.println("<title>Servlet ControladorFinalizarPedidoProd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFinalizarPedidoProd at " + request.getContextPath() + "</h1>");
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
            //PARAMETRO PEDIDO
            String  prmPedido;
            prmPedido = request.getParameter("codigoPed");
            String prmtienda;
            prmtienda = request.getParameter("txtTienda");
            String prmusuario = request.getParameter("txtUsuario");
            //LLAMO AL DAO
            DaoPedido daoPedidos = new DaoPedido();
            //LLENO LOS TOTALES
            daoPedidos.InsertarTotales(prmPedido);
            
            //OBTENER DATOS DEL PEDIDO
            Pedido obPedido = daoPedidos.ConsultarPedidosId(prmPedido);
            //DEBUELVO EL CODIGO PEDIDO
            request.setAttribute("codpedido", prmPedido);
            //DEVUELVO EL OBJETO PEDIDO
            request.setAttribute("edit", obPedido);
            
            System.out.println("U:"+prmusuario);
            //MUESTRO EN REGISTRAR PEDIDO
            request.getRequestDispatcher("ControladorMostrarPedidos?txtTienda="+prmtienda+"&txtUsuario="+prmusuario).
                                            forward(request, response);
    }
}
