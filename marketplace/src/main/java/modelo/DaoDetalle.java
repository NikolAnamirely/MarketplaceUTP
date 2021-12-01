
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import utils.MysqlDBConexion;


public class DaoDetalle {
    public void editar(Detalle det) 
    {
        double cantidad=det.getCantidad();
        double total=det.getTotal();
        String idprod=det.getCodproducto();
        String idped=det.getPedido();
           String sql = "update detalle_pedido set cantidad="+cantidad+",total="+total+" where id_producto="+idprod+" and id_pedido="+idped;
            //Connection cnx = getConnection();
            Connection cnx= null;
            Statement stm = null;
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
        
    }
    public double ConsultarSubtotal(List<Detalle> lista) 
    {
        double subtotal=0.00;
        try 
        {
            for(Detalle aux :lista){
                subtotal=subtotal+aux.getTotal();    
            }    
            System.out.print(subtotal);
        } 
       catch (Exception e) 
        {
                System.out.print(e);
        } 
        return subtotal;
    }
     public void eliminar(String idProd,String idped) 
    {
            String sql = "delete from detalle_pedido where id_producto='"+idProd+"' and id_pedido='"+idped+"'";
            
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
        try{
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            stm.executeUpdate(sql);
            cnx.close();
        }catch (Exception e){
                e.printStackTrace();
        }finally{
            try{
                    if(rs!= null) rs.close();
                    if(stm!= null) stm.close();
                    if(cnx!= null) cnx.close();
            } 
            catch (Exception e2) {
            }
        }
    } 
    public List<Detalle> ConsultarDetalleId(String idpedido) 
    {
        List<Detalle> lst = new ArrayList<Detalle>();
        String sql = "SELECT p.id_producto,p.nombre,u.unidad,d.cantidad,d.total,d.id_pedido,p.costo from producto p inner join detalle_pedido d on d.id_producto=p.id_producto inner join unidades_medida u on u.id_unidades=p.id_unidades where d.id_pedido="+idpedido;
        Connection cnx= null;
        ResultSet rs=null;
        Statement stm = null;
        Detalle resp = new Detalle();
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Detalle p = new Detalle();
                p.setCodproducto(rs.getString(1));
                p.setProducto(rs.getString(2));
                p.setUnidades(rs.getString(3));
                p.setCantidad(rs.getDouble(4));
                p.setTotal(Math.round(rs.getFloat(5)*100.0)/100.0);
                p.setPedido(rs.getString(6));
                p.setCosto(rs.getDouble(7));
                lst.add(p);
            }
            cnx.close();            
        } 
       catch (Exception e) 
        {
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
        return lst;
    }
    public String generarIdPedido(String user){
        String sql0 = "select id_usuario from usuario where usuario='"+user+"'";
            Connection cnx= null;
            Statement stm = null;
            ResultSet rs=null;
            String idusuario="0";
            Calendar today = Calendar.getInstance();
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            rs =stm.executeQuery(sql0);
            while (rs.next()) {
               idusuario=rs.getString(1);
            }
            String sql = "INSERT INTO `pedido` (`id_pedido`, `subtotal`, `igv`, `total`, `fechacreacion`, `fechaentrega`, `horaentrega`, `estado`, `tipopago`, `repartidor`, `id_usuario`) VALUES (NULL, NULL, NULL, NULL, '"+ String.valueOf(today.get(Calendar.YEAR))+"-"+(String.valueOf(today.get(Calendar.MONTH)+1))+"-"+(String.valueOf(today.get(Calendar.DAY_OF_MONTH)))+"' , NULL, NULL, NULL, NULL, NULL,"+idusuario+")";
            
            stm.executeUpdate(sql);
        } 
       catch (Exception e) 
        {
                System.out.print("ERROR AGREGAR:"+e);
        } 
        finally
        {
                try{
                        
                } 
                catch (Exception e2){
                    System.out.print("ERROR AGREGAR2:"+e2);
                }
        }
        String sql2 = "select id_pedido from pedido";
        String codi="";
        try {
        rs = stm.executeQuery(sql2);
            while (rs.next()) {
                codi=rs.getString(1);
            } 
        }catch (Exception e) 
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
        return codi;
    }
    public void insertar(Detalle detallenuevo) 
    {
        String idprod=detallenuevo.getProducto();
        String idped=detallenuevo.getPedido();
        double cant=detallenuevo.getCantidad();
        double total=detallenuevo.getTotal();
        String sql = "insert into detalle_pedido(id_producto,id_pedido,cantidad,total) values ('"+idprod+"','"+
                        idped+"','"+cant+"','"+total+"')";

        Connection cnx= null;
        Statement stm = null;
            
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
                System.out.print("ERR:"+e);
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
                    System.out.print("ERR2:"+e2);
                }
        }
    } 
}
