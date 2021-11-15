/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.InputStream;
import modelo.DaoProducto;
import modelo.Producto;

/**
 *
 * @author Lenovo
 */
@MultipartConfig
@WebServlet(name = "ControladorEditarProducto", urlPatterns = {"/ControladorEditarProducto"})
public class ControladorEditarProducto extends HttpServlet {

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
            out.println("<title>Servlet ControladorEditarProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEditarProducto at " + request.getContextPath() + "</h1>");
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
        

           //OBTENER DATOS
           String id = request.getParameter("codigo");
           Double costo=Double.parseDouble(request.getParameter("costo"));
           String Estad=request.getParameter("estado");
           String nombre=request.getParameter("nombre");
           String unidad=request.getParameter("unidad");
           String marca=request.getParameter("marca");
           String desc=request.getParameter("descripcion");
           String categoria=request.getParameter("categoria");
           String tienda=request.getParameter("tienda");
           //FOTO
           Part part=request.getPart("fileFoto");
           InputStream inputStream=part.getInputStream();
        //CREO INSTANCIA PROD
            Producto prod=new Producto();
            DaoProducto daoProductos = new DaoProducto();
        //ENVIO AL OBJETO
            prod.setCodigo(id);
            prod.setCosto(costo);
            prod.setNombre(nombre);
            prod.setDescripcion(desc);
            //ESTADO
            if(Estad.equals("Agotado"))
                 prod.setEstado("0");
            else
                 prod.setEstado("1");
            //FOTO
            prod.setFoto(inputStream);
            //OBTENGO CODIGO MARCA, CATEGORIA, UNIDAD
            String idmarca=daoProductos.NuevoCodigo(marca,"marca");
            String idunidad=daoProductos.NuevoCodigo(unidad,"unidades_medida");
            String idcategoria=daoProductos.NuevoCodigo(categoria,"categoria");
            prod.setUnidades(idunidad);
            prod.setCategoria(idcategoria);
            prod.setMarca(idmarca);
           //ENVIO AL DAO
           
           daoProductos.editar(prod);
           //ENVIO AL CAMBIO IMAGEN
            if(inputStream.available() != 0){
            daoProductos.editarImagen(prod);}
           

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
