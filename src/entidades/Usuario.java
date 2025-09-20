package entidades;

/**
 * Representa un usuario de la biblioteca digital.
 * <p>
 * Cada usuario contiene información personal básica como nombre,
 * apellidos, DNI, teléfono y correo electrónico.
 * </p>
 */

public class Usuario {
    //ATRIBUTOS
    private String nombre;
    private String apellidos;
    private String DNI;
    private int telefono;
    private String correo;

    //CONSTRUCTORES

    /**
     * Crea un usuario con todos sus datos.
     *
     * @param nombre nombre del usuario.
     * @param apellidos apellidos del usuario.
     * @param DNI documento de identidad del usuario.
     * @param telefono número de teléfono del usuario.
     * @param correo correo electrónico del usuario.
     */
    public Usuario(String nombre, String apellidos, String DNI, int telefono, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Crea un usuario únicamente con el nombre.
     * <p>
     * Los demás campos se inicializan con valores vacíos o cero.
     * </p>
     *
     * @param nombre nombre del usuario.
     */
    public Usuario (String nombre) {
        this.nombre = nombre;
        this.apellidos = "";
        this.DNI = "";
        this.telefono = 0;
        this.correo = "";
    }

    //GETTERS Y SETTERS
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getDNI() {return DNI;}
    public int getTelefono() {return telefono;}
    public String getCorreo() {return correo;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setDNI(String DNI) {this.DNI = DNI;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setCorreo(String correo) {this.correo = correo;}

    //MÉTODOS

    /**
     * Muestra la información del usuario por consola,
     * incluyendo nombre completo, DNI, teléfono y correo.
     */
    public void mostrarInfoUsuario() {
        System.out.println(" ");
        System.out.println("Nombre: " +getNombre() +" "+ getApellidos());
        System.out.println("DNI: " + getDNI());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Correo: " + getCorreo());
    }
}
