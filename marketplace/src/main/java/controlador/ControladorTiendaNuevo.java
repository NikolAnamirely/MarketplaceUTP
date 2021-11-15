package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DaoTienda;
import modelo.Tienda;
import modelo.DaoVendedor;



/**
 *
 * @author andre
 */
@WebServlet(name = "ControladorTiendaNuevo", urlPatterns = {"/ControladorTiendaNuevo"})
public class ControladorTiendaNuevo extends HttpServlet {
    public ControladorTiendaNuevo()
    {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String latitud = request.getParameter("latitud");
        String longitud = request.getParameter("longitud");
        String calificacion = request.getParameter("calificacion");
        String activo = request.getParameter("activo");
        String id_tipodir = request.getParameter("id_tipodireccion");
        String id_persona = request.getParameter("id_persona");
        String id_distrito = request.getParameter("id_distrito");
        Tienda tien=new Tienda();
        //Envio
        //tien.setId(Integer.parseInt(id_tienda));
        tien.setNombre(nombre);
        tien.setDireccion(direccion);
        tien.setActivo(Integer.parseInt(activo));
        tien.setLatitud(latitud);
        tien.setLongitud(longitud);
        tien.setCalificacion(Integer.parseInt(calificacion));
        tien.setId_distrito(Integer.parseInt(id_distrito));
        tien.setId_tipodir(Integer.parseInt(id_tipodir));
        DaoVendedor daoven =new DaoVendedor();
        tien.setId_persona(daoven.ultimoVendedor().getId());

        DaoTienda daotien = new DaoTienda();
        daotien.insertarTienda(tien);

           request.getRequestDispatcher("/index.jsp").
                                           forward(request, response);
    
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
