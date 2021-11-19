/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.MysqlDBConexion;

/**
 *
 * @author Lenovo
 */
public class DaoUsuario {
    static Connection cnx= null;
    static ResultSet rs=null;
    
    public static String obtenerId(String username){
        String id=null;
        
        String sql = "select * from usuario where usuario='"
                        + username+ "'";
            //Connection cnx = getConnection();
            
            Statement stm = null;
            String rol=null;
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                id = rs.getString(1);
            }
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
    
    public static String ObtenerRol(Usuario user){
            String username=user.getUsuario();
            
            String sql = "select * from usuario where usuario='"
                        + username+ "'";
            //Connection cnx = getConnection();
            
            Statement stm = null;
            String rol=null;
            ResultSet rms=null;
        try 
        {
            rms = stm.executeQuery(sql);
            rol = rms.getString(5);
            System.out.print(rol);
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
        return rol;
    }
    public static Usuario VerificarUsuario(Usuario bean) 
    {
            String username=bean.getUsuario();
            String passw=bean.getPassword();
            String sql = "select * from usuario where usuario='"
                        + username
                        + "' AND password='"
                        + passw
                        + "'";
            //Connection cnx = getConnection();
            
            Statement stm = null;
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            
            boolean more = rs.next();
	    
            // if user does not exist set the isValid variable to false
            if (!more) 
            {
               bean.setValid(false);
               System.out.println("Falso");
            } 
            //if user exists set the isValid variable to true
            else if (more) 
            {
               
               
               bean.setValid(true);
               System.out.println("Correcto");
            }
            
        } 
       catch (Exception e) 
        {
                e.printStackTrace();
        } 
        finally
        {
                if (rs != null)	{
                    try {
                       rs.close();
                    } catch (Exception e) {}
                       rs = null;
                    }

        }
       String sql2 = "select * from usuario where usuario='"
                        + username+ "'";
            //Connection cnx = getConnection();
            
        try 
        {
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql2);
            
            while (rs.next()) {
                String rol = rs.getString(4);
                System.out.print(rs.getString(4));
                bean.setRol(rol);
            }
            
            
        } 
       catch (Exception e) 
        {
                e.printStackTrace();
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
        return bean;
    } 
    public void insertarUsuario(Usuario usuario){
        
        String sql = "insert into usuario(id_usuario,usuario,password,id_rol,id_persona,activo) values (NULL,?, ?, ?, ?, ?)";
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            stm.setString(1, usuario.getUsuario());
            stm.setString(2, usuario.getPassword());
            stm.setInt(3, Integer.parseInt(usuario.getRol()));
            stm.setInt(4, Integer.parseInt(usuario.getPersona()));
            stm.setInt(5, usuario.getActivo());
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
}
