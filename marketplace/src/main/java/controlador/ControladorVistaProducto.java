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
import modelo.DaoProducto;
import modelo.DaoSeleccionar;
import modelo.Producto;
import modelo.Seleccionar;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorVistaProducto", urlPatterns = {"/ControladorVistaProducto"})
public class ControladorVistaProducto extends HttpServlet {

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
            out.println("<title>Servlet ControladorVistaProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVistaProducto at " + request.getContextPath() + "</h1>");
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
            String prmProducto,prmTienda,prmCrit,codPed,prmuser;
            //OBTENER ID PRODUCTO
            prmProducto = request.getParameter("idprod");
            //OBTENER ID TIENDA
            prmTienda = request.getParameter("tien");
            //OBTENER CRTERIO
            prmCrit = request.getParameter("crit");
            
            //DECLARAR DAOS
            DaoProducto daoProductos = new DaoProducto();
            //OBTNENER OBJETO CON DATOS DEL PROD SELECCIONADO
            Producto obProducto = daoProductos.ConsultarProductosId(prmProducto);
        
            //ENVIAR OBJETO
            request.setAttribute("edit", obProducto);
            //ENVIAR TIENDA
            request.setAttribute("tien", prmTienda);
            
            
            if(prmCrit.equalsIgnoreCase("1")){
                codPed = request.getParameter("codp");
                prmuser = request.getParameter("user");
                //ENVIAR TIENDA
                request.setAttribute("codp", codPed);
                request.setAttribute("user", prmuser);
                
                //DEVOLVER A EDITAR
                request.getRequestDispatcher("/vistaProductoCli.jsp").
                                            forward(request, response);
            }else{
                //DEVOLVER A EDITAR
                String prmusuario = request.getParameter("txtUsuario");
                request.setAttribute("txtUsuario", prmusuario);
                    System.out.println("A:"+prmusuario);
                request.getRequestDispatcher("/vistaProducto.jsp").
                                            forward(request, response);
            }
            
            
    }
}
