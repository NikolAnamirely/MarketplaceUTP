/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static modelo.DaoUsuario.cnx;
import static modelo.DaoUsuario.rs;
import utils.MysqlDBConexion;

/**
 *
 * @author Sketcher
 */
public class DaoTienda {
    public String Calificacion(String prmuser, String prmTienda) {
        String id,prmpersona="";
        id="1";
        String sqls = "select id_persona from usuario where id_usuario="+prmuser;
        String sqls2 = "select id_calificacion from calificacion";

            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
            
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            //EJECUTO LA PRIMERA CONSULTA
            rs = stm.executeQuery(sqls);
            while(rs.next()){
                prmpersona = rs.getString(1);
            }
            System.out.println("\nPERSONA: " + prmpersona);
            
            String sql = "insert into calificacion(id_calificacion,comentario,id_tienda,id_persona,id_numerica) values (NULL,NULL,"+prmTienda+","+prmpersona+",NULL)";
            //EJECUTO LA SEGUNDA CONSULTA
            stm.executeUpdate(sql);
            
            //EJECUTO LA TERCERA CONSULTA
            //stm = cnx.createStatement();
            rs = stm.executeQuery(sqls2);
            while(rs.next()){
                id = rs.getString(1);
            }
            System.out.println("\nIDCALIFICACION: " + id);
        } 
        catch (Exception e) 
        {
                e.printStackTrace();
                System.out.print("ERROR: !!"+e);
        } 
        finally
        {
                if (rs != null)	{
                    try {
                       rs.close();
                    } catch (Exception e) {}
                       rs = null;
                    }

                 if (stm != null) {
                    try {
                       stm.close();
                    } catch (Exception e) {}
                       stm = null;
                    }

                 if (cnx != null) {
                    try {
                       cnx.close();
                    } catch (Exception e) {
                    }

                    cnx = null;
                 }
        }
        return id;
    }
    public String ObtenerDistrito(String username){
            
            String sql = "select id_distrito from persona where id_persona=(select id_persona from usuario where usuario='"
                        + username+ "')";
            //Connection cnx = getConnection();
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
            
            String distrito=null;
        try 
        {
            rs = stm.executeQuery(sql);
            distrito = rs.getString(1);
            System.out.print(distrito);
        } 
        catch (Exception e) 
        {
                e.printStackTrace();
                System.out.print("ERROR: !!"+e);
        } 
        finally
        {
                if (rs != null)	{
                    try {
                       rs.close();
                    } catch (Exception e) {}
                       rs = null;
                    }

                 if (stm != null) {
                    try {
                       stm.close();
                    } catch (Exception e) {}
                       stm = null;
                    }

                 if (cnx != null) {
                    try {
                       cnx.close();
                    } catch (Exception e) {
                    }

                    cnx = null;
                 }
        }
        return distrito;
    }
    public Tienda ConsultarTiendaPorId(String idtienda) 
    {
            List<Tienda> lst = new ArrayList<Tienda>();
            String sql = "select t.id_tienda,t.nombre,t.direccion,t.activo,t.latitud,t.longitud,t.calificacion,d.id_distrito,i.id_tipodireccion,p.id_persona from tienda t inner join distrito d on t.id_distrito=d.id_distrito INNER JOIN tipo_direccion  on t.id_tipodireccion=i.id_tipodireccion INNER JOIN persona p on t.id_persona=p.id_persona where t.id_tienda='"+
                    idtienda+"'";
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
            Tienda resp = new Tienda();
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tienda t = new Tienda();
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setDireccion(rs.getString(3));
                t.setActivo(rs.getInt(4));
                t.setLatitud(rs.getString(5));
                t.setLongitud(rs.getString(6));
                t.setCalificacion(rs.getInt(7));
                t.setId_distrito(rs.getInt(8));
                t.setId_tipodir(rs.getInt(9));
                t.setId_persona(rs.getInt(10));

                lst.add(t);
            }
            for(Tienda aux :lst)
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
    public List<Tienda> ConsultarTiendaId(String usuario) 
    {
            List<Tienda> lst = new ArrayList<Tienda>();
            String sql = "select * from tienda where id_persona=(select id_persona from usuario where usuario='"+usuario+"');";
            //Connection cnx = getConnection();
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tienda c = new Tienda();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setCalificacion(rs.getInt(7));

                lst.add(c);
            }
            cnx.close();
            
            
        } 
       catch (Exception e) 
        {
                e.printStackTrace();
                System.out.print("ERROR TIENDA:"+e);
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
                    System.out.print("ERROR TIENDA2:"+e2);
                }
        }
        return lst;
    }public void insertarTienda(Tienda tiendaNuevo) {
	    String sql = "insert into tienda(id_tienda,nombre,direccion,activo,latitud,longitud,calificacion,id_distrito, id_tipodireccion,id_persona) values (NULL, UPPER(?), UPPER(?), ?, ?, ?, ?, ?, ?, ?)";
	        Connection cnx= null;
                ResultSet rs=null;
                PreparedStatement stm = null;
	        try {
	            cnx = MysqlDBConexion.getConexion();
	            stm = cnx.prepareStatement(sql);
	            stm.setString(1, tiendaNuevo.getNombre());
	            stm.setString(2, tiendaNuevo.getDireccion());
                    stm.setInt(3,tiendaNuevo.getActivo());
	            stm.setString(4, tiendaNuevo.getLatitud());
                    stm.setString(5, tiendaNuevo.getLongitud());
                    stm.setInt(6,tiendaNuevo.getCalificacion());
                    stm.setInt(7, tiendaNuevo.getId_distrito());
                    stm.setInt(8,tiendaNuevo.getId_tipodir());
                    stm.setInt(9, tiendaNuevo.getId_persona());

	            stm.execute();
	            //cnx.commit();
	            cnx.close();
	        }
                catch (Exception e) 
                {
                e.printStackTrace();
                } 
                finally
                {
                    try 
                    {
                        if (rs != null)	{
                    try {
                       rs.close();
                    } catch (Exception e) {}
                       rs = null;
                    }

                    if (stm != null) {
                       try {
                          stm.close();
                       } catch (Exception e) {}
                          stm = null;
                       }

                    if (cnx != null) {
                       try {
                          cnx.close();
                       } catch (Exception e) {
                       }

                       cnx = null;
                    }

                    } 
                    catch (Exception e2) 
                    {
                    }
        }
    }
    public ArrayList<Tienda> listarTiendasMapa(String id_distrito) {
        ArrayList<Tienda> tiendas;
        tiendas = new ArrayList<>();
        String sql = "SELECT t.id_tienda,t.nombre,t.direccion,t.latitud,t.longitud,t.calificacion, d.nombre,td.descripcion "
                + "FROM tienda t "
                + "JOIN distrito d ON t.id_distrito=d.id_distrito "
                + "JOIN tipo_direccion td ON t.id_tipodireccion=td.id_tipodireccion "
                + "WHERE t.id_distrito=?";
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(id_distrito));
            rs = stm.executeQuery();
            while (rs.next()) {
                Tienda t = new Tienda();
                //c.setCodigo(rs.getString(1));
                //c.setNombre(rs.getString(2));
                //c.setMarca(rs.getString(3));
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setDireccion(rs.getString(3));
                t.setLatitud(rs.getString(4));
                t.setLongitud(rs.getString(5));
                t.setCalificacion(rs.getInt(6));
                t.setDistrito(rs.getString(7));
                t.setTipodireccion(rs.getString(8));
                tiendas.add(t);
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
        return tiendas;
    }


}

