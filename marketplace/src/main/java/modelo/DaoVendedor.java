package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MysqlDBConexion;

public class DaoVendedor {

    public List<Vendedor> ConsultarVendedores() {
        List<Vendedor> lst = new ArrayList<Vendedor>();
        String sql = "select p.id_persona,p.nombre,p.primerapellido,p.segundoapellido,p.email,p.telefono,p.activo,p.direccion,p.id_tipodireccion,p.id_distrito, u.id_rol from persona p inner join usuario u on p.id_persona=u.id_persona where u.id_rol=1";
        //Connection cnx = getConnection();
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.prepareStatement(sql);
            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            rs = stm.executeQuery();
            //CREAMOS OBJETO PRODUCTO
            Vendedor v = null;
            while (rs.next()) {
                v = new Vendedor();
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setPrimerapellido(rs.getString(3));
                v.setSegundoapellido(rs.getString(4));
                v.setEmail(rs.getString(5));
                v.setTelefono(rs.getString(6));
                v.setActivo(rs.getInt(7));
                v.setDireccion(rs.getString(8));
                v.setTipodireccion(rs.getInt(9));
                v.setDistrito(rs.getInt(10));
                lst.add(v);
            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (Exception e2) {
            }
        }
        return lst;
    }
    public Vendedor ConsultarVendedoresId(String idvendedor) 
    {
            List<Vendedor> lst = new ArrayList<Vendedor>();
            String sql = "select p.id_persona,p.nombre,p.primerapellido,p.segundoapellido,p.email,p.telefono,p.activo,p.direccion,p.id_tipodireccion,p.id_distrito from persona p where p.id_persona='"+
                    idvendedor+"'";
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
            Vendedor resp = new Vendedor();
            try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setPrimerapellido(rs.getString(3));
                v.setSegundoapellido(rs.getString(4));
                v.setEmail(rs.getString(5));
                v.setTelefono(rs.getString(6));
                v.setActivo(rs.getInt(7));
                v.setDireccion(rs.getString(8));
                v.setTipodireccion(rs.getInt(9));
                v.setDistrito(rs.getInt(10));
                lst.add(v);
                
            }
            for(Vendedor aux :lst)
            {
                resp=aux;
            }
            cnx.close();
            
            
        } 
       catch (Exception e) 
        {
                e.printStackTrace();
                System.out.print(e);
        } 
        finally
        {
                try 
                {
                        if(rs!= null) rs.close();
                        if(stm!= null) stm.close();
                        if(cnx!= null) cnx.close();
                } 
                catch (Exception e2) 
                {
                }
        }
        return resp;
    }

    public void insertarVendedor(Vendedor vendedorNuevo) {
        String sql = "insert into persona(id_persona,nombre,primerapellido,segundoapellido,email,telefono,activo,direccion, id_tipodireccion,id_distrito) values (NULL,UPPER(?), UPPER(?), UPPER(?), UPPER(?), ?, ?, UPPER(?), ?, ?)";
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            stm.setString(1, vendedorNuevo.getNombre());
            stm.setString(2, vendedorNuevo.getPrimerapellido());
            stm.setString(3, vendedorNuevo.getSegundoapellido());
            stm.setString(4, vendedorNuevo.getEmail());
            stm.setString(5, vendedorNuevo.getTelefono());
            stm.setInt(6, vendedorNuevo.getActivo());
            stm.setString(7, vendedorNuevo.getDireccion());
            stm.setInt(8, vendedorNuevo.getTipodireccion());
            stm.setInt(9, vendedorNuevo.getDistrito());
            stm.executeUpdate();
            //cnx.commit();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("ERROR AGREGAR:" + e);

        } finally {
            try {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (Exception e) {
                    }
                    rs = null;
                }

                if (stm != null) {
                    try {
                        stm.close();
                    } catch (Exception e) {
                    }
                    stm = null;
                }

                if (cnx != null) {
                    try {
                        cnx.close();
                    } catch (Exception e) {
                    }

                    cnx = null;
                }

            } catch (Exception e2) {
            }
        }
    }

    public Vendedor ultimoVendedor() {
        Vendedor ven = new Vendedor();

        String sql = "SELECT * FROM persona ORDER BY id_persona DESC LIMIT 1";
        //Connection cnx = getConnection();
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.prepareStatement(sql);
            
            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            rs = stm.executeQuery();
            //CREAMOS OBJETO PRODUCTO

            while (rs.next()) {

                ven.setId(rs.getInt(1));
                ven.setNombre(rs.getString(2));
                ven.setPrimerapellido(rs.getString(3));
                ven.setSegundoapellido(rs.getString(4));
                ven.setEmail(rs.getString(5));
                ven.setTelefono(rs.getString(6));
                ven.setActivo(rs.getInt(7));
                ven.setDireccion(rs.getString(8));
                ven.setTipodireccion(rs.getInt(9));
                ven.setDistrito(rs.getInt(10));

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (Exception e2) {
            }
        }
        return ven;
    }
    public Vendedor editar(Vendedor ven) 
    {
        int id = ven.getId();
        String nombre= ven.getNombre();
        String primerapellido= ven.getPrimerapellido();
        String segundoapellido= ven.getSegundoapellido();
        String email= ven.getEmail();
        String telefono= ven.getTelefono();
        int activo= ven.getActivo();
        String direccion= ven.getDireccion();
        int tipodireccion= ven.getTipodireccion();
        int distrito=ven.getDistrito();

        String sql = "update persona set nombre='"+nombre+"',primerapellido='"+primerapellido+"',segundoapellido='"+segundoapellido+"',email='"+email+"',telefono='"+telefono+"',activo="+activo+",direccion='"+direccion+"',id_tipodireccion="+tipodireccion+",id_distrito="+distrito+" where id_persona="+id;
        //Connection cnx = getConnection();
        Connection cnx= null;
        Statement stm = null;
        Vendedor v = null;
        try 
        {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            stm.executeUpdate(sql);

            cnx.close();
            
            
        } 
       catch (Exception e) 
        {
                e.printStackTrace();
                System.out.print(e);
        } 
        finally
        {
                try 
                {
                        if(stm!= null) stm.close();
                        if(cnx!= null) cnx.close();
                } 
                catch (Exception e2) 
                {
                }
        }
        return v;
    }
}
