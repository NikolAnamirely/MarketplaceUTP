package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.DaoCliente;
import modelo.DaoUsuario;
import modelo.Usuario;

/**
 *
 * @author andre
 */
@WebServlet(name = "ControladorClienteNuevo", urlPatterns = {"/ControladorClienteNuevo"})
public class ControladorClienteNuevo extends HttpServlet {
    public ControladorClienteNuevo()
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
        
        Cliente cli=new Cliente();
        //Envio
        //cli.setId(Integer.parseInt(id_persona));
        cli.setNombre(nombre);
        cli.setPrimerapellido(primerapellido);
        cli.setSegundoapellido(segundoapellido);
        cli.setEmail(email);
        cli.setTelefono(telefono);
        cli.setActivo(Integer.parseInt(activo));
        cli.setDireccion(direccion);
        cli.setTipodireccion(Integer.parseInt(id_tipodir));
        cli.setDistrito(Integer.parseInt(id_distrito));
        DaoCliente daocli = new DaoCliente();
        DaoUsuario daousu =new DaoUsuario();
        daocli.insertarCliente(cli);
        Usuario usu = new Usuario();
        usu.setUsuario(email);
        usu.setPassword(password);
        usu.setRol("2");
        usu.setActivo(1);
        usu.setPersona(String.valueOf(daocli.ultimoCliente().getId()));
        daousu.insertarUsuario(usu);
        
        
       

           request.getRequestDispatcher("/index.jsp").
                                           forward(request, response);
    
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
