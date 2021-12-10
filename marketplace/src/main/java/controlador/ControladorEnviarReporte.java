/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DaoPedido;
import modelo.DaoTienda;
import modelo.Pedido;
import modelo.Tienda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.time.LocalDate;
import modelo.DaoVendedor;
import modelo.Vendedor;
import utils.Correo;

/**
 *
 * @author myers
 */
public class ControladorEnviarReporte extends HttpServlet {

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
            out.println("<title>Servlet ControladorEnviarReporte</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEnviarReporte at " + request.getContextPath() + "</h1>");

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
        HttpSession sesion = request.getSession();
        String prmtienda = String.valueOf(request.getParameter("txtTienda"));
        DaoTienda tienda = new DaoTienda();
        Tienda t  = tienda.ConsultarTiendaPorId(prmtienda);   
        DaoPedido ped = new DaoPedido();
        List<Pedido> lista2 = (List<Pedido>) sesion.getAttribute("lista");
        List<Pedido> lista = new ArrayList<>();
        lista.add(ped.pedidoVacio());
        lista.addAll(lista2);
        DaoVendedor vendedor = new DaoVendedor();
        Vendedor v =vendedor.ConsultarVendedoresId(prmtienda);
        String correo=v.getEmail();
        ServletOutputStream out = response.getOutputStream();
        try {
            InputStream inputStream;
            inputStream = new FileInputStream("D:\\CESAR\\Documentos\\NetBeansProjects\\marketplace\\reporte\\reportepedidos.jrxml");
            
            if (inputStream != null) {
                LocalDate fecha = LocalDate.now();
                JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
                JasperReport report = JasperCompileManager.compileReport(jasperDesign);
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lista.toArray());                
                Map<String, Object> parameters = new HashMap();
                parameters.put("ds", ds);
                parameters.put("tienda",t.getNombre());
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=ReportesPedidos.pdf");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
                out.close();
                String nombre="reporte-"+String.valueOf(fecha)+"-"+t.getNombre()+".pdf";
                String ruta="D:\\CESAR\\Documentos\\NetBeansProjects\\marketplace\\reporte\\"+nombre;
                JasperExportManager.exportReportToPdfFile(jasperPrint, ruta);
                
                Correo c = new Correo();
                c.enviarReporte(ruta,nombre, correo);
                
               
                
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

    }
}
