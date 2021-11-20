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

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorCalificacion", urlPatterns = {"/ControladorCalificacion"})
public class ControladorCalificacion extends HttpServlet {

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
            out.println("<title>Servlet ControladorCalificacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCalificacion at " + request.getContextPath() + "</h1>");
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
            //DECLARO
            String prmTienda,prmuser,action,idcalificacion,numer,comentario;
            //OBTENGO CODTIENDA Y CODPEDIDO
            prmuser = request.getParameter("user");
            action = request.getParameter("action");
            
            DaoTienda daoTienda = new DaoTienda();
            
            if(action.equals("1")){
                prmTienda = request.getParameter("txtTienda");
                
                idcalificacion= daoTienda.Calificacion(prmuser,prmTienda);
                request.setAttribute("id_cal", idcalificacion);
                request.setAttribute("user", prmuser);
                request.getRequestDispatcher("/Calificacion.jsp").
                                            forward(request, response);
            }else{
                numer = request.getParameter("numeracion");
                comentario = request.getParameter("comentario");
                idcalificacion = request.getParameter("id_cal");
                System.out.println("NUMERO: "+numer);
                daoTienda.InsertarCalificacion(numer,comentario,idcalificacion);
                request.getRequestDispatcher("ControladorListarTiendas?txtUsuario="+prmuser).
                                            forward(request, response);
            }
    }
}
