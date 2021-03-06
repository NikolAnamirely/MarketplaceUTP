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
import modelo.DaoUsuario;
import modelo.Usuario;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorAutentificar", urlPatterns = {"/ControladorAutentificar"})
public class ControladorAutentificar extends HttpServlet {

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
            out.println("<title>Servlet ControladorAutentificar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAutentificar at " + request.getContextPath() + "</h1>");
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
        try
            {	    

                Usuario user= new Usuario();
                String username=request.getParameter("txtUsuario");
                user.setUsuario(username);
                user.setPassword(request.getParameter("txtPass"));
                
                user = DaoUsuario.VerificarUsuario(user);
                String rol=user.getRol();
                if (user.isValid())
                {
                    HttpSession sesion = request.getSession();
                    sesion.invalidate();
                    HttpSession session = request.getSession(true);	    
                    session.setAttribute("currentSessionUser",user);
                    session.setAttribute("currentUser",username);
                    
                    
                    if(rol.equals("1")){
                        response.sendRedirect("ControladorBuscarTienda?txtUsuario="+username); //vendedor 
                    }else if (rol.equals("2")){
                        String idusuario=DaoUsuario.obtenerId(username);
                        response.sendRedirect("ControladorListarTiendas?txtUsuario="+username+"&iduser="+idusuario);//cliente
                    }else if (rol.equals("3")){
                        response.sendRedirect("Administrador.jsp");//administrador
                    }
                            
                }

                else 
                     response.sendRedirect("login.jsp"); //error page 
           } 


           catch (Throwable theException) 	    
           {
                System.out.println(theException); 
           }
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
