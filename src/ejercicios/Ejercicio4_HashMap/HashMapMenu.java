package ejercicios.Ejercicio4_HashMap;

import java.util.Scanner;

/**
 * Clase principal del Ejercicio 4 (HashMap).
 * <p>
 * Contiene el menú y el flujo de interacción con el usuario
 * para gestionar un sistema de usuarios implementado con {@code HashMap}.
 * </p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li>Registrar nuevos usuarios (añadir pares clave-valor al HashMap).</li>
 *     <li>Iniciar sesión comprobando credenciales.</li>
 *     <li>Mostrar todos los usuarios registrados.</li>
 *     <li>Pregunta teórica sobre cómo HashMap diferencia claves con el mismo hashCode().</li>
 * </ul>
 *
 * <p>La lógica de negocio se delega a la clase {@link GestionUsuarios}.</p>
 */

public class HashMapMenu {
    /** Constante que indica las opciones totales del menú. */
    private static final String OPCIONES_MENU = "5";

    /**
     * Método de entrada del ejercicio.
     * <p>
     * Crea una instancia de {@link GestionUsuarios} y arranca el flujo principal.
     * </p>
     */
    public static void ejecutar() {
        Scanner entrada = new Scanner(System.in);
        GestionUsuarios gestionUsuarios = new GestionUsuarios();

        flujoE4HashMap(gestionUsuarios, entrada);
    }

    /**
     * Controla el flujo principal del programa.
     * <p>
     * Muestra el menú y gestiona las acciones seleccionadas
     * hasta que el usuario decide salir.
     * </p>
     *
     * @param gestionUsuarios objeto que gestiona las operaciones de usuarios.
     * @param entrada         scanner para leer la entrada del usuario.
     */
    private static void flujoE4HashMap(GestionUsuarios gestionUsuarios, Scanner entrada) {
        String opcion;

        do {
            opcion= menuHashMap(entrada);
            switch (opcion){
                case "1":
                    gestionUsuarios.registrarUsuario(entrada);
                    break;
                case "2":
                    gestionUsuarios.iniciarSesion(entrada);
                    break;
                case "3":
                    gestionUsuarios.mostrarUsuariosRegistrados();
                    break;
                case "4":
                    System.out.println(" ");
                    System.out.println("⬇️Respuesta⬇️");
                    System.out.println("""
                            HashMap diferencia 2 claves con el mismo hasCode() mediante el equals(). Por ejemplo, cuando insertamos con put() a un HashMap
                            se calcula el hasCode() de la clave y si ya existe una clave con ese hasCode() entonces
                            llama al equals() para ver si las claves son iguales o no. Si son iguales entonces actualiza el valor asociado a dicha clave y
                            si no son iguales las claves entonces crea un nuevo par clave-valor en el HashMap.""");
                    break;
                case "5":
                    System.out.println("Volviendo al menú principal... \uD83D\uDD1A");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida ⚠️");
                    break;
            }
        }while(!opcion.equals(OPCIONES_MENU));
    }

    /**
     * Muestra el menú por consola y devuelve la opción seleccionada por el usuario.
     *
     * @param entrada scanner para leer la opción introducida.
     * @return String con la opción seleccionada.
     */
    private static String menuHashMap(Scanner entrada) {
        System.out.println("\n\uD83D\uDCDA\uD83D\uDCDA ===== MENÚ HASHMAP ====== \uD83D\uDCDA\uD83D\uDCDA");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Registrar nuevo usuario.");
        System.out.println("2. Iniciar sesión.");
        System.out.println("3. Mostrar todos los usuarios registrados.");
        System.out.println("4. \uD83E\uDDD0 Pregunta:¿Cómo diferencia HashMap a dos claves distintas que generan el mismo hashCode()?");
        System.out.println("5. SALIR. \uD83D\uDD1A");
        System.out.print("Introduce una opción: ");
        return entrada.nextLine();
    }
}
