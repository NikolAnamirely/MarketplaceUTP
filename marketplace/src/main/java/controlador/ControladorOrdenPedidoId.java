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
@WebServlet(name = "ControladorOrdenPedidoId", urlPatterns = {"/ControladorOrdenPedidoId"})
public class ControladorOrdenPedidoId extends HttpServlet {

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
            out.println("<title>Servlet ControladorOrdenPedidoId</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorOrdenPedidoId at " + request.getContextPath() + "</h1>");
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

 
            String prmPedido;
            //OBTENER ID PEDIDO
            prmPedido = request.getParameter("idped");
            //DECLARAR DAOS
            DaoPedido daoPedidos = new DaoPedido();
            //OBTNENER OBJETO CON DATOS DEL PED SELECCIONADO
            Pedido obPedido = daoPedidos.ConsultarPedidosId(prmPedido);
            //ENVIAR OBJETO
            request.setAttribute("edit", obPedido);

            String prmusuario = request.getParameter("txtUsuario");
            request.setAttribute("txtUsuario", prmusuario);
            System.out.println("U:"+prmusuario);
            
            //DEVOLVER A EDITAR
            request.getRequestDispatcher("ordenPedido.jsp").forward(request, response);
    }
}
