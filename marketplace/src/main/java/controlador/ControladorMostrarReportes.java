/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DaoPedido;
import modelo.Pedido;

/**
 *
 * @author Sketcher
 */
@WebServlet(name = "ControladorMostrarReportes", urlPatterns = {"/ControladorMostrarReportes"})
public class ControladorMostrarReportes extends HttpServlet {

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
            out.println("<title>Servlet ControladorMostrarReportes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorMostrarReportes at " + request.getContextPath() + "</h1>");
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

        String met;

        met = request.getParameter("metodo");
        switch (met) {
            case "listar":
                lista(request, response);
                break;
            case "filtrar":
                filtro(request, response);
                break;
            default:
                lista(request, response);

        }
    }

    protected void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prmtienda;
        String param = "";
        prmtienda = request.getParameter("txtTienda");
        DaoPedido daoPed = new DaoPedido();
        List<Pedido> lista = daoPed.ConsultarPedidosReporte(prmtienda, param);

        request.setAttribute("listPed", lista);
        request.setAttribute("idTienda", prmtienda);

        request.getRequestDispatcher("/ReporteAdm.jsp").
                forward(request, response);

    }

    protected void filtro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String param = "";
        String prmtienda = request.getParameter("txtTienda");
        String prmcliente = request.getParameter("cliente");
        String prminicio = request.getParameter("fInicio");
        String prmfin = request.getParameter("fFin");
        String prmcomp = request.getParameter("comp");
        String prmmonto = request.getParameter("monto");
        String prmestado = request.getParameter("estado");

        DaoPedido daoPed = new DaoPedido();

        if (!(prmcliente.isEmpty())) {
            param = param + "AND CONCAT(pe.nombre,' ',pe.primerapellido,' ',pe.segundoapellido) LIKE '%" + prmcliente.replace(" ", "%") + "%' ";
        }

        if (prminicio.isEmpty() && !(prmfin.isEmpty())) {
            prminicio = prmfin;
        }
        if (prmfin.isEmpty() && !(prminicio.isEmpty())) {
            prmfin = prminicio;
        }
        if (prminicio.isEmpty() && prmfin.isEmpty()) {
        } else {
            if (prmfin.compareTo(prminicio) < 0) {
                String tmp = prmfin;
                prmfin = prminicio;
                prminicio = tmp;

            }
            param = param + "AND p.fechacreacion BETWEEN '" + prminicio + "' AND '" + prmfin + "' ";
        }
        if (prmmonto.isEmpty()) {
        } else {
            param = param + "AND p.total " + prmcomp + " " + prmmonto + " ";
        }
        if (prmestado.isEmpty()) {
        } else {
            param = param + "AND p.estado = " + prmestado + " ";
        }

        List<Pedido> lista = daoPed.ConsultarPedidosReporte(prmtienda, param);
        request.setAttribute("listPed", lista);
        request.setAttribute("idTienda", prmtienda);

        request.getRequestDispatcher("/ReporteAdm.jsp").
                forward(request, response);

    }

}
