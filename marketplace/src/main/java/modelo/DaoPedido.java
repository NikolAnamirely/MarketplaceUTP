package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import utils.MysqlDBConexion;

public class DaoPedido {

    public void eliminar(String idPed) {
        String sql = "update pedido set estado=3 where id_pedido='" + idPed + "'";

        Connection cnx = null;
        ResultSet rs = null;
        Statement stm = null;

        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();

            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            stm.executeUpdate(sql);

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
    }

    public void InsertarTotales(String idpedido) {
        String sql = "select total from detalle_pedido where id_pedido=" + idpedido;

        Connection cnx = null;
        ResultSet rs = null;
        Statement stm = null;
        double subtotal = 0.00, total, igv;
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();

            rs = stm.executeQuery(sql);
            while (rs.next()) {
                subtotal = subtotal + rs.getDouble(1);
            }
            igv = subtotal * 0.18;
            total = subtotal + igv;
            String sql2 = "update pedido set subtotal=" + subtotal + ",total=" + total + ",igv=" + igv + " where id_pedido=" + idpedido;
            stm.executeUpdate(sql2);
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public List<Pedido> ConsultarPedidos(String idpedido) {
        List<Pedido> lst = new ArrayList<Pedido>();
        String sql = "select * from pedido where id_pedido = ? and (estado=1 or estado=2)";
        //Connection cnx = getConnection();
        Connection cnx = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.prepareStatement(sql);
            stm.setString(1, idpedido);
            //LECTURA DE LOS DATOS QUE DEBUELVE LA BD
            rs = stm.executeQuery();
            //CREAMOS OBJETO PRODUCTO
            Pedido p = null;
            while (rs.next()) {
                p = new Pedido();
                p.setId(rs.getString(1));
                p.setSubtotal(rs.getFloat(2));
                p.setIgv(rs.getFloat(3));
                p.setTotal(rs.getFloat(4));
                p.setFecha_creacion(rs.getString(5));
                p.setFecha_entrega(rs.getString(6));
                p.setHora(rs.getString(7));
                p.setEstado(rs.getString(8));
                p.setTipoPago(rs.getString(9));
                p.setRepartidor(rs.getString(10));
                p.setId_usuario(rs.getString(11));

                lst.add(p);
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

    public List<Pedido> BusquedaPedidosTienda(String idtienda, String criterio, String termino) {
        List<Pedido> lst = new ArrayList<Pedido>();
        String sql = "";

        if (criterio.equals("cliente")) {
            sql = "select p.id_pedido,p.subtotal,p.igv,p.total,p.fechacreacion,p.fechaentrega,p.horaentrega,p.estado,p.tipopago,p.repartidor,p.ordenpedido,u.id_usuario from pedido p inner join usuario u on p.id_usuario=u.id_usuario inner join persona s on u.id_persona=s.id_persona where (p.estado=1 or p.estado=2) and p.id_pedido in (select d.id_pedido from detalle_pedido d inner join producto o on d.id_producto= o.id_producto where o.id_tienda='" + idtienda + "') and (p.estado='1') and (s.primerapellido='" + termino + "' or s.segundoapellido='" + termino + "' or s.nombre='" + termino + "') order by p.estado asc";
        } else {
            sql = "select p.id_pedido,p.subtotal,p.igv,p.total,p.fechacreacion,p.fechaentrega,p.horaentrega,p.estado,p.tipopago,p.repartidor,p.ordenpedido,u.id_usuario from pedido p inner join usuario u on p.id_usuario=u.id_usuario where (p.estado=1 or p.estado=2) and p.id_pedido in (select d.id_pedido from detalle_pedido d inner join producto o on d.id_producto= o.id_producto where o.id_tienda='" + idtienda + "') and " + criterio + "='" + termino + "' order by p.estado asc";
        }
        Connection cnx = null;
        ResultSet rs = null;
        Statement stm = null;
        Pedido resp = new Pedido();
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getString(1));
                p.setSubtotal(rs.getFloat(2));
                p.setIgv(rs.getFloat(3));
                p.setTotal(rs.getFloat(4));
                p.setFecha_creacion(rs.getString(5));
                p.setFecha_entrega(rs.getString(6));
                p.setHora(rs.getString(7));
                p.setEstado(rs.getString(8));
                p.setTipoPago(rs.getString(9));
                p.setRepartidor(rs.getString(10));
                p.setOrdenpedido(rs.getString(11));
                p.setId_usuario(rs.getString(12));
                lst.add(p);
            }

            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
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

    public List<Pedido> ConsultarPedidosTienda(String idtienda) {
        List<Pedido> lst = new ArrayList<Pedido>();
        String sql = "select p.id_pedido,p.subtotal,p.igv,p.total,p.fechacreacion,p.fechaentrega,p.horaentrega,p.estado,p.tipopago,p.repartidor,p.ordenpedido,u.id_usuario from pedido p inner join usuario u on p.id_usuario=u.id_usuario where (p.estado=1 or p.estado=2) and p.id_pedido in (select d.id_pedido from detalle_pedido d inner join producto o on d.id_producto= o.id_producto where o.id_tienda='" + idtienda + "')order by p.estado asc";
        Connection cnx = null;
        ResultSet rs = null;
        Statement stm = null;
        Pedido resp = new Pedido();
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getString(1));
                p.setSubtotal(rs.getFloat(2));
                p.setIgv(rs.getFloat(3));
                p.setTotal(rs.getFloat(4));
                p.setFecha_creacion(rs.getString(5));
                p.setFecha_entrega(rs.getString(6));
                p.setHora(rs.getString(7));
                p.setEstado(rs.getString(8));
                p.setTipoPago(rs.getString(9));
                p.setRepartidor(rs.getString(10));
                p.setOrdenpedido(rs.getString(11));
                p.setId_usuario(rs.getString(12));
                lst.add(p);
            }

            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
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
        public List<Pedido> ConsultarPedidosReporte(String idtienda , String param) {
        List<Pedido> lst = new ArrayList<>();
        String sql = "SELECT  p.id_pedido,p.subtotal ,p.igv,p.total,p.fechacreacion,p.fechaentrega,p.horaentrega,p.estado,p.tipopago,p.repartidor,p.ordenpedido, CONCAT(pe.nombre,' ',pe.primerapellido,' ',pe.segundoapellido) as nombre FROM (pedido p INNER JOIN usuario u on p.id_usuario=u.id_usuario) inner join persona pe on pe.id_persona=u.id_persona WHERE p.estado is not null and p.id_pedido in (select d.id_pedido from detalle_pedido d inner join producto o on d.id_producto= o.id_producto where o.id_tienda='"+idtienda+"') "+param+" order by p.fechacreacion DESC";
        Connection cnx = null;
        ResultSet rs = null;
        Statement stm = null;
        Pedido resp = new Pedido();
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getString(1));
                p.setSubtotal(rs.getFloat(2));
                p.setIgv(rs.getFloat(3));
                p.setTotal(rs.getFloat(4));
                p.setFecha_creacion(rs.getString(5));
                p.setFecha_entrega(rs.getString(6));
                p.setHora(rs.getString(7));
                p.setEstado(rs.getString(8));
                p.setTipoPago(rs.getString(9));
                p.setRepartidor(rs.getString(10));
                p.setOrdenpedido(rs.getString(11));
                p.setId_usuario(rs.getString(12));
                lst.add(p);
            }

            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
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

