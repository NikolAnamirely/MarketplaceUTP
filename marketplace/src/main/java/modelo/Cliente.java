package modelo;


public class Cliente extends Persona{

    public Cliente() {
    }

    public Cliente(int id, String nombre, String primerapellido, String segundoapellido, String email, String telefono, int activo, String direccion, int tipodireccion, int distrito) {
        super(id, nombre, primerapellido, segundoapellido, email, telefono, activo, direccion, tipodireccion, distrito);
    }
}
