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
@WebServlet(name = "ControladorEditarPedido", urlPatterns = {"/ControladorEditarPedido"})
public class ControladorEditarPedido extends HttpServlet {

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
            out.println("<title>Servlet ControladorEditarPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEditarPedido at " + request.getContextPath() + "</h1>");
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
           String id =request.getParameter("id_pedido");
           float subtotal=Float.valueOf(request.getParameter("subtotal"));
           float igv=Float.valueOf(request.getParameter("igv"));
           float total=Float.valueOf(request.getParameter("total"));
           String fechacreacion= request.getParameter("fechacreacion");
           String fechaentrega= request.getParameter("fechaentrega");
           String hora= request.getParameter("horaentrega");
           String estado=request.getParameter("estado");
           String tipopago=request.getParameter("tipopago");
           String repartidor=request.getParameter("repartidor");
           String ordenpedido=request.getParameter("ordenpedido");
           String id_usuario =(request.getParameter("id_usuario"));
           
           
           Pedido ped=new Pedido();
           DaoPedido daoPedidos = new DaoPedido();
           ped.setId(id);
           ped.setSubtotal(subtotal);
           ped.setIgv(igv);
           ped.setTotal(total);
           ped.setFecha_creacion(fechacreacion);
           ped.setFecha_entrega(fechaentrega);
           ped.setHora(hora);
           ped.setEstado(estado);
           ped.setTipoPago(tipopago);
           ped.setRepartidor(repartidor);
           ped.setOrdenpedido(ordenpedido);
           ped.setId_usuario(id_usuario);
           //ENVIO AL DAO
           daoPedidos.editar(ped);
           

           request.getRequestDispatcher("editarPedido.jsp").
                                           forward(request, response);
    }
}
