package modelo;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.MysqlDBConexion;

public class DaoProducto 
{
    public String NuevoCodigo(String nombre,String tipo) {
            List<Seleccionar> lst = new ArrayList<Seleccionar>();
            String sql = "insert into "+tipo+" values(NULL,'"+nombre+"')";
            String sql2 = "select * from "+tipo;
            int repetido=0;
            int id=0;
            String idletra=null;
             //Connection cnx = getConnection();
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            
            rs = stm.executeQuery(sql2);
            while (rs.next()) {
                Seleccionar c = new Seleccionar();
                c.setId(rs.getString(1));
                c.setNombre(rs.getString(2));
                lst.add(c);
                id=rs.getInt(1);
            }
            
            for(Seleccionar aux :lst){
                if(aux.getNombre().equalsIgnoreCase(nombre)){
                    repetido=repetido+1;
                    idletra=aux.getId();
                }
            }
            if(repetido==0){
                stm.executeUpdate(sql);
                id=id+1;
                idletra=id+"";
            }
            cnx.close();
            
            System.out.println("idnuevo:"+id);
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
        return idletra;
    }
    public List<Producto> ConsultarProductosStock(String idtienda) 
    {
            List<Producto> lst = new ArrayList<Producto>();
            String sql = "select p.id_producto,p.nombre,u.unidad,m.nombre,p.costo,p.estado,p.descripcion from producto p inner join marca m on p.id_marca=m.id_marca inner join unidades_medida u on p.id_unidades=u.id_unidades where p.id_tienda=? and estado=1";
            //Connection cnx = getConnection();
            Connection cnx= null;
            ResultSet rs=null;
            PreparedStatement stm = null;
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            stm.setString(1, idtienda);
            rs = stm.executeQuery();
            while (rs.next()) {
                Producto c = new Producto();
                c.setCodigo(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setUnidades(rs.getString(3));
                c.setMarca(rs.getString(4));
                c.setCosto(rs.getDouble(5));
                if(rs.getString(6).equals("1"))
                    c.setEstado("En stock");
                else 
                    c.setEstado("Agotado");
                c.setDescripcion(rs.getString(7));
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
    public List<Producto> ConsultarProductos(String idtienda) 
    {
            List<Producto> lst = new ArrayList<Producto>();
            String sql = "select p.id_producto,p.nombre,u.unidad,m.nombre,p.costo,p.estado,p.imagen,p.descripcion from producto p inner join marca m on p.id_marca=m.id_marca inner join unidades_medida u on p.id_unidades=u.id_unidades where (p.estado=1 or p.estado=0) and  p.id_tienda=?";
            //Connection cnx = getConnection();
            Connection cnx= null;
            ResultSet rs=null;
            PreparedStatement stm = null;
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            stm.setString(1, idtienda);
            rs = stm.executeQuery();
            while (rs.next()) {
                Producto c = new Producto();
                c.setCodigo(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setUnidades(rs.getString(3));
                c.setMarca(rs.getString(4));
                c.setCosto(rs.getDouble(5));
                if(rs.getString(6).equals("1"))
                    c.setEstado("En stock");
                else 
                    c.setEstado("Agotado");
                c.setFoto(rs.getBinaryStream(7));
                c.setDescripcion(rs.getString(8));
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
    public void listarImagen(int id, HttpServletResponse response) {    
            List<Producto> lst = new ArrayList<Producto>();
            String sql = "select p.id_producto,p.nombre,u.unidad,m.nombre,p.costo,p.estado,p.imagen from producto p inner join marca m on p.id_marca=m.id_marca inner join unidades_medida u on p.id_unidades=u.id_unidades where p.id_producto="+id;
            
            InputStream inputStream=null;
            OutputStream outputStream=null;
            BufferedInputStream bufferedInputStream=null;
            BufferedOutputStream bufferedOutputStream=null;
            response.setContentType("image/*");
            Connection cnx= null;
            ResultSet rs=null;
            PreparedStatement stm = null;
        try 
        {
            outputStream=response.getOutputStream();
            
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                inputStream=rs.getBinaryStream("imagen");
            }
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
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
    }
    public List<Producto> BuscarProductos(String criterio,String idtienda,String producto) 
    {
            List<Producto> lst = new ArrayList<Producto>();
            String sql = "select p.id_producto,p.nombre,u.unidad,m.nombre,p.costo,p.estado,p.imagen,p.descripcion from producto p inner join marca m on p.id_marca=m.id_marca inner join unidades_medida u on p.id_unidades=u.id_unidades where (p.estado=1 or p.estado=0) and p.id_tienda="+
                            idtienda+" AND "+criterio+"= '"+producto+"'";
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
                Producto c = new Producto();
                
                c.setCodigo(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setUnidades(rs.getString(3));
                c.setMarca(rs.getString(4));
                c.setCosto(rs.getDouble(5));
                if(rs.getString(6).equals("1"))
                    c.setEstado("En stock");
                else 
                    c.setEstado("Agotado");
                c.setFoto(rs.getBinaryStream(7));
                c.setDescripcion(rs.getString(8));
                
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
     public Producto ConsultarProductosId(String idproducto) 
    {
            List<Producto> lst = new ArrayList<Producto>();
            String sql = "select p.id_producto,p.nombre,p.costo,p.estado,c.nombre,m.nombre,u.unidad,p.id_tienda,p.descripcion,p.imagen from producto p inner join categoria c on p.id_categoria=c.id_categoria INNER JOIN marca m on p.id_marca=m.id_marca INNER JOIN unidades_medida u on p.id_unidades=u.id_unidades where p.id_producto='"+
                    idproducto+"'";
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;
            Producto resp = new Producto();
        try 
        {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto c = new Producto();
                c.setCodigo(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setCosto(rs.getDouble(3));
                c.setCategoria(rs.getString(5));
                c.setMarca(rs.getString(6));
                c.setUnidades(rs.getString(7));
                if(rs.getString(4).equals("1"))
                    c.setEstado("En stock");
                else 
                    c.setEstado("Agotado");
                c.setTienda(rs.getString(8));
                c.setDescripcion(rs.getString(9));
                c.setFoto(rs.getBinaryStream(10));
                lst.add(c);
            }
            for(Producto aux :lst)
            {
                resp=aux;
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
        return resp;
    } 	
    
    public void editar(Producto prod) 
    {
        String id = prod.getCodigo();
        String nombre = prod.getNombre();
        Double costo=prod.getCosto();
        int estado=Integer.parseInt(prod.getEstado());
        String unidades=prod.getUnidades();
        String marca=prod.getMarca();
        String categoria=prod.getCategoria();
        String desc=prod.getDescripcion();
        String sql = "update producto set nombre='"+nombre+"',estado="+estado+
                ",costo='"+costo+"',id_unidades="+unidades+",descripcion='"+desc+"',id_marca="+marca+",id_categoria="+categoria+
                " where id_producto='"+id+"'";
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
    public void editarImagen(Producto prod) 
    {
        InputStream foto=prod.getFoto();
        String id = prod.getCodigo();
        String sql="update producto set imagen=? where id_producto="+id;
        //Connection cnx = getConnection();
        Connection cnx= null;
        PreparedStatement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.prepareStatement(sql);
            stm.setBlob(1, foto);

            stm.executeUpdate();

            

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
                        if(stm!= null) stm.close();
                        if(cnx!= null) cnx.close();
                } 
                catch (Exception e2) 
                {
                }
        }
    } 	
    public void insertar(Producto product) 
    {
            //String id = product.getCodigo();
            String nombre = product.getNombre();
            Double costo=product.getCosto();
            String estado=product.getEstado();
            String descrip=product.getDescripcion();
            String tienda=product.getTienda();
            String categoria=product.getCategoria();
            String marca=product.getMarca();
            String unidades=product.getUnidades();
            InputStream foto=product.getFoto();
            String sql = "insert into producto values(NULL,?,?,?,?,?,?,?,?,?)";
            
            Connection cnx= null;
            PreparedStatement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.prepareStatement(sql);
            stm.setString(1, nombre);
            stm.setDouble(2, costo);
            stm.setString(3, estado);
            stm.setBlob(4, foto);
            stm.setString(5, descrip);
            stm.setString(6, tienda);
            stm.setString(7, categoria);
            stm.setString(8, marca);
            stm.setString(9, unidades);

            stm.executeUpdate();

            cnx.close();
        } 
       catch (Exception e) 
        {
                System.out.print("ERROR AGREGAR:"+e);
        } 
        finally
        {
                try{
                        if(stm!= null) stm.close();
                        if(cnx!= null) cnx.close();
                } 
                catch (Exception e2){
                    System.out.print("ERROR AGREGAR2:"+e2);
                }
        }
    }
    public void eliminar(String idProd) 
    {
            String sql = "update producto set estado=3 where id_producto='"+idProd+"'";
            
            Connection cnx= null;
            ResultSet rs=null;
            Statement stm = null;

        try 
        {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            
            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            stm.executeUpdate(sql);
            
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
    } 

    
}
