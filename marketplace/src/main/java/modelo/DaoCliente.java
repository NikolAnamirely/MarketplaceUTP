package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MysqlDBConexion;

public class DaoCliente {

    public String ObtenerDistrito(String username) {
        String id_distrito=null;
        String sql = "SELECT id_distrito "
                + "FROM persona "
                + "WHERE id_persona=(select id_persona from usuario where usuario='"
                + username + "')";
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            
            rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                id_distrito=rs.getString(1);
                
                
            }

            cnx.close();
        } catch (SQLException e) {
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
            } catch (SQLException e2) {
            }
        }
        return id_distrito;
    }

    public List<Cliente> ConsultarClientes(String idcliente) {
        List<Cliente> lst = new ArrayList<Cliente>();
        String sql = "select * from persona where id_persona = ?";
        //Connection cnx = getConnection();
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.prepareStatement(sql);
            stm.setString(1, idcliente);
            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            rs = stm.executeQuery();
            //CREAMOS OBJETO PRODUCTO
            Cliente c = null;
            while (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setPrimerapellido(rs.getString(3));
                c.setSegundoapellido(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setActivo(rs.getInt(7));
                c.setDireccion(rs.getString(8));
                c.setTipodireccion(rs.getInt(9));
                c.setDistrito(rs.getInt(10));
                lst.add(c);
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

    /*
	public List<Cliente> consultarClientes() {
	        List<Cliente> lst = new ArrayList<Cliente>();
	        String sql = "select id_persona,nombre,primerapellido,segundoapellido,email,telefono,activo,direccion, tipodireccion,distrito from persona";
	        Connection cnx = getConnection();
	        ResultSet rs;
	        try {
	            PreparedStatement stm = cnx.prepareStatement(sql);
	            rs = stm.executeQuery();
	            while (rs.next()) {
	            	Cliente c = new Cliente();
	            	c = new Cliente();
                        c.setId(rs.getString(1));
                        c.setNombre(rs.getString(2));
                        c.setPrimerapellido(rs.getString(3));
                        c.setSegundoapellido(rs.getString(4));
                        c.setEmail(rs.getString(5));
                        c.setTelefono(rs.getString(6));
                        c.setActivo(rs.getInt(7));
                        c.setDireccion(rs.getString(8));
                        c.setTipodireccion(rs.getString(9));
                        c.setDistrito(rs.getString(10));
	                lst.add(c);
	            }
	            cnx.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return lst;
	    }
     */

    public void insertarCliente(Cliente clienteNuevo) {
        String sql = "insert into persona(id_persona,nombre,primerapellido,segundoapellido,email,telefono,activo,direccion, id_tipodireccion,id_distrito) values (NULL,UPPER(?), UPPER(?), UPPER(?), UPPER(?), ?, ?, UPPER(?), ?, ?)";
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            stm.setString(1, clienteNuevo.getNombre());
            stm.setString(2, clienteNuevo.getPrimerapellido());
            stm.setString(3, clienteNuevo.getSegundoapellido());
            stm.setString(4, clienteNuevo.getEmail());
            stm.setString(5, clienteNuevo.getTelefono());
            stm.setInt(6, clienteNuevo.getActivo());
            stm.setString(7, clienteNuevo.getDireccion());
            stm.setInt(8, clienteNuevo.getTipodireccion());
            stm.setInt(9, clienteNuevo.getDistrito());
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

    public Cliente ultimoCliente() {
        Cliente cli = new Cliente();

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

                cli.setId(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setPrimerapellido(rs.getString(3));
                cli.setSegundoapellido(rs.getString(4));
                cli.setEmail(rs.getString(5));
                cli.setTelefono(rs.getString(6));
                cli.setActivo(rs.getInt(7));
                cli.setDireccion(rs.getString(8));
                cli.setTipodireccion(rs.getInt(9));
                cli.setDistrito(rs.getInt(10));

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
        return cli;
    }
}
