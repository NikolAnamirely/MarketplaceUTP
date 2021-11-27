/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import static modelo.DaoUsuario.cnx;
import static modelo.DaoUsuario.rs;

/**
 *
 * @author Sketcher
 */
public class Tienda {
    private String nombre,direccion,latitud,longitud,distrito,tipodireccion;
    private int id,activo,calificacion;
    private int id_tipodir,id_persona,id_distrito;
    private String pnom,ppape,psape,pemail;
    private String comentario;
    
    public Tienda(String nombre, String direccion, String latitud, String longitud, String distrito, String tipodireccion, int id, int activo, int calificacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.distrito = distrito;
        this.tipodireccion = tipodireccion;
        
        this.id = id;
        this.activo = activo;
        this.calificacion = calificacion;
    }

    public Tienda() {
        this.nombre = null;
        this.direccion = null;
        this.latitud = null;
        this.longitud = null;
        this.distrito = null;
        this.tipodireccion = null;
        
        this.id = 0;
        this.activo = 0;
        this.calificacion = 0;
    }

    public String getPnom() {
        return pnom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPpape() {
        return ppape;
    }

    public void setPpape(String ppape) {
        this.ppape = ppape;
    }

    public String getPsape() {
        return psape;
    }

    public void setPsape(String psape) {
        this.psape = psape;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tipodir() {
        return id_tipodir;
    }

    public void setId_tipodir(int id_tipodir) {
        this.id_tipodir = id_tipodir;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(int id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTipodireccion() {
        return tipodireccion;
    }

    public void setTipodireccion(String tipodireccion) {
        this.tipodireccion = tipodireccion;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    
    
    
    
    
    
    
}
