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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import modelo.DaoProducto;
import modelo.Producto;

/**
 *
 * @author Lenovo
 */
@MultipartConfig
@WebServlet(name = "ControladorAgregarProd", urlPatterns = {"/ControladorAgregarProd"})
public class ControladorAgregarProd extends HttpServlet {

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
            out.println("<title>Servlet ControladorAgregarProd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAgregarProd at " + request.getContextPath() + "</h1>");
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
         //OBTENGO DATOS DEL JSP
           String estado,id="";
           Double costo=Double.parseDouble(request.getParameter("costo"));
           String marca=request.getParameter("marca");
           String nombre=request.getParameter("nombre");
           String categoria=request.getParameter("categoria");
           String desc=request.getParameter("descripcion");
           String estadoS=request.getParameter("estado");
           String unidades=request.getParameter("unidad");
           String tienda=request.getParameter("tienda");
        //FOTO
           Part part=request.getPart("fileFoto");
           InputStream inputStream=part.getInputStream();
           
           if(estadoS.equals("Agotado"))
                estado="0";
           else
               estado="1";
           
           
           Producto prod=new Producto();
           DaoProducto daoProductos = new DaoProducto();
           
           //GENERO CODIGO MARCA, CATEGORIA
           String idmarca=daoProductos.NuevoCodigo(marca,"marca");
           String idcategoria=daoProductos.NuevoCodigo(categoria,"categoria");
           //CREO UN OBJETO
           prod.setCodigo(id);
           prod.setNombre(nombre);
           prod.setCosto(costo);
           prod.setEstado(estado);
           prod.setTienda(tienda);
           prod.setDescripcion(desc);
           prod.setMarca(idmarca);
           prod.setCategoria(idcategoria);
           prod.setUnidades(unidades);
           prod.setFoto(inputStream);
           daoProductos.insertar(prod);
           //DEVUELCO RSPUESTA AL CATALOGO DE LA TIENDA
           request.getRequestDispatcher("ControladorProductoTienda?txtTienda="+tienda+"&termino=nada&criterio=nada").
                                           forward(request, response);
    
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
 
}
