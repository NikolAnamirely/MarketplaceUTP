package modelo;

import java.sql.Date;

public class Pedido {
    private String estado,tipoPago,repartidor,hora,id,id_usuario;
    private String fecha_creacion,fecha_entrega,ordenpedido;
    private float subtotal,igv,total;

    public Pedido () 
    {}

    public Pedido(String id, String id_usuario,String estado, String ordenpedido,String tipoPago, String repartidor, String hora, String fecha_creacion, String fecha_entrega, float subtotal, float igv, float total) {
        this.id=id;
        this.id_usuario=id_usuario;
        this.estado = estado;
        this.tipoPago = tipoPago;
        this.repartidor = repartidor;
        this.hora = hora;
        this.fecha_creacion = fecha_creacion;
        this.fecha_entrega = fecha_entrega;
        this.ordenpedido=ordenpedido;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIgv() {
        return igv;
    }

    public void setIgv(float igv) {
        this.igv = igv;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrdenpedido() {
        return ordenpedido;
    }

    public void setOrdenpedido(String ordenpedido) {
        this.ordenpedido = ordenpedido;
    }
    

    
    	
}
