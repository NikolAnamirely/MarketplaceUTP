/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MysqlDBConexion;

/**
 *
 * @author Lenovo
 */
public class DaoSeleccionar {
    public List<Seleccionar> Cargar(String tipo) 
    {
            List<Seleccionar> lst = new ArrayList<Seleccionar>();
            String sql = "select * from "+tipo;
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
                Seleccionar c = new Seleccionar();
                c.setId(rs.getString(1));
                c.setNombre(rs.getString(2));
                
                lst.add(c);
            }
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
                        if(rs!= null) rs.close();
                        if(stm!= null) stm.close();
                        if(cnx!= null) cnx.close();
                } 
                catch (Exception e2) 
                {
                }
        }
        return lst;
    }
}
