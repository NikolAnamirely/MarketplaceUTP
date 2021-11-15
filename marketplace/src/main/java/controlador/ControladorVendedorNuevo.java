package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Vendedor;
import modelo.DaoVendedor;
import modelo.DaoUsuario;
import modelo.Usuario;

/**
 *
 * @author andre
 */
@WebServlet(name = "ControladorVendedorNuevo", urlPatterns = {"/ControladorVendedorNuevo"})
public class ControladorVendedorNuevo extends HttpServlet {
    public ControladorVendedorNuevo()
    {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String primerapellido = request.getParameter("primerapellido");
        String segundoapellido = request.getParameter("segundoapellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String activo = request.getParameter("activo");
        String direccion = request.getParameter("direccion");
        String id_tipodir = request.getParameter("id_tipodireccion");
        String id_distrito = request.getParameter("id_distrito");
        String password = request.getParameter("password");
        
        Vendedor ven=new Vendedor();
        //Envio
        //cli.setId(Integer.parseInt(id_persona));
        ven.setNombre(nombre);
        ven.setPrimerapellido(primerapellido);
        ven.setSegundoapellido(segundoapellido);
        ven.setEmail(email);
        ven.setTelefono(telefono);
        ven.setActivo(Integer.parseInt(activo));
        ven.setDireccion(direccion);
        ven.setTipodireccion(Integer.parseInt(id_tipodir));
        ven.setDistrito(Integer.parseInt(id_distrito));
        DaoVendedor daoven = new DaoVendedor();
        DaoUsuario daousu =new DaoUsuario();
        daoven.insertarVendedor(ven);
        Usuario usu = new Usuario();
        usu.setUsuario(email);
        usu.setPassword(password);
        usu.setRol("1");
        usu.setActivo(1);
        usu.setPersona(String.valueOf(daoven.ultimoVendedor().getId()));
        daousu.insertarUsuario(usu);
        
           request.getRequestDispatcher("/ControladorCargarCriteriosTienda").
                                           forward(request, response);
    
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
