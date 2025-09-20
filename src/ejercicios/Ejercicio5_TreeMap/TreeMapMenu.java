package ejercicios.Ejercicio5_TreeMap;

import datos.DatosPrueba;

import java.util.Scanner;

/**
 * Clase principal del Ejercicio 5 (TreeMap).
 * <p>
 * Gestiona el menú y el flujo de interacción para simular
 * descargas de libros almacenadas en un {@code TreeMap}.
 * </p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li>Añadir libros al TreeMap junto con el número de descargas.</li>
 *     <li>Mostrar todos los libros descargados, ordenados alfabéticamente (A-Z).</li>
 *     <li>Consultar el primer y último libro del TreeMap (según orden natural).</li>
 *     <li>Pregunta teórica sobre la diferencia entre un {@code TreeMap} y un {@code HashMap}</li>
 * </ul>
 *
 * <p>La lógica de negocio se delega a la clase {@link GestionDescargas}.</p>
 */

public class TreeMapMenu {
    //Constantes
    private static final String OPCIONES_MENU = "5";

    /**
     * Método de entrada del ejercicio.
     * <p>
     * Crea una instancia de {@link GestionDescargas} y arranca el flujo principal.
     * </p>
     */
    public static void ejecutar() {
        Scanner entrada = new Scanner(System.in);
        GestionDescargas gestionDescargas = new GestionDescargas();

        flujoE5TreeMap(gestionDescargas, entrada);
    }

    /**
     * Controla el flujo principal del programa.
     * <p>
     * Muestra el menú y gestiona las acciones seleccionadas
     * hasta que el usuario decide salir.
     * </p>
     *
     * @param gestionDescargas objeto que gestiona las operaciones con el TreeMap.
     * @param entrada          scanner para leer la entrada del usuario.
     */
    private static void flujoE5TreeMap (GestionDescargas gestionDescargas, Scanner entrada) {
        String opcion;

        do {
            opcion= menuTree(entrada);
            switch (opcion){
                case "1":
                    gestionDescargas.agregarLibro(DatosPrueba.LIBROS, entrada);
                    break;
                case "2":
                    gestionDescargas.mostrarLibrosDescargados();
                    break;
                case "3":
                    gestionDescargas.consultaPrimerUltimoLibro();
                    break;
                case "4":
                    System.out.println(" ");
                    System.out.println("⬇️Respuesta⬇️");
                    System.out.println("""
                            En un TreeMap las claves se ordenan automáticamente al añadir en la colección (si son número se ordenan de menor a mayor
                            y si son letras alfabéticamente).En cambio en un HashMap las claves se almacenan sin mantener ningún orden.""");
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
    private static String menuTree(Scanner entrada) {
        System.out.println("\n📚🌳 ===== GESTIÓN DE DESCARGAS (TREEMAP) ===== 🌳📚");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. 📥 Añadir libro y descargas.");
        System.out.println("2. 📚 Mostrar todos los libros ordenados A->Z.");
        System.out.println("3. 📖 Consultar el primer y último libro.");
        System.out.println("4. \uD83E\uDDD0 ¿En qué se diferencia un TreeMap de un HashMap en cuanto al orden de las claves?");
        System.out.println("5. SALIR. \uD83D\uDD1A");
        System.out.print("Introduce una opción: ");
        return entrada.nextLine();
    }
}
