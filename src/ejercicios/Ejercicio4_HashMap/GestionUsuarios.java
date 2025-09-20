package ejercicios.Ejercicio4_HashMap;

import datos.DatosPrueba;
import entidades.Usuario;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase que gestiona el registro e inicio de sesión de usuarios
 * utilizando un {@link HashMap}, donde:
 * <ul>
 *     <li>La clave es el nombre de usuario (String).</li>
 *     <li>El valor es la contraseña asociada (String).</li>
 * </ul>
 *
 * <p>Al iniciar el programa, se precargan los usuarios de {@link DatosPrueba}
 * con una contraseña por defecto ("1234") para facilitar las pruebas.</p>
 */

public class GestionUsuarios {

    /** Mapa de usuarios (clave: nombre, valor: contraseña). */
    private final HashMap<String, String> usuarios;

    /**
     * Constructor que inicializa el HashMap y precarga los nombre de
     * los usuarios de {@link DatosPrueba} con la contraseña "1234"
     * por defecto para poder hacer pruebas más fácilmente.
     */
    public GestionUsuarios() {
        this.usuarios = new HashMap<>();

        for (Usuario usuario : DatosPrueba.USUARIOS) {
            usuarios.put(usuario.getNombre(), "1234");
        }
    }

    /**
     * Permite registrar un nuevo usuario con nombre único y contraseña.
     *
     * @param entrada Scanner para leer datos por consola.
     */
    public void registrarUsuario(Scanner entrada){
        String nombreUsuario;
        String password;

        System.out.println("\nNUEVO USUARIO");
        do{
            System.out.print("Inserta el nombre de usuario: ");
            nombreUsuario = entrada.nextLine().trim();
            if (usuarios.containsKey(nombreUsuario)){
                System.out.println("❌El nombre de usuario '"+nombreUsuario+"' ya existe. Por favor, elige otro nombre de usuario.❌");
            } else if (nombreUsuario.isEmpty()) {
                System.out.println("❌El nombre de usuario no puede estar vacío.❌");
            }
        }while(nombreUsuario.isEmpty() || usuarios.containsKey(nombreUsuario));

        do{
            System.out.print("Inserta la contraseña: ");
            password = entrada.nextLine().trim();
            if (password.isEmpty()){
                System.out.println("❌La contraseña no puede estar vacía.❌");
            }
        }while(password.isEmpty());

        usuarios.put(nombreUsuario, password);
        System.out.println("\n✔️El usuario '"+nombreUsuario+"' ha sido registrado correctamente.✔️");
    }

    /**
     * Muestra todos los usuarios registrados en el sistema.
     * */
    public void mostrarUsuariosRegistrados(){
        if (!usuarios.isEmpty()) {
            System.out.println("\nUsuarios registrados:");
            for (String usuario : usuarios.keySet()) {
                System.out.println("- " + usuario);
            }
        } else {
            System.out.println("\nℹ️ No hay usuarios registrados. ℹ️");
        }
    }

    /**
     * Permite iniciar sesión introduciendo nombre y contraseña.
     *
     * @param entrada Scanner para leer datos por consola.
     */
    public void iniciarSesion(Scanner entrada){
        String nombreUsuario;
        String password;
        System.out.println("INICIAR SESIÓN");
        System.out.print("Inserta el nombre de usuario: ");
        nombreUsuario = entrada.nextLine().trim();

        if (usuarios.get(nombreUsuario) != null){
            System.out.print("Introduce la contraseña para iniciar sesión: ");
            password = entrada.nextLine().trim();
            if (usuarios.get(nombreUsuario).equals(password)){
                System.out.println("✔️BIENVENIDO '"+nombreUsuario+"'! Has iniciado sesión correctamente.✔️");
            }else{
                System.out.println("❌La contraseña es incorrecta.❌");
                System.out.println("El usuario '"+nombreUsuario+"' no ha podido iniciar sesión.");
            }
        }else{
            System.out.println("El usuario '"+nombreUsuario+"' no puede iniciar sesión. No está registrado.❌");
        }
    }
}
