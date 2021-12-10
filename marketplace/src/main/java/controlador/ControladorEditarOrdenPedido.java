/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.DaoCliente;
import modelo.DaoPedido;
import modelo.DaoTienda;
import modelo.DaoVendedor;
import modelo.Pedido;
import modelo.Tienda;
import modelo.Vendedor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import utils.Conectar;
import utils.Correo;
import utils.MysqlDBConexion;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ControladorEditarOrdenPedido", urlPatterns = {"/ControladorEditarOrdenPedido"})
public class ControladorEditarOrdenPedido extends HttpServlet {

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
            out.println("<title>Servlet ControladorEditarOrdenPedido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEditarOrdenPedido at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {

        //OBTENER DATOS
        String id = request.getParameter("id_pedido");
        float subtotal = Float.valueOf(request.getParameter("subtotal"));
        float igv = Float.valueOf(request.getParameter("igv"));
        float total = Float.valueOf(request.getParameter("total"));
        String fechacreacion = request.getParameter("fechacreacion");
        String fechaentrega = request.getParameter("fechaentrega");
        String hora = request.getParameter("horaentrega");
        String estado = request.getParameter("estado");
        String tipopago = request.getParameter("tipopago");
        String repartidor = request.getParameter("repartidor");
        String ordenpedido = request.getParameter("ordenpedido");
        String id_usuario = (request.getParameter("id_usuario"));
        String prmusuario = request.getParameter("txtUsuario");

        Pedido ped = new Pedido();
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
 
        DaoCliente cliente = new DaoCliente();
        String correo = prmusuario;

        PrintWriter out = response.getWriter();
        try {
            InputStream inputStream;
            inputStream = new FileInputStream("D:\\CESAR\\Documentos\\NetBeansProjects\\marketplace\\reporte\\nota.jrxml");

            if (inputStream != null) {
                LocalDate fecha = LocalDate.now();
                JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
                JasperReport report = JasperCompileManager.compileReport("D:\\CESAR\\Documentos\\NetBeansProjects\\marketplace\\reporte\\nota.jrxml");

                Conectar con = new Conectar("jdbc:mysql://localhost/db_marketplace");
                Map<String, Object> parameters = new HashMap();

                parameters.put("id_pedido", id);

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con.getConnection());

                String nombre = "notapedido" + String.valueOf(fecha) + "" + id_usuario + ".pdf";
                String ruta = "D:\\CESAR\\Documentos\\NetBeansProjects\\marketplace\\reporte\\" + nombre;
                JasperExportManager.exportReportToPdfFile(jasperPrint, ruta);

                Correo c = new Correo();
                c.enviarNotaPedido(ruta, nombre, correo);
                
            } else {
                response.setContentType("text/plain");
                out.println("no se pudo generar el reporte");
                out.println("esto puede debrse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
                out.println("contacte a soporte");
            }
        } catch (Exception e) {
            response.setContentType("text/plain");
            out.print("ocurrió un error al intentar generar el reporte:" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("U:" + prmusuario);

        request.getRequestDispatcher("ControladorBuscarTienda?txtUsuario=" + prmusuario).
                forward(request, response);
    }
}
