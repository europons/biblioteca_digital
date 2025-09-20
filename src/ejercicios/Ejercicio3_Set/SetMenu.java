package ejercicios.Ejercicio3_Set;

import java.util.*;

/**
 * Clase principal del Ejercicio 3 (Set).
 * <p>
 * Contiene el menú y el flujo de interacción con el usuario
 * para gestionar un catálogo de libros implementado mediante un {@code HashSet}.
 * </p>
 * <p>Funcionalidades del programa:</p>
 * <ul>
 *     <li>Insertar un libro en el catálogo.</li>
 *     <li>Buscar si un libro existe en el catálogo.</li>
 *     <li>Mostrar todos los libros del catálogo.</li>
 *     <li>Pregunta teórica sobre HashSet y diferencia con HashMap.</li>
 * </ul>
 * <p>La clase actúa como interfaz de usuario por consola y delega la
 * gestión del catálogo a la clase {@link CatalogoLibros}.</p>
 */

public class SetMenu {
    /** Constante que indica las opciones totales del menú. */
    private static final String OPCIONES_MENU = "5";

    /**
     * Método público que inicializa el ejercicio.
     * <p>Crea un catálogo de libros y arranca el flujo principal.</p>
     */
    public static void ejecutar() {
        Scanner entrada = new Scanner(System.in);
        CatalogoLibros catalogo = new CatalogoLibros();

        flujoE3Set(catalogo, entrada);
    }

    /**
     * Flujo principal del ejercicio Set.
     * <p>Muestra el menú y gestiona las opciones seleccionadas
     * hasta que el usuario decide salir.</p>
     *
     * @param catalogoLibros objeto que gestiona el catálogo de libros.
     * @param entrada        scanner para leer la entrada del usuario.
     */
    private static void flujoE3Set (CatalogoLibros catalogoLibros, Scanner entrada) {
        String opcion;

        do {
            opcion= menuSet(entrada);
            switch (opcion){
                case "1":
                    catalogoLibros.agregarLibro(entrada);
                    break;
                case "2":
                    catalogoLibros.buscarLibro(entrada);
                    break;
                case "3":
                    catalogoLibros.mostrarCatalogo();
                    break;
                case "4":
                    System.out.println(" ");
                    System.out.println("⬇️Respuesta⬇️");
                    System.out.println("""
                        - En un HashMap, al intentar insertar elementos duplicados (con la misma clave), se ejecutará la operación y el valor asociado a esa clave se actualizará con el nuevo valor proporcionado.
                          No se permiten claves duplicadas, pero si que pueden haber valores duplicados con distintas claves. El HashMap guarda pares clave-valor.
                        - La diferencia con un HashSet, es que el HashSet guarda elementos únicos (no pares clave-valor), y si intentas agregar un elemento que ya existe en la colección,
                          no se ejecutará la operación y la colección se mantendrá igual.
                        - El HashSet puede ser útil cuando queremos asegurarnos de que una colección no tenga elementos duplicados, por ejemplo en un programa de una biblioteca como este es útil para casos como
                          para almacenar usuarios únicos con identificadores únicos (DNI o ID),
                          categorías o secciones únicas de libros, para identificadores únicos para libros (IBAN) o cualquier cosa que queramos que sea única en una colección.""");
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
     * Muestra el menú de opciones por consola y devuelve
     * la opción seleccionada por el usuario.
     *
     * @param entrada scanner para leer la opción.
     * @return String con la opción elegida por el usuario.
     */
    private static String menuSet(Scanner entrada) {
        System.out.println("\n📚✨ ===== CATÁLOGO DE LIBROS (SET) ===== ✨📚");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. ➕ Insertar libro.");
        System.out.println("2. 🔍 Comprobar si un libro está en el catálogo.");
        System.out.println("3. 📖 Mostrar todo el catálogo.");
        System.out.println("""
            4. \uD83E\uDDD0 Pregunta:
               ¿Qué ocurre al intentar insertar elementos duplicados en un HashMap?
               ¿Qué diferencia hay con el HashSet?
               ¿Cuándo crees que puede ser útil esta estructura (HashSet)?""");
        System.out.println("5. SALIR. \uD83D\uDD1A");
        System.out.print("Introduce una opción: ");
        return entrada.nextLine();
    }
}
