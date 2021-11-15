/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDBConexion 
{
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConexion()
        {
            Connection con=null;
            try 
            {
                con=DriverManager.getConnection("jdbc:mysql://localhost/db_marketplace","root","");
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            return con;
	}	
}
