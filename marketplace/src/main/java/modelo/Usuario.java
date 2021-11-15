/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Lenovo
 */
public class Usuario {
    private String usuario,password,rol,persona;
    private boolean valid;
    private int iduser,activo;
    
    //GETTER & SETTER
    public int getIduser() {        return iduser;    }
    public void setIduser(int iduser) {        this.iduser = iduser;    }
    public String getUsuario() {        return usuario;    }
    public void setUsuario(String usuario) {        this.usuario = usuario;    }
    public String getPassword() {        return password;    }
    public void setPassword(String password) {        this.password = password;    }
    public String getRol() {        return rol;    }
    public void setRol(String rol) {        this.rol = rol;    }
    public String getPersona() {        return persona;    }
    public void setPersona(String persona) {        this.persona = persona;    }
    public int getActivo() {        return activo;    }
    public void setActivo(int activo) {        this.activo = activo;    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
