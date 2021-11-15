package modelo;

public class Persona {
    private String nombre,primerapellido,segundoapellido,telefono,email,direccion;
    private int id,activo,tipodireccion, distrito;

    public Persona () 
    {}
    public Persona(int id, String nombre, String primerapellido, String segundoapellido, String email, String telefono, int activo, String direccion, int tipodireccion, int distrito) {
    this.id = id;
    this.nombre = nombre;
    this.primerapellido = primerapellido;
    this.segundoapellido = segundoapellido;
    this.telefono = telefono;
    this.activo= activo;
    this.email = email;
    this.distrito = distrito;
    this.tipodireccion = tipodireccion;
    this.direccion = direccion;;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public int getTipodireccion() {
        return tipodireccion;
    }

    public void setTipodireccion(int tipodireccion) {
        this.tipodireccion = tipodireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    	
}