    public List<Pedido> ConsultarPedidos() {
        List<Pedido> lst = new ArrayList<Pedido>();
        String sql = "select p.id_pedido,p.subtotal,p.igv,p.total,p.fechacreacion,p.fechaentrega,p.horaentrega,p.estado,p.tipopago,p.repartidor,u.id_usuario from pedido p inner join usuario u on p.id_usuario=u.id_usuario where (p.estado=1 or p.estado=2) and p.id_pedido in (select d.id_pedido from detalle_pedido d inner join producto o where o.id_tienda='1')";
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
            Pedido p = null;
            while (rs.next()) {
                p = new Pedido();
                p.setId(rs.getString(1));
                p.setSubtotal(rs.getFloat(2));
                p.setIgv(rs.getFloat(3));
                p.setTotal(rs.getFloat(4));
                p.setFecha_creacion(rs.getString(5));
                p.setFecha_entrega(rs.getString(6));
                p.setHora(rs.getString(7));
                p.setEstado(rs.getString(8));
                p.setTipoPago(rs.getString(9));
                p.setRepartidor(rs.getString(10));
                p.setId_usuario(rs.getString(11));

                lst.add(p);
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

    public Pedido ConsultarPedidosId(String idpedido) {
        List<Pedido> lst = new ArrayList<Pedido>();
        String sql = "select p.id_pedido,p.subtotal,p.igv,p.total,p.fechacreacion,p.fechaentrega,p.horaentrega,p.estado,p.tipopago,p.repartidor,p.ordenpedido,u.id_usuario from pedido p inner join usuario u on p.id_usuario=u.id_usuario where p.id_pedido='"
                + idpedido + "'";
        Connection cnx = null;
        ResultSet rs = null;
        Statement stm = null;
        Pedido resp = new Pedido();
        try {
            cnx = MysqlDBConexion.getConexion();
            stm = cnx.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getString(1));
                p.setSubtotal(rs.getFloat(2));
                p.setIgv(rs.getFloat(3));
                p.setTotal(rs.getFloat(4));
                p.setFecha_creacion(rs.getString(5));
                p.setFecha_entrega(rs.getString(6));
                p.setHora(rs.getString(7));
                p.setEstado(rs.getString(8));
                p.setTipoPago(rs.getString(9));
                p.setRepartidor(rs.getString(10));
                p.setOrdenpedido(rs.getString(11));
                p.setId_usuario(rs.getString(12));
                lst.add(p);
            }
            for (Pedido aux : lst) {
                resp = aux;
            }
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
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
        return resp;
    }

    public Pedido insertarPedido(Pedido pedido) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String id = pedido.getId();
        float subtotal = pedido.getSubtotal();
        float igv = pedido.getIgv();
        float total = pedido.getTotal();
        String fechacreacion = pedido.getFecha_creacion();
        String fechaentrega = pedido.getFecha_entrega();
        String horaentrega = pedido.getHora();
        String estado = pedido.getEstado();
        String tipopago = pedido.getTipoPago();
        String ordenpedido = pedido.getOrdenpedido();
        String repartidor = pedido.getRepartidor();
        String id_usuario = pedido.getId_usuario();

        String sql = "update pedido set subtotal='" + subtotal + "',igv='" + igv + "',total='" + total + "',fechacreacion='" + fechacreacion + "',fechaentrega='" + fechaentrega + "',horaentrega='" + horaentrega + "',estado='" + estado + "',tipopago='" + tipopago + "',repartidor='" + repartidor + "',ordenpedido=" + ordenpedido + ",id_usuario=" + id_usuario + " where id_pedido=" + id;
        //Connection cnx = getConnection();
        Connection cnx = null;
        Statement stm = null;
        Pedido p = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            stm.executeUpdate(sql);

            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (Exception e2) {
                System.out.print("ERROR UP" + e2);
            }
        }
        return p;
    }

    public Pedido editar(Pedido ped) {
        String id = ped.getId();
        float subtotal = ped.getSubtotal();
        float igv = ped.getIgv();
        float total = ped.getTotal();
        String fechacreacion = ped.getFecha_creacion();
        String fechaentrega = ped.getFecha_entrega();
        String horaentrega = ped.getHora();
        String estado = ped.getEstado();
        String tipopago = ped.getTipoPago();
        String repartidor = ped.getRepartidor();
        String ordenpedido = ped.getOrdenpedido();
        String id_usuario = ped.getId_usuario();

        String sql = "update pedido set subtotal='" + subtotal + "',igv='" + igv + "',total='" + total + "',fechacreacion='" + fechacreacion + "',fechaentrega='" + fechaentrega + "',horaentrega='" + horaentrega + "',estado='" + estado + "',tipopago='" + tipopago + "',repartidor='" + repartidor + "',ordenpedido=" + ordenpedido + ",id_usuario=" + id_usuario + " where id_pedido=" + id;
        //Connection cnx = getConnection();
        Connection cnx = null;
        Statement stm = null;
        Pedido p = null;
        try {
            //ABRE CONEXION CON BASE DE DATOS
            cnx = MysqlDBConexion.getConexion();
            //EJECUTAMOS SENTENCIA SQL
            stm = cnx.createStatement();
            stm.executeUpdate(sql);

            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (Exception e2) {
            }
        }
        return p;
    }
}
